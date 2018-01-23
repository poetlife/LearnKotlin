# 第8章 高阶函数与lambda表达式
## 高阶函数
高阶函数是一种特殊的函数，它接受函数作为参数，或者返回一个函数。
```
interface Product
{
    var area: String
    fun sell(name: String)
}

class MobilePhone: Product
{
    override var area: String
        get() = ""
        set(value) {}

    override fun sell(name: String) {
        println("销售${name}")
    }

    override fun toString(): String {
        return area
    }
}

fun mobilePhoneArea(name: String): String
{
    return "${name} 美国"
}

// 高阶函数
fun processProduct(product: Product, area: (name: String) -> String): Product
{
    // 调用第2个参数指定的函数
    product.area = area("iPhone")
    return product
}

fun main(args: Array<String>){
    var product = MobilePhone()
    // 将函数作为参数传入高阶函数，需要在函数名前加两个冒号（::)作为标记
    processProduct(product, ::mobilePhoneArea)
    println(product)
}
```
## lambda表达式与匿名函数
### 函数类型
### Lambda表达式的语法
```
{x ,y -> x + y}
```
### 匿名函数
### 闭包

## 小结
