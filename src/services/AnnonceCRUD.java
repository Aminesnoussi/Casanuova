/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Annonce;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utilis.MyConnexion;

/**
 *
 * @author Mohamed Amine
 */
public class AnnonceCRUD {
Connection cnx = MyConnexion.getInstance().getConnexion(); 

  
    public void ajouterAnnonce (Annonce a) { 
    String req =" INSERT INTO `annonce` (  `region`, `prix`, `duree`, `id_cat`, `titre`) VALUES (' "+ a.getRegion() + "',' "+ a.getPrix() + "',' "+ a.getDuree() + "',' "+ a.getId_cat() + "',' " + a.getTitre() + "')";
    

    Statement st ; 
    try {
        st=cnx.createStatement() ; 
        st.executeUpdate(req) ; 
        System.out.println("ajout terminé!!!");
    }catch(SQLException ex ){ 
        System.err.println(ex.getMessage()) ;} 
    }
   
     
    public void supprimerAnnonce(int id_annonce) {
       String req = "DELETE FROM `annonce` WHERE `id_annonce`='"+id_annonce+"'" ;
        Statement st;
        try {
            st =cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("A Annonce was deleted successfully!");
        }catch (SQLException ex){
            System.err.println(ex.getMessage());
        }

    } 


     public void modifierAnnonce(Annonce a)  {
    
   String req = "UPDATE `annonce` SET `titre`='"+ a.getTitre()+"',`Region`='"+ a.getRegion() + "',`prix`='"+ a.getPrix() + "',`duree`='"+ a.getDuree() + "',`id_cat`='"+ a.getId_cat() +  "' WHERE id_annonce " + "=" + a.getId_annonce();
    
    Statement st;
    try {
    st =cnx.createStatement();
    st.executeUpdate(req);
    System.out.println("A user was updated successfully!");
     }
     catch (SQLException ex){
     System.err.println(ex.getMessage());
                            }
     }

          public List<Annonce> afficher() {
List <Annonce> list = new ArrayList<>();
        try {
      String req = "SELECT * from annonce  ";         
Statement st;
st =cnx.createStatement();
ResultSet rs = st.executeQuery(req);
while(rs.next()){
Annonce e = new Annonce (rs.getInt("id_annonce") , rs.getString("titre"), rs.getString("duree"),rs.getString("region"),rs.getFloat("prix"),rs.getInt("id_cat"));
list.add(e);
}
 }catch (SQLException ex){
    System.err.println(ex.getMessage());
}
return list;}




}
    
