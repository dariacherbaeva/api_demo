package ru.itis.api_demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.api_demo.models.Recipe;

import java.util.Optional;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    Optional<Recipe> findById(Long id);
}
