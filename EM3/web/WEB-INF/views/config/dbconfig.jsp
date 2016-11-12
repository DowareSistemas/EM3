<%-- 
    Document   : dbconfig
    Created on : 07/11/2016, 21:11:15
    Author     : Marcos Vinícius
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="aut" tagdir="/WEB-INF/tags/" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DB Config</title>

        <link rel="stylesheet" href="resources/css/bootstrap.css">
    </head>
    <body>
        <div class="container">
            <h5>Configuração do banco de dados</h5>

            <div id="autenticacao">
                <aut:autent-config/>
            </div>
            

            <div id="config">
                <form role="form" method="post" id="form-config" action="savedbconfig">

                    <div class="row">
                        <div class="col-md-6">
                            <label class="h5"> Banco de dados </label>
                            <select class="form-control" name="db_type">
                                <option value="SQLServer"> Microsoft SQL Server </option>
                                <option value="MySQL"> MySQL </option>
                                <option value="FirebirdSQL"> FirebirdSQL </option>
                                <option value="PostgreSQL"> PostgreSQL </option>
                            </select>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-4">
                            <label class="h5"> Servidor </label>
                            <input type="text" name="host" class="form-control"/>
                        </div>

                        <div class="col-md-2">
                            <label class="h5"> Porta </label>
                            <input class="form-control" type="number" min="0" max="9999" name="port"/>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-4">
                            <label class="h5"> Usuário </label>
                            <input type="text" name="user" class="form-control"/>
                        </div>

                        <div class="col-md-2">
                            <label class="h5"> Senha </label>
                            <input class="form-control" type="password" min="0" max="9999" name="password"/>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-4">
                            <label class="h5"> Base de dados </label>
                            <input class="form-control" name="database" />
                        </div>
                    </div>
                    <br/>
                    <div class="row">
                        <div class="col-md-2">
                            <input type="button" class="btn btn-primary form-control" id="salvar" value="Salvar"/>
                        </div>

                        <div class="row">
                            <div class="col-md-2">
                                <input type="button" class="btn btn-default form-control" id="testar" value="Testar"/>
                            </div>
                        </div>
                </form>
            </div>
        </div>
        <script src="resources/js/libs/jquery.js"></script>
        <script src="resources/js/libs/jquery-form.js"></script>
        <script src="resources/js/libs/bootstrap.js"></script>
        <script src="resources/js/my/dbconfig.js"></script>
    </body>
</html>
