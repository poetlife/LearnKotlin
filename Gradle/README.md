# Gradle的使用
Gradle是一个基于Groovy的自动化构建的工具。在AS中，它被作为自动化管理编译过程。
## The Build Process
> The build process involves many tools and processes that convert your project into an Android Application Package(APK).

![Figure 1. the build process of a typical Android app module](https://developer.android.com/images/tools/studio/build-process_2x.png)
1. 编译器将你的源码编译成DEX(Dalvik Executable)文件，这个文件中包含了在安卓设备上运行的二进制文件和其他的一些编译了的文件。
2. APk 打包器将DEX文件和编译的资源文件整合到一个apk文件中去，在你的APP能被装到安卓设备上，你需要对你的ApK文件签名。
3. 签名
4. The packager uses the zipalign tool to optimize your app to use less memory when running on a device.

## Custom Build Configurations
Gradle and the Android plugin help you configure the following aspects of your build:
+ Build Types
[how to configure bulid types](https://developer.android.com/studio/build/build-variants.html#build-types)
+ Product Flavors
你可以在这里展示不同版本，比如说免费版本和付费版本，这个需要手动设置。
[how to configure product flavors](https://developer.android.com/studio/build/build-variants.html#product-flavors)
+ Build Variants
A build variant is a cross product of a bulid type and product flavor, and is the configuration Gradle uses to build your app.
[how to configure bulid variants](https://developer.android.com/studio/build/build-variants.html)
+ Manifest Entries
You can specify values for some properties of the manifest file in the build variant configuration.These bulid values overrides the existing values in manifest file.
[merges manifest settings]（https://developer.android.com/studio/build/manifest-merge.html）
+ Dependencies
The bulid system manages project dependencies from your local filesystem adn from the remote repositories.
[add bulid dependencies](https://developer.android.com/studio/build/dependencies.html)
+ Signing
The bulid system enables you to specify signing settings in the bulid configuration, and it can automatically sign your APKs during the build process.
+ ProGuard
The build system enables you to specify a different [ProGuard](https://developer.android.com/studio/build/shrink-code.html) rules file for each bulid variant.
+ Multiple APK Support
The build system enables you to automatically build different APKs that each contain only the code and resources needed for a specific screen density or Application Binary Interface.
[Build Multiple APKs](https://developer.android.com/studio/build/configure-apk-splits.html)
## Build Configuration Files
Creating custom build configurations requires you to make changes to one or more bulid configuration files, or `build.gradle` files. These plain text files use Domain Specific Language(DSL) to describe and manipulate the build logic using Groovy, which is a dynamic language for the Java Virtual Machine.

![figure 2. The default project structure for an Android app module](https://developer.android.com/images/tools/studio/project-structure_2x.png)

There are a few Gradle build configuration files that are a part of the standard project structure for an Android App.
+ The Gradle Settings File
tells Gradle which modules it should include when building up your app.
+ The Top-level Build File
defines bulid configurations that apply to all modules in your project.By default, the top-level build file uses the `buildscript` block to define the Gradle repositories and dependencies that are common to all modules in the project.
+ The Module-level Build File
allows you to configure build settings for the specific module it is located in.
+ Gradle Properties Files

+ Syncing Project with Gradle Files

+ Source Sets
