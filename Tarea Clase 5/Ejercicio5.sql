SELECT * FROM restaurant.vendors;
SELECT * FROM restaurant.ingredients;

select companyname as ProveedoresLacteos
from vendors 
inner join ingredients on vendors.vendorid = ingredients.vendorid
			and vendors.referredby = (select vendorid from vendors where companyname='Veggies_R_Us')
            and foodgroup ='Milk'