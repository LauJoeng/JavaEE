Spring整合hibernate

- 由IOC容器来生成Hibernate的SessionFactory
- 让Hibernate使用上Spring的声明式事务

整合步骤
- 加入Hibernate

- 加入spring

- 整合

- 实际编写代码



**测试中坑：用hibernate执行hql语句时select 后面跟的是类名，不是表名，是类名，不是表名，是类名不是表名!**

注意整合过程中要添加c3p0的一个额外jar包
mchange-commons-java-0.2.11.jar