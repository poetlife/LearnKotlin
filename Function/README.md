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
