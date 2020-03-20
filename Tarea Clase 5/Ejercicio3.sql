SELECT * FROM restaurant.ingredients;
SELECT * FROM restaurant.vendors;

select avg(unitprice)PrecioPromedio
from ingredients
inner join vendors on vendors.vendorid = ingredients.vendorid 
	and companyname = 'Veggies_R_Us' 