package ru.itis.api_demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.api_demo.models.Recipe;
import ru.itis.api_demo.repositories.RecipeRepository;

import java.util.List;

@RestController
@RequestMapping("/api/recipe-management/")
public class RecipeApiController {

    @Autowired
    RecipeRepository recipeRepository;

    @GetMapping("/recipes/")
    public ResponseEntity<List<Recipe>> getAll() {
        return ResponseEntity.ok(recipeRepository.findAll());
    }

    @GetMapping("/recipes/{recipe-id}/")
    public ResponseEntity<Recipe> getRecipe(@PathVariable("recipe-id") Long recipeId) {
        Recipe recipe = recipeRepository.findById(recipeId).get();
        return ResponseEntity.ok(recipe);
    }

    @PostMapping("/recipes/")
    public ResponseEntity<Recipe> addRecipe(@RequestBody Recipe recipe) {
        recipeRepository.save(recipe);
        return ResponseEntity.ok(recipe);
    }

    @DeleteMapping("/recipes/{recipe-id}/")
    public ResponseEntity deleteRecipe(@PathVariable("recipe-id") Long recipeId) {
        recipeRepository.deleteById(recipeId);
        return ResponseEntity.accepted().build();
    }
}


