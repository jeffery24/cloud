# OpenFeign

> Feign是一个声明式的web服务客户端，让编写web服务客户端变得非常容易，**只需创建一个接口并在接口上添加注解即可**
>
> OpenFeign 依赖 Ribbon，自带**负载均衡**功能

github: https://github.com/spring-cloud/spring-cloud-openfeign

> Feign和OpenFeign两者区别

Feign是Springcloud组件中的一个轻量级Restful的HTTP服务客户端，Feign内置了Ribbon，用来做客户端负载均衡，去调用服务注册中心的服务。Feign的使用方式是：使用Feign的注解定义接口，调用这个接口，就可以调用服务注册中心的服务

Feign支持的注解和用法请参考官方文档：https://github.com/OpenFeign/feign

**Feign本身不支持Spring MVC的注解，它有一套自己的注解**

```xml
 <!--feign-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-feign</artifactId>
        </dependency>
```

OpenFeign是Spring Cloud 在Feign的基础上支持了Spring MVC的注解，如@RequesMapping等等。
OpenFeign的@FeignClient可以解析SpringMVC的@RequestMapping注解下的接口，
并通过动态代理的方式产生实现类，实现类中做负载均衡并调用其他服务

## 服务消费者使用 OpenFeign 步骤

1. 建 Module，cloud-consumer-feign-order80

2. 改 POM

   ```xml
   <dependency>
       <groupId>org.springframework.cloud</groupId>
       <artifactId>spring-cloud-starter-openfeign</artifactId>
   </dependency>
   ```

3. 主启动类，添加注解 `@EnableFeignClients`

4. 写yml

   ```yaml
   server:
     port: 80
   
   eureka:
     client:
       register-with-eureka: false
       service-url:
         defaultZone: http://eureka7001.com:7001/eureka/,http://eureka7002.com:7002/eureka/
   ```

5. 业务类，Feign 接口类

   ```java
   @Component
   @FeignClient(value = "CLOUD-PAYMENT-SERVICE")
   public interface PaymentFeignService {
       
       @GetMapping(value = "/payment/get/{id}")
       public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);
   
   }
   ```

6. 调用 Feign 接口类

   ```java
   @Resource
   private PaymentFeignService paymentFeignService;
   
   @GetMapping(value = "/consumer/payment/get/{id}")
   public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
       return paymentFeignService.getPaymentById(id);
   }
   ```

   

## OpenFeign超时控制

步骤

- 写 yml

  ```yaml
  #设置feign客户端超时时间(OpenFeign默认支持ribbon)
  ribbon:
    #指的是建立连接所用的时间，适用于网络状况正常的情况下,两端连接所用的时间，默认为1s
    ReadTimeout: 5000
    #指的是建立连接后从服务器读取到可用资源所用的时间，默认为1s
    ConnectTimeout: 5000
  ```



## OpenFeign日志打印功能

### 日志级别

| 级别    | 描述                                                        |
| ------- | ----------------------------------------------------------- |
| NONE    | 默认，不显示任何日志                                        |
| BASIC   | 仅记录请求方法、URL、响应状态码及执行时间                   |
| HEADERS | 除了 BASIC 中定义的信息之外，还有请求和相应的头信息         |
| FULL    | 除了 HEADERS 中定义的信息之外，还有请求和响应的正文及元数据 |

#### 配置步骤

1. 新建配置类

   ```java
   @Configuration
   public class FeignConfig {
       @Bean
       Logger.Level feignLoggerLevel() {
           return Logger.Level.FULL;
       }
   }
   ```

2. 写 YML

   ```yaml
   logging:
     level:
       # feign日志以什么级别监控哪个接口
       com.atguigu.springcloud.service.PaymentFeignService: debug
   ```

   





















































































































