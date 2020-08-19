package Model;

/**
 *
 * @author USER
 */
public class ingredients {

    int ID, recipeID;
    String ingredients;

    public ingredients() {
    }

    public ingredients(int ID, int recipeID, String ingredients) {
        this.ID = ID;
        this.recipeID = recipeID;
        this.ingredients = ingredients;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getRecipeID() {
        return recipeID;
    }

    public void setRecipeID(int recipeID) {
        this.recipeID = recipeID;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

}
