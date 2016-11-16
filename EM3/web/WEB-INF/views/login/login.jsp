<%-- 
    Document   : login
    Created on : 09/11/2016, 13:03:42
    Author     : Marcos Vinícius
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/mensagens/" prefix="msg" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <link rel="stylesheet" href="resources/css/bootstrap.css">
        <link rel="stylesheet" href="resources/css-my/login.css">
    </head>
    <body id="body">

        <div class="container">
            <div id="space"></div>
            <div class="row">
                <div class="col-md-4"></div>

                <div class="col-md-4">
                    <div class="panel">
                        <form action="usr-login" id="form-login" method="post">
                            <div class="panel panel-heading" style="background: grey">
                                <div class="panel-title">
                                    <h4 class="h4"> Autenticação </h4>
                                </div>
                            </div>


                            <div class="panel panel-body">
                                <div class="row">
                                    <div class="col-md-12">
                                        <label class="h5"> Usuário </label>
                                        <input type="text" id="txNome" name="nome" class="form-control"/>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-md-12">
                                        <label class="h5"> Senha </label>
                                        <input type="password" id="txSenha" name="senha" class="form-control"/>
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-12">
                                    <label class="h5"> Empresa </label>
                                    <input type="search" class="form-control" />
                                </div>
                            </div>
                            <br/>
                            <div class="row">
                                <div class="col-md-4 pull-right">
                                    <input type="button" id='btnLogin' class="btn btn-primary" value="Login"/>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

            <div class="col-md-4"></div>
        </div>
    </div>
    
    <msg:mensagem-ok id="msg-login"/>
    
    <script src="resources/js/libs/jquery.js"></script>
    <script src="resources/js/libs/bootstrap.js"></script>
    <script src="resources/js/libs/jquery-form.js"></script>
    <script src="resources/js/my/login.js"></script>
</body>
</html>
