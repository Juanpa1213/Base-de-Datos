SELECT * FROM bookstore.venta;

select sum(precio) as MontoVendido
from venta
inner join empleado on empleado.idempleado = venta.idempleado and empleado.nombre = 'EMILIO'