<%-- 
    Document   : base
    Created on : 04.01.2015, 14:10:51
    Author     : @author ILYA_GOLOVACHEV
--%>

<%@ page contentType="text/html; charset=utf-8"%> 
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="${pageContext.servletContext.contextPath}/img/favicon.ico">
        <link href="${pageContext.servletContext.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.servletContext.contextPath}/css/starter-template.css" rel="stylesheet">
        <script src="${pageContext.servletContext.contextPath}/js/jquery.min.js"></script>
        <script src="${pageContext.servletContext.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.servletContext.contextPath}/js/shome.js"></script>
        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]--> 
        <title>SHome</title>
    </head>
    <body>
        <tiles:insertAttribute name="menu" />
        <tiles:insertAttribute name="body" />


        <div class="overlay" title="Окно входа"></div>
        <div class="popup">
            <div class="close_window">x</div>
            <div class="container">

                <form class="form-signin" action="${pageContext.servletContext.contextPath}/login" method="POST">
                    <h2 class="form-signin-heading">Вход</h2>
                    <input name="name" placeholder="Логин" required autofocus><br></br>
                    <input name="password" type="password" placeholder="Пароль" required>
                    <div class="checkbox">
                        <label>
                            <input type="checkbox" value="remember-me"> Запомнить меня
                        </label>
                    </div>
                    <button class="btn btn-lg btn-primary " type="submit">Вход</button>
                </form>

            </div>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <script src="${pageContext.servletContext.contextPath}/js/ie10-viewport-bug-workaround.js"></script>
    </body>
</html>
