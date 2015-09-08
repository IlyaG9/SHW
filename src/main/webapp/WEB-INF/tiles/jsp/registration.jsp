<%-- 
    Document   : registration
    Created on : 08.01.2015, 12:04:59
    Author     : @author ILYA_GOLOVACHEV.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="content-area registration-area">
	<form class="form-horizontal">
		<div class="form-group">
			<label for="text" class="col-sm-2 control-label">Имя</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="name" placeholder="Имя">
			</div>
		</div>
		<div class="form-group">
			<label for="text" class="col-sm-2 control-label">Логин</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="login"
					placeholder="Логин">
			</div>
		</div>
		<div class="form-group">
			<label for="mail" class="col-sm-2 control-label">Email</label>
			<div class="col-sm-4">
				<input type="email" class="form-control" id="mail"
					placeholder="Email">
			</div>
		</div>
		<div class="form-group">
			<label for="pass" class="col-sm-2 control-label">Пароль</label>
			<div class="col-sm-4">
				<input type="password" class="form-control" id="pass"
					placeholder="Пароль">
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-4">
				<button type="submit" class="btn btn-success">Зарегистрировать</button>
			</div>
		</div>
	</form>
</div>