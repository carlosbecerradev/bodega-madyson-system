use master
drop database BodegaMadyson

create database BodegaMadyson

use BodegaMadyson

-- CREACIÓN DE LOGIN ADMINISTRADOR /sa/123 --
create login madyson
with password = '12345',
default_database = BodegaMadyson

-- CREACIÓN DE USUARIO ADMINISTRADOR --
create user madyson
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

create table Producto(
codProd int identity primary key not null,
articulo varchar(100),
marca varchar(30),
precioVenta float,
stock int
)


create table Venta(
codVenta int identity primary key not null,
fechaVenta date,
totalVenta float,
codEmp1 int,
codCli1 int,
foreign key (codCli1) references Cliente (codCli),
foreign key (codEmp1) references Empleado (codEmp)
)

create table DetalleVenta(
codVenta int,
codProd int,
codCliente int,
codEmpleado int,
cantidad int,
importe float,
foreign key (codVenta) references Venta (codVenta),
foreign key (codProd) references Producto (codProd),
foreign key (codCliente) references Cliente (codCli),
foreign key (codEmpleado) references Empleado (codEmp)
)

select * from Cliente
select * from DetalleVenta
select * from Venta
select * from Empleado
select * from Producto

--Empleado--
insert into Empleado values('Administrador', 'Administrador', 71463111, 'admin', '12345', 'M', 1)
insert into Empleado values('Cajero', 'Cajero', 10000000, 'cajero', '12345', 'M', 1)
--Cliente--
insert into Cliente values('Cliente Casual', 10000000, 'casualM@hotmail.com', 'M')
-- Producto --
insert into Producto values('Helado 1lt de chocolate', 'Donofrio', 9.90, 200)
insert into Producto values('Detergente de 500gr', 'Bolivar', 3, 200)
insert into Producto values('Jabón para lavar 200g ', 'Bolivar', 2, 200)
insert into Producto values('Gaseosa de 2lt retornable', 'Coca Cola', 5, 200)
insert into Producto values('Gaseosa de 3lt retornable', 'Coca Cola', 8, 200)

--Mostrar boletas--
select codVenta, codCli,nombApeCli,fechaVenta, totalVenta, codEmp, nombApeEmp
from Venta
inner join Cliente on Venta.codCli1 = Cliente.codCli
inner join Empleado on Venta.codEmp1 = Empleado.codEmp

-- Mostrar detalle de venta --
select Producto.codProd, articulo, precioVenta,cantidad, importe
from Venta
inner join DetalleVenta on Venta.codVenta = DetalleVenta.codVenta
inner join Producto on DetalleVenta.codProd = Producto.codProd
where Venta.codVenta = 2

-- Mostrar boletas por fecha --
select codVenta, codCli,nombApeCli,fechaVenta, totalVenta, codEmp, nombApeEmp
from Venta
inner join Cliente on Venta.codCli1 = Cliente.codCli
inner join Empleado on Venta.codEmp1 = Empleado.codEmp 
where fechaVenta = '2019-02-01' or fechaVenta = '2019-01-31'

