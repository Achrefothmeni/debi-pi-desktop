/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reclamation.module;

/**
 *
 * @author dhia
 */
public class Reclamation {
    private int id;
    private String message;
    private String type;
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public Reclamation(int id, String message, String type, String status) {
        this.id = id;
        this.message = message;
        this.type = type;
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Reclamation(String message, String type) {
        this.message = message;
        this.type = type;
    }
            
}
