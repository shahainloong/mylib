------

# JQuery 

> Author：Echo
>

## 1. 简介

官网地址：https://jquery.com/，目前的版本是jquery-3.5.1。

jQuery 是一个 JavaScript 库/框架，使用方法：

<head>
<script type="text/javascript" src="./../static/jquery-3.5.1.js"></script>
</head>

在HTML5中，没有必要在 <script> 标签中使用 type="text/javascript"，因为JavaScript 是 HTML5 以及所有现代浏览器中的默认脚本语言！
jQuery代码必须在文档加载完成之后运行，也就是说在DOM加载完成之后才能对DOM进行操作。

```javascript
// 使用方法如下
$(document).ready(function () {
    alert("hello jquery");
})
```

但是一般可以这么用，而且下面的是常用的写法

```javascript
$(function(){
	alert("hello jquery");
});
```

## 2. 常用JQuery操作

### 2.1 定义HTML中的DIV：

```html
<div id="wulin">
    <ul id="ming">
        <li class="male">Zhang Wuji</li>
        <li class="female">Yang Buhui</li>
        <li class="male">Yang Xiao</li>
        <li class="male">Fan Yao</li>
    </ul>
    <ul id="wudang">
        <li class="male">Zhang Sanfeng</li>
        <li class="male">Zhang Cuishang</li>
        <li class="male">Song Yuanqiao</li>
        <li class="male">Song Qingshu</li>
    </ul>
    <ul id="emei">
        <li class="female">Mei Jue</li>
        <li class="female">Zhou Zhiruo</li>
        <li class="female">Ji Xiaofu</li>
        <li class="female">Ding Minjun</li>
    </ul>
</div>
```

### 2.2 jQuery的选择器操作：

```javascript
$(function () {
    // To get a javascript object by js statement
    var femaleJS = document.getElementsByClassName("female");
    // femaleJS is javascript object so that we could not use jQuery function .css()
    // femaleJS.css("color", "#f00");
    // use $(xxx) can make JS object as a jquery object
    $(femaleJS).css("color", "#f00");
    // every jquery node is array, and its value is js node
    // alert($("ul li").length);
    // alert($("ul li")[1].html());
    var mingUsers = $("ul#ming li");
    for (var i = 0; i < mingUsers.length; i++) {
        // This is js usage description.
        var mingUser = mingUsers[i];
        mingUser.innerHTML = "[" + (i + 1) + "]" + mingUser.innerHTML;
    }
    var wudangUsers = $("ul#wudang li");
    for (var i = 0; i < wudangUsers.length; i++) {
        // This is the usage description of jQuery.
        var wudangUser = $(wudangUsers[i]);
        wudangUser.html("[" + (i + 1) + "]" + wudangUser.html());
    }
})
```

### 2.1 选择器操作

