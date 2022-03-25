INSERT INTO `Producto` (`idProducto`, `idPedido`,`nombre`,`precio`) VALUES ('1', '1', 'Burguer', '90');
INSERT INTO `Producto` (`idProducto`, `idPedido`,`nombre`,`precio`) VALUES ('2', '2', 'FrenchFries', '45');
INSERT INTO `Producto` (`idProducto`, `idPedido`,`nombre`,`precio`) VALUES ('3', '3', 'Cerveza', '35');
INSERT INTO `Producto` (`idProducto`, `idPedido`,`nombre`,`precio`) VALUES ('4', '4', 'Pastel', '40');
select * from Producto;

INSERT INTO `Categoria` (`idCategoria`, `idProducto`,`nombre`) VALUES ('1', '1', 'Carne');
INSERT INTO `Categoria` (`idCategoria`, `idProducto`,`nombre`) VALUES ('2', '2', 'Entradas');
INSERT INTO `Categoria` (`idCategoria`, `idProducto`,`nombre`) VALUES ('3', '.3', 'Bebidas');
INSERT INTO `Categoria` (`idCategoria`, `idProducto`,`nombre`) VALUES ('4', '4', 'Postres');
select * from Categoria;