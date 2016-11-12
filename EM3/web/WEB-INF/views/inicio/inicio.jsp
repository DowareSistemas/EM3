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
        <link rel="stylesheet" href="resources/css-my/inicio.css"/>
    </head>
    <body>

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

        <script src="resources/js/libs/jquery.js"></script>
        <script src="resources/js/libs/bootstrap.js"></script>
        <script src="resources/js/my/inicio.js"></script>
    </body>
</html>
