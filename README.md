# BankCardSystem
银行卡管理系统 jave web
一、项目名称
　		信用卡项目
二、功能要求
1.注册
2.登录
3.浏览信用卡列表

三、需求分析
普通用户需要注册登录后可以进行信用卡银行列表浏览
四、设计思想
   
1.使用JAVA语言
2.使用Servelet实现后台服务，使用JSP或者Android实现前端页面
3.使用集合进行数据的存储和管理 主要使用了List、Map集合
4.使用数据库进行数据的存储和管理 

五、具体实现
　1、技术思路：
界面：基于ServLet使用Tomcat服务器实现用户在Web端的交互
程序流程：通过request 和response进行servlet和jsp之间的数据传输

2、功能子函数划分：
主页显示
注册功能
判断用户名、密码、手机号是否为空
判断注册时手机号码是否符合规范
判断两次密码输入是否一致
访问数据库，判断该用户是否已存在
访问数据库，将数据插入
跳转登录页面
登录功能
访问数据库，用户名和密码是否正确
返回登录状态
跳转个人用户首页
  退出功能