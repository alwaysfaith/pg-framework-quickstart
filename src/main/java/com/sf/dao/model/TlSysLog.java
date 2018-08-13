package com.sf.dao.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "tl_sys_log")
public class TlSysLog implements Serializable {
    /**
     * 日志ID
     */
    @Id
    @Column(name = "ID")
    private String id;

    /**
     * 请求的url地址
     */
    @Column(name = "URL")
    private String url;

    /**
     * 访问的操作
     */
    @Column(name = "ACTION")
    private String action;

    /**
     * http 请求方法, GET,POST...
     */
    @Column(name = "HTTP_METHOD")
    private String httpMethod;

    /**
     * 访问对应的java类
     */
    @Column(name = "TARGET")
    private String target;

    /**
     * 请求者ip地址
     */
    @Column(name = "IP")
    private String ip;

    /**
     * 请求时间戳
     */
    @Column(name = "REQUEST_TIME")
    private Date requestTime;

    /**
     * 响应时间戳
     */
    @Column(name = "RESPONSE_TIME")
    private Date responseTime;

    /**
     * 描述
     */
    @Column(name = "REMARK")
    private String remark;

    /**
     * 请求耗时(ms)
     */
    @Column(name = "USE_TIME")
    private Long useTime;

    @Column(name = "CREATE_TIME")
    private Date createTime;

    /**
     * http 请求头集合
     */
    @Column(name = "HTTP_HEADERS")
    private String httpHeaders;

    /**
     * http 请求参数集合
     */
    @Column(name = "HTTP_PARAMETERS")
    private String httpParameters;

    /**
     * 响应结果,方法的返回值
     */
    @Column(name = "RESPONSE")
    private String response;

    /**
     * 异常信息,请求对应方法抛出的异常
     */
    @Column(name = "EXCEPTION")
    private String exception;

    private static final long serialVersionUID = 1L;

    /**
     * 获取日志ID
     *
     * @return ID - 日志ID
     */
    public String getId() {
        return id;
    }

    /**
     * 设置日志ID
     *
     * @param id 日志ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取请求的url地址
     *
     * @return URL - 请求的url地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置请求的url地址
     *
     * @param url 请求的url地址
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取访问的操作
     *
     * @return ACTION - 访问的操作
     */
    public String getAction() {
        return action;
    }

    /**
     * 设置访问的操作
     *
     * @param action 访问的操作
     */
    public void setAction(String action) {
        this.action = action;
    }

    /**
     * 获取http 请求方法, GET,POST...
     *
     * @return HTTP_METHOD - http 请求方法, GET,POST...
     */
    public String getHttpMethod() {
        return httpMethod;
    }

    /**
     * 设置http 请求方法, GET,POST...
     *
     * @param httpMethod http 请求方法, GET,POST...
     */
    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    /**
     * 获取访问对应的java类
     *
     * @return TARGET - 访问对应的java类
     */
    public String getTarget() {
        return target;
    }

    /**
     * 设置访问对应的java类
     *
     * @param target 访问对应的java类
     */
    public void setTarget(String target) {
        this.target = target;
    }

    /**
     * 获取请求者ip地址
     *
     * @return IP - 请求者ip地址
     */
    public String getIp() {
        return ip;
    }

    /**
     * 设置请求者ip地址
     *
     * @param ip 请求者ip地址
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * 获取请求时间戳
     *
     * @return REQUEST_TIME - 请求时间戳
     */
    public Date getRequestTime() {
        return requestTime;
    }

    /**
     * 设置请求时间戳
     *
     * @param requestTime 请求时间戳
     */
    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

    /**
     * 获取响应时间戳
     *
     * @return RESPONSE_TIME - 响应时间戳
     */
    public Date getResponseTime() {
        return responseTime;
    }

    /**
     * 设置响应时间戳
     *
     * @param responseTime 响应时间戳
     */
    public void setResponseTime(Date responseTime) {
        this.responseTime = responseTime;
    }

    /**
     * 获取描述
     *
     * @return REMARK - 描述
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置描述
     *
     * @param remark 描述
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取请求耗时(ms)
     *
     * @return USE_TIME - 请求耗时(ms)
     */
    public Long getUseTime() {
        return useTime;
    }

    /**
     * 设置请求耗时(ms)
     *
     * @param useTime 请求耗时(ms)
     */
    public void setUseTime(Long useTime) {
        this.useTime = useTime;
    }

    /**
     * @return CREATE_TIME
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取http 请求头集合
     *
     * @return HTTP_HEADERS - http 请求头集合
     */
    public String getHttpHeaders() {
        return httpHeaders;
    }

    /**
     * 设置http 请求头集合
     *
     * @param httpHeaders http 请求头集合
     */
    public void setHttpHeaders(String httpHeaders) {
        this.httpHeaders = httpHeaders;
    }

    /**
     * 获取http 请求参数集合
     *
     * @return HTTP_PARAMETERS - http 请求参数集合
     */
    public String getHttpParameters() {
        return httpParameters;
    }

    /**
     * 设置http 请求参数集合
     *
     * @param httpParameters http 请求参数集合
     */
    public void setHttpParameters(String httpParameters) {
        this.httpParameters = httpParameters;
    }

    /**
     * 获取响应结果,方法的返回值
     *
     * @return RESPONSE - 响应结果,方法的返回值
     */
    public String getResponse() {
        return response;
    }

    /**
     * 设置响应结果,方法的返回值
     *
     * @param response 响应结果,方法的返回值
     */
    public void setResponse(String response) {
        this.response = response;
    }

    /**
     * 获取异常信息,请求对应方法抛出的异常
     *
     * @return EXCEPTION - 异常信息,请求对应方法抛出的异常
     */
    public String getException() {
        return exception;
    }

    /**
     * 设置异常信息,请求对应方法抛出的异常
     *
     * @param exception 异常信息,请求对应方法抛出的异常
     */
    public void setException(String exception) {
        this.exception = exception;
    }
}