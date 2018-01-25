# 第11章 Android的窗口——Activity
## 什么是Activity
Activity是安卓中最重要的组件之一，绝大多数Android APP都会有至少一个Activity，它是显示各种UI的窗口。
## Activity的基本用法
### 手动创建一个Activity
```
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle

// Activity必须是Activity的直接或者间接子类
class New: AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        // 重写的函数必须调用父类中同样的函数
    }
}
```
### 创建和加载布局
layout:
```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical" android:layout_width="match_parent"
    android:layout_height="match_parent">
    <Button
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="点击我哦"/>

</LinearLayout>
```
new.kt:
```
setContentView(R.layout.my_activity)  // 装载的布局文件
        // 在Android中，所有资源文件都必须使用R.layout.XXX形式引用，其中XXX为资源名，不包括扩展名
```
### 在AndroidManifest文件中注册Activity

### 编译和运行Android工程

### 为Activity添加新组件

### 为Activity添加逻辑代码

### 为Activity添加Toast

### 关闭Activity
## 使用Intent连接多个Activity

## 向Activity中传递数据

## 从Activity中返回数据

## Activity的生命周期

## 记录当前活动的Activity
