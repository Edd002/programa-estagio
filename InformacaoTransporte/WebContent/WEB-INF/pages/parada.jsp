<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
						<span class="card-title">
							Teste para o Processo Seletivo Aiko Digital
						</span>
					</div>
					<div class="card-content">
						<p>
							<b>Controle de frota florestal completo</b> para tornar o <b>processo
								mais preciso</b>, do início ao fim.
						</p>
					</div>
					<div class="card-action">
						<a href="https://aiko.digital/">Visite a Aiko Digital</a>
					</div>
				</div>
			</div>
		</div>

		<!-- CADASTRAR -->
		<div class="row">
    		<h3 class="left-align">Cadastrar Paradas</h3>
  		</div>
		<div class="row">
			<form class="col s12" action="parada" method="post">
				<div class="row">
					<div class="input-field col s12">
						<input name="textFieldName" id="textFieldName" type="text" class="validate">
						<label for="textFieldName">Nome da Parada</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s12">
						<input name="textFieldLatitude" id="textFieldLatitude" type="number" class="validate">
						<label for="textFieldLatitude">Latitude da Parada</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s12">
						<input name="textFieldLongitude" id="textFieldLongitude" type="number" class="validate">
						<label for="textFieldLongitude">Longitude da Parada</label>
					</div>
				</div>
				<div class="row">
					<button class="btn waves-effect waves-light" type="submit" name="cadastrar">
						Cadastrar
						<i class="material-icons right">send</i>
					</button>
				</div>
			</form>
		</div>
		<c:if test="${param.cadastrar != null}">
			<c:choose>
				<c:when test="${not empty requestScope.arrayListMensagensErros}">
					<div class="row">
						<div class="col s12 m12">
							<div class="card red">
								<div class="card-content white-text">
									<span class="card-title">Erro ao Cadastrar</span>
									<p>
										<c:forEach items="${requestScope.arrayListMensagensErros}" var="mensagemErro">
											<c:out value="${mensagemErro}" /><br />
										</c:forEach>
									</p>
								</div>
							</div>
						</div>
					</div>
				</c:when>
				<c:otherwise>
					<div class="row">
						<div class="col s12 m12">
							<div class="card green">
								<div class="card-content white-text">
									<span class="card-title">Parada Cadastrada</span>
								</div>
							</div>
						</div>
					</div>
				</c:otherwise>
			</c:choose>
		</c:if>

		<hr><hr>

		<!-- VISUALIZAR TODOS -->
		<div class="row">
    		<h3 class="left-align">Lista de Paradas</h3>
  		</div>
	 	<div class="row">
			<c:choose>
				<c:when test="${empty requestScope.arrayListParadas}">
					<div class="row">
						<div class="col s12 m12">
							<div class="card yellow accent-4">
								<div class="card-content white-text">
									<span class="card-title">Erro ao Visualizar</span>
									<p>
										Não foi possível recuperar nenhuma parada do banco de dados. Ocorreu um erro ou não há nenhuma cadastrada.
									</p>
								</div>
							</div>
						</div>
					</div>
				</c:when>
				<c:otherwise>
					<div class="row">
						<table class="striped">
							<thead>
								<tr>
									<th>Id</th>
									<th>Name</th>
									<th>Latitude</th>
									<th>Longitude</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${arrayListParadas}" var="parada">
									<tr>
										<td>${parada.id}</td>
										<td>${parada.name}</td>
										<td>${parada.latitude}</td>
										<td>${parada.longitude}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</c:otherwise>
			</c:choose>
		</div>

		<hr><hr>

		<!-- BUSCAR POR ID, ALTERAR E EXCLUIR -->
		<div class="row">
    		<h3 class="left-align">Atualizar Paradas</h3>
  		</div>
  		<div class="row">
  			<form class="col s12" action="parada" method="get">
				<div class="input-field col s11">
					<input placeholder="Id para Busca" name="textFieldId" id="textFieldId" type="number" class="validate">
					<label for="textFieldId">Id para Busca</label>
				</div>
				<div class="input-field col s1">
					<button class="btn waves-effect waves-light" type="submit" name="buscarPorId">
						Buscar
					</button>
				</div>
			</form>
		</div>
  		<div class="row">
			<form class="col s12" action="parada" method="post">
				<div class="row">
					<div class="input-field col s12">
						<input readonly style="color: grey;" value="${requestScope.parada.id}" name="textFieldId" id="textFieldId" type="text" class="validate">
						<label for="textFieldId">Id da Parada</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s12">
						<input value="${requestScope.parada.name}" name="textFieldName" id="textFieldName" type="text" class="validate">
						<label for="textFieldName">Nome da Parada</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s12">
						<input value="${requestScope.parada.latitude}" name="textFieldLatitude" id="textFieldLatitude" type="number" class="validate">
						<label for="textFieldLatitude">Latitude da Parada</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s12">
						<input value="${requestScope.parada.longitude}" name="textFieldLongitude" id="textFieldLongitude" type="number" class="validate">
						<label for="textFieldLongitude">Longitude da Parada</label>
					</div>
				</div>
				<div class="row">
					<button class="btn waves-effect waves-light" type="submit" name="atualizar">
						Atualizar
						<i class="material-icons right">send</i>
					</button>
					<label>
						<input class="with-gap" name="radioButtonAtualizar" value="alterar" type="radio" checked />
						<span>Alterar</span>
					</label>
					<label>
						<input class="with-gap" name="radioButtonAtualizar" value="excluir" type="radio" />
						<span>Excluir</span>
					</label>
				</div>
			</form>
		</div>
		<c:if test="${param.alterar != null}">
			<c:choose>
				<c:when test="${not empty requestScope.arrayListMensagensErros}">
					<div class="row">
						<div class="col s12 m12">
							<div class="card red">
								<div class="card-content white-text">
									<span class="card-title">Erro ao Alterar</span>
									<p>
										<c:forEach items="${requestScope.arrayListMensagensErros}" var="mensagemErro">
											<c:out value="${mensagemErro}" /><br />
										</c:forEach>
									</p>
								</div>
							</div>
						</div>
					</div>
				</c:when>
				<c:otherwise>
					<div class="row">
						<div class="col s12 m12">
							<div class="card green">
								<div class="card-content white-text">
									<span class="card-title">Parada Alterada</span>
								</div>
							</div>
						</div>
					</div>
				</c:otherwise>
			</c:choose>
		</c:if>
	</div>

	<!--JavaScript at end of body for optimized loading-->
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/materialize.min.js"></script>
</body>
</html>