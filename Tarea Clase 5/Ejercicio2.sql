SELECT * FROM restaurant.ingredients;
SELECT * FROM restaurant.vendors;

select ingredients.name
from ingredients
inner join vendors on vendors.vendorid = ingredients.vendorid 
	and (companyname = 'Veggies_R_Us'  or companyname = 'Spring Water Supply')