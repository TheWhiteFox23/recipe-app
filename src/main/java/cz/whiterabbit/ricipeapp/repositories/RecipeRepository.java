package cz.whiterabbit.ricipeapp.repositories;

import cz.whiterabbit.ricipeapp.model.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
