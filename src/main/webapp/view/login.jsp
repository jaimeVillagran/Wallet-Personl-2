<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous" />
<link rel="stylesheet" href="./assets/css/style.css" />
<!-- <link rel="stylesheet" type="text/css" href="css/styles.css">-->
</head>
<body class="d-flex flex-column min-vh-100">
	<header class="row mt-3">
		<h1 class="text-center">Wallet Personal App</h1>
	</header>
	<div class="container mt-5">
		<div class="container-main row justify-content-center">
			<div class="col-md-6">
				<h2 class="text-center mt-5">Bienvenido Usuario Nuevo</h2>
				<p class="text-center mt-5">Ingrese sus Datos.</p>
				<div class="row justify-content-center">
					<form action="movimientos" method="get">
						<button type="submit">Iniciar Sesión</button>
					</form>
				</div>

				<form class="row g-3">
					<div class="col-md-12">
						<div class="row m-4">
							<label for="validationDefault01" class="col-sm-2 col-form-label">Nombre</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="validationDefault01"
									placeholder="Juanito" required>
							</div>
						</div>
						<div class="row m-4">
							<label for="validationDefault02" class="col-sm-2 col-form-label">Apellido</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="validationDefault02"
									placeholder="Perez" required>
							</div>
						</div>
						<div class="row m-4">
							<label for="inputEmail3" class="col-sm-2 col-form-label">Email</label>
							<div class="col-sm-10">
								<input type="email" class="form-control" id="inputEmail3"
									placeholder="name@example.com" required>
							</div>
						</div>
						<div class="row mb-4">
							<label for="inputPassword3" class="col-sm-2 col-form-label">Contraseña</label>
							<div class="col-sm-10">
								<input type="password" class="form-control" id="inputPassword3"
									REQUIRED>
							</div>
						</div>
					</div>
					<div class="col-7 mt-5">
						<button class="btn btn-primary" type="submit">Enviar</button>
					</div>
				</form>
			</div>

		</div>
	</div>
	</div>
	<footer class="footer mt-auto py-3">
		<div class="container text-center">
			<p class="text-center mt-3 mb-0">&copy; 2024 My Wallet App. Jaime
				Villagran -Todos los derechos reservados.</p>
		</div>
	</footer>

</body>
</html>
