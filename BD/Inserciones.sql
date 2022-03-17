INSERT INTO `Puestos` (`idPuesto`, `nombre`, `salarioMin`, `SalarioMax`) VALUES ('1', 'Cajero', '2000','5000');
INSERT INTO `Puestos` (`idPuesto`, `nombre`, `salarioMin`, `SalarioMax`) VALUES ('2', 'Mesero', '1000','1500');
INSERT INTO `Puestos` (`idPuesto`, `nombre`, `salarioMin`, `SalarioMax`) VALUES ('3', 'Administrador', '3000','7000');
select * from Puestos;

INSERT INTO `Empleados` (`idEmpleado`, `idPuesto`, `tipoUsuario`, `numSeguro`,`turno`) VALUES ('1', '2', 'M','18010413','Matutino');
INSERT INTO `Empleados` (`idEmpleado`, `idPuesto`, `tipoUsuario`, `numSeguro`,`turno`) VALUES ('2', '2', 'M','18010402','Vespertino');
INSERT INTO `Empleados` (`idEmpleado`, `idPuesto`, `tipoUsuario`, `numSeguro`,`turno`) VALUES ('3', '1', 'C','18010400','Matutino');
INSERT INTO `Empleados` (`idEmpleado`, `idPuesto`, `tipoUsuario`, `numSeguro`,`turno`) VALUES ('4', '3', 'A','18010411','Matutino');
select*from Empleados;

INSERT INTO `Login` (`username`, `password`, `idEmpleado`) VALUES ('erickG12', 'Hola.123', '2');
INSERT INTO `Login` (`username`, `password`, `idEmpleado`) VALUES ('carlaC01', 'Hola.123', '1');
INSERT INTO `Login` (`username`, `password`, `idEmpleado`) VALUES ('pabloM22', 'Hola.123', '4');
select*from Login;
