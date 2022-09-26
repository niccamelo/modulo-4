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
        <h1>Atualizar Cliente</h1>
    </header>

		<div class="container p-4 me-9">


  <form class="row g-3" action="./atualizar-cliente">
				

   

  <div class="col-md-4">
    <label for="nome" class="form-label">Nome</label>
    <input type="text" class="form-control " name="nome" id="nome" value="<%=request.getAttribute("nome")%>" required>
  </div>
  
  
  <div class="col-md-4">
    <label for="nome" class="form-label">Sobre Nome</label>
    <input type="text" class="form-control " name="sobre_nome" id="sobre_nome" value="<%=request.getAttribute("sobre_nome")%>" required>
  </div>
  
  
  <div class="col-md-4">
    <label for="nome" class="form-label">Email</label>
    <div class="input-group has-validation">
      <span class="input-group-text" id="inputGroupPrepend3">@</span>
      <input type="text" class="form-control " id="email" value="<%=request.getAttribute("email")%>" name="email" aria-describedby="inputGroupPrepend3 validationServerUsernameFeedback" required>
    </div>
  </div>
  
  
  <div class="col-md-6">
    <label for="nome" class="form-label">Cidade</label>
    <input type="text" class="form-control " value="<%=request.getAttribute("cidade")%>" name="cidade" id="cidade" aria-describedby="validationServer03Feedback" required>
  </div>
  
  
  <div class="col-md-3">
    <label for="nome" class="form-label">Estado </label>
    <input type="text" class="form-control " value="<%=request.getAttribute("estado")%>" name="estado" id="estado" aria-describedby="validationServer06Feedback" required>
  </div>
  
  
  <div class="col-md-3">
    <label for="nome" class="form-label">CEP</label>
    <input type="text" class="form-control " value="<%=request.getAttribute("cep")%>" name="cep" id="cep" aria-describedby="validationServer05Feedback" required>
    </div>
    
  
  <div class="col-md-6">
    <label for="nome" class="form-label">Senha </label>
    <input type="text" class="form-control " value="<%=request.getAttribute("senha")%>" name="senha" id="senha" aria-describedby="validationServer07Feedback" required>
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