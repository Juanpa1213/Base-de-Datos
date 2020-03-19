SELECT * FROM bookstore.usuario;
SELECT * FROM bookstore.empleado;

select nombre as Nombre, apellido as Apellido, usuario.usuario as Usuario
from empleado
inner join usuario on usuario.idempleado = empleado.idempleado ; 