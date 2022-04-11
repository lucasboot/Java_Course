create database dbagenda;
show databases;
use dbagenda;
create table contatos(
	idcon int primary key auto_increment,
    nome varchar(50) not null,
    fone varchar(15) not null,
    email varchar(50)
);
show tables;
describe contatos;

/* CRUD CREATE */ 
insert into contatos (nome, fone, email) values ('Lucas F', '9999999', 'lucas@teste.com');

/* CRUD READ */
select * from contatos;
select * from contatos order by nome;
select * from contatos where idcon=2;

/* CRUD UPDATE */
update contatos set nome='Dona Arca' where idcon=2;

/* CRUD DELETE */
delete from contatos where idcon=2;
