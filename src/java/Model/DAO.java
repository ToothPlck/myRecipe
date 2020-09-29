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
            PreparedStatement ps = connection.prepareStatement("insert into recipe(ID, name, type, des, vegNonveg, time, steps, uploadedBy, status, imageName)"
                    + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setInt(1, addRecipe.getID());
            ps.setString(2, addRecipe.getName());
            ps.setString(3, addRecipe.getType());
            ps.setString(4, addRecipe.getDes());
            ps.setString(5, addRecipe.getVegNonveg());
            ps.setString(6, addRecipe.getTime());
            ps.setString(7, addRecipe.getSteps());
            ps.setString(8, addRecipe.getUploadedBy());
            ps.setString(9, addRecipe.getStatus());
            ps.setString(10, addRecipe.getImageName());

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
            PreparedStatement ps = connection.prepareStatement("insert into recipe(ID, name, type, des, vegNonveg, time, steps, uploadedBy, status, imageName)"
                    + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setInt(1, addRecipe.getID());
            ps.setString(2, addRecipe.getName());
            ps.setString(3, addRecipe.getType());
            ps.setString(4, addRecipe.getDes());
            ps.setString(5, addRecipe.getVegNonveg());
            ps.setString(6, addRecipe.getTime());
            ps.setString(7, addRecipe.getSteps());
            ps.setString(8, addRecipe.getUploadedBy());
            ps.setString(9, addRecipe.getStatus());
            ps.setString(10, addRecipe.getImageName());

            ps.executeUpdate();

        } catch (SQLException exception) {
            exception.getMessage();
        }
    }

    public List<recipe> recipeDetails() {
        List<recipe> recipeDetails = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("select ID ,name, type, des, vegNonveg, time, steps, uploadedBy,imageName from recipe where status = ?");
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
                String imageName = rs.getString("imageName");

                recipe recipes = new recipe(Integer.parseInt(ID), name, type, des, vegNonveg, time, steps, uploadedBy, imageName);
                recipeDetails.add(recipes);
                
            }
        } catch (Exception e) {
            System.out.println("Hit Error Here: " + e);
        }
        return recipeDetails;
    }

    public List<Users> viewUsersList() {
        List<Users> users = new ArrayList<Users>();
        try {
            PreparedStatement ps = connection.prepareStatement("select firstname, lastname, email, "
                    + "password from users where role='User'");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String email = rs.getString("email");
                String password = rs.getString("password");
                Users user = new Users(firstname, lastname, email, password);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public void deleteUser(String email) {
        try {
            PreparedStatement ps = connection.prepareStatement("delete from users where email=?");

            ps.setString(1, email);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void registerUser(Users User) {
        try {
            //insert data into the database
            PreparedStatement ps = connection.prepareStatement("insert into users(firstname, lastname, nickname, email, password, role)"
                    + "values (?, ?, ?, ?, ?, ?)");
            ps.setString(1, User.getFirstname());
            ps.setString(2, User.getLastname());
            ps.setString(3, User.getUsername());
            ps.setString(4, User.getEmail());
            ps.setString(5, User.getPassword());
            ps.setString(6, User.getRole());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean existingUser(String email) {
        boolean user = false;

        try {
            //check whether the email already exists in the users database
            PreparedStatement ps = connection.prepareStatement("select email from users where email=?");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            user = rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public String authenticateUser(Users User) {
        String email = User.getEmail();
        String password = User.getPassword();

        try {
            PreparedStatement ps = connection.prepareStatement("select email,password,role from users");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String EMAIL = rs.getString("email");
                String PASSWORD = rs.getString("password");
                String ROLE = rs.getString("role");

                if (email.equals(EMAIL) && password.equals(PASSWORD) && ROLE.equals("Administrator")) {
                    return "Administrator";
                }
                else if (email.equals(EMAIL) && password.equals(PASSWORD) && ROLE.equals("user")) {
                    return "user";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "invalid";
    }

    public List<Contact> getAllContactDetails() {
        List<Contact> contact = new ArrayList<Contact>();
        try {
            PreparedStatement ps = connection.prepareStatement("select * from contact");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String description = rs.getString("description");
                String date = rs.getString("date");

                Contact myConatct = new Contact(name, email, description, date);
                contact.add(myConatct);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return contact;
    }

    public void comment(Comment comment) {
        try {
            PreparedStatement stmt = connection.prepareStatement("insert into comment(name,message,date) values(?,?,?)");
            stmt.setString(1, comment.getName());
            stmt.setString(2, comment.getMessage());
            stmt.setString(3, comment.getDate());

            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Contact> AnswerContact(String name, String date) {
        ArrayList<Contact> contact = new ArrayList<Contact>();
        try {

            PreparedStatement preparedStatement = connection.prepareStatement("select * from contact where name=?");
            preparedStatement.setString(1, name);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String NAME = rs.getString("name");
                String email = rs.getString("email");
                String description = rs.getString("description");
                String DATE = rs.getString("date");

                Contact myContact = new Contact(NAME, email, description, DATE);
                contact.add(myContact);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed Query");
        }
        return contact;
    }

    public void delete(String name, String date) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from contact where name = ?");
            preparedStatement.setString(1, name);
            //preparedStatement.setString(2, date);

            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void contact(Contact contact) {
        try {
            PreparedStatement stmt = connection.prepareStatement("insert into contact(name,email,description,date) values(?,?,?,?)");
            stmt.setString(1, contact.getName());
            stmt.setString(2, contact.getEmail());
            stmt.setString(3, contact.getDescription());
            stmt.setString(4, contact.getDate());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<recipe> pendingRecipes() {
        List<recipe> pendingRecipes = new ArrayList<recipe>();
        try {
            PreparedStatement ps = connection.prepareStatement("select ID ,name, type, des, vegNonveg, time, steps, uploadedBy, imageName from recipe where status = 'pending'");
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
                String imageName = rs.getString("imageName");

                recipe recipes = new recipe(Integer.parseInt(ID), name, type, des, vegNonveg, time, steps, uploadedBy, imageName);
                pendingRecipes.add(recipes);
            }
        } catch (SQLException exception) {
            exception.toString();
        }
        return pendingRecipes;
    }

    public void acceptRecipe(int ID) {
        try {
            PreparedStatement ps = connection.prepareStatement("update recipe set status = 'accepted' where ID = ?");

            ps.setInt(1, ID);
            ps.executeUpdate();
        } catch (SQLException exception) {
            exception.toString();
        }
    }

    public void rejectComplaint(int ID) {
        try {
            PreparedStatement ps = connection.prepareStatement("update recipe set status = 'rejected' where ID = ?");

            ps.setInt(1, ID);
            ps.executeUpdate();
        } catch (SQLException exception) {
            exception.toString();
        }
    }

}
