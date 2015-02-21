<%-- 
    Document   : base
    Created on : 04.01.2015, 14:10:51
    Author     : @author ILYA_GOLOVACHEV
--%>

<%@ page contentType="text/html; charset=utf-8"%> 
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <meta http-equiv="refresh" content="60">
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
        <title><tiles:insertAttribute name="title" /></title>
    </head>
    <body>
        <tiles:insertAttribute name="menu" />
        <tiles:insertAttribute name="body" />


        <div class="overlay" title="Окно входа"></div>
        <div class="popup">
            <div class="close_window">x</div>
            <div class="container">

                <form  action="${pageContext.servletContext.contextPath}/j_spring_security_check" method="POST">
                    <h2 class="form-signin-heading">Вход</h2>
                    <input name="j_username" placeholder="Логин" required autofocus><br></br>
                    <input name="j_password" type="password" placeholder="Пароль" required>
                    <div class="checkbox">
                        <label>
                            <input type="checkbox" name="_spring_security_ remember_me" value="remember-me"> Запомнить меня
                        </label>
                    </div>
                    <button class="btn btn-lg btn-primary " type="submit">Вход</button>
                </form>

            </div>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <script src="${pageContext.servletContext.contextPath}/js/ie10-viewport-bug-workaround.js"></script>
        <!-- Yandex.Metrika counter -->
        <script type="text/javascript">
            (function(d, w, c) {
                (w[c] = w[c] || []).push(function() {
                    try {
                        w.yaCounter27871902 = new Ya.Metrika({
                            id: 27871902
                        });
                    } catch (e) {
                    }
                });

                var n = d.getElementsByTagName("script")[0],
                        s = d.createElement("script"),
                        f = function() {
                            n.parentNode.insertBefore(s, n);
                        };
                s.type = "text/javascript";
                s.async = true;
                s.src = (d.location.protocol == "https:" ? "https:" : "http:") + "//mc.yandex.ru/metrika/watch.js";

                if (w.opera == "[object Opera]") {
                    d.addEventListener("DOMContentLoaded", f, false);
                } else {
                    f();
                }
            })(document, window, "yandex_metrika_callbacks");
        </script>
        <noscript><div><img src="//mc.yandex.ru/watch/27871902" style="position:absolute; left:-9999px;" alt="" /></div></noscript>
        <!-- /Yandex.Metrika counter --> 
    </body>
</html>
