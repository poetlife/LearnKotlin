# 实验性章节 协程
> 协程在kotlin 1.1+ 以上都是实验性的功能

## 协程的概念
协程把异步编程放入库中以简化操作。程序逻辑在协程中顺序表述，而底层的库会将其打包为异步操作。  
如果将程序分为IO密集型应用和CPU密集型应用，两者的发展历程大致如下：
+ IO密集型应用： 多进程→多线程→事件驱动→协程
+ CPU密集型应用： 多进程→多线程

协程提供了一种避免阻塞线程并用更简单、更可控的操作替代线程阻塞的方法：**线程挂起**。

## 协程的基本操作
Kotlin协程是一种**用户态**轻量级线程，它由协程构建器（Launch Coroutine Builder）启动。

### 配置Kotlin协程
使用Gradle配置Kotlin协程核心，代码如下：
```
dependencies {
  cpmpile "org.jetbrains.kotlin:kotlinx-coroutines-core:0.22.2"
}
```
此依赖项使用的Kotlin版本为：`1.2.21`。
更多配置信息，参见[Kotlin-coroutines-cores Github](https://github.com/Kotlin/kotlinx.coroutines#gradle)

### 简单的协程示例
```
fun firstCoroutineDemo(){
    launch(CommonPool) {
        delay(3000L, TimeUnit.MILLISECONDS)
        println("Hello, ")
    }
    println("World!")
    Thread.sleep(5000L)
}
```

### 使用launch函数启动协程
launch函数的定义如下：
```
public actual fun launch(  // actual是为多平台支持
    context: CoroutineContext = DefaultDispatcher,
    start: CoroutineStart = CoroutineStart.DEFAULT,
    parent: Job? = null,
    block: suspend CoroutineScope.() -> Unit  // 挂起函数
): Job {
    val newContext = newCoroutineContext(context, parent)
    val coroutine = if (start.isLazy)
        LazyStandaloneCoroutine(newContext, block) else
        StandaloneCoroutine(newContext, active = true)
    coroutine.start(start, coroutine, block)
    return coroutine
}
```
易知launch有4个参数，其中
