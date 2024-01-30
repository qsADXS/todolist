服务器地址`http://8.134.24.31:6666`

![image-20240128192911627](https://s2.loli.net/2024/01/28/FPHflSvNqhIe6gp.png)

感觉SQL语句可以更精简一点

[接口文档参考](https://apifox.com/apidoc/shared-dfe01168-cd9f-4278-b88f-3e01b439ea4e)

和任务有关的操作因为没有传token，所以多传了一个`String username`，~有参考了gpt的一些`token`代码~

然后因为一些失误，除了`get`以外，都是用`body`参数

数据库是有两个表，一个`user`，一个`todolist`，通过`userid`来判断是哪一个用户创建的任务，感觉表可以改进，但是不知道怎么改进，有想到一个方法是每一个用户一个表，这样更符合三大范式

- todolist

  ![image-20240128194256299](https://s2.loli.net/2024/01/28/5ITQJ79wBUslpgF.png)

- user

  ![image-20240128194237595](https://s2.loli.net/2024/01/28/wTLK6Dn5I7VyqAN.png)

[就先这样吧](https://github.com/qsADXS/todolist "肯定不是不想写其他的")

因为是赶工写的，所以没有用安全框架，~肯定不是我还不会~，~重生之用两天时间从0开始完成简单的springboot项目~
