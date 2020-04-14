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
public class Appel_d_Offre {
    private int id;
    private String status;

    public int getId() {
        return id;
    }

    public Appel_d_Offre(int id, String status) {
        this.id = id;
        this.status = status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
