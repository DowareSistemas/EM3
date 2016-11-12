<%-- 
    Document   : visualizacao
    Created on : 06/11/2016, 12:25:15
    Author     : Marcos Vinícius
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="formulario" tagdir="/WEB-INF/tags/formularios/" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <link rel="stylesheet" href="resources/css/datatables.css">
    </head>
    <body>

        <div id="formulario">
            <formulario:cadastro-cliente/>
        </div>
        
        <div id="visualizacao">
            <div class="row">
                <div class="col-md-11">
                    <h4> Cadastro de clientes </h4>
                </div>
                <div class="col-md-1">
                    <button type="button" class="btn btn-link pull-right"> Sair </button>
                </div>
            </div>

            <div class="row">
                <div class="col-md-3 col-sm-3 col-xs-3">
                    <input type="text" class="form-control col-md-3" placeholder="Pesquisar"/>
                </div>

                <button id="btnNovo" type="button" class="btn btn-primary">
                    <span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Novo
                </button>

                <button type="button" class="btn btn-default">
                    <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span> Alterar
                </button>

                <button type="button" class="btn btn-default">
                    <span class="glyphicon glyphicon-trash" aria-hidden="true"></span> Excluir
                </button>

            </div>

            <table id="tabela" style="margin-top: 10px" class="table table-bordered table-striped">
                <thead>
                    <tr>
                        <th> Codigo </th>
                        <th> Nome </th>
                        <th> Telefone 1 </th>
                        <th> Telefone 2 </th>
                        <th> Email </th>
                        <th> CPF </th>
                        <th> RG </th>
                    </tr>
                </thead>

                <tbody>
                    <tr>
                        <td> 1 </td>
                        <td> Marcos Vinicius P. Oliveira </td>
                        <td> 24 3337-7005 </td>
                        <td>  </td>
                        <td> marcos8154@gmail.com </td>
                        <td> 171.321.077-04 </td>
                        <td> 254848565-78 </td>
                    </tr>
                    <tr>
                        <td> 1 </td>
                        <td> Marcos Vinicius P. Oliveira </td>
                        <td> 24 3337-7005 </td>
                        <td>  </td>
                        <td> marcos8154@gmail.com </td>
                        <td> 171.321.077-04 </td>
                        <td> 254848565-78 </td>
                    </tr>
                    <tr>
                        <td> 1 </td>
                        <td> Marcos Vinicius P. Oliveira </td>
                        <td> 24 3337-7005 </td>
                        <td>  </td>
                        <td> marcos8154@gmail.com </td>
                        <td> 171.321.077-04 </td>
                        <td> 254848565-78 </td>
                    </tr>
                    <tr>
                        <td> 1 </td>
                        <td> Marcos Vinicius P. Oliveira </td>
                        <td> 24 3337-7005 </td>
                        <td>  </td>
                        <td> marcos8154@gmail.com </td>
                        <td> 171.321.077-04 </td>
                        <td> 254848565-78 </td>
                    </tr>

                    <tr>
                        <td> 1 </td>
                        <td> Marcos Vinicius P. Oliveira </td>
                        <td> 24 3337-7005 </td>
                        <td>  </td>
                        <td> marcos8154@gmail.com </td>
                        <td> 171.321.077-04 </td>
                        <td> 254848565-78 </td>
                    </tr>

                    <tr>
                        <td> 1 </td>
                        <td> Marcos Vinicius P. Oliveira </td>
                        <td> 24 3337-7005 </td>
                        <td>  </td>
                        <td> marcos8154@gmail.com </td>
                        <td> 171.321.077-04 </td>
                        <td> 254848565-78 </td>
                    </tr>

                    <tr>
                        <td> 1 </td>
                        <td> Marcos Vinicius P. Oliveira </td>
                        <td> 24 3337-7005 </td>
                        <td>  </td>
                        <td> marcos8154@gmail.com </td>
                        <td> 171.321.077-04 </td>
                        <td> 254848565-78 </td>
                    </tr>

                    <tr>
                        <td> 1 </td>
                        <td> Marcos Vinicius P. Oliveira </td>
                        <td> 24 3337-7005 </td>
                        <td>  </td>
                        <td> marcos8154@gmail.com </td>
                        <td> 171.321.077-04 </td>
                        <td> 254848565-78 </td>
                    </tr>

                    <tr>
                        <td> 1 </td>
                        <td> Marcos Vinicius P. Oliveira </td>
                        <td> 24 3337-7005 </td>
                        <td>  </td>
                        <td> marcos8154@gmail.com </td>
                        <td> 171.321.077-04 </td>
                        <td> 254848565-78 </td>
                    </tr>

                    <tr>
                        <td> 1 </td>
                        <td> Marcos Vinicius P. Oliveira </td>
                        <td> 24 3337-7005 </td>
                        <td>  </td>
                        <td> marcos8154@gmail.com </td>
                        <td> 171.321.077-04 </td>
                        <td> 254848565-78 </td>
                    </tr>

                    <tr>
                        <td> 1 </td>
                        <td> Marcos Vinicius P. Oliveira </td>
                        <td> 24 3337-7005 </td>
                        <td>  </td>
                        <td> marcos8154@gmail.com </td>
                        <td> 171.321.077-04 </td>
                        <td> 254848565-78 </td>
                    </tr>
                    <tr>
                        <td> 1 </td>
                        <td> Marcos Vinicius P. Oliveira </td>
                        <td> 24 3337-7005 </td>
                        <td>  </td>
                        <td> marcos8154@gmail.com </td>
                        <td> 171.321.077-04 </td>
                        <td> 254848565-78 </td>
                    </tr>
                    <tr>
                        <td> 1 </td>
                        <td> Marcos Vinicius P. Oliveira </td>
                        <td> 24 3337-7005 </td>
                        <td>  </td>
                        <td> marcos8154@gmail.com </td>
                        <td> 171.321.077-04 </td>
                        <td> 254848565-78 </td>
                    </tr>

                    <tr>
                        <td> 1 </td>
                        <td> Marcos Vinicius P. Oliveira </td>
                        <td> 24 3337-7005 </td>
                        <td>  </td>
                        <td> marcos8154@gmail.com </td>
                        <td> 171.321.077-04 </td>
                        <td> 254848565-78 </td>
                    </tr>
                    <tr>
                        <td> 1 </td>
                        <td> Marcos Vinicius P. Oliveira </td>
                        <td> 24 3337-7005 </td>
                        <td>  </td>
                        <td> marcos8154@gmail.com </td>
                        <td> 171.321.077-04 </td>
                        <td> 254848565-78 </td>
                    </tr>
                    <tr>
                        <td> 1 </td>
                        <td> Marcos Vinicius P. Oliveira </td>
                        <td> 24 3337-7005 </td>
                        <td>  </td>
                        <td> marcos8154@gmail.com </td>
                        <td> 171.321.077-04 </td>
                        <td> 254848565-78 </td>
                    </tr>
                    <tr>
                        <td> 1 </td>
                        <td> Marcos Vinicius P. Oliveira </td>
                        <td> 24 3337-7005 </td>
                        <td>  </td>
                        <td> marcos8154@gmail.com </td>
                        <td> 171.321.077-04 </td>
                        <td> 254848565-78 </td>
                    </tr>

                </tbody>
            </table>
        </div>

        <script src="resources/js/libs/jquery.js"></script>
    
        <script src="resources/js/libs/datatables.js"></script>
        <script src="resources/js/my/clientes.js"></script>
    </body>
</html>
