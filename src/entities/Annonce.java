/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Objects;

/**
 *
 * @author Mohamed Amine
 */
public class Annonce {
    private int id_annonce;
    private String titre;
    private String duree;
    private String region ;
    private float prix ; 
    private int id_cat ;

    public Annonce(int id_annonce, String titre, String duree, String region, float prix, int id_cat) {
        this.id_annonce = id_annonce;
        this.titre = titre;
        this.duree = duree;
        this.region = region;
        this.prix = prix;
        this.id_cat = id_cat;
    }
      public Annonce( String titre, String duree, String region, float prix, int id_cat) {
  
        this.titre = titre;
        this.duree = duree;
        this.region = region;
        this.prix = prix;
        this.id_cat = id_cat;
    }


    public int getId_annonce() {
        return id_annonce;
    }

    public void setId_annonce(int id_annonce) {
        this.id_annonce = id_annonce;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

  

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getId_cat() {
        return id_cat;
    }

    public void setId_cat(int id_cat) {
        this.id_cat = id_cat;
    }

    @Override
    public String toString() {
        return "Annonce{" + "id_annonce=" + id_annonce + ", titre=" + titre + ", duree=" + duree + ", region=" + region + ", prix=" + prix + ", id_cat=" + id_cat + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Annonce other = (Annonce) obj;
        if (Float.floatToIntBits(this.prix) != Float.floatToIntBits(other.prix)) {
            return false;
        }
        if (!Objects.equals(this.titre, other.titre)) {
            return false;
        }
        if (!Objects.equals(this.duree, other.duree)) {
            return false;
        }
        if (!Objects.equals(this.region, other.region)) {
            return false;
        }
        return true;
    }

   
    
    
    
    

}
