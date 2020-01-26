package br.com.rperondi.spring.action.tacos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcIngredientRepository implements IngredientRepository {

	@Autowired
	private JdbcTemplate template;

	@Override
	public List<Ingredient> findAll() {
		return template.query("Select id, name, type from Ingredient order by 1 asc", this::mapRowToIngredient);
	}

	@Override
	public Ingredient findOne(String id) {
		return template.queryForObject("Select id, name, type from Ingredient where id=? order by 1 asc",
				this::mapRowToIngredient, id);
	}

	@Override
	public Ingredient save(Ingredient ingredient) {
		template.update("insert into Ingredient (id, name, type) values (?, ?, ?)", ingredient.getId(),
				ingredient.getName(), ingredient.getType().toString());

		return ingredient;
	}

	private Ingredient mapRowToIngredient(ResultSet rs, int rowNum) throws SQLException {
		return new Ingredient(rs.getString("id"), rs.getString("name"), Ingredient.Type.valueOf(rs.getString("type")));
	}

}
