package it.uniroma3.siw.siw_recipes.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    
    private String text;

    @NotNull
    @Min(1)
    @Max(5)
    private Integer score; // "Stelle"

    @ManyToOne
    private User author;

    @ManyToOne
    private Recipe recipe; // Ricetta preferita

    // ------GETTERS E SETTERS------ 
    public Long getId() { 
        return id; 
    }

    public void setId(Long id) { 
        this.id = id; 
    }

    public String getTitle() { 
        return title; 
    }

    public void setTitle(String title) { 
        this.title = title; 
    }

    public String getText() { 
        return text; 
    }

    public void setText(String text) { 
        this.text = text; 
    }

    public Integer getScore() { 
        return score; 
    }

    public void setScore(Integer score) { 
        this.score = score; 
    }

    public User getAuthor() { 
        return author; 
    }

    public void setAuthor(User author) { 
        this.author = author; 
    }

    public Recipe getRecipe() { 
        return recipe; 
    }

    public void setRecipe(Recipe recipe) { 
        this.recipe = recipe; 
    }
}