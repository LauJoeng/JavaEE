![](https://img3.mukewang.com/5a41ac900001c16d12800720.jpg)

- hbm2ddl.auto中使用create表示每次执行添加数据时会把原有数据库删除再重新创建，即每次都只有最新插入的数据
- 使用update表示每次插入数据都是在原来的表中插入数据，原有数据不会删除

hibernate.default_schema这个属性的效果是每创建一个表都会在表名前添加该属性值得前缀

hibernate执行流程
<hr/>

![](https://img4.mukewang.com/5a41af00000131a612800720.jpg)

![](https://img3.mukewang.com/5a41b12400010e4b12800720.jpg)

![](https://img1.mukewang.com/5a41b3f3000132f212800720.jpg)

![](https://img4.mukewang.com/5a41b6dc0001c27812800720.jpg)

通过session获取数据库对象使用get方法和load方法的区别

![](https://img2.mukewang.com/5a4244a80001efab12800720.jpg)

而且查询数据不存在时，get方法返回null，load方法抛出异常org.hibernate.ObjectNotFindException