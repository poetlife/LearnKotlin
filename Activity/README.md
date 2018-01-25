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
```
<activity android:name=".New" android:label="我的窗口">
            <intent-filter>
                <action android:name="android.intent.action.MAIN"></action>
                <category android:name="android.intent.category.LAUNCHER"></category>
            </intent-filter>
</activity>
```
### 编译和运行Android工程
使用了ADB连接了我自己的手机。
### 为Activity添加新组件
```
<EditText
        android:id="@+id/edittext"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />
```
### 为Activity添加逻辑代码
```
class MyActivity: AppCompatActivity()
{
    // 声明一个edittext类型的变量
    var edittext: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.my_activity)
        edittext = findViewById(R.id.edittext)
    }
    fun onClick(view: View){
        edittext?.setText("I love uozoyo forever!")
    }
}
```
### 为Activity添加Toast
```
fun onClickToast(view: View){
        // edittext with ?
        Toast.makeText(this, edittext?.text, Toast.LENGTH_LONG ).show()
    }
```
### 关闭Activity
```
// 关闭Activity
    fun onClickClose(view: View){
        finish()
    }
```
如果一个APP只有一个Activity，当关闭这个Activity时，这个APP就关闭了。
## 使用Intent连接多个Activity
一般一个APP都不会还有一个Activity，如果包含了多个Activity，那么就会涉及这些Activity之间的交互。
### 使用显示Intent
main_activity
```
// second activity
    fun onClickShowSecondActivity(view: View){
        // SecondActivity:: class.java用于获取SecondActivity中的Java类的元数据
        var intent = Intent(this, SecondActivity::class.java)
        // 第二个参数是要显示Activity的class（Activity的元数据）
        startActivity(intent)
    }
```
activity_second
```
package com.peng.jakie.uozoyo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
    }
    open fun onClickClose(view: View){
        finish()
    }
}
```
### 使用隐式Intent

### 为隐式Intent设置更多的过滤条件

### 使用隐式Intent访问系统APP

## 向Activity中传递数据

## 从Activity中返回数据

## Activity的生命周期

## 记录当前活动的Activity
