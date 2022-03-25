INSERT INTO `Pedidos` (`idPedido`, `idMesa`, `totalPagar`) VALUES ('1', '1', '2000');
INSERT INTO `Pedidos` (`idPedido`, `idMesa`, `totalPagar`) VALUES ('2', '1', '1500');
INSERT INTO `Pedidos` (`idPedido`, `idMesa`, `totalPagar`) VALUES ('3', '1', '800');
INSERT INTO `Pedidos` (`idPedido`, `idMesa`, `totalPagar`) VALUES ('4', '1', '1200');
select*from Pedidos;

INSERT INTO `Pagos` (`idPago`,`idPedido`, `descripcion`, `total`) VALUES ('1', '1', 'Cuenta mesa 2', '2000');
INSERT INTO `Pagos` (`idPago`, `idPedido`, `descripcion`, `total`) VALUES ('2', '2', 'Cuenta mesa 1', '1000');
INSERT INTO `Pagos` (`idPago`, `idPedido`, `descripcion`, `total`) VALUES ('3', '3', 'Cuenta mesa 3', '3000');
INSERT INTO `Pagos` (`idPago`, `idPedido`, `descripcion`, `total`) VALUES ('4', '4', 'Cuenta mesa 4', '1500');
select * from Pagos;

INSERT INTO `detallePedido` (`idDetPed`,`idProducto`, `idPedido`,`cant`,`precio`, `subtotal`) VALUES ('1', '1', '1','2', '100', '200');
INSERT INTO `detallePedido` (`idDetPed`, `idProducto`, `idPedido`,`cant`,`precio`, `subtotal`) VALUES ('2', '2', '2', '5', '50', '2500');
INSERT INTO `detallePedido` (`idDetPed`, `idProducto`, `idPedido`,`cant`,`precio`, `subtotal`) VALUES ('3', '3', '1', '2', '80', '160');
INSERT INTO `detallePedido` (`idDetPed`, `idProducto`, `idPedido`,`cant`,`precio`, `subtotal`) VALUES ('4', '4', '3', '3', '30', '90');
select * from detallePedido;

INSERT INTO `tipoPago` (`idTipo`,`idPago`, `nombre`) VALUES ('1', '1', 'Efectivo');
INSERT INTO `tipoPago` (`idTipo`,`idPago`, `nombre`) VALUES ('2', '2', 'Tarjeta');
INSERT INTO `tipoPago` (`idTipo`,`idPago`, `nombre`) VALUES ('3', '3', 'Efectivo');
INSERT INTO `tipoPago` (`idTipo`,`idPago`, `nombre`) VALUES ('4', '4', 'Tarjeta');
select*from tipoPago;