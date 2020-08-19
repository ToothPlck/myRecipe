package Model;

/**
 *
 * @author USER
 */
public class recipe {

    int ID;
    String name, type, des, vegNonveg, time, steps, uploadedBy, status;

    public recipe() {
    }

    public recipe(int ID, String name, String type, String des, String vegNonveg, String time, String steps, String uploadedBy, String status) {
        this.ID = ID;
        this.name = name;
        this.type = type;
        this.des = des;
        this.vegNonveg = vegNonveg;
        this.time = time;
        this.steps = steps;
        this.uploadedBy = uploadedBy;
        this.status = status;
    }

    public recipe(int ID, String name, String type, String des, String vegNonveg, String time, String steps, String uploadedBy) {
        this.ID = ID;
        this.name = name;
        this.type = type;
        this.des = des;
        this.vegNonveg = vegNonveg;
        this.time = time;
        this.steps = steps;
        this.uploadedBy = uploadedBy;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getVegNonveg() {
        return vegNonveg;
    }

    public void setVegNonveg(String vegNonveg) {
        this.vegNonveg = vegNonveg;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public String getUploadedBy() {
        return uploadedBy;
    }

    public void setUploadedBy(String uploadedBy) {
        this.uploadedBy = uploadedBy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
