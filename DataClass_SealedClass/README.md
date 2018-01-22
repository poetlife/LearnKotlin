# 数据类和封闭类
## 数据类（Data Class）
数据类是Kotlin的一个*语法糖*。Kotlin编译器会自动为数据类生成一些成员函数，以提高开发效率。
### 使用数据类
如果在程序中使用数据库，或映射JSON数据，很可能会将查询结果集火JSON格式的数据映射成为对象，或将对象映射成为数据集或JSON格式的数据。无论是哪一种，我们总需要一个类来表示数据。
```
// 使用数据类
class User(name: String, age: Int)
{
    var name: String = name
    var age: Int = age
}


fun main(args:Array<String>){
    // main function
    var user1 = User("Mike", 34)
    var user2 = User("Jack", 43)
    println(user1)  // 默认调用了toString(), 而这个方法会默认调用hashCode()
    println(user2)
    println(user1.equals(user2))
    /*
    out:
    com.pjd.helloworld.User@2de80c
    com.pjd.helloworld.User@144bcfa
    false
     */
}
```
这个显然不是我们需要的，因此我们用数据类重写User类。
### 对象复制
### 数据类成员的解构
## 封闭类（Sealed Class）
