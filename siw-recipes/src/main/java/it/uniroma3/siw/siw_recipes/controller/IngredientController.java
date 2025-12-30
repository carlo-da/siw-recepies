package it.uniroma3.siw.siw_recipes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.siw.siw_recipes.model.Ingredient;
import it.uniroma3.siw.siw_recipes.model.Recipe;
import it.uniroma3.siw.siw_recipes.repository.IngredientRepository;
import it.uniroma3.siw.siw_recipes.repository.RecipeRepository;

@Controller
public class IngredientController {
    
    @Autowired private RecipeRepository recipeRepository;
    @Autowired private IngredientRepository ingredientRepository;

    // Mostra la pagina di gestione ingredienti
    @GetMapping("/recipe/{recipeId}/ingredients")
    public String editIngredients(@PathVariable("recipeId") Long recipeId, Model model) {
        Recipe recipe = recipeRepository.findById(recipeId).get();        
        model.addAttribute("recipe", recipe);
        model.addAttribute("ingredient", new Ingredient()); 
        model.addAttribute("ingredients", recipe.getIngredients());        
        return "ingredientsForm";
    }

    // Aggiunge un ingrediente
    @PostMapping("/recipe/{recipeId}/ingredients")
    public String addIngredient(@PathVariable("recipeId") Long recipeId, 
                                @ModelAttribute("ingredient") Ingredient ingredient) {
        
        Recipe recipe = recipeRepository.findById(recipeId).get();
        ingredient.setRecipe(recipe); // Collega i due oggetti
        recipe.getIngredients().add(ingredient); 
        ingredientRepository.save(ingredient); // Salva
        
        // Ricarica la STESSA pagina per aggiungerne un altro
        return "redirect:/recipe/" + recipeId + "/ingredients";
    }
}
