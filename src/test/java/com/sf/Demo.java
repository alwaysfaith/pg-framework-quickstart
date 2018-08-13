package com.sf;

import com.sf.core.config.SwaggerConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by zhonglj on 2017/12/2.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SfBootApplication.class,
        SwaggerConfig.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class Demo {


//    @Test
//    public void t2() throws Exception{
//        Map<String,PropertyDescriptor> map = BeanUtil.getPropertyDescriptorMap(ThSysPerm.class,false);
//log.debug(""+map);
//map.containsKey()
//    }

//    @Test
//    public void t() throws InterruptedException {
//        ExecutorService exec = Executors.newFixedThreadPool(3);
//        for (int index = 0; index < 100; index++) {
//
//            exec.execute(() -> {
//                System.out.println("生产对象的线程"+Thread.currentThread().getName());
//                AccessLoggerInfo get = new AccessLoggerInfo();
//                myLoggingListener.onLogger(get);
//            });
//        }
//        Thread.sleep(Integer.MAX_VALUE);
//        System.out.println("哈哈哈");
//    }
}
