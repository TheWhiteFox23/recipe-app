package cz.whiterabbit.ricipeapp.controllers;

import cz.whiterabbit.ricipeapp.model.Category;
import cz.whiterabbit.ricipeapp.model.UnitOfMeasure;
import cz.whiterabbit.ricipeapp.repositories.CategoryRepository;
import cz.whiterabbit.ricipeapp.repositories.RecipeRepository;
import cz.whiterabbit.ricipeapp.repositories.UnitOfMeasureRepository;
import cz.whiterabbit.ricipeapp.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"/", "", "/index"})
    public String getIndexPage(Model model){
        model.addAttribute("recipes", recipeService.getAll());
        return "index";
    }
}
