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
更多配置信息，参见[https://github.com/Kotlin/kotlinx.coroutines#gradle](Kotlin-coroutines-cores Github)
