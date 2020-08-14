package cz.whiterabbit.ricipeapp.bootstrap;

import cz.whiterabbit.ricipeapp.model.Category;
import cz.whiterabbit.ricipeapp.model.Difficulty;
import cz.whiterabbit.ricipeapp.model.Ingredient;
import cz.whiterabbit.ricipeapp.model.Recipe;
import cz.whiterabbit.ricipeapp.repositories.CategoryRepository;
import cz.whiterabbit.ricipeapp.repositories.RecipeRepository;
import cz.whiterabbit.ricipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DataLoader implements CommandLineRunner {

    private RecipeRepository recipeRepository;
    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public DataLoader(RecipeRepository recipeRepository, CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.recipeRepository = recipeRepository;
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("Creating recipe : Perfect Guacamole");
        insertPerfectGuacamole();

    }

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

        //Avocado
        Ingredient avocado = new Ingredient();
        avocado.setAmount(new BigDecimal(2));
        avocado.setDescription("Avocado");
        avocado.setUnitOfMeasure(unitOfMeasureRepository.findByDescription("Peace").get());
        perfectGuacamole.getIngredients().add(avocado);

        //Salt
        Ingredient salt = new Ingredient();
        salt.setUnitOfMeasure(unitOfMeasureRepository.findByDescription("Teaspoon").get());
        salt.setAmount(new BigDecimal(0.25));
        salt.setDescription("Salt");
        perfectGuacamole.getIngredients().add(salt);

        //Lime Juice
        Ingredient limeJuice = new Ingredient();
        limeJuice.setUnitOfMeasure(unitOfMeasureRepository.findByDescription("Tablespoon").get());
        limeJuice.setAmount(new BigDecimal(1));
        limeJuice.setDescription("Fresh lime juice");
        perfectGuacamole.getIngredients().add(limeJuice);

        //Red Onion
        Ingredient redOnion = new Ingredient();
        redOnion.setUnitOfMeasure(unitOfMeasureRepository.findByDescription("Tablespoon").get());
        redOnion.setDescription("Red Onion");
        redOnion.setAmount(new BigDecimal(2));
        perfectGuacamole.getIngredients().add(redOnion);

        //Serrano chiles
        Ingredient serranoChiles = new Ingredient();
        serranoChiles.setUnitOfMeasure(unitOfMeasureRepository.findByDescription("Peace").get());
        serranoChiles.setDescription("Serrano chiles");
        serranoChiles.setAmount(new BigDecimal(2));
        perfectGuacamole.getIngredients().add(serranoChiles);

        //Cilantro
        Ingredient cilantro = new Ingredient();
        cilantro.setUnitOfMeasure(unitOfMeasureRepository.findByDescription("Tablespoon").get());
        cilantro.setDescription("Cilantro");
        cilantro.setAmount(new BigDecimal(2));
        perfectGuacamole.getIngredients().add(cilantro);

        //Black pepper
        Ingredient blackPepper = new Ingredient();
        blackPepper.setUnitOfMeasure(unitOfMeasureRepository.findByDescription("Dash").get());
        blackPepper.setDescription("Black Pepper");
        blackPepper.setAmount(new BigDecimal(1));
        perfectGuacamole.getIngredients().add(blackPepper);

        //Tomato
        Ingredient tomato = new Ingredient();
        tomato.setUnitOfMeasure(unitOfMeasureRepository.findByDescription("Peace").get());
        tomato.setDescription("Ripe Tomato");
        tomato.setAmount(new BigDecimal(0.5));
        perfectGuacamole.getIngredients().add(tomato);

        //Red radishes
        Ingredient redRadishes = new Ingredient();
        redRadishes.setUnitOfMeasure(unitOfMeasureRepository.findByDescription("Peace").get());
        redRadishes.setDescription("Red radishes");
        redRadishes.setAmount(new BigDecimal(1));
        perfectGuacamole.getIngredients().add(redRadishes);

        //Tortilla chips
        Ingredient tortillaChips = new Ingredient();
        tortillaChips.setUnitOfMeasure(unitOfMeasureRepository.findByDescription("Package").get());
        tortillaChips.setDescription("Tortilla chips");
        tortillaChips.setAmount(new BigDecimal(1));
        perfectGuacamole.getIngredients().add(tortillaChips);
    }
}
