package com.sf.core.log;

import com.alibaba.fastjson.JSON;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.sf.dao.mapper.TlSysLogMapper;
import com.sf.dao.model.TlSysLog;
import com.sf.pg.core.log.define.AccessLoggerInfo;
import com.sf.pg.core.log.define.AccessLoggerListener;
import com.sf.pg.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Date;
import java.util.concurrent.*;

/**
 * 默认的日志处理监听器
 *
 * @author lijie.zh
 */
@Component
@Slf4j
public class CustomLoggingListener implements AccessLoggerListener {
    /**
     * 存放日志对象的队列
     */
    BlockingQueue<AccessLoggerInfo> queue = new LinkedBlockingQueue<AccessLoggerInfo>();

    /**
     * 异步消费线程池
     */
    ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("loggingConsumer-%d").build();
    ExecutorService executor = new ThreadPoolExecutor(2, 10, 1, TimeUnit.MINUTES,
            new LinkedBlockingQueue<Runnable>(5),
            namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());


    @Autowired
    TlSysLogMapper tlSysLogMapper;

    @Override
    public void onLogger(AccessLoggerInfo loggerInfo) {
        queue.add(loggerInfo);
        executor.execute(() -> {
            AccessLoggerInfo info = queue.poll();
            TlSysLog tlSysLog = new TlSysLog();
            //Function<Object, Serializable> function = e -> e.toString();
            //Map<String,Object> logMap = get.toSimpleMap(function);

            if (info != null) {
                tlSysLog.setId(loggerInfo.getId());
                tlSysLog.setAction(loggerInfo.getAction());
                tlSysLog.setRemark(loggerInfo.getDescribe());
                tlSysLog.setTarget(loggerInfo.getTarget().getName() + "." + loggerInfo.getMethod().getName());
                tlSysLog.setIp(loggerInfo.getIp());
                tlSysLog.setUrl(loggerInfo.getUrl());
                tlSysLog.setHttpHeaders(JSON.toJSONString(loggerInfo.getHttpHeaders()));
                tlSysLog.setHttpMethod(loggerInfo.getHttpMethod());
                tlSysLog.setResponse(JSON.toJSONString(loggerInfo.getResponse()));
                tlSysLog.setRequestTime(new Date(loggerInfo.getRequestTime()));
                tlSysLog.setResponseTime(new Date(loggerInfo.getResponseTime()));
                if (loggerInfo.getHttpParameters() != null && loggerInfo.getHttpParameters().size() > 0) {
                    tlSysLog.setHttpParameters(JSON.toJSONString(loggerInfo.getHttpParameters()));
                }
                Throwable throwable = loggerInfo.getException();
                if (throwable != null) {
                    Writer result = new StringWriter();
                    PrintWriter printWriter = new PrintWriter(result);

                    if(throwable instanceof BusinessException){
                        printWriter.write(((BusinessException) throwable).getErrMsg());
                    }else{
                        throwable.printStackTrace(printWriter);
                    }

                    printWriter.close();
                    tlSysLog.setException(result.toString());
                }
                tlSysLog.setUseTime((loggerInfo.getResponseTime() - loggerInfo.getRequestTime()));
                tlSysLogMapper.insert(tlSysLog);
            }
        });
    }


}