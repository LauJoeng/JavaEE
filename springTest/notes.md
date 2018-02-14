Spring IOC 容器可以自动装配Bean，需要做的仅仅是在<bean>额autowire属性里指定自动装配的模式,有下面两种模式
- byType(根据自动装配)：若IOC容器有多个与目标Bean类型一致额Bean，这种情况下，Spring将无法判定哪个Bean最适合该属性，所以讲不能自动装配
- byName(根据名称自动装配)必须将目标Bean的名称和属性名设置得完全相同
- constructor(通过构造器自动装配)当Bean中存在多个构造器时，此种自动装配方式会很复杂

autowire使用不够灵活，很少使用


bean配置的继承

- 自bean从父bean继承配置，包括bean的属性配置
- 子bean可以覆盖父bean的配置
- 父bean可以作为配置的模板，也可以作为bean的实例，若只想把父bean作为bean的模板，可以设置<bean>的abstract属性设置为true，这样spring就不会实例化这个bean
- 并不是所有<bean>元素里的所有属性都会被继承，比如autowire，abstract等
- 也可以忽略父的class属性，让子bean指定自己的类，而共享相同的属性，但此时abstract必须设为true

依赖bean的配置

Spring允许用户通过depends-on属性设定bean前置依赖的bean，前置依赖bean会在本bean实例实例化之前创建好，如果前置依赖于多个bean，则可以通过逗号或者空格的方式设置bean的名称



Spring IOC 容器可以管理bean的生命周期，Spring允许在bean的生命周期的特点执行定制的任务

SpringIOC容器对bean的生命周期进行管理的过程如下
- 通过构造器或工厂方法创建bean实例
- 为bean的属性设置值和对其他bean的引用
- 调用bean的初始化方法
- bean可以使用了
- 当容器关闭时，调用bean的销毁方法

在bean的生命声明里设置init-method和destroy-method属性，为bean指定初始化和销毁方法

bean的后置处理器允许在调用初始化方法前后对bean进行额外处理

bean的后置处理器对IOC容器里所有的bean实例逐一处理，而非单一实例，其典型应用是：检查bean属性的正确新或根据特定的标准进行更改

对bean的后置处理器而言，需要实现BeanPostProcessor接口，在初始化方法调用前后，Spring将把每个bean实例分别传递给上述接口的两个方法

