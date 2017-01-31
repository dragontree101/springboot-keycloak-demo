# springboot-keycloak-demo

## 第一步: 部署keycloak的单机模式server
- 下载keycloak-2.5.1.Final.tar.gz包，并且解压
- cd keycloak-2.5.1.Final/keycloak
- 启动数据库 mysql
- 创建数据库 create database keycloak;
- bin/add-user-keycloak.sh -r master -u username -p password
- 在standalone/configuration/standalone.xml文件中加入

```
                <datasource jndi-name="java:jboss/datasources/KeycloakDS" pool-name="KeycloakDS" use-java-context="true">
                    <connection-url>jdbc:mysql://127.0.0.1:3306/keycloak</connection-url>
                    <driver>mysql</driver>
                    <security>
                        <user-name>root</user-name>
                        <password></password>
                    </security>
                </datasource>
                <drivers>
                    <driver name="mysql" module="com.mysql">
                        <xa-datasource-class>com.mysql.jdbc.jdbc2.optional.MysqlXADataSource</xa-datasource-class>
                    </driver>
                </drivers>
```
然后注释掉
```
<!--
                <datasource jndi-name="java:jboss/datasources/KeycloakDS" pool-name="KeycloakDS" enabled="true" use-java-context="true">
                    <connection-url>jdbc:h2:${jboss.server.data.dir}/keycloak;AUTO_SERVER=TRUE</connection-url>
                    <driver>h2</driver>
                    <security>
                        <user-name>sa</user-name>
                        <password>sa</password>
                    </security>
                </datasource>
-->
```

- 创建目录: mkdir -p modules/system/layers/base/com/mysql/main/
- 在main目录下添加文件module.xml文件

```
<?xml version="1.0" encoding="UTF-8"?>

<module xmlns="urn:jboss:module:1.3" name="com.mysql">

    <resources>
        <resource-root path="mysql-connector-java-5.1.40.jar"/>
    </resources>
    <dependencies>
        <module name="javax.api"/>
    </dependencies>
</module>
```

- 在main目录下添加mysql的jar包: mysql-connector-java-5.1.40.jar

- 运行脚本 bash bin/standalone.sh  启动单机模式的keycloak的server

- 然后就可以访问http://localhost:8080/auth

- 使用username和password进行登录

## 创建一个服务端的app
- 安装maven,初始化springboot项目
- 利用springboot创建了一个family-app的项目，目前提供了一个get请求，来获取数据库的family成员的数据
- 在本地启动了这个后端服务

## 创建一个前端的app
- 安装node.js, npm, webpack, vue2, vue-cli
- 利用vue-cli来创建一个webpack-simple项目 ```vue init webpack-simple family-js```
- 通过ajax来调用服务端的接口，获取数据，并且以表格的形式进行展示
