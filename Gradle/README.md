# Gradle的使用
Gradle是一个基于Groovy的自动化构建的工具。在AS中，它被作为自动化管理编译过程。
## The Build Process
> The build process involves many tools and processes that convert your project into an Android Application Package(APK).

![Figure 1. the build process of a typical Android app module](https://developer.android.com/images/tools/studio/build-process_2x.png)
1. 编译器将你的源码编译成DEX(Dalvik Executable)文件，这个文件中包含了在安卓设备上运行的二进制文件和其他的一些编译了的文件。
2. APk 打包器将DEX文件和编译的资源文件整合到一个apk文件中去，在你的APP能被装到安卓设备上，你需要对你的ApK文件签名。
3. 签名
4. The packager uses the zipalign tool to optimize your app to use less memory when running on a device/

## Custom Build Configurations

## Build Configuration Files
