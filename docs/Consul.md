# Consul

> 服务注册与发现

## 简介

官网：https://www.consul.io/intro/index.html

功能

- 服务发现
  	提供HTTP和DNS两种发现方式
- 健康监测
  	支持多种协议，HTTP、TCP、Docker、Shell脚本定制化
- KV存储
  	key , Value的存储方式
- 多数据中心
  	Consul支持多数据中心
- 可视化Web界面

玩法：https://www.springcloud.cc/spring-cloud-consul.html



## 下载安装运行

1. 官网下载

2. 查看版本信息(控制台)

   ```shell
   .\consul.exe --version
   ```

3. 使用开发模式启动

   ```
   consul agent -dev
   ```

4. 访问Consul的首页

   ```
   http;//localhost:8500
   ```



## 提供者

1. 建 Module，cloud-providerconsul-payment8006

2. 改 POM

   ```
   <dependency>
       <groupId>org.springframework.cloud</groupId>
       <artifactId>spring-cloud-starter-consul-discovery</artifactId>
   </dependency>
   ```

3. 写yml

   ```
   ###服务端口号
   server:
     port: 8006
   
   spring:
     application:
       name: consul-provider-payment
     ####consul注册中心地址
     cloud:
       consul:
         host: localhost
         port: 8500
         discovery:
           service-name: ${spring.application.name}
   ```

4. 主启动类，添加注解 `@EnableDiscoveryClient`

5. 测试：Consul 的图形化界面中出现新的 Service，consul-provider-payment



## 服务消费者

同上，注意Spring Boot 是会自动注入数据源，如果配置文件中没有配置就会启动失败，可以通过排除`@SpringBootApplication(exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})` 解决



## 三个注册中心异同点

| 组件名    | 语言 | CAP  | 健康检查 | 对外暴露接口 | Spring Cloud 集成 |
| --------- | ---- | ---- | -------- | ------------ | ----------------- |
| Eureka    | Java | AP   | 可配支持 | HTTP         | 已集成            |
| Consul    | Go   | CP   | 支持     | HTTP/DNS     | 已集成            |
| ZooKeeper | Java | CP   | 支持     | 客户端       | 已集成            |

CAP
	C:Consistency(强一致性)
	A:Availability(可用性)
	P:Partition tolerance(分区容错)
	CAP理论关注粒度是数据，而不是整体系统设计的策略
经典CAP图
	AP(Eureka)
	CP(Zookeeper/Consul)

























