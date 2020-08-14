package cz.whiterabbit.ricipeapp.bootstrap;

import cz.whiterabbit.ricipeapp.model.Category;
import cz.whiterabbit.ricipeapp.model.Difficulty;
import cz.whiterabbit.ricipeapp.model.Ingredient;
import cz.whiterabbit.ricipeapp.model.Recipe;
import cz.whiterabbit.ricipeapp.repositories.CategoryRepository;
import cz.whiterabbit.ricipeapp.repositories.RecipeRepository;
import cz.whiterabbit.ricipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements /*CommandLineRunner,*/ ApplicationListener<ContextRefreshedEvent> {

    private RecipeRepository recipeRepository;
    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public DataLoader(RecipeRepository recipeRepository, CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.recipeRepository = recipeRepository;
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }


    /*@Override
    public void run(String... args) throws Exception {

    }*/

    private void insertPerfectGuacamole() {
        Recipe perfectGuacamole = new Recipe();
        perfectGuacamole.getCategories().add(categoryRepository.findByDescription("Mexican").get());
        perfectGuacamole.setPrepTime(10);
        perfectGuacamole.setCookTime(0);
        perfectGuacamole.setServings(4);
        perfectGuacamole.setSource("simplyrecipes.com");
        perfectGuacamole.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
        perfectGuacamole.setDirections("1 Cut the avocado, remove flesh: Cut the avocados in half. Remove the pit. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl.\n" +
                "\n" +
                "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)\n" +
                "\n" +
                "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "\n" +
                "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" +
                "\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n" +
                "\n" +
                "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.\n" +
                "\n" +
                "4 Serve: Serve immediately, or if making a few hours ahead, place plastic wrap on the surface of the guacamole and press down to cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.");
        perfectGuacamole.setDescription("Perfect Guacamole");
        perfectGuacamole.setDifficulty(Difficulty.EASY);

        setIngredientsGuacamole(perfectGuacamole);

        recipeRepository.save(perfectGuacamole);
    }

    private void setIngredientsGuacamole(Recipe perfectGuacamole) {
        //INGREDIENT
        Set<Ingredient> ingredientSet = new HashSet<>();
        //Avocado
        ingredientSet.add(new Ingredient("Avocado",new BigDecimal(2), unitOfMeasureRepository.findByDescription("Peace").get()));
        ingredientSet.add(new Ingredient("Salt",new BigDecimal(0.25), unitOfMeasureRepository.findByDescription("Teaspoon").get()));
        ingredientSet.add(new Ingredient("Fresh lime juice",new BigDecimal(1), unitOfMeasureRepository.findByDescription("Tablespoon").get()));
        ingredientSet.add(new Ingredient("Red Onion",new BigDecimal(2), unitOfMeasureRepository.findByDescription("Tablespoon").get()));
        ingredientSet.add(new Ingredient("Serrano chiles",new BigDecimal(2), unitOfMeasureRepository.findByDescription("Peace").get()));
        ingredientSet.add(new Ingredient("Cilantro",new BigDecimal(2), unitOfMeasureRepository.findByDescription("Tablespoon").get()));
        ingredientSet.add(new Ingredient("Black Pepper",new BigDecimal(1), unitOfMeasureRepository.findByDescription("Dash").get()));
        ingredientSet.add(new Ingredient("Ripe Tomato",new BigDecimal(0.5), unitOfMeasureRepository.findByDescription("Peace").get()));
        ingredientSet.add(new Ingredient("Red radishes",new BigDecimal(1), unitOfMeasureRepository.findByDescription("Peace").get()));
        ingredientSet.add(new Ingredient("Tortilla chips",new BigDecimal(2), unitOfMeasureRepository.findByDescription("Package").get()));

        perfectGuacamole.setIngredients(ingredientSet);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("Creating recipe : Perfect Guacamole");
        insertPerfectGuacamole();
    }
}
