/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casanuova;

import entities.Annonce;
import services.AnnonceCRUD;
import utilis.MyConnexion;

/**
 *
 * @author Mohamed Amine
 */
public class Casanuova {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        MyConnexion c = MyConnexion.getInstance();
        AnnonceCRUD cc = new AnnonceCRUD() ; 
        //Annonce A1 = new Annonce(1,"A vendre ","3 mois","s+5","tunis",150.20f,1);
        //cc.ajouterAnnonce(A1);
          cc.supprimerAnnonce(1);
//int id_annonce, String titre, String duree, int type, String region, Float prix, int id_cat
        
        
        
        
        
        
        
        
        
        
        
    }
    
}
