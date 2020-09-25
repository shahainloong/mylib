------

# Interview Question

> Author：Echo
>

## SAP

### concurrentHashMaP线程安全原理

### 1、构造器（Constructor）是否可被重写（override）？

不可以重写，但是可以重载

### 2、获取Class对象（实例）有哪些方式？

4种

调用运行时类本身的.class属性

Class clazz=Person.class;

运行时类的对象获取

Person p=new Person();
Class clazz2=p.getClass()

通过Class的静态方法获取

String className="test.Person";
Class clazz3=Class.forName(className);

通过类的加载器

ClassLoader classLoader=this.getClass().getClassLoader();
Class clazz4=classLoader.loadClass(className);

3、什么是java序列化？什么情况下需要序列化？

4、HashMap的工作原理

https://github.com/Snailclimb/JavaGuide/blob/master/docs/java/collection/HashMap.md

