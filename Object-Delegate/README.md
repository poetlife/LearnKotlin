# 第7章 对象和委托
## 对象（Object）
有时候我们需要创建一个对某个类做了轻微改动的类的对象，而不用为之显示声明新的子类。Java用匿名内部类处理这种情况。Kotlin使用**对象表达式和对象声明**对这个概念稍微概括了一下。
### 对象表达式
```
// 对象表达式
open class MyClass(name: String){
    open var name = name
    open fun verify(){
        println("Verify")
    }
}
interface MyInterface
{
    // 默认实现了closeData函数
    fun closeData(){
        println("closeData")
    }
}
fun process(obj: MyClass){
    obj.verify()
    // 判断obj是否是MyInterface的实例，如果是，则调用closeData方法
    if (obj is MyInterface)
    {
        obj.closeData()
    }
}

fun main(args:Array<String>){
    // main function
    process(object: MyClass("Bill"), MyInterface{
        override fun verify() {
            println("object verify")
        }
    })
}
```
## 委托
## 标准委托
## 小结
