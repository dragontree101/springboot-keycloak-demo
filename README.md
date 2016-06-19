# springboot-keycloak-demo

## 部署keycloak的server
- 下载keycloak-1.9.8.Final.tar.gz包，并且解压
- cd keycloak-1.9.8.Final/keycloak
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

- 创建目录: mkdir -p modules/system/layers/base/com/mysql/main/
- 在main目录下添加文件module.xml文件

```
<?xml version="1.0" encoding="UTF-8"?>

<module xmlns="urn:jboss:module:1.3" name="com.mysql">

    <resources>
        <resource-root path="mysql-connector-java-5.1.33.jar"/>
    </resources>
    <dependencies>
        <module name="javax.api"/>
    </dependencies>
</module>
```

- 在main目录下添加mysql的jar包: mysql-connector-java-5.1.33.jar

- 然后就可以访问http://localhost:8080/auth/amin

- 使用username和password进行登录
