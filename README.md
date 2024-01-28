项目地址`http://8.134.24.31:6666`

![image-20240128192911627](https://s2.loli.net/2024/01/28/FPHflSvNqhIe6gp.png)

感觉SQL语句可以更精简一点

[接口文档参考]("https://apifox.com/apidoc/shared-dfe01168-cd9f-4278-b88f-3e01b439ea4e")

和任务有关的操作因为没有传token，所以多传了一个`String username`，~有参考了gpt的一些`token`代码~

数据库是有两个表，一个`user`，一个`todolist`，通过`userid`来判断是哪一个用户创建的任务，感觉表可以改进，但是不知道怎么改进，有想到一个方法是每一个用户一个表



[就先这样吧]("肯定不是不想写其他的")