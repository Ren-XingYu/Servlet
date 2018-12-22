<%--
  Created by IntelliJ IDEA.
  User: RenXingYu
  Date: 2018/12/22
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Login</title>
  </head>
  <body>
      <form action="LoginServlet" method="post">
        <table>
          <tr>
            <td>用户名：</td>
            <td><input type="text" name="username"></td>
          </tr>
          <tr>
            <td>密  码：</td>
            <td><input type="password" name="password"></td>
          </tr>
          <tr>
            <td><input type="submit" value="注册"></td>
          </tr>
        </table>
      </form>
  </body>
</html>
