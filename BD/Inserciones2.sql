
INSERT INTO `Reservaciones`(`idReservacion`, `idMesa`, `idCliente`, `nombreReser`, `personas`,`hora`,`fecha`) VALUES ('1','3','1','Alejandro','2','3:00','29-03-2022');
INSERT INTO `Reservaciones`(`idReservacion`, `idMesa`, `idCliente`, `nombreReser`, `personas`,`hora`,`fecha`) VALUES ('2','4','2','Victor','5','3:00','29-03-2022');
INSERT INTO `Reservaciones`(`idReservacion`, `idMesa`, `idCliente`, `nombreReser`, `personas`,`hora`,`fecha`) VALUES ('3','1','4','Genaro','3','5:00','29-03-2022');
INSERT INTO `Reservaciones`(`idReservacion`, `idMesa`, `idCliente`, `nombreReser`, `personas`,`hora`,`fecha`) VALUES ('4','5','3','Sebastian','7','4:00','29-03-2022');
INSERT INTO `Reservaciones`(`idReservacion`, `idMesa`, `idCliente`, `nombreReser`, `personas`,`hora`,`fecha`) VALUES ('5','2','5','Martin','5','7:00','29-03-2022');
select*from Reservaciones;

INSERT INTO `Cliente`(`idCliente`, `idUsuario`,`idFactura`) VALUES ('1','3','1');
INSERT INTO `Cliente`(`idCliente`, `idUsuario`,`idFactura`) VALUES ('5','3','2');
INSERT INTO `Cliente`(`idCliente`, `idUsuario`,`idFactura`) VALUES ('3','3','3');
INSERT INTO `Cliente`(`idCliente`, `idUsuario`,`idFactura`) VALUES ('2','3','4');
INSERT INTO `Cliente`(`idCliente`, `idUsuario`,`idFactura`) VALUES ('4','3','5');
select*from Cliente;

INSERT INTO `Factura`(`idFactura`, `totalPagar`) VALUES ('1','$800');
INSERT INTO `Factura`(`idFactura`, `totalPagar`) VALUES ('2','$300');
INSERT INTO `Factura`(`idFactura`, `totalPagar`) VALUES ('3','$550');
INSERT INTO `Factura`(`idFactura`, `totalPagar`) VALUES ('4','$640');
INSERT INTO `Factura`(`idFactura`, `totalPagar`) VALUES ('5','$900');
select*from Factura;

