create database site_Embark;
use site_embark;

create table Cliente(
id_cliente int primary key auto_increment,
nome varchar(40) not null,
email varchar(40) not null,
cidade varchar(40) not null,
cep int(10) not null,
senha varchar(8),
sobre_nome VARCHAR(40),
estado varchar(10)
);


create table compra (
nota_fiscal int primary key,
data_compra varchar (10),
nome_cliente varchar (40) not null,
quantidade_compra int (10) not null,
destino varchar (40) not null
 );
 
ALTER TABLE compra ADD valorCompra varchar(20) ;
 ALTER TABLE compra DROP COLUMN cpf_cliente;
 
 
 create table cliente_compra (
id_cliente int,
nota_fiscal int,
foreign key(id_cliente) references CLIENTE (id_cliente),
foreign key(nota_fiscal) references compra (nota_fiscal)
);


create table Hospedagem (
id_hosp int primary key auto_increment,
nomeHosp varchar (40) not null,
cidade varchar (80) not null,
estado varchar (80) not null,
rua varchar (80) not null
);


create table Pct_viagem (
id_destino varchar (10) primary key,
preço varchar (10) not null,
data_da_viagem date not null,
destino varchar (40) not null,
condução varchar (20) not null,
id_hosp int,
foreign key(id_hosp) references Hospedagem (id_hosp)
);


RENAME TABLE Pct_viagem1 TO Pct_viagem;


create table compra_pct_viagem(
id_destino varchar (10),
nota_fiscal int,
foreign key(id_destino) references pct_viagem (id_destino),
foreign key(nota_fiscal) references compra (nota_fiscal)
);

DROP TABLE compra_pct_viagem; 
DROP TABLE compra_promo; 
DROP TABLE promocoes; 
select*from cliente;
select*from hospedagem;
select*from Pct_viagem;
select*from Compra;
