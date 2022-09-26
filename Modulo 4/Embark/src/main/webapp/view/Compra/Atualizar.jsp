<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Atualizar Compra</title>

<!-- CDN CSS Bootstrap v-5.1 -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
</head>
<body>
	
		<header class="container-fluid bg-dark p-4 text-light ">
        <h1>Atualizar Compra</h1>
    </header>

		<div class="container p-4 me-9">


  <form class="row g-3" action="./atualizar-compra">
				

    <div class="col-md-4">
    <label for="nome" class="form-label">Data da Compra</label>
    <input type="text" class="form-control " name="data_compra" id="data_compra" value="<%=request.getAttribute("data_compra")%>" required>
  </div>
  

  <div class="col-md-4">
    <label for="nome" class="form-label">Nome do cliente</label>
    <input type="text" class="form-control " name="nome_cliente" id="nome_cliente" value="<%=request.getAttribute("nome_cliente")%>" required>
  </div>
  
  
  <div class="col-md-6">
    <label for="nome" class="form-label">Quantidade de Compra</label>
    <input type="text" class="form-control " value="<%=request.getAttribute("quantidade_compra")%>" name="quantidade_compra" id="quantidade_compra" aria-describedby="validationServer03Feedback" required>
  </div>
  
  
  <div class="col-md-3">
    <label for="nome" class="form-label">Destino  </label>
    <input type="text" class="form-control " value="<%=request.getAttribute("destino")%>" name="destino" id="destino" aria-describedby="validationServer06Feedback" required>
  </div>
  
  
  <div class="col-md-3">
    <label for="nome" class="form-label">Valor da Compra </label>
    <input type="text" class="form-control " value="<%=request.getAttribute("valorCompra")%>" name="valorCompra" id="valorCompra" aria-describedby="validationServer05Feedback" required>
    </div>
    
  
  <div class="col-md-3">
    <label for="nome" class="form-label">Nota Fiscal</label>
    <input type="text" class="form-control " value="<%=request.getAttribute("nota_fiscal")%>" name="nota_fiscal" id="nota_fiscal" aria-describedby="validationServer05Feedback" required>
    </div>
  
  
 
  <div class="col-12"  >
    <button class="btn btn-dark" type="submit">Enviar</button>
    <a href="./cliente" class="btn btn-danger" style="margin-left: 10px"> Cancelar </a>
  </div>
  <div class="col-12">
  
  </div>
</form>
</div>

	<!-- CDN JS Bootstrap v-5.1 -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>