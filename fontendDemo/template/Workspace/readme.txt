## 代码使用
    frontend 文件夹存放前端代码，直接将frontend中文件夹如base，整个拷贝的到前端代码的空项目根目录下
    如 apolloFrontend/base

    javaBackend 文件夹存放java后端代码，里面会存在src文件夹，直接将此文件夹复制到java后端空项目根目录下，选择全部覆盖


## 代码如何快速运行
    cmd、cd 到 javaBackend项目根目录：如 C:/javaBackend
    直接 mvn clean package 完成编译打包
    在target文件夹下找到对应的war包，如zjgl-1.0.0.war
    改名为zjgl.war,然后部署到tomcat的网站目录下，完成后端部署
    访问地址比如是 http://localhost:8080/zjgl  (localhost建议用ip替换)

    配置前端项目（如ApolloFrontend）根目录下dc.pageConfig.js
    配置 dc.project.backendUrl = "http://localhost:8080/zjgl";(localhost建议用ip替换)
    将整个前端项目部署到tomcat的网站目录下，完成前端部署

## 访问快速搭建的项目
    一般直接访问生成的页面即可：
        地址如：  http://localhost:8080/ApolloFrontend/base/ZjglCert/Index.html
        (具体地址详见生成的代码目录结构)