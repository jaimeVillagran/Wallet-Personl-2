<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Retirar Fondos</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
		  rel="stylesheet"
		  integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
		  crossorigin="anonymous"/>
	<link rel="stylesheet" href="../assets/css/style.css"/>
</head>
<body class="d-flex flex-column min-vh-100">
<header class="row mt-3">
	<h1 class="text-center">Wallet Personal App</h1>
</header>
<div class="container">
	<div class="container-main row justify-content-center">
		<div class="col-md-6">
			<h2 class="text-center mt-5">Retirar Fondos</h2>
			<p class="text-center mt-5">Tu aplicación confiable para gestionar transacciones financieras de manera segura y eficiente.</p>
			<div class="row justify-content-center">
				<form action="transaction" method="post">
					<input type="hidden" name="type" value="withdraw">
					<div class="mb-3">
						<label for="amount" class="form-label">Monto:</label>
						<input type="text" id="amount" name="amount" class="form-control">
					</div>
					<button type="submit" class="btn btn-primary">Retirar</button>
				</form>
			</div>
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

