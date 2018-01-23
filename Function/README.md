# 第9章 函数
## 使用中缀标记法调用函数
所谓中缀标记法就是**将函数放在两个操作数中**间。左侧是包含函数的对象或值，右侧是函数的参数值。
使用中缀标记法需要满足的**3个条件**：
+ 成员函数或扩展函数
+ 只有1个参数
+ 使用infix关键字声明函数
【字符串除法操作】：就是去除分子字符串中包含的所有分母字符串
```
// 中缀表达式
infix fun String.div(str: String): String
{
    return this.replace(str, "")
}

fun main(args: Array<String>)
{
    // 一般方式调用
    var str:String = "hello world"
    println(str.div("l"))

    // 中缀表达式
    println(str div "l")

    // 可以连续使用
    println(str div "l" div "h")
}
```
## 单表达式函数
如果一个函数的函数体只有一条语句，而且是return语句，那么可以省略函数体的大括号，以及return关键字。return后面的表达式可以直接写在函数声明的后面，用等号与函数声明分隔。
```
fun double(x: Int): Int = x * 2
```
## 函数参数和返回值
### 可变参数
用vararg表示，就是指任意多个参数，并会以数组的形式来处理这些参数。
```
// 可变参数
fun <T> asList(vararg ts: T): List<T>
{
    var result = ArrayList<T>()
    for (t in ts){
        result.add(t)
    }
    return result
    // Array<out T>
}


fun main(args: Array<String>)
{
    // 由于ts是可变参数，因此可以传递任意多个参数值，并且可以使任意类型的
    var list =  asList(1, 2, "a", 2.1)
    println(list)
}
```

## 函数的范围
在Kotlin中，函数可以定义在源代码的顶级范围内（top level），这就意味着你不必像在Java、C#或Scala等语言中那样，创建一个类来容纳这些函数，除顶级函数之外，Kotlin中的函数也可以定义为局部函数、成员函数及扩展函数。

## 内联函数（Remain Confused）
使用**高阶函数**会带来一些运行时的效率损失：每一个函数都是一个对象，并且会捕获一个闭包。即那些在函数体内会访问到的变量。内存分配（对于函数对象和类）和虚拟调用会引入运行时间开销。
