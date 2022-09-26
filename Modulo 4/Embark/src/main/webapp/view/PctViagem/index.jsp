<%@ page language="java" contentType="text/html; charset=UTF-8"  import="model.Pct_viagem"
    pageEncoding="UTF-8" import="java.util.List"%>
    
    <%
@SuppressWarnings("unchecked")
List<Pct_viagem> lista = (List<Pct_viagem>) request.getAttribute("pct_viagem");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pct</title>
<link rel="stylesheet" href="./css/index.css">
<!-- CDN CSS Bootstrap v-5.1 -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>	

	<header class="container-fluid bg-dark p-4 text-light">
		<h1>Pacote de Viagens</h1>
	</header>

	<!-- Menu -->
<ul class="nav  justify-content-center">
		<li class="nav-item"><a class="nav-link  text-light fs-4"
			aria-current="page" href="./index.html">Home</a></li>
	</ul>

	<header class="container my-4">
		<div class="row justify-content-center">
			<div class="col ">
				<a class="cadastrar bg-dark p-4 text-light " href="./view/PctViagem/CadastroPct.html">Cadastrar </a>
				
			</div>

		</div>
	</header>



	<!-- Tabelas -->

	<table class="table container">
		<thead class="thead-dark">
			<tr>
				<th scope="col">#</th>
				<th scope="col">Preço</th>
				<th scope="col">Data da Viagem</th>
				<th scope="col">destino</th>
				<th scope="col">Veiculo</th>
				<th scope="col">Id Hospedagem</th>
			</tr>
		</thead>
		<tbody>
            
              <%
			for (Pct_viagem a : lista) {
			%>
			
			<tr>

				<td><%=a.getid_destino()%></td>
				<td><%=a.getpreço()%></td>
				<td><%=a.getdata_da_viagem()%></td>
				<td><%=a.getdestino()%></td>
				<td><%=a.getcondução()%></td>
				<td><%=a.getid_hosp()%></td>
				<td>
					<a class="editar btn btn-dark" href="editar-pct?id=<%=a.getid_destino()%>">Atualizar</a>
					<a class= "excluir btn btn-danger" href="deletar-pct?id=<%=a.getid_destino()%>">Deletar</a>
				</td>
				
			<%
			};
			%>
			
			</tr>
		</tbody>
	</table>

	<!-- CDN JS Bootstrap v-5.1 -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>


</html>