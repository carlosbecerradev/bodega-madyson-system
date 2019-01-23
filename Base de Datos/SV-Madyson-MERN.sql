create database SVMadysonMERN

use  SVMadysonMERN
use master
drop database SVMadysonMERN

CREATE TABLE Cliente
( 
	codCli               int IDENTITY ( 1,1 ) ,
	codPers              int  NULL ,
	correo               varchar(100)  NULL 
)
go



ALTER TABLE Cliente
	ADD  PRIMARY KEY  CLUSTERED (codCli ASC)
go



CREATE TABLE DetalleVenta
( 
	codVenta             int  NOT NULL ,
	codCli               int  NOT NULL ,
	codEmp               int  NOT NULL ,
	codProd              int  NOT NULL ,
	cantidad             int  NULL ,
	importe              float  NULL 
)
go



ALTER TABLE DetalleVenta
	ADD  PRIMARY KEY  CLUSTERED (codVenta ASC,codCli ASC,codEmp ASC,codProd ASC)
go



CREATE TABLE Empleado
( 
	codEmp               int IDENTITY ( 1,1 ) ,
	codPers              int  NULL ,
	cargo                varchar(15)  NULL ,
	codUsu               int  NULL 
)
go



ALTER TABLE Empleado
	ADD  PRIMARY KEY  CLUSTERED (codEmp ASC)
go



CREATE TABLE Marca
( 
	codMarca             int IDENTITY ( 1,1 ) ,
	marca                varchar(50)  NULL 
)
go



ALTER TABLE Marca
	ADD  PRIMARY KEY  CLUSTERED (codMarca ASC)
go



CREATE TABLE Persona
( 
	codPers              int IDENTITY ( 1,1 ) ,
	nombres              varchar(50)  NULL ,
	apePat               varchar(50)  NULL ,
	apeMat               varchar(50)  NULL ,
	dni                  char(8)  NULL ,
	genero               char(1)  NULL 
)
go



ALTER TABLE Persona
	ADD  PRIMARY KEY  CLUSTERED (codPers ASC)
go



CREATE TABLE Producto
( 
	codProd              int IDENTITY ( 1,1 ) ,
	codMarca             int  NULL ,
	articulo             varchar(100)  NULL ,
	precioVenta          float  NULL ,
	stock                int  NULL 
)
go



ALTER TABLE Producto
	ADD  PRIMARY KEY  CLUSTERED (codProd ASC)
go



CREATE TABLE Usuario
( 
	codUsu               int IDENTITY ( 1,1 ) ,
	usuario              varchar(50)  NULL ,
	contrasenia          varchar(50)  NULL ,
	estado               bit  NULL 
)
go



ALTER TABLE Usuario
	ADD  PRIMARY KEY  CLUSTERED (codUsu ASC)
go



CREATE TABLE Venta
( 
	codVenta             int IDENTITY ( 1,1 ) ,
	codCli               int  NOT NULL ,
	codEmp               int  NOT NULL ,
	fechaVenta           date  NULL ,
	totalVenta           float  NULL 
)
go



ALTER TABLE Venta
	ADD  PRIMARY KEY  CLUSTERED (codVenta ASC,codCli ASC,codEmp ASC)
go




ALTER TABLE Cliente
	ADD  FOREIGN KEY (codPers) REFERENCES Persona(codPers)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
go




ALTER TABLE DetalleVenta
	ADD  FOREIGN KEY (codVenta,codCli,codEmp) REFERENCES Venta(codVenta,codCli,codEmp)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
go




ALTER TABLE DetalleVenta
	ADD  FOREIGN KEY (codProd) REFERENCES Producto(codProd)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
go




ALTER TABLE Empleado
	ADD  FOREIGN KEY (codPers) REFERENCES Persona(codPers)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
go




ALTER TABLE Empleado
	ADD  FOREIGN KEY (codUsu) REFERENCES Usuario(codUsu)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
go




ALTER TABLE Producto
	ADD  FOREIGN KEY (codMarca) REFERENCES Marca(codMarca)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
go




ALTER TABLE Venta
	ADD  FOREIGN KEY (codCli) REFERENCES Cliente(codCli)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
go




ALTER TABLE Venta
	ADD  FOREIGN KEY (codEmp) REFERENCES Empleado(codEmp)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
go


select * from Persona
select * from Cliente
select * from Empleado
select * from Usuario
select * from Venta
select * from DetalleVenta
select * from Producto
select * from Marca

insert into Persona values ('Carlos','Becerra','Hernández','71463111','M')

insert into Cliente values (1, 'hello@gmail')

select codCli, nombres, apePat, apeMat, dni, correo, genero
from Persona
inner join Cliente on Cliente.codPers = Persona.codPers