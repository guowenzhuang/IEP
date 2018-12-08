智慧教学平台
---
微服务划分

iep_bbs  论坛   孟劭华组

iep_exam  考试  高中烨组

iep_student 学生   盛广杰组

iep_teacher 老师   白婷婷组

其他         郭文壮组

## 启动项目之前:
1. 从github上拉取项目  (使用sts/idea)
2. 安装redis  端口设为6379 不用设置密码
## 启动项目
1. 运行redis server
2. 启动 iep_eureka
3. 启动 iep_config (需要等config完全启动后再启动以下的微服务)
4. 启动 iep_zipkin
5. 启动 iep_student
6. 启动 iep_teacher
7. 启动 iep_exam
8. 启动 iep_bbs
9. 启动 iep_zuul
10. 运行前端 [点这里](https://github.com/guowenzhuang/ieppage)

4-9之间顺序可任意

## 内存调优
如果项目启动太大 设置一下启动的参数

    -Xms256M -Xmx512M
## 开始编写之前
### pom依赖
根据自己组的选择 导入 jpa或者 mybatis依赖

jpa:
    
     <dependency>
         <groupId>org.springframework.boot</groupId>
         <artifactId>spring-boot-starter-data-jpa</artifactId>
     </dependency>
mybatis:

    <dependency>
        <groupId>org.mybatis.spring.boot</groupId>
        <artifactId>mybatis-spring-boot-starter</artifactId>
    </dependency>
### 更改配置 application.yml
配置数据库连接:

    spring:
      datasource:
        url: 班级群里的mysql url
        username: 班级群里的mysql 账号
        password: 班级群里的mysql 密码
      jpa:
        database: MySQL
        show-sql: true
        hibernate:
          ddl-auto: update
        database-platform: org.hibernate.dialect.MySQL5InnoDBDialect
## 如何进行测试Restful
1. <a href="#dl">登录获得token</a>
2. <a href="#fw">token存到头信息中测试</a>

访问你项目的路径以/api开头

列如访问 iep_student微服务下的Restful为/api/student/*

路由匹配规则:

    zuul:
      routes:
        teacher:
          serviceId: IEP-TEACHER
          path: /teacher/**
        bbs:
          serviceId: IEP-BBS
          path: /bbs/**
        exam:
          serviceId: IEP-EXAM
          path: /exam/**
        student:
          serviceId: IEP-STUDENT
          path: /student/**
        oss:
          serviceId: IEP-OSS
          path: /oss/**
      ignored-services: "*"
      prefix: "/api"


<h2 id="dl">登录获得token</h2>
axios连接示例:

    let params = new URLSearchParams();
    //认证类型
    params.append("grant_type", "password");
    //用户名
    params.append("username", username.value);
    //密码
    params.append("password", password.value);
    //发送请求
     axios({
            method: 'post',
            url: '/oauth/token',
            data: params,
            headers: {
                //头信息
                "Authorization": "Basic aWVwOmllcHNlY3JldA=="
            }
        })
返回值示例:

    
    "access_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiLlvKDkuIkiLCJzY29wZSI6WyJhbGwiLCJyZWFkIiwid3JpdGUiXSwiY29tcGFueSI6ImllcCIsImV4cCI6MTU0NDI4Njc0MSwiYXV0aG9yaXRpZXMiOlt7ImF1dGhvcml0eSI6IlJPTEVf5a2m55SfIn0seyJhdXRob3JpdHkiOiLmtYvor5XmnYPpmZAifV0sImp0aSI6IjRhNzFhM2I4LWJiZmItNGFkZi1iMGUyLWZiYWViMzUyMmU4ZSIsImNsaWVudF9pZCI6ImllcCJ9.b4IPGfD7yPMbYRdpljSMGz5t20mBUUDE4KkzE22NAaI",
    "token_type": "bearer",
    "refresh_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiLlvKDkuIkiLCJzY29wZSI6WyJhbGwiLCJyZWFkIiwid3JpdGUiXSwiYXRpIjoiNGE3MWEzYjgtYmJmYi00YWRmLWIwZTItZmJhZWIzNTIyZThlIiwiY29tcGFueSI6ImllcCIsImV4cCI6MTU0Njg3MTU0MSwiYXV0aG9yaXRpZXMiOlt7ImF1dGhvcml0eSI6IlJPTEVf5a2m55SfIn0seyJhdXRob3JpdHkiOiLmtYvor5XmnYPpmZAifV0sImp0aSI6ImRkMzVjMjUzLTg1ZTQtNGU1Ny1hM2JkLTRlMWM1YmNhYjA0NCIsImNsaWVudF9pZCI6ImllcCJ9.8q6LhCoUZA5zLFYd11J6j8fb04FGFPsNEDNo0m78sMg",
    "expires_in": 7199,
    "scope": "all read write",
    "company": "iep",
    "authorities": [
    {
    "authority": "ROLE_学生"
    },
    {
    "authority": "测试权限"
    }
    ],
    "jti": "4a71a3b8-bbfb-4adf-b0e2-fbaeb3522e8e"
access_token  为你的登录token
<h2 id="fw">token存到头信息中测试</h2>  
axios访问示例

      axios({
            method: 'get',
            url: '/api/oauth/me',
            headers: {
                "Authorization": "bearer "+你的token
            }
        })
    


    

   