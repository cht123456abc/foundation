

### TASKING

- Client
  - Account current // 当前账户
  - Account login(String username, String password) // 判断或修改账号的status
  - Account register(String username,String password)// 注册账号前事先判断是否已经注册
  - Boolean modify(Account account) // 修改账号对应的密码
- Account
  - String username
  - String password
  - Boolean login // 登录状态
- AccountTable
  - Map<String,Account> accounts // 用户名与账号的映射
  - addAccount()
