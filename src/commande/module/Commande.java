/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commande.module;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author dali
 */
public class Commande {
    private int id,somme,id_usr;
    private String adresse,status;
               
     java.util.Date dt = new java.util.Date();
    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String date = sdf.format(dt);
    
    // java.util.Date dt = new java.util.Date();
  //  java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String dateM = sdf.format(dt);

    public Commande() {
    }

    public Commande(int id,String date,int id_usr,int somme, String adresse, String dateM,String status) {
       
        this.id=id;
        this.date=date;
        this.id_usr = id_usr;
        this.somme = somme;
       
        this.adresse = adresse;
        this.dateM=dateM;
        this.status = status;
    }

    public String getDateM() {
        return dateM;
    }

    public void setDateM(String dateM) {
        this.dateM = dateM;
    }
    
    

    
    
    
    

    public int getId() {
        return id;
    }

    public int getSomme() {
        return somme;
    }

    public int getId_usr() {
        return id_usr;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getStatus() {
        return status;
    }

    public Date getDt() {
        return dt;
    }

    public SimpleDateFormat getSdf() {
        return sdf;
    }

    public String getDate() {
        return date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSomme(int somme) {
        this.somme = somme;
    }

    public void setId_usr(int id_usr) {
        this.id_usr = id_usr;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDt(Date dt) {
        this.dt = dt;
    }

    public void setSdf(SimpleDateFormat sdf) {
        this.sdf = sdf;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Commande{" + "id=" + id + ", somme=" + somme + ", id_usr=" + id_usr + ", adresse=" + adresse + ", status=" + status + ", dt=" + dt + ", sdf=" + sdf + ", date=" + date + ", dateM=" + dateM + '}';
    }

    public Commande(int id_usr,int somme, String adresse,String status) {
       // this.id=id;
        this.id_usr = id_usr;
        this.somme=somme;
        this.adresse = adresse;
        this.status=status;
       
    }

   
    
}
