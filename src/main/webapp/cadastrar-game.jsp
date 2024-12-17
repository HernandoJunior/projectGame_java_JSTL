<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--TAG PARA USAR --%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSTL Project</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./resources/CSS/bootstrap.css">
</head>
<body>
<%@include file="header.jsp" %>
<div class="container">
    <div class="mt-5 ms-5 me-5">
        <div class="card mb-3">
            <div class="card-header">
                CADASTRO DE PRODUTO
            </div>
            <div class="card-body">
                <form action="gameSave" method="post">
                    <div class="form-group">
                        <label for="id-titulo">Título</label>
                        <input type="text" name="titulo" id="id-titulo" class="form-control">
                    </div>
                    <div class="form-group mt-3">
                        <label for="id-estudio">Estúdio</label>
                        <input type="text" name="estudio" id="id-estudio" class="form-control">
                    </div>
                    <div class="form-group mt-3">
                        <label for="id-lancamento">Ano de lançamento</label>
                        <input type="number" value="2024" name="lancamento" id="id-lancamento" class="form-control">
                    </div>
                    <div class="form-group mt-3">
                        <label for="id-finalizado">Finalizado</label>
                        <input type="checkbox" name="finalizado" id="id-finalizado">
                    </div>
                    <input type="submit" value="Save" class="btn btn-primary mt-3">
                </form>
            </div>
        </div>
    </div>
</div>
<%@include file="footer.jsp" %>
<script src="resources/JS/bootstrap.bundle.js"></script>
</body>
</html>