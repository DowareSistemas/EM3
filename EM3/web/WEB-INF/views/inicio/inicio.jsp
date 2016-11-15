<%-- 
    Document   : inicio
    Created on : 06/11/2016, 11:01:07
    Author     : Marcos Vinícius
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="inicio" tagdir="/WEB-INF/tags/" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="resources/css/bootstrap.css"/>
        <link rel="stylesheet" href="resources/css/style.css"/>
    </head>
    <body>
        <div class="container-fluid">
            <nav class="navbar navbar-default navbar-fixed-top">
                <div class="container">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="#">Curae</a>
                    </div>
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

                    </div>
                </div>
            </nav>
        
            <nav class="navbar navbar-fixed-left" id="menulateral">
                <div class="panel-heading panel-nav-left">
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-md-12">
                                <img src="resources/images/profile.png" alt="Imagem perfil" width="50" height="50" class="img-circle">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-9">
                                <label class="text-nav-left">hello@example.com</label>
                            </div>
                            <div class="col-md-3">
                                <button type="button" class="btn btn-panel-nav-left">
                                    <span class="glyphicon glyphicon-triangle-bottom"></span>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-12">
                        <button type="button" class="btn btn-block btn-nav-left">
                            <span class="glyphicon glyphicon-triangle-bottom"></span>
                             <label class="text-nav-left">Estoque</label>
                        </button>
                        <button type="button" class="btn btn-block btn-nav-left" id="teste">Olá</button>
                        <button type="button" class="btn btn-block btn-nav-left">Olá</button>
                        <button type="button" class="btn btn-block btn-nav-left">Olá</button>
                        <button type="button" class="btn btn-block btn-nav-left">Olá</button>
                    </div>
                </div>


            </nav>
        </div>



        <%-- OLD STYLE
        <div class="col-md-12 col-lg-12 col-xs-12" style="margin-top: 10px;">
            <ul class="nav nav-tabs" id="abas" style="background: #204d74">

                <li class="active" id="li-home"><a data-toggle="tab" href="#home"> Doware EM3 </a></li>

            </ul>

            <div id="conteudo-abas" class="tab-content">
                <div id="home" class="tab-pane in active">
                    <inicio:conteudo-inicio/>
                </div>
            </div>

        </div>
        --%>
        <script src="resources/js/libs/jquery.js"></script>
        <script src="resources/js/libs/bootstrap.js"></script>
        <script src="resources/js/my/inicio.js"></script>
    </body>
</html>
