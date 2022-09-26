<%@ page language="java" contentType="text/html; charset=UTF-8" import="model.Cliente"
    pageEncoding="UTF-8" import="java.util.List"%>
    
    <%
@SuppressWarnings("unchecked")
List<Cliente> lista = (List<Cliente>) request.getAttribute("cliente");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cliente</title>
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
		<h1>Clientes</h1>
	</header>

	<!-- Menu -->
	<ul class="nav  justify-content-center">
		<li class="nav-item"><a class="nav-link  text-light fs-4"
			aria-current="page" href="./index.html">Home</a></li>
	</ul>

	<header class="container my-4">
		<div class="row justify-content-center">
			<div class="col ">
				<a class="cadastrar bg-dark p-4 text-light " href="./view/Cliente/CadastroCliente.html">Cadastrar Cliente</a>
				
			</div>

		</div>
	</header>



	<!-- Tabelas -->

	<table class="table container">
		<thead class="thead-dark">
			<tr>
				<th scope="col">#</th>
				<th scope="col">Nome</th>
				<th scope="col">Email</th>
				<th scope="col">Cidade</th>
				<th scope="col">CEP</th>
				<th scope="col">Senha</th>
				<th scope="col">Sobre Nome</th>
				<th scope="col">Estado</th>
			</tr>
		</thead>
		<tbody>
            
              <%
			for (Cliente a : lista) {
			%>
			
			<tr>

				<td><%=a.getid_cliente()%></td>
				<td><%=a.getnome()%></td>
				<td><%=a.getemail()%></td>
				<td><%=a.getcidade()%></td>
				<td><%=a.getcep()%></td>
				<td><%=a.getsenha()%></td>
				<td><%=a.getsobre_nome()%></td>
				<td><%=a.getestado()%></td>
				<td>
					<a class="editar btn btn-dark" href="editar-cliente?id=<%=a.getid_cliente()%>">Atualizar</a>
					<a class= "excluir btn btn-danger" href="deletar-cliente?id=<%=a.getid_cliente()%>">Deletar</a>
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