## wapiti

​	Wapiti是一个开源的基于web的工具，它扫描部署的web应用程序的web页面，寻找可以注入数据的脚本和表单。

​	Wapiti执行的是“黑盒”方式的扫描，也就是说直接对网页进行扫描，而不需要扫描*Web应用程序的源代码。

​	Wapiti通过扫描网页的脚本和表单，查找可以注入数据的地方

​	它是用Python构建的，使用的时候需要Python环境，可以检测：

​	文件处理错误（本地和远程include/require，fopen，readfile…）

​	数据库、XSS、LDAP和CRLF注入（HTTP响应拆分、会话固定…）

​	命令执行检测（eval（），system（），passtru（）…）

​	可以去：[http://sourceforge.net/projects/wapiti/](http://sourceforge.net/projects/wapiti/)下载windows的版本，这里主要介绍kali环境下的wapiti

### 主要的操作：

#### 	安装：

#### 		1：首先更新一下库

​				`sudo apt-get update`

#### 		2：安装wapiti

​				`sudo apt-get install wapiti`

#### 		3：安装依赖包

​				`sudo apt-get -f install`

#### 	基本操作

​			`wapiti -u http://testphp.vulnweb.com/ -o wapiti_result -f html`

​			-u 为要测试的网站

​			-0 导出报告的文件名

​			-f 为导出报告的格式
​			[http://testphp.vulnweb.com/](http://testphp.vulnweb.com/)为靶机所以大家可以放心扫描

#### 其他参数

 `-x <URL>：从扫描中排除特定的 URL，对于登出和密码修改 URL 很实用。`
 `-o <output>：设置输出文件及其格式，如：result.html`
 `-f <type_file>：设置输出文件格式，如：html,json等`
 `-m <module_options>：设置模块进行攻击`
 `-i <file>：从 XML 文件中恢复之前保存的扫描。文件名称是可选的，因为如果忽略的话 Wapiti 从scan文件夹中读取文件。`
`-a <login%password>：为 HTTP 登录使用特定的证书。`
`--auth-method <method>：为-a选项定义授权方式，可以为basic，digest，kerberos 或 ntlm。`
 `-s <URL>：定义要扫描的 URL。`
`-p <proxy_url>：使用 HTTP 或 HTTPS 代理。`