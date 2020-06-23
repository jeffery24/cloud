# cloud

[toc]



## ΢����ܹ�



##  2.2.x �� H ��

### ���

���ε�SpringCloud�ڶ�����Ϊ�ϰ볡���°볡

��ƪ
	SpringBoot2.X���SpringCloud H��
��ƪ
	SpringCloud Alibaba

### Ŀ¼

![image-20200623174850016](cloud2.assets/image-20200623174850016.png)



### Springboot�汾ѡ��
?	gitԴ���ַ��
?		https://github.com/spring-projects/spring-boot/releases/
?	SpringBoot2.0�����ԣ�
?		https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-2.0-Release-Notes
?	ͨ������������֣�Boot�ٷ�ǿ�ҽ�����������2.X���ϰ汾
?	������Boot�汾 
?		 springboot(����2019.10.26)
?		springboot(����2020.2.15)
### SpringCloud�汾ѡ��
?	gitԴ���ַ
?		https://github.com/spring-projects/spring-cloud/wiki
?	������
?		https://spring.io/projects/spring-cloud
?	������Cloud�汾 
?		Cloud��������
?		springcloud(����2019.10.26)
?		springboot(����2020.2.15)

### SpringCloud��Springboot֮���������ϵ��ο�

- https://spring.io/projects/spring-cloud#overview
- ����
- ����ϸ�İ汾��Ӧ�鿴����

  - https://start.spring.io/actuator/info

  - �鿴json�����ؽ��

### ����

```
- cloud��Hoxton.SR1

- boot��2.2.2.RELEASE

- cloud Alibaba��2.1.0.RELEASE

- java�� JAVA8

- maven�� 3.5������

- mysql��5.7������

- ������������ȫ���汾���������һ��
- ���⻰
	-boot���Ѿ���2.2.4Ϊ���£�Ϊʲôѡ2.2.2��
    - ֻ��boot��ֱ��������
      - Subtopic
    - ͬʱ��boot��cloud����Ҫ�չ�cloud����cloud����boot�汾
      - ���
    - SpringCloud��SpringBoot�汾��Ӧ��ϵ
  - 2.X�汾���õ����pom
```



## Cloud���������ͣ��/����/�滻

### ��ͣ�������ġ������Ұ���

- ͣ����ͣ��

  - �����޸�bugs
  - ���ٽ��ܺϲ�����
  - ���ٷ����°汾

- ��ϸ��Ŀ

  - ��ǰ
  - now2020



### �ο����ϼ�����
?	Spring Cloud
?		https://cloud.spring.io/spring-cloud-static/Hoxton.SR1/reference/htmlsingle/
?		Spring Cloud�����ĵ�
?			https://www.bookstack.cn/read/spring-cloud-docs/docs-index.md
?	Spring Boot
?		https://docs.spring.io/spring-boot/docs/2.2.2.RELEASE/reference/htmlsingle/



## ΢����ṹ���빹��

Լ�� > ���� > ����



### idea ��Ŀ����

΢����cloud����ۺϸ�����Project
	�����̲���
		1.New Project��Maven site project��
		2.�ۺ��ܹ�������
		3.Mavenѡ�汾
		4.��������
		5.�ַ�����(��Ŀ���б���ʹ��utf-8)
		6.ע����Ч����(setting)
		7.java����汾ѡ8(idea Ĭ������������)
		8.File Type����

������POM

?	https://github.com/x-emory/cloud/blob/master/pom.xml

?	Maven�е�dependencyManagement��dependencies ��������ģ��������dependencies �汾

?	maven��������Ԫ���ԣ�idea �Ҳ���maven�������磩

�����̴������ִ��mvn:install�������̷������ֿⷽ���ӹ��̼̳�



#### Rest ΢������Ŀ����

��������

- ?	����xxx΢�����ṩ��Moduleģ�飬������ظ����̿���pom�ļ��仯
- ?	дpom
- ?	дyaml
- ?	������
- ?	ҵ����� --	SQL -> entitles -> dao -> servicve -> controller

�������һ��ģ�����в���

?	����ͨ��chrome���

?	ͨ�� postman

����

?	idea �п��������Ŀ���Զ���ʾ�Ƿ�Ҫ����Run DashBoard����

?		���`û�п���`����ͨ���޸�idea��workpace.xml�ķ�ʽ�����ٴ�Run DashBoard����

?	����idea�汾��ͬ������Ҫ����



#### �Ȳ���

bootҲ��һ���Ȳ��𷽰� 

?		�Ȳ���idea��Springboot�Ƽ�Spring-boot-devtools��ʵ���Ȳ���+ ��ݼ� ctrl+F9



cloud:

1.Adding devtools to your project

2.Adding plugin to your pom.xml

```xml
<plugin>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-maven-plugin</artifactId>
    <configuration>
    <fork>true</fork>
    <addResources>true</addResources>
    </configuration>
</plugin>
```

3.Enabling automatic build (compiler select adbc)

4.Update the value of

5.����IDEA

idea �� ctrl+shift+alt+/ ѡ�� xxx...app.running �� xxx...assertFocusAccessFormat	-ֱ������ѡ�м���



#### ΢����������Moduleģ��

��������

- ?	����xxx΢�����ṩ��Moduleģ�飬������ظ����̿���pom�ļ��仯
- ?	дpom
- ?	дyaml
- ?	������
- ?	ҵ����� -- �����ṩ���ṩ����
  ?	RestTemplate
  ?		��ʲô��������JdbcTempleate..
  ?		������ʹ��:
  - https://docs.spring.io/spring-framework/docs/5.2.2.RELEASE/javadoc-api/org/springframework/web/client/RestTemplate.html
  - config������
    		ApplicationContextConfig:https://github.com/x-emory/cloud/blob/master/cloud-consumer-order80/src/main/java/com/emory/springcloud/config/ApplicationContextConfig.java
      	����controller

����

��Ҫ����@RequestBodyע��



#### ��Ŀ�ع�

���⣺ϵͳ���ظ����֣��ع�

���ظ����ֳ�ȡ����������һ���µ�cloud-api-commons modles ���

?	POM

```xml
   <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-devtools -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>        <!-- https://mvnrepository.com/artifact/cn.hutool/hutool-all -->
        <dependency>
            <groupId>cn.hutool</groupId>
            <artifactId>hutool-all</artifactId>
            <version>5.1.0</version>
        </dependency>
```

?	entities
?		Paymentʵ��
?		CommonResultͨ�÷�װ��
?	maven����clean install

����80��֧��8001�ֱ����
	ɾ�����Ե�ԭ���й���entities�ļ���
	�������POM����

```xml
<dependency>
            <groupId>com.emory.springcloud</groupId>
            <artifactId>cloud-api-commons</artifactId>
            <version>0.0.1-SNAPSHOT</version>
</dependency>
```

�ܽ᣺��������Թ���Ĳ��ֳ�ȡ����һ���µ�ģ�飬ͨ��maven ���������ģ�����ü���

























































































































