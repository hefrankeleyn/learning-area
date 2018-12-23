# 切换到mysql数据库
use mysql;

# 查看所有的用户
select user from user;

# 创建一个用户
create user php identified by "php@world";

# mysql用户重命名
rename user php to php_test;

# mysql删除一个用户
# mysql 5之前要先用revoke删除账号相关权限，然后再用drop user 删除账号
drop user php_test;

# 新创建的用户，没有分配权限前，除了能够登陆数据库外，不能做任何操作（包括查看数据）

# 查看赋予用户的权限
show grants for php;

# mysql的权限用户用户名和主机名结合定义：user@host，如果不指定主机名，使用默认主机名%

# 授予php用户对diy_blog库中所有表的查看权限
grant select on diy_blog.* to php;

# 撤销用户的php用户的权限
revoke select on diy_blog.* from php;

# 授予php用户对php_db库的select insert update delete drop 权限
grant select, insert, update, delete,drop on php_db.* to php;




# 更改密码

use mysql;
# 将php的密码从php@world修改为world
alter user 'php'@'%' identified with caching_sha2_password by 'world';

##  caching_sha2_password 是比较新的加密方式，平时很多应用都不支持
## caching_sha2_password 是默认的加密方式
# 查看加密方法
select user,plugin from user;

# 将加密方式改为 mysql_native_password
alter user 'php'@'%' identified with mysql_native_password by 'php@world';

