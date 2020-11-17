# web应用安全侦测工具

## Netsparker

​	Netsparker是一款web应用安全漏洞扫描工具，与其他安全扫描工具相比更好检测SQL注入和跨站脚本攻击类型的安全漏洞。它分为专业版和免费版，免费版的功能也比较强大。Netsparker与其他综合 性的web应用安全扫描工具相比的一个特点是它能够更好的检测SQL Injection和 Cross-site Scripting类型的安全漏洞

​	获取DEMO的链接

​	[https://www.netsparker.com/blog/news/end-of-life-netsparker-community-edition/](https://www.netsparker.com/blog/news/end-of-life-netsparker-community-edition/)

​	需要工作邮箱才能获取

​	

## Websecurify

​	Websecurify是一个非常易于使用和开源的工具，它通过使用高级发现和模糊技术自动识别web应用程序漏洞。

​	它可以创建简单的报告（可以导出为多种格式）一旦运行。该工具还可以使用多种语言，并且可以通过附加支持进行扩展。

​	下载链接

​	[http://code.google.com/p/websecurify/downloads/list](http://code.google.com/p/websecurify/downloads/list)

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



## Skipfish

​	Skipfish是一款主动的Web应用程序安全侦察工具。它通过执行递归爬取和基于字典的探测来为目标站点准备交互式站点地图。

### 	主要特征

​			高速：纯C代码，高度优化的HTTP处理，最小的CPU占用空间 - 轻松实现响应目标的每秒2000个请求。

​			易于使用：启发式支持各种古怪的Web框架和混合技术站点，具有自动学习功能，动态词汇表创建和表单自动完成功能。
​			尖端的安全逻辑：高质量，低误报率，差分安全检查，能够发现一系列细微的缺陷，包括盲注入矢量。

### 	基础操作

#### 			1.skipfish --help

​					查看这个命令的参数选项

#### 			2.skipfish -o /root/桌面/skipfish_test https://www.bilibili.com/

​					扫描https://www.bilibili.com/将结果存在 /root/桌面/skipfish_test中

#### 			3.skipfish -o /root/桌面/url/test @/root/桌面/url/url.txt

​					扫描多个目标,该命令表示扫描url.txt文件中的url, 并且将扫描结果存放在test文件内

#### 			4.skipfish -o test -S complet.wl -W abc.wl http://1.1.1.1 

​				使用字典：

​				`dpkg -L skipfish | grep wl`：查询skipfish使用的字典

​				`skipfish -o test1 -I /dvwa/ -S /usr/share/skipfish/dictionaries/minimal.wl http://172.16.10.133/dvwa/`

​				指定skipfish查询使用的字典

### 	更多操作

​		

```
-I 只检查包含′string′的 URL
skipfish -o test -I /dvwa/ http:``//1.1.1.1/dvwa/
```

 

```
-X 不检查包含′string′的URL #例如：login
skipfish -o test -X /login/ http:``//1.1.1.1/dvwa/
```

 

```
-S 用字典去爬网站
skipfish -o test -S complet.wl http:``//1.1.1.1/dvwa/
```

 

```
-K 不对指定参数进行 Fuzz 测试
如果你不想对参数进行Fuzz测试就可以指定
```

 

```
-D 跨站点爬另外一个域
skipfish -o test -D http:``//url -I /dvwa/ http://1.1.1.1/dvwa/
```

 

```
-l 每秒最大请求数 真实性能还要考虑你的网络环境
skipfish -o test -l 200 -S complet.wl http:``//1.1.1.1/dvwa/
```



```
-m 每IP最大并发连接数
skipfish -o test -m 100 -I /dvwa/ http:``//1.1.1.1/dvwa/
```



### 	身份认证

​	

```
基于http身份认证
skipfish -A user:pass -o test http:``//1.1.1.1/dvwa/
```

```
基于Cookies身份认证
skipfish -C ``"name=val"` `-o test http:``//1.1.1.1/dvwa/
如果有多个cookies值，多一个cookies就多一个 -C ``"name=val"
skipfish -o test -C ``"name=val"` `-C ``"name=val"` `http:``//1.1.1.1/dvwa/
```

```
基于表单的身份认证
skipfish -o test --auth-form url --auth-form-atrget url --auth-user-filed 用户名的表单名 --auth-user 用户名 --auth-pass-filed 用户名的密码名 --auth-pass 密码 --auth-verify-url url http:``//1.1.1.1/dvwa/
```

 

```
--auth-form url 表单所在网页
--auth-form-atrget 表单提交到哪个url处理表单
--auth-verify-url 表单提交成功后，重定向哪个url，就是身份认证成功后所在页面
```

​	





