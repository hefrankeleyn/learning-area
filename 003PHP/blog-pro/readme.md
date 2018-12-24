---
author: lf
---
# 博客项目
## 一、开发环境

### 1.1 硬件环境
- winodws 7 ，64位

### 1.2 软件环境
- PHP 7.3.0
- mysql  Ver 8.0.13
- git 2.19.1

## 二、功能

2.1 用户登陆和注册；
2.2 用户发帖；
2.3 用户评论；
2.4 图片验证码；
2.5 上传图片；
2.6 阻止用户在发文章或评论时输入带html或javaScript的内容；
2.7 防范sql注入；

    关键点：
        用户登陆密码不应该是明文，应该用MD5加密；
        用户登陆后，对用户自己的帖子可以重新编译或删除功能，但无权编译其他用户的帖子；

    提示：
        - 涉及到三张表：用户表、文章表、评论表

## 三、设计思路

3.1 创建数据库表；
    想要创建一个应用，从表的设计开始总是一个非常好的想法。用一句话描述将要创建的应用程序：用户(users)阅读博客（blogs）内容，可以将想法评论(posts)到博文下面，用户自己也可以发表博客，并可以对自己发表的博客进行修改和删除。

    该应用程序涉及到三张表：用户表（users）、博客表（blogs）、评论表（posts）。

    下面，通过sql语句来对这几张表进行说明：
    
    # 创建用户表的语句
    create table if not exists users(
    uid int not null auto_increment comment 'user id',
    user_name varchar(100) not null comment 'user name',
    user_password varchar(30) not null comment 'user password',
    email varchar(50) not null unique comment 'user email',
    unique index user_name_index(user_name),
    primary key(uid) comment 'define primary key'
    )engine=InnoDB;

    # 创建博客表的语句
    create table if not exists blogs(
    bid int not null auto_increment comment 'blog id',
    blog_title varchar(50) not null comment 'blog title',
    blog_context varchar(10000) comment 'blog content',
    create_time date not null comment 'blog create time',
    update_time date not null comment 'blog update time',
    uid int not null comment 'user id',
    primary key(bid) comment 'define bid is primary key',
    foreign key(uid) references users(uid)
    )engine=InnoDB;

    # 创建评论表的语句
    create table if not exists posts(
    pid int not null auto_increment comment 'post id',
    post_context varchar(500) not null comment 'post context',
    create_time date not null comment 'post time',
    uid int not null comment 'post user id',
    primary key(pid) comment 'post primary key',
    foreign key(uid) references users(uid)
    )engine=InnoDB;



3.2 创建主页面（index.html）、阅读页面（reading.html）、我的博客页面(myblog.html)

3.3 连接数据库；

3.4 展示博客的概览；

3.5 用户注册和登陆；

3.6 用户评论；

3.7 用户发帖、修改帖子；
