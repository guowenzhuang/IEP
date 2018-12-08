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