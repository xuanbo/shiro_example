#   笔记

##  1.执行流程

* 身份认证
* 授权

##  2.url匹配

* `？`匹配一个字符。
  例如，/admin?能匹配/admin、/admin2，不能匹配/admin12、/admin
* `*`匹配零个、一个、多个字符
  例如，/admin*能匹配/admin、/admin1、/admin12，不能匹配/admin/1
* `**`匹配零个或者多路径
  例如，/admin/**能匹配/admin、/admin/1，不能匹配/admin1