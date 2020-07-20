<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">

	<!--Import Google Icon Font-->
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	
	<!--Import materialize.css-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/materialize.min.css">
	
	<!--Let browser know website is optimized for mobile-->
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
</head>

<body>
	<nav class="blue z-depth-0">
		<div class="nav-wrapper container">
			<a href="index" class="brand-logo left">AIKO DIGITAL</a>
			
			<ul id="nav-mobile" class="right hide-on-med-and-down">
				<li class="active"><a href="index">Início</a></li>
				<li class="active"><a href="linha">Linha</a></li>
				<li class="active"><a href="parada">Parada</a></li>
				<li class="active"><a href="posicao-veiculo">Posição dos Veículos</a></li>
				<li class="active"><a href="veiculo">Veículo</a></li>
			</ul>
		</div>
	</nav>
	<div class="container">
		<div class="row">
			<div class="col s12 m12">
				<div class="card">
					<div class="card-image">
						<img src="${pageContext.request.contextPath}/img/aiko-digital.jpg" height="400">
						<span class="card-title">Teste para o Processo Seletivo Aiko Digital</span>
					</div>
					<div class="card-content">
						<p><b>Controle de frota florestal completo</b> para tornar o <b>processo
						mais preciso</b>, do início ao fim.</p>
					</div>
					<div class="card-action">
						<a href="https://aiko.digital/">Visite a Aiko Digital</a>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!--JavaScript at end of body for optimized loading-->
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/materialize.min.js"></script>
</body>
</html>