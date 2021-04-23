# Code Smells Examples

[Clutter](#clutter)<br>
[Bad Names](#bad-names)<br>
[Duplication](#duplication)<br>
[Long Methods](#long-methods)<br>
[Long Lines](#long-lines)

## Clutter

### Example (Excessive Comments)
The name of the function is clear enough and the code should be simple and singular focused, warranting 
no need for comments.
```java
\\this returns a recipe when given a name
public Recipe getRecipeByName(String recipeName) {
   \\This calls the recipe service to pass in the recipename
    Recipe recipe = recipeService.getRecipeByName(recipeName);
   
    \\returns the recipe that was retreived from the recipe service
    return recipe;
}
```

### Refactored

```java
public Recipe getRecipeByName(String recipeName) {
    return recipeService.getRecipeByName(recipeName);
}
```

### Example (Commented Out Code)
Old Code can be managed by git and should be removed rather than commented out as this just clutters 
your code and causes potential confusion, given someone may not be aware of what you were accomplishing 
with the commented code.

```java
public Recipe getRecipeByName(String recipeName) {
    Recipe recipe = recipeService.getRecipeByName(recipeName);
    \\ Recipe[] recipeList = recipeService.getRecipes();
    \\ List<Recipe> filterdRecipes = recipeList.stream().filter(recipe -> recipe.name.equals(recipeName)).collect(Collectors.toList());
    \\ return filteredRecipes;

    return recipe;
}
```

### Refactored

```java
public Recipe getRecipeByName(String recipeName) {
    return recipeService.getRecipeByName(recipeName);
}
```

## Duplication

### Example
Here we notice that multiple methods accept the same long list of parameters and create a new recipe 
from it. This can be extracted into a separate method allowing for simpler code in the original methods.

```java
public void addNewRecipeToFavorites(UUID, uuid, String title, List<Ingredient> ingredients, String categoryTag) {
    Recipe recipe = new Recipe(uuid, title, ingredients, categoryTag);
    recipeService.addFavorite(recipe);
}

public void addNewRecipeToBreakfastCategory(UUID, uuid, String title, List<Ingredient> ingredients, String categoryTag) {
    Recipe recipe = new Recipe(uuid, title, ingredients, categoryTag);
    List<Recipe> breakfastRecipes = recipeService.getRecipesByCategory(categoryTag);
    breakfastRecipes.add(recipe);
    recipeService.setRecipesByCategory(categoryTag, breakfastRecipes);
}
```

### Refactored

```java
public void addNewRecipeToFavorites(Recipe recipe) {
    recipeService.addFavorite(recipe);
}

public void addNewRecipeToBreakfastCategory(Recipe recipe) {
    List<Recipe> breakfastRecipes = recipeService.getRecipesByCategory(categoryTag);
    breakfastRecipes.add(recipe);
    recipeService.setRecipesByCategory(categoryTag, breakfastRecipes);
}

public Recipe createRecipe(UUID, uuid, String title, List<Ingredient> ingredients, String categoryTag) {
    return new Recipe(UUID, uuid, String title, List<Ingredient> ingredients, String categoryTag);
}
```

## Bad Names

### Example Bad Variable Names
Variable names should be descriptive to what the actual variable is, even if this means the name is
longer. Avoid using 1 letter variable names, abbreviations, or variable types as they may not be clear 
to everyone what they represent, and variable types are subject to change overtime.

```java
public void addIngredientsToRecipe(Recipe r1, Ingredient ing, Integer intAm) {
    Recipe r2 = recipeService.getRecipe(r1);
    r2.addIngredients(ing, intAm);
}
```

### Refactored

```java
public void addIngredientsToRecipe(Recipe recipe, Ingredient ingredients, Integer ingredientAmount) {
    Recipe currentRecipe = recipeService.getRecipe(recipe);
    currentRecipe.addIngredients(ingredients, ingredientAmount);
}
```

### Example Bad Class/Method Names

```java
public class iniLst {
    private List<Recipe> recipes;
    private final RecipeService recipeService;

    public iniLst(RecipeService recipeService, List<Recipe> recipes) {
        this.recipes = recipes;
        this.recipeService = recipeService;
    }

    private void srList(List<Recipe> recipes) {
        recipeService.setRecipes(recipes);
    }
}
```

### Refactored

```java
public class SetRecipeList {
    private List<Recipe> recipes;
    private final RecipeService recipeService;

    public RecipeList(RecipeService recipeService, List<Recipe> recipes) {
        this.recipes = recipes;
        this.recipeService = recipeService;
    }

    private void setRecipeServiceList(List<Recipe> recipes) {
        recipeService.setRecipes(recipes);
    }
}
```

## Long Methods

### Example
Methods should have a singular focus and be short and concise to what they are accomplishing. Extract code out to make it more readable.

```java
private void removeDuplicateRecipes() {
    List<UUID> recipeIds = Collections.emptyList();
    List<Recipe> newRecipes = Collections.emptyList();
    List<Recipe> recipes = recipeService.getAllRecipes();

    recipes.forEach((recipe) -> {
        if (recipeIds.contains(recipe.getUuid())) {
            //Don't add recipe id to list
        } else {
            recipeIds.add(recipe.getUuid());
        }
    });
    
    recipeIds.forEach((recipeId) -> {
        Recipe recipe = recipeService.getRecipeById(recipeId);
        newRecipes.add(recipe);
    });
    
    recipeService.setRecipes(newRecipes);
}
```

### Refactored

```java
private void removeDuplicateRecipes() {
    List<UUID> recipeIds = getUniqueRecipeIds();
    List<Recipe> uniqueRecipes = createRecipesList(recipeIds);
    
    recipeService.setRecipes(uniqueRecipes);
}

private List<UUID> getUniqueRecipeIds() {
    List<UUID> recipeIds = Collections.emptyList();
    List<Recipe> recipes = recipeService.getAllRecipes();
    
        recipes.forEach((recipe) -> {
            if (recipeIds.contains(recipe.getUuid())) {
                //Don't add recipe id to list
            } else {
                recipeIds.add(recipe.getUuid());
            }
        });
    return recipeIds;
}

private List<Recipe> createRecipesList(List<UUID> recipeIds) {
    List<Recipe> newRecipes = Collections.emptyList();

    recipeIds.forEach((recipeId) -> {
            Recipe recipe = recipeService.getRecipeById(recipeId);
            newRecipes.add(recipe);
        });
    
    return newRecipes;
}
```

## Long Lines

### Example
Much like Long Methods, keep lines clear and concise. The more readable the better. If a line is too long it becomes hard to follow the logic.

```java
    private List<UUID> getUniqueRecipeIds() {
        List<UUID> recipeIds = Collections.emptyList();
        List<Recipe> recipes = recipeService.getAllRecipes();
        
        recipes.forEach((recipe) -> { if (recipeIds.contains(recipe.getUuid())) { } else {recipeIds.add(recipe.getUuid());}});
        return recipeIds;
    }
```

### Refactored

```java
private List<UUID> getUniqueRecipeIds() {
    List<UUID> recipeIds = Collections.emptyList();
    List<Recipe> recipes = recipeService.getAllRecipes();
    
        recipes.forEach((recipe) -> {
            if (recipeIds.contains(recipe.getUuid())) {
                //Don't add recipe id to list
            } else {
                recipeIds.add(recipe.getUuid());
            }
        });
    return recipeIds;
}
```
