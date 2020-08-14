package cz.whiterabbit.ricipeapp.controllers;

import cz.whiterabbit.ricipeapp.model.Category;
import cz.whiterabbit.ricipeapp.model.UnitOfMeasure;
import cz.whiterabbit.ricipeapp.repositories.CategoryRepository;
import cz.whiterabbit.ricipeapp.repositories.RecipeRepository;
import cz.whiterabbit.ricipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;
    private RecipeRepository recipeRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository, RecipeRepository recipeRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.recipeRepository = recipeRepository;
    }

    @RequestMapping({"/", "", "/index"})
    public String getIndexPage(Model model){
        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
        System.out.println("recipe count : " + recipeRepository.count());
        System.out.println("recipe description : " + recipeRepository.findById(1l).get().getDescription());
        model.addAttribute("recipes", recipeRepository.findAll());
        System.out.println("Cat ID is: " + categoryOptional.get().getId());
        System.out.println("UoM ID is: " + unitOfMeasureOptional.get().getId());
        return "index";
    }
}
