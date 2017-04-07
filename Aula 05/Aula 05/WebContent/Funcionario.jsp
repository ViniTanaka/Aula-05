<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="model.Funcionario" %>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Visualizar Funcionário</title>

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
    </head>

    <body>
        <%Funcionario funcionario = (Funcionario) request.getAttribute("funcionario");%>
        <!-- Barra superior com os menus de navegação -->

        <!-- Container Principal -->
        <div id="main" class="container">
            <h3 class="page-header">Visualizar Funcionário #<%=funcionario.getCpf()%></h3>
            <div class="row">
                <div class="col-md-12">
                    <p><strong>Empregado pela:</strong>
                    </p>
                    <p>
                        <%=funcionario.getEmpresa()%>
                    </p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-4">
                    <p><strong>Nome</strong>
                    </p>
                    <p>
                        <%=funcionario.getNome()%>
                    </p>
                </div>
                <div class="col-md-4">
                    <p><strong>CPF</strong>
                    </p>
                    <p>
                        <%=funcionario.getCpf()%>
                    </p>
                </div>
                <div class="col-md-4">
                    <p><strong>Nascimento</strong>
                    </p>
                    <p>
                        <%=funcionario.getNascimento()%>
                    </p>
                </div>

            </div>
            <div class="row">
                <div class="col-md-6">
                    <p><strong>Horário de Entrada</strong>
                    </p>
                    <p>
                        <%=funcionario.getHorarioEntrada()%>
                    </p>
                </div>
                <div class="col-md-6">
                    <p><strong>E-Mail</strong>
                    </p>
                    <p>
                        <%=funcionario.getHorarioSaida()%>
                    </p>
                </div>
            </div>
            <hr />
            <div id="actions" class="row">
                <div class="col-md-12">
                    <a href="index.html" class="btn btn-default">Voltar</a>
                </div>
            </div>
        </div>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>

</html>