INSERT INTO `Puestos` (`idPuesto`, `nombre`, `salarioMin`, `SalarioMax`) VALUES ('4', 'Cajero', '2000','5000');
INSERT INTO `Puestos` (`idPuesto`, `nombre`, `salarioMin`, `SalarioMax`) VALUES ('5', 'Mesero', '1000','1500');
INSERT INTO `Puestos` (`idPuesto`, `nombre`, `salarioMin`, `SalarioMax`) VALUES ('6', 'Administrador', '3000','7000');
select * from Puestos;

INSERT INTO `Usuarios` (`idUsuario`,`nombre`, `telefono`, `email`, `direccion`, `tipoUsuario`) VALUES ( '1', 'Erick Garcia', '351-282-0730','EG22@gmail.com','Lerdo de tejada 198 ote','E');
INSERT INTO `Usuarios` (`idUsuario`, `nombre`, `telefono`, `email`, `direccion`, `tipoUsuario`) VALUES ('2', 'Amanda Ruiz', '351-280-0600','AR2@gmail.com','Melchor Ocampo 23 nte','C');
INSERT INTO `Usuarios` (`idUsuario`, `nombre`, `telefono`, `email`, `direccion`, `tipoUsuario`) VALUES ('3', 'Pedro Sola', '351-122-1710','PS342@gmail.com','Agustin Melgar 34 sur','C');
INSERT INTO `Usuarios` (`idUsuario`, `nombre`, `telefono`, `email`, `direccion`, `tipoUsuario`) VALUES ('4', 'Martin Vaca', '351-100-3619','MV11@gmail.com','Verduzco 123','E');
INSERT INTO `Usuarios` (`idUsuario`, `nombre`, `telefono`, `email`, `direccion`, `tipoUsuario`) VALUES ('5', 'Efren Nava', '351-124-8700','EN8@gmail.com','morelos nte 56','C');
INSERT INTO `Usuarios` (`idUsuario`, `nombre`, `telefono`, `email`, `direccion`, `tipoUsuario`) VALUES ('6', 'Guillermo Camarillo', '351-101-4101','GC07@gmail.com','Ribera 32','E');
INSERT INTO `Usuarios` (`idUsuario`, `nombre`, `telefono`, `email`, `direccion`, `tipoUsuario`) VALUES ('7', 'Jose Solano', '351-232-0282','JS01@gmail.com','prados del bosque 2','E');
INSERT INTO `Usuarios` (`idUsuario`, `nombre`, `telefono`, `email`, `direccion`, `tipoUsuario`) VALUES ('8', 'Alejandro Leon', '351-245-1415','AL112@gmail.com','Avenida juarez 32','E');
select*from Usuarios;

INSERT INTO `Empleados` (`idEmpleado`, `idPuesto`, `numSeguro`,`turno`,`idUsuario`) VALUES ('1', '2','18010413','Matutino','1');
INSERT INTO `Empleados` (`idEmpleado`, `idPuesto`, `numSeguro`,`turno`,`idUsuario`) VALUES ('2', '2','18010402','Vespertino','4');
INSERT INTO `Empleados` (`idEmpleado`, `idPuesto`, `numSeguro`,`turno`,`idUsuario`) VALUES ('3', '1','18010400','Matutino','6');
INSERT INTO `Empleados` (`idEmpleado`, `idPuesto`, `numSeguro`,`turno`,`idUsuario`) VALUES ('4', '3','18010411','Matutino','8');
select*from Empleados;

INSERT INTO `Login` (`username`, `password`, `idEmpleado`) VALUES ('erickG12', 'Hola.123', '2');
INSERT INTO `Login` (`username`, `password`, `idEmpleado`) VALUES ('carlaC01', 'Hola.123', '1');
INSERT INTO `Login` (`username`, `password`, `idEmpleado`) VALUES ('pabloM22', 'Hola.123', '4');
select*from Login;

INSERT INTO `Nomina` (`idNomina`, `idEmpleado`, `salario`) VALUES ('1', '2', '1200');
INSERT INTO `Nomina` (`idNomina`, `idEmpleado`, `salario`) VALUES ('2', '1', '3200');
INSERT INTO `Nomina` (`idNomina`, `idEmpleado`, `salario`) VALUES ('3', '3', '6000');
select*from Nomina;

