<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Saldo y Transacciones</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
          crossorigin="anonymous"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css"/>
</head>
<body class="d-flex flex-column min-vh-100">
<header class="row mt-3">
    <h1 class="text-center">Wallet Personal App</h1>
</header>
<div class="container">
    <div class="container-main row justify-content-center">
        <div class="col-md-8">
            <h2 class="text-center mt-5">Saldo y Transacciones</h2>
            <p class="text-center mt-5">Aquí se mostrarán las transacciones y el saldo.</p>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Monto</th>
                    <th>Fecha</th>
                    <th>Tipo</th>
                </tr>
                </thead>
                <tbody>
                <!-- Datos de ejemplo -->
                <tr>
                    <td>1</td>
                    <td>100.00</td>
                    <td>2023-01-01</td>
                    <td>Deposito</td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>50.00</td>
                    <td>2023-01-02</td>
                    <td>Retiro</td>
                </tr>
                </tbody>
            </table>
            <a href="${pageContext.request.contextPath}/index.jsp" class="btn btn-primary">Volver</a>
        </div>
    </div>
</div>
<footer class="footer mt-auto py-3">
    <div class="container text-center">
        <p class="text-center mt-3 mb-0">&copy; 2024 My Wallet App. Jaime Villagran - Todos los derechos reservados.</p>
    </div>
</footer>
</body>
</html>


