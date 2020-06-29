> Zookeeper 服务注册与发现

## 结论

服务在 Zookeeper 中创建的是临时节点，一旦服务停止，一段时间后，节点被 Zookeeper 删除。

## SpringCloud整合Zookeeper代替Eureka

#### 注册中心Zookeeper

安装zookeeper，要选择下面的第一个，另一个会启动报错，找不到类

Apache ZooKeeper 3.6.1 is our latest stable release.

#### Apache ZooKeeper 3.6.1

[Apache ZooKeeper 3.6.1](https://www.apache.org/dyn/closer.lua/zookeeper/zookeeper-3.6.1/apache-zookeeper-3.6.1-bin.tar.gz)([asc](https://downloads.apache.org/zookeeper/zookeeper-3.6.1/apache-zookeeper-3.6.1-bin.tar.gz.asc), [sha512](https://downloads.apache.org/zookeeper/zookeeper-3.6.1/apache-zookeeper-3.6.1-bin.tar.gz.sha512))

[Apache ZooKeeper 3.6.1 Source Release](https://www.apache.org/dyn/closer.lua/zookeeper/zookeeper-3.6.1/apache-zookeeper-3.6.1.tar.gz)([asc](https://downloads.apache.org/zookeeper/zookeeper-3.6.1/apache-zookeeper-3.6.1.tar.gz.asc), [sha512](https://downloads.apache.org/zookeeper/zookeeper-3.6.1/apache-zookeeper-3.6.1.tar.gz.sha512))





1. 启动 Zookeeper

   - 关闭虚拟机中的防火墙   

     ```shell
     systemctl stop firewalld.service
     ```

   - 启动

     ```shell
     # 启动服务
     ./zkServer.sh start
     # 验证状态
     ./zkServer.sh status
     # 启动客户端
     ./zkCli.sh
     ```



### 服务提供者

创建生产者服务

1. 建 Module，cloud-provider-payment8004

2. 改 POM

   ```
   <dependency>
       <groupId>org.springframework.cloud</groupId>
       <artifactId>spring-cloud-starter-zookeeper-discovery</artifactId>
   </dependency>
   ```

3. 如果启动时报错，可能是依赖的 ZooKeeper 的 jar 包与使用的 ZooKeeper 版本不一致，可以通过调整依赖解决：

   ```xml
   <dependency>
       <groupId>org.springframework.cloud</groupId>
       <artifactId>spring-cloud-starter-zookeeper-discovery</artifactId>
       <!--先排除自带的zookeeper3.5.3-->
       <exclusions>
           <exclusion>
               <groupId>org.apache.zookeeper</groupId>
               <artifactId>zookeeper</artifactId>
           </exclusion>
       </exclusions>
   </dependency>
   <!--添加zookeeper3.4.9版本-->
   <dependency>
       <groupId>org.apache.zookeeper</groupId>
       <artifactId>zookeeper</artifactId>
       <version>3.4.9</version>
   </dependency>
   ```

4. 改 YML

   ```yaml
   #8004表示注册到zookeeper服务器的支付服务提供者端口号
   server:
     port: 8004
   
   
   #服务别名----注册zookeeper到注册中心名称
   spring:
     application:
       name: cloud-provider-payment
     cloud:
       zookeeper:
         connect-string: 192.168.43.79:2181
   ```

5. 主启动类，添加注解 `@EnableDiscoveryClient`

6. 测试

   - 启动不报错
   - Zookeeper 客户端中查看，会产生新的节点 `services`，`services` 下有 `cloud-provider-payment` 节点



### 消费者和上面差不多

1. 建 Module ，cloud-consumerzk-order80
2. 改 POM，同上
3. 改 YML，同上
4. 主启动类，同上

### 集群和Eureka思想差不多















