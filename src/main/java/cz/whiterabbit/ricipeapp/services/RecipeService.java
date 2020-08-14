package cz.whiterabbit.ricipeapp.services;

import cz.whiterabbit.ricipeapp.model.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getAll();
}
