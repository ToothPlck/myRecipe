package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class DAO {

    private final Connection connection;

    public DAO() {
        connection = Database.getConnection();
    }

    public int getNewID() {
        int newID = 0;
        try {
            PreparedStatement ps = connection.prepareStatement("select count(*) as count from recipe");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int ID = rs.getInt("count");
                newID = ID++;
            }
        } catch (SQLException exception) {
            exception.getMessage();
        }
        return newID;
    }

    public void addRecipe(recipe addRecipe) {
        try {
            PreparedStatement ps = connection.prepareStatement("insert into recipe(ID, name, type, des, vegNonveg, time, steps, uploadedBy, status)"
                    + "values(?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setInt(1, addRecipe.getID());
            ps.setString(2, addRecipe.getName());
            ps.setString(3, addRecipe.getType());
            ps.setString(4, addRecipe.getDes());
            ps.setString(5, addRecipe.getVegNonveg());
            ps.setString(6, addRecipe.getTime());
            ps.setString(7, addRecipe.getSteps());
            ps.setString(8, addRecipe.getUploadedBy());
            ps.setString(9, addRecipe.getStatus());

            ps.executeUpdate();

        } catch (SQLException exception) {
            exception.getMessage();
        }
    }

    public int getNewIngredientID() {
        int newIngredientID = 0;
        try {
            PreparedStatement ps = connection.prepareStatement("select count(*) as count from ingredients");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int ID = rs.getInt("count");
                newIngredientID = ID++;
            }
        } catch (SQLException exception) {
            exception.getMessage();
        }
        return newIngredientID;
    }

    public void addIngredient(ingredients ingredientt) {
        try {
            PreparedStatement ps = connection.prepareStatement("insert into ingredients(ID, recipeID, ingredients)"
                    + "values(?, ?, ?)");
            ps.setInt(1, ingredientt.getID());
            ps.setInt(2, ingredientt.getRecipeID());
            ps.setString(3, ingredientt.getIngredients());

            ps.executeUpdate();
        } catch (SQLException exception) {
            exception.getMessage();
        }
    }

    public void addRecipeUser(recipe addRecipe) {
        try {
            PreparedStatement ps = connection.prepareStatement("insert into recipe(ID, name, type, des, vegNonveg, time, steps, uploadedBy, status)"
                    + "values(?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setInt(1, addRecipe.getID());
            ps.setString(2, addRecipe.getName());
            ps.setString(3, addRecipe.getType());
            ps.setString(4, addRecipe.getDes());
            ps.setString(5, addRecipe.getVegNonveg());
            ps.setString(6, addRecipe.getTime());
            ps.setString(7, addRecipe.getSteps());
            ps.setString(8, addRecipe.getUploadedBy());
            ps.setString(9, addRecipe.getStatus());

            ps.executeUpdate();

        } catch (SQLException exception) {
            exception.getMessage();
        }
    }

    public List<recipe> recipeDetails() {
        List<recipe> recipeDetails = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("select ID ,name, type, des, vegNonveg, time, steps, uploadedBy from recipe where status = ?");
            ps.setString(1, "accepted");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                String ID = rs.getString("ID");
                String name = rs.getString("name");
                String type = rs.getString("type");
                String des = rs.getString("des");
                String vegNonveg = rs.getString("vegNonveg");
                String time = rs.getString("time");
                String steps = rs.getString("steps");
                String uploadedBy = rs.getString("uploadedBy");

                recipe recipes = new recipe(Integer.parseInt(ID), name, type, des, vegNonveg, time, steps, uploadedBy);
                recipeDetails.add(recipes);
            }
        } catch (Exception e) {
            System.out.println("Hit Error Here: " + e);
        }
        return recipeDetails;
    }

}
