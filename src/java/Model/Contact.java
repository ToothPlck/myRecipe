package Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ayeshmi
 */
public class Contact {
    private String name;
    private String email;
    private String description;
    private String date;
    private String answer;

    public Contact(String name, String email, String description) {
        this.name = name;
        this.email = email;
        this.description = description;
    }

    public Contact(String name, String email, String description,String date) {
        this.name = name;
        this.email = email;
        this.description = description;
        this.date=date;
    }

    public Contact(String name, String email, String description, String date, String answer) {
        this.name = name;
        this.email = email;
        this.description = description;
        this.date = date;
        this.answer = answer;
    }
    

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
