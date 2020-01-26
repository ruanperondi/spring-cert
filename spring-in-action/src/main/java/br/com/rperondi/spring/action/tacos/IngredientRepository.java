package br.com.rperondi.spring.action.tacos;

import java.util.List;

public interface IngredientRepository {

	List<Ingredient> findAll();

	Ingredient findOne(String id);

	Ingredient save(Ingredient ingredient);

}
