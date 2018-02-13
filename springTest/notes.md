Spring IOC 容器可以自动装配Bean，需要做的仅仅是在<bean>额autowire属性里指定自动装配的模式,有下面两种模式
- byType(根据自动装配)：若IOC容器有多个与目标Bean类型一致额Bean，这种情况下，Spring将无法判定哪个Bean最适合该属性，所以讲不能自动装配
- byName(根据名称自动装配)必须将目标Bean的名称和属性名设置得完全相同
- constructor(通过构造器自动装配)当Bean中存在多个构造器时，此种自动装配方式会很复杂

autowire使用不够灵活，很少使用