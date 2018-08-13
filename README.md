# 简介
适用华东项目后台api接口的开发或者前后端分离的后台服务开发，该项目集成了当前主流的技术栈

- springboot 2.0+
- tkmybatis 持久层操作，详细介绍地址[https://gitee.com/free/Mapper](https://gitee.com/free/Mapper "https://gitee.com/free/Mapper")
- redis  缓存和会话管理
- spring-cache 热点数据缓存
- hibernate-validator 后台校验
- shiro  权限控制

# 使用方法
1. 因为项目默认是引入pg-framework-parent下的一些jar包，这些已经deploy到nexus上，如果没有下载pg-framework-parent的源代码install的话，需要配置下私服，找到自己机器的maven settings文件，参考如下配置
[http://10.29.7.159:9001/download/attachments/950330/settings.rar?version=1&modificationDate=1530865890675&api=v2](http://10.29.7.159:9001/download/attachments/950330/settings.rar?version=1&modificationDate=1530865890675&api=v2 "http://10.29.7.159:9001/download/attachments/950330/settings.rar?version=1&modificationDate=1530865890675&api=v2")
2. 本地创建数据库
执行doc下的pg_db.sql
3. 本地安装并启动redis
4. 在IDEA中启动 SfApplication.java 即可，默认的配置环境为application-local.properties
5. 查看接口文档，访问 [http://127.0.0.1:8888/swagger-ui.html](http://127.0.0.1:8888/swagger-ui.html) 
6. 使用postmanm操作接口示例，可以进行如下操作，
打开postmanm->import，找到项目的doc/postman.json。导入后可以看到如下
![](http://7xlymq.com1.z0.glb.clouddn.com/Snipaste_2018-07-06_19-22-37.png)

然后按照如下方式设置变量

![](http://7xlymq.com1.z0.glb.clouddn.com/%E6%9C%AA%E6%A0%87%E9%A2%98-3.jpg)


# 文档说明
## 初始用户
超级管理员的用户ID为100000，
用户名 admin，密码为123456，无需赋权就拥有所有的权限；
其他注册用户某些功能需要赋权才能使用；

## 用户登录  
登录地址：/login， 登录成功之后返回如下报文：
```
{
    "code": "0",
    "data": {
        "authToken": "251998537743732736_970d5151bece4d16b087ccd6869ab7c0",
        "userId": "251998537743732736",
        "userName": "曹操"
    },
    "message": "ok",
    "success": true
}
```

得到authToken之后，后续如果要访问需要认证的接口时，需要将该token放在header里，key为authorization(该key可以通过application.properties进行配置)，例如
![](http://7xlymq.com1.z0.glb.clouddn.com/5.png)

**PostMan中如何保持会话？**    
登录成功之后可以设置下postman的环境变量，如下图：  
目的就是将获取到的token设置到authorization变量中，如果要访问需认证的接口，可使用{{authorization}}来取得最新的token，就不需要每次都手动设置token了；
![](http://7xlymq.com1.z0.glb.clouddn.com/Snipaste_2018-07-06_22-37-22.png)

![](http://7xlymq.com1.z0.glb.clouddn.com/Snipaste_2018-07-06_22-43-30.png)

## application.properties 配置说明
\#配置token的失效时间（秒），默认30天  
authc.token.expireSeconds=2592000

\#配置登录校验header的key  
authc.name=authorization

\#配置同一个用户是否互踢  
authc.kickSameUser=false

\#是否开启参数验签  
sign.enable=false

\#配置验签秘钥    
sign.secret=

\#配置验签参数的key，默认为sign    
sign.name=sign

\#是否开启错误友好提示，一般用于生产环境，对于未知错误仅显示服务异常，而不会把堆栈信息打印出来  
system.enableFriendlyError=false

## UserUtils 工具类
可以使用该类获取到当前登录用户的信息，例如用户ID,用户姓名等,
UserUtils.getContext().getUserId();
更多字段可以扩展CurrentUser类；

## 参数校验
后台校验功能集成的是hibernate-validator，有哪些注解可以使用可自行百度。  
框架又对校验功能进行了一个扩展，可以很方便的处理复杂校验的问题；  
例如修改密码请求，使用的请求类为PasswordModifyRequest，该类实现了IRequest接口，重新实现check()方法，在该方法里进行参数的校验，如果失败抛出异常即可；

## AccessLogger注解
只限加在Controller的类或者方法上；
加入该注解之后，访问到该方法的请求都会被LoggingListener监听到，默认的实现是CustomLoggingListener，该实现是异步记录到tl_sys_log表中，可以根据自己的需要进行扩展；

**参数说明：**  
value：可为空，对方法进行简单的说明  
describe：可为空，对类或方法的详细描述  
ignore：可为空，是否取消日志记录, 如果不想记录某些方法或者类, 设置为true即可  
ignoreParameters：可为空，哪些参数不做记录，一般用于输入密码的场景    

该注解与swagger的@ApiOperation做了集成，如果@AccessLogger的value没有设置，会继续从@ApiOperation里找信息，然后设置到value里，这样就不用重复写文字说明了；


## Code2Name注解
只限加在对象属性上；
数据库里保存的一般都是字典值，在查询用户详情或者列表的时候可能需要对该值进行翻译，例如性别字段，数据库里存储的是“M”，要想翻译成“男”要么就是通过SQL关联，要么就是遍历list从缓存或者其他地方重新set进去；

这里提供更简单的方式，使用该注解就可以解决问题，例如
![](http://7xlymq.com1.z0.glb.clouddn.com/6.png)
只需要在返回的POJO对象上增加该注解即可实现翻译；  

如果特殊情况需要手动获取翻译，可以注入CacheManager类来解决问题；


**参数说明：**  
key：可为空，一般用于从字典表进行翻译的时才用到  
codeFrom：必填，code值是来源于pojo的哪个属性的  
converter：必填，使用哪个Converter进行翻译，默认实现有字典翻译DictConverter和用户姓名翻译UserConverter，可以根据自己的需要进行实现各种Converter  

## 缓存
选择了spring-cache+redis方案，可以使用@Cacheable等注解进行数据的缓存，默认缓存时间3600秒，可以在CacheConfiguration类中根据自己的需要进行修改；也可以在该类的redisCacheConfigurationMap中给特定的缓存指定过期策略。

## 数据库公共字段
一般每个表中都有些公共字段，例如  
create\_time 创建时间  
create\_by 创建人   
update\_time 修改时间  
update\_by 修改人  

在新增或者修改操作时，框架会自动设置create_time/update_time为当前时间，create_by/update_by修改为当前登录用户ID； 实现方式为mybatis的切面； 

例如：用户修改操作的DTO为UpdateUser，如果该对象的updateTime属性为NULL时，框架对自动设置updateTime为当前时间；


## 选择项controller
请求地址：/component/selection/dict  
该组件用于提供给前端 单选/复选/下拉框的选项值，例如男女选择  
该组件根据KEY值从字典表查询出结果并做了缓存

## 设置过滤器链
CustomFilterChainLoader可以对shiro的过滤器链进行自定义设置，如果某些url可以匿名访问，就将url设置为anon，例如
filterChainDefinitionMap.put("/doc*","anon");

## 接口幂等注解
关于幂等，概念讨论请参考https://www.zhihu.com/question/27744795
*   总体思路 
    1）在调用接口之前先调用获取token的接口生成对应的令牌(token)，并存放在redis当中。     
    2）在调用接口的时候，将第一步得到的token放入请求头中。     
    3）解析请求头，如果能获取到该令牌，就放行，执行既定的业务逻辑，并从redis中删除该token。     
    4)如果获取不到该令牌，就返回错误信息(例如：请勿重复提交)    
* 实现方案      
1 获取令牌：    
通过IdempotencyToken 注解可以获取到令牌，不过该注解是将令牌放到了response的Header属性中（Idempotency-Token），前端人员需要从header中去获取；还有一种方式是注入IdempotencyTokenManager类，通过getToken方法获取；    
2 校验令牌：    
前端获取到令牌之后，再将令牌传进来，需要后端进行校验，通过IdempotencyCheck注解可以实现校验，还有一种方式是注入IdempotencyTokenManager类，通过checkToken方法校验；    