<%-- 
    Document   : signIn
    Created on : 08.01.2015, 13:09:42
    Author     : @author ILYA_GOLOVACHEV.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container">

    <form class="form-signin" method="POST" action="${pageContext.servletContext.contextPath}/j_spring_security_check">
        <h2 class="form-signin-heading">Авторизируйтесь</h2>
        <label class="sr-only">Логин</label>
        <input type="text" name="j_username" class="form-control" placeholder="Логин" required autofocus>
        <label  class="sr-only">Пароль</label>
        <input type="password" name="j_password" class="form-control" placeholder="Пароль" required>
        <div class="checkbox">
          <label>
              <input type="checkbox" name="_spring_security_ remember_me" value="remember-me"> Запомнить меня
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Войти</button>
      </form>

    </div>
