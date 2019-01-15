use master
drop database BodegaMadyson

create database BodegaMadyson

use BodegaMadyson

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

create table Categoria(
codCat int identity primary key not null,
nombCat varchar(30)
)

create table Marca(
codMarca int primary key identity not null,
nombMarca varchar(50)
)

create table Producto(
codProd int identity primary key not null,
articulo varchar(50),
codMarca1 int,
precioVenta float,
stock int,
codCat1 int,
constraint fk_cca1 foreign key (codCat1) references Categoria (codCat),
constraint fk_cma1 foreign key (codMarca1) references Marca (codMarca)
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

create table Proveedor(
codProv int identity primary key not null,
rucProv varchar(11),
nombProv varchar(50),
telefProv int,
direcProv varchar(100),
obserProv varchar(200)
)

create table Compra(
codComp int identity primary key not null,
codProv1 int,
fechaComp date,
totalComp float,
constraint fk_pv1 foreign key (codProv1) references Proveedor (codProv)
)

create table DetalleCompra(
codCompra1 int,
codProd2 int,
precioCompra float,
cantidad int,
descuento float,
importe float,
constraint fk_cp1 foreign key (codCompra1) references Compra (codComp),
constraint fk_cpr2 foreign key (codProd2) references Producto (codProd)
)

select * from Cliente
select * from Compra
select * from DetalleCompra
select * from DetalleVenta
select * from Empleado
select * from Producto
select * from Marca
select * from Categoria
select * from Proveedor
select * from Venta

--Marcas--
insert into Marca values('Coca Cola')
insert into Marca values('Pepsi')
insert into Marca values('Donofrio')
insert into Marca values('Artica')
insert into Marca values('Sprite')
--Categorias--
insert into Categoria values('Gaseosa')
insert into Categoria values('Helado')
--Empleado--
insert into Empleado values('Carlos Becerra', 'Administrador', 71463111, 'hoarlos', 'carlos123', 'M', 1)
insert into Empleado values('Alberto Hernández', 'Cajero', 11136417, 'solraoh', '123carlos', 'M', 0)
--Cliente--
insert into Cliente values('Maritza Vela', 51427532, null,'F')
--Proveedor--
insert into Proveedor values (10111213141, 'Grupo Terra', 2851302, 'Calle 13', null)

------ACTUALIZAR----
update Cliente set nombApeCli = 'Maritza Vela champ', dniCli = '11242145', rucCli = '125', genCli = 'T' where codCli = 1

	--LIKE --
	select * from Cliente where dniCli like '%5%'