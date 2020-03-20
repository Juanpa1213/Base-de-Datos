SELECT * FROM restaurant.ingredients;

select ingredients.name as NombreIngrediente, inventory as Inventario
from ingredients
where ingredients.inventory < (select avg(ingredients.inventory) from ingredients)
