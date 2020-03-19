SELECT * FROM bookstore.usuario;

select email as Correo
from empleado
inner join usuario on usuario.idempleado = empleado.idempleado  and usuario.activo = 1; 