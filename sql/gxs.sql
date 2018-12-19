create database gxs;

use gxs;


-- Cria uma tabela
create table usuarios (
id int not null auto_increment primary key,
nome VARCHAR(50) NOT NULL,
login VARCHAR(50) NOT NULL ,
senha VARCHAR(50) NOT NULL,
cpf VARCHAR(14) NOT NULL,
tel VARCHAR(20) NOT NULL,
whatsapp VARCHAR(20) NOT NULL,
email VARCHAR(50) NOT NULL,
dtCadastro date NOT NULL,
dtUltAlteracao date NOT NULL
);


-- NEW 
create table clientes (
/*
ate String id;
    private String nome;
    private String email;
    private String cpf_cnpj;
    private String telefone;
    private String whatsapp;
    private double desconto;
    private String totalCompras;
*/
id int not null auto_increment primary key,
nome VARCHAR(50) NOT NULL,
email VARCHAR(50) NOT NULL,
cpf_cnpj VARCHAR(20) NOT NULL ,
telefone VARCHAR(20) NOT NULL ,
whatsapp VARCHAR(20) NOT NULL ,
desconto double NOT NULL ,
totalCompras int NOT NULL ,
dtCadastro date NOT NULL,
dtUltAlteracao date NOT NULL,
dtUltCompra date NOT NULL
);


use gxs;
select * from clientes;
 

insert into clientes 
(
id,
nome,
email,
cpf_cnpj,
telefone,
whatsapp,
desconto,
totalCompras,
dtCadastro,
dtUltAlteracao,
dtUltCompra
)
values
(
1,
'teste,',
'teste@teste.teste',
'15325071785',
'021 26954472',
'201 9 64645673',
0.0,
0,
'2018-11-27',
'2018-11-27',
'2018-11-27'
);

drop table clientes;
select * from clientes;


-- Inseri dados na tabela
insert into usuarios(nome,email,login,senha,dtCadastro,dtUltAlteracao)
values
("Alex Souza da Silva","alex@gmail.com","alex.silva","123",'2001-03-03','2001-03-03');

delete from usuarios where id = 1;

drop table usuarios;


create table produtos (
id int not null auto_increment primary key,
codigo VARCHAR(50) NOT NULL,
nome VARCHAR(50) NOT NULL,
qtd int NOT NULL,
valor double NOT NULL,
dtCadastro date NOT NULL
);

insert into produtos(codigo,nome,qtd,valor,dtCadastro)
values
("0002","Teclado","25",26.30,'2018-09-05');

select * from produtos;

drop table produtos;

insert into produtos(codigo,nome,qtd,valor,dtCadastro)
values
("0003","Cabo USB Iphone","150",55.00,'2018-09-05');

insert into produtos(codigo,nome,qtd,valor,dtCadastro)
values
("0004","Cabo USB Android","530",25.00,'2018-05-09');

use agora;

select * from produtos;

select * from produtos where id = 6;

select * from usuarios;


create table relatorios 
(
id  int not null auto_increment primary key,
nome varchar(50) not null,
conteudo varchar(1000) not null,
dtCriacao date NOT NULL,
dtUltAlteracao date NOT NULL
);
 
insert into relatorios(nome,conteudo,dtCriacao,dtUltAlteracao)
values
("Report-One","This is the primary report of Alex",'2018-11-17','2018-11-17'); 
 
 select * from relatorios;
 
 delete from relatorios where id = 2;
 
 create table eu (
 id  int not null auto_increment primary key,
 nome varchar(50),
 conteudo varchar(100)
 );
 
select * from eu;
drop table eu;
 
 update usuarios set id = 1 where id = 3;
 select * from usuarios;
 
 
