use GXS;

create table usuario (id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, login CHAR(10), senha CHAR(30)); 

select * from usuario;

-- alter table usuario (nome CHAR(30), email VARCHAR(50)); 
DROP TABLE `gxs`.`usuario`;

create table usuario (idUsuario INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
login VARCHAR(10), 
senha VARCHAR(30), 
nome VARCHAR(50), 
email VARCHAR(50),
dataCadastro DATE,
situacao VARCHAR(10)); 

select * from usuario;

INSERT INTO `usuario` (`idUsuario`,`login`,`senha`,`nome`,`email`,`dataCadastro`,`situacao`)
VALUES
(1,"alex","12345","Alex Souza da Silva","alexsouza8045@gmail.com","ativo");

INSERT INTO `usuario` (`login`,`senha`,`nome`,`email`,`dataCadastro`,`situacao`)
VALUES
("teste","123","Administrador2","admin2@admin.com",2018-02-08,"ativo");


DELETE FROM usuario WHERE idUsuario = 5;

select * from usuario;





