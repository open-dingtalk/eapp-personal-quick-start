
## 运行环境开发工具
java7  
intellij idea

## 项目结构
```
├── README.md
├── lib
│   ├── taobao-sdk-java-auto_1479188381469-20180524-source.jar
│   └── taobao-sdk-java-auto_1479188381469-20180524.jar
├── pom.xml
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       ├── Application.java
    │   │       ├── config
    │   │       │   └── Constant.java
    │   │       ├── controller
    │   │       │   └── IndexController.java
    │   │       ├── sdk
    │   │       │   ├── DingTalkSignatureUtil.java
    │   │       │   └── URLConstant.java
    │   │       └── util
    │   │           ├── LogFormatter.java
    │   │           ├── ServiceResult.java
    │   │           └── ServiceResultCode.java
    │   └── resources
    │       └── application.properties
    └── test
        └── java
            └── com
                └── ApplicationTests.java

```
                    
                
## 项目配置
1.更新Constant.java文件的APP_ID，APP_SECRET三个属性。  
获取方法请登录[开发者后台](http://open-dev.dingtalk.com/)，个人应用设置-详情内查看，详情参考[第三方个人应用-概述-名词解释](https://ding-doc.dingtalk.com/doc#/personnal/fdzxvg)   

2.更新application.properties文件的服务器启动端口。

## 打包命令
mvn clean package  -Dmaven.test.skip=true  
打成的包在工程文件的target目录下。文件为  "工程名"-"版本号".jar。()

## 服务部署    
java -jar  target/"工程名"-"版本号".jar

## 创建小程序等开发流程，参见文档  
https://ding-doc.dingtalk.com/doc#/personnal/how-to-write
