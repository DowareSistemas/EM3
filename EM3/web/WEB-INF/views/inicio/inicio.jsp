<%-- 
    Document   : inicio
    Author     : Marcos Vinícius
    Style      : Emerson Tinoco
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
            <header>
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
            </header>
            <aside>
                <nav class="navbar navbar-fixed-left">
                    <div class="panel-heading panel-nav-left">
                        <div class="panel-body">
                            <div class="row">
                                <div class="form-group col-md-12">
                                    <img src="resources/images/profile.png" alt="Imagem perfil" width="50" height="50" class="img-circle">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-9">
                                    <label class="text-nav-left">hello@example.com</label>
                                </div>
                                <div class="col-md-3">
                                    <button type="button" class="btn btn-panel-nav-left dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        <span class="glyphicon glyphicon-triangle-bottom"></span>
                                    </button>
                                    <ul class="dropdown-menu dropdown-menu-right">
                                        <li><a href="#">hello@example.com</a></li>
                                        <li><a href="#">info@example.com</a></li>
                                        <li role="separator" class="divider"></li>
                                        <li>
                                            <a href="#"><span class="glyphicon glyphicon-plus"></span> Adicionar outra conta</a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-12">
                            <button type="button" class="btn btn-block btn-nav-left">
                                <span class="glyphicon glyphicon-triangle-bottom"></span>
                                <label class="text-nav-left">  Estoque</label>
                            </button>
                            <button type="button" class="btn btn-block btn-nav-left">Olá</button>
                            <button type="button" class="btn btn-block btn-nav-left">Olá</button>
                            <button type="button" class="btn btn-block btn-nav-left">Olá</button>
                            <button type="button" class="btn btn-block btn-nav-left">Olá</button>
                        </div>
                    </div>
                </nav>
            </aside>
            <main>
                <div class="aside-main">
                    <inicio:conteudo-inicio/>
                </div>
            </main>
        </div>



        <%-- OLD STYLE

                <li class="active" id="li-home"><a data-toggle="tab" href="#home"> Doware EM3 </a></li>


                    <inicio:conteudo-inicio/>
        --%>
        <script src="resources/js/libs/jquery.js"></script>
        <script src="resources/js/libs/bootstrap.js"></script>
        <script src="resources/js/my/inicio.js"></script>
    </body>
</html>
