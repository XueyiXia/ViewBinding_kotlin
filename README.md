# ViewBinding_kotlin

kotlin 版本的ViewBinding ，首先我们为什么使用ViewBinding ？

看一段常规代码：

![image](https://user-images.githubusercontent.com/25949241/192211746-a9b19cd5-b64b-413b-a1ed-bd0176018b8f.png)

每次都需要定义一个组件的名字，然后通过findViewById 获取这个组件的id ,然后才可以进行一些操作，赋值等等，如果有100个组件，需要进行100 次findViewById，繁琐的工作，大大增加了工作量

接下来，再看一段代码

![image](https://user-images.githubusercontent.com/25949241/192212222-0457e601-3a4f-4d55-b741-5fdc35468edb.png)

是不是很简洁，不需要先定义一个组件的常量，也不需要findViewById！！

其实关于使用ViewBinding 的使用，也非常简单，自行去google了，这个项目是对ViewBinding 进行了一次封装，主要在BaseActivity 和BaseFragment中

步骤：
step 1.
在主工程中，开启ViewBinding

![image](https://user-images.githubusercontent.com/25949241/113827267-afd86000-97b5-11eb-80e1-a31fdeaaa812.png)

step 2.
增加远程依赖仓库

 implementation 'com.github.XueyiXia:ViewBinding_kotlin:v1.0'
 
![image](https://user-images.githubusercontent.com/25949241/192212985-d5640c9a-1829-4906-a763-f72ba7b17f23.png)

step3.

在Activity 中 使用，继承BaseActivity：

![image](https://user-images.githubusercontent.com/25949241/192213261-2972620a-7bf9-4749-8c97-af04bac20ae9.png)


在Fragment 中 使用，继承BaseFragment：

![image](https://user-images.githubusercontent.com/25949241/192215316-df984e96-3210-40aa-87c0-4104581aa5fc.png)

以上就是viewbinding 的使用，这个最基础的版本，在项目中，可以改造基类，搭配mvp 或者MVVM 开发架构使用


在项目中使用：
build.gradle 增加implementation 'com.github.XueyiXia:ViewBinding_kotlin:1.0.1'
 
![image](https://user-images.githubusercontent.com/25949241/198540162-e90092d7-07fa-4b7c-8dc2-d53de098459d.png)



