# OKHttpDemo
#
# 这是关于OKHttp对Get请求的深度封装
#
# 新增post请求，并与get请求兼容做到统一请求方式，详细请看MainActivity实例


通过在application中注册对所有请求进行统一管理，通过tag来结束当前请求，可以设置是否打印请求的log日志，以及通过对请求接口的拼接从而更好的管理所有请求接口

使用cookie进行持久化   用的是PersistentCookieJar开源代码
