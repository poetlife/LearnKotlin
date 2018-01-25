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
使用隐式Intent方式显示Activity，需要将Activity与action、catagory等绑定。这里的action和catagory可以是任意字符串。在创建Intent对象时，需要指定与Activity绑定的action、catagory等信息。
为Activity指定action、catagory等信息，需要在<activity>标签中指定<intent-filter>子标签，并在该子标签中定义一个<action>和一个<catagory>标签。
`Androidmanifest.xml`配置
```
<activity android:name=".SecondActivity" android:label="Uozoyo2">
     <intent-filter>
          <action android:name="com.jakie.peng.SECOND_ACTIVITY"></action>
          <category android:name="android.intent.category.DEFAULT"></category>
     </intent-filter>
</activity>    
```
其中，Action标签中的name可以是任意值，但是Catagory里面的name属性是系统内置的。
Kotlin代码：
```
    // second activity 隐式
    fun onClickShowSecondActivity(view: View){
        // 通过Intent的构造器指定Action
        var intent = Intent("com.jakie.peng.SECOND_ACTIVITY")
        startActivity(intent)
    }
```
### 为隐式Intent设置更多的过滤条件
还有第三个过滤机制：就是<Data>标签，实际上，通过<data>标签，可以将一个[Uri](https://baike.baidu.com/item/URI/2901761?fr=aladdin)分成不同部分指定。
+ android:scheme: 用于指定Uri协议部分，如http、https、ftp等
+ android:host: 用于指定Uri的主机名部分
+ android:port: 用于指定Uri的端口部分
+ android:path: 用于指定主机名和端口名之后的部分
+ android:mimeType: 用于制定可以处理的数据类型：如image/png、application/pdf等   
### 使用隐式Intent访问系统APP
基本上就是打开特定的一些窗口。
## 向Activity中传递数据

## 从Activity中返回数据

## Activity的生命周期

## 记录当前活动的Activity
