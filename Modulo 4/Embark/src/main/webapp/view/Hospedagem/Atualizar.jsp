<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Atualizar Cliente</title>

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
        <h1>Atualizar Hospedagem</h1>
    </header>

		<div class="container p-4 me-9">


  <form class="row g-3" action="./atualizar-hosp">
				

   

  <div class="col-md-4">
    <label for="nome" class="form-label">Nome da Hospedagem</label>
    <input type="text" class="form-control " name="nomeHosp" id="nomeHosp" value="<%=request.getAttribute("nomeHosp")%>" required>
  </div>
  
 

  
  <div class="col-md-6">
    <label for="nome" class="form-label">Cidade</label>
    <input type="text" class="form-control " value="<%=request.getAttribute("cidade")%>" name="cidade" id="cidade" aria-describedby="validationServer03Feedback" required>
  </div>
  
  
  <div class="col-md-3">
    <label for="nome" class="form-label">Estado </label>
    <input type="text" class="form-control " value="<%=request.getAttribute("estado")%>" name="estado" id="estado" aria-describedby="validationServer06Feedback" required>
  </div>
  
  
  
  <div class="col-md-6">
    <label for="nome" class="form-label">Endereço </label>
    <input type="text" class="form-control " value="<%=request.getAttribute("rua")%>" name="rua" id="rua" aria-describedby="validationServer07Feedback" required>
  </div>
  
  
 
  <div class="col-12"  >
    <button class="btn btn-dark" type="submit">Enviar</button>
    <a href="./hospedagem" class="btn btn-danger" style="margin-left: 10px"> Cancelar </a>
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