use master
drop database BodegaMadyson

create database BodegaMadyson

use BodegaMadyson

-- CREACIÓN DE LOGIN ADMINISTRADOR --
create login madyson
with password = '12345',
default_database = BodegaMadyson

-- CREACIÓN DE USUARIO ADMINISTRADOR --
create user admMadyson
for login madyson
with default_schema = esq

-- CREACIÓN DE ESQUEMA PARA ADMINISTRACIÓN
create schema esq authorization madyson

-- CREACIÓN DE PRIVILEGIOS PARA ADMINISTRADOR --
grant create proc, execute, create table, create role, select, insert, update, delete to madyson

create table Cliente(
codCli int identity primary key not null,
nombApeCli varchar(150),
dniCli char(8),
correoCli varchar(100),
genCli char(1)
)

create table Empleado(
codEmp int identity primary key not null,
nombApeEmp varchar(150),
cargoEmp varchar(20),
dniEmp char(8),
usuEmp varchar(30),
contraEmp varchar(30),
genEmp char(1),
estado bit
)
/*
create table Categoria(
codCat int identity primary key not null,
nombCat varchar(30)
)
create table Marca(
codMarca int primary key identity not null,
nombMarca varchar(50)
)
*/
create table Producto(
codProd int identity primary key not null,
articulo varchar(100),
marca varchar(30),
precioVenta float,
stock int,
categoria varchar(30)
/*nstraint fk_cca1 foreign key (codCat1) references Categoria (codCat),
constraint fk_cma1 foreign key (codMarca1) references Marca (codMarca)*/
)

create table Venta(
codVenta int identity primary key not null,
fechaVenta date,
totalVenta float,
codEmp1 int,
codCli1 int,
constraint fk_ccl1 foreign key (codCli1) references Cliente (codCli),
constraint fk_cem1 foreign key (codEmp1) references Empleado (codEmp)
)
-----------
create table DetalleVenta(
codVenta int,
codProd int,
cantidad int,
importe float,
constraint fk_cv1 foreign key (codVenta) references Venta (codVenta),
constraint fk_cpr1 foreign key (codProd) references Producto (codProd)
)

select * from Cliente
select * from DetalleVenta
select * from Empleado
select * from Producto
select * from Marca
select * from Categoria
select * from Venta
/*
--Marcas--
insert into Marca values('Coca Cola')
insert into Marca values('Pepsi')
insert into Marca values('Donofrio')
insert into Marca values('Artica')
insert into Marca values('Sprite')
--Categorias--
insert into Categoria values('Gaseosa')
insert into Categoria values('Helado')
*/
--Empleado--
insert into Empleado values('Carlos Becerra', 'Administrador', 71463111, 'admin', '12345', 'M', 1)
insert into Empleado values('Alberto Hernández', 'Cajero', 11136417, 'cajero', '12345', 'M', 0)
--Cliente--
insert into Cliente values('anonimo', 10000000, null, null)
insert into Cliente values('Maritza Vela', 51427532, vela@gmail.com,'F')
-- Producto --
insert into Producto values('Helado 1lt de chocolate', 'PeziDuri', 9.90, 10,'Comestible')

------ACTUALIZAR----
update Cliente set nombApeCli = 'Maritza Vela champ', dniCli = '11242145', correoCli = '125', genCli = 'T' where codCli = 1

	--LIKE --
	select * from Cliente where dniCli like '%5%'
select usuEmp, contraEmp, cargoEmp, estado from Empleado