1)
insert into public."Cajeros" ("cajero","nomapels")
values ('2','Alma Sosa');
insert into public."MaquinasRegistradoras" ("maquina","piso")
values ('2','1');
insert into public."Productos" ("producto","nombre","precio")
values ('2','Agua','15.00');
insert into public."Venta" ("cajero","maquina","producto")
values ('2','2','1');


2)
select A.producto,B.Nombre,count(*) as NoVentas from public."Venta" AS A
inner join public."Productos" AS B
on A.producto = B.producto
group by A.producto,B.Nombre
order by 2 desc;

3)
select C.nomApels,B.Nombre,B.precio,M.piso from public."Venta" AS A
inner join public."Productos" AS B
on A.producto = B.producto
inner join public."Cajeros" AS C
on A.cajero = C.cajero
inner join public."MaquinasRegistradoras" AS M
on A.maquina = M.maquina;

4)
select M.piso,sum(B.precio) AS ventastotales from public."Venta" AS A
inner join public."Productos" AS B
on A.producto = B.producto
inner join public."MaquinasRegistradoras" AS M
on A.maquina = M.maquina
group by M.piso
order by 2 desc;

5)
select C.cajero,C.nomApels,sum(B.precio) AS ventastotales from public."Venta" AS A
inner join public."Productos" AS B
on A.producto = B.producto
inner join public."Cajeros" AS C
on A.cajero = C.cajero
group by C.cajero,C.nomApels
order by 3 desc;


6)
select C.cajero,C.nomApels,sum(B.precio) AS ventastotales from public."Venta" AS A
inner join public."Productos" AS B
on A.producto = B.producto
inner join public."Cajeros" AS C
on A.cajero = C.cajero
group by C.cajero,C.nomApels
HAVING SUM (B.precio) < '5000'
order by 3 desc;
