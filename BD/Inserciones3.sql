INSERT INTO `Zona`(`idZona`, `nombre`) VALUES ('1','Terraza');
INSERT INTO `Zona`(`idZona`, `nombre`) VALUES ('2','Patio');
INSERT INTO `Zona`(`idZona`, `nombre`) VALUES ('3','Centro');
select * from zona;

INSERT INTO `Mesa`(`idMesa`,`idZona`, `noMesa`) VALUES ('1','2','5');
INSERT INTO `Mesa`(`idMesa`,`idZona`, `noMesa`) VALUES ('2','1','10');
INSERT INTO `Mesa`(`idMesa`,`idZona`, `noMesa`) VALUES ('3','3','6');
select*from mesa

