create database ERP;
use ERP;
create table login
(
	username varchar(15) not null,
    password varchar(8),
    idEmpleado int not null
);

create table Puestos
(
	idPuesto int auto_increment not null,
    nombre varchar(50),
    salarioMin float,
    salarioMax float,
    constraint pk_puestos primary key(idPuesto)
);

create table Nomina
(
	idNomina int auto_increment not null,
    idEmpleado int not null,
    salario float not null,
    constraint pk_Nomina primary key (idNomina)
);

create table Empleados
(
	idEmpleado int auto_increment not null,
    idPuesto int not null,
    tipoUsuario char(1) not null,
    numSeguro char(8) not null,
    turno varchar(15) not null,
    constraint pk_Empleados primary key (idEmpleado),
    constraint uq_numSeg_Empleados unique(numSeguro)
    
);
create table Usuarios
(
   idUsuario      int auto_increment not null,
   idEmpleado int not null,
   nombre         varchar(50) not null,
   telefono       char(12) not null,
   email          varchar(50) not null,
   direccion      varchar(50) not null,
   tipoUsuario           char(1) not null,
   constraint pk_Usuarios primary key (idUsuario),
   constraint uq_nombre_Usuarios unique(nombre),
   constraint uq_email_Usuarios unique(email)
);

create table Factura
(
	idFactura int auto_increment not null,
    totalPagar float not null,
    constraint pk_Factura primary key(idFactura)
);

create table Cliente
(
	idCliente int auto_increment not null,
    idUsuario int not null,
    idFactura int not null,
    constraint pk_cliente primary key(idCliente)
);

create table Reservaciones
(
	idReservacion int auto_increment not null,
    idMesa int not null,
    idCliente int not null,
    nombreReser varchar(50),
    personas int,
    hora time,
    fecha date,
    constraint pk_reservacion primary key(idReservacion)
);

create table Mesa
(
	idMesa int auto_increment not null,
    idZona int not null,
    noMesa int not null,
    constraint pk_mesa primary key(idMesa)
);

create table Zona
(
	idZona int  auto_increment not null,
    nombre varchar(20),
    constraint pk_Zona primary key(idZona)    
);

create table tipoPago
(
	idTipo int auto_increment not null,
    idPago int not null,
    nombre varchar(20),
    constraint pk_tipoPago primary key(idTipo)
);

create table Pagos
(
	idPago int auto_increment not null,
    idPedido int not null,
    descripcion varchar(25) not null,
    total float not null,
    constraint pk_Pagos primary key(idPago)
);

create table Pedidos
(
	idPedido int auto_increment not null,
    idMesa int not null,
    totalPagar float not null,
    constraint pk_Pedidos primary key(idPedido)
);

create table Productos 
(
	idProducto int auto_increment not null,
    idPedido int not null,
    nombre varchar(30) not null,
    precio float not null,
    constraint pk_Productos primary key(idProducto)
);

create table Categoria
(
	idCategoria int auto_increment not null,
    idProducto int not null,
    nombre varchar(30),
    constraint pk_categoria primary key(idCategoria),
    constraint uq_categoria_nombre unique(nombre)
);

create table Promociones
(
	idPromocion int auto_increment not null,
    idProducto int not null,
    nombre varchar(30) not null,
    descuento float not null,
    canMin float not null,
    canMax float not null,
    constraint pk_Promociones primary key(idPromocion),
    constraint uq_Promociones_nombre unique(nombre)
);

create table detallePedido
(
	idDetPed int auto_increment not null,
    idProducto int not null,
    idPedido int not null,
    cant int not null,
    precio float not null,
    subtotal float not null,
    constraint pk_detallePedido primary key(idDetPed)
);
/*==============================================================*/
/* Constraints de tipo FK                                     */
/*==============================================================*/
alter table tipoPago add constraint FK_Pagos_tipoPagos foreign key (idPago)
      references Pagos (idPago);
alter table Pagos add constraint FK_pedidos_Pagos foreign key (idPedido)
      references Pedidos (idPedido);
alter table Pedidos add constraint FK_Mesa_Pedidos foreign key (idMesa)
      references Mesa (idMesa);
alter table Mesa add constraint FK_Zona_Mesa foreign key (idZona)
      references Zona (idZona);
alter table Productos add constraint FK_pedidos_productos foreign key (idPedido)
      references Pedidos (idPedido);
alter table Categoria add constraint FK_productos_Categoria foreign key (idProducto)
      references Productos (idProducto);
alter table Promociones add constraint FK_productos_promociones foreign key (idProducto)
      references  Productos (idProducto);
alter table detallePedido add constraint FK_Productos_detallePedido foreign key (idProducto)
      references  Productos (idProducto);
alter table detallePedido add constraint FK_pedidos_detallePedido foreign key (idPedido)
      references  Pedidos (idPedido);
alter table Reservaciones add constraint FK_Mesa_Reservaciones foreign key (idMesa)
      references  Mesa (idMesa);
alter table Reservaciones add constraint FK_cliente_Reservaciones foreign key (idCliente)
      references  Cliente (idCliente);
alter table Cliente add constraint FK_factura_cliente foreign key (idFactura)
      references  Factura (idFactura);
alter table Cliente add constraint FK_usuario_cliente foreign key (idUsuario)
      references  Usuarios (idUsuario);
alter table Usuarios add constraint FK_Empleados_Usuarios foreign key (idEmpleado)
      references  Empleados (idEmpleado);
alter table Empleados add constraint FK_Puestos_Empleados foreign key (idPuesto)
      references  Puestos (idPuesto);
alter table Nomina add constraint FK_Empleados_Nomina foreign key (idEmpleado)
      references  Empleados (idEmpleado);
alter table Login add constraint FK_Empleados_Login foreign key (idEmpleado)
      references  Empleados (idEmpleado);
      
