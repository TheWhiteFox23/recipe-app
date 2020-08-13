package cz.whiterabbit.ricipeapp.repositories;

import cz.whiterabbit.ricipeapp.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
