package auteur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import modele.modeleAuteur;

public class AutFonction {
    
	 private Connection conn;

		public AutFonction(Connection conn) {
			super();
			this.conn = conn;
		}
		
	     public boolean addAuteur(modeleAuteur Auteur)
	     {
	    	 boolean f=false;
	    	 try {
				 String sql="insert into auteur(noms,prenom,nation) value(?,?,?) ";
				 PreparedStatement ps=conn.prepareStatement(sql);
				 ps.setString(1, Auteur.getNoms());
				 ps.setString(3, Auteur.getPrenom());
				 ps.setString(2, Auteur.getNation());
				
				int i=ps.executeUpdate();
				if(i==1)
				{
					f=true; 
				}
			} catch (Exception e) {
			 e.printStackTrace(); 
			}
	    	 return f;
	     }
	     
	     
	     
	     public List<modeleAuteur> getAllAuteur()
	     {
	    	 List<modeleAuteur> list=new ArrayList<modeleAuteur>();
	    	 modeleAuteur s=null;
	    	 try {
	    		 
	    		 String sql="select * from auteur";
	      	   
	      	   PreparedStatement ps=conn.prepareStatement(sql);
	      	   
	      	   ResultSet rs=ps.executeQuery();
	      	    
	      	     while(rs.next()) {
		    	 
	 	    	s=new modeleAuteur();
	 	    	
	 	    	 s.setId(rs.getInt(1));
	 	    	 s.setNoms((rs.getString(2)));
	 	    	 s.setPrenom(rs.getString(3));
	 	    	 s.setNation(rs.getString(4));
	 	    	 list.add(s);
	      	   }
	      	     
			} catch (Exception e) {
		      e.printStackTrace();	
			}
	    	  
	    	    
	    	 return list;
	     }
	     
	     
	     public modeleAuteur getAuteurById(int id)
	     {
	    	 modeleAuteur s=null;
	    	 
	    	 try {
	    		 	
	    		 String sql="select * from auteur where id=?";
	      	   
	      	   PreparedStatement ps=conn.prepareStatement(sql);
	      	   ps.setInt(1, id);
	      	   
	      	   ResultSet rs=ps.executeQuery();
	      	    
	      	     while(rs.next()) {
		    	 
	 	    	s= new modeleAuteur();
	 	    	
	 	    	 s.setId(rs.getInt(1));
	 	    	 s.setNoms(rs.getString(2));
	 	    	 s.setPrenom(rs.getString(3));
	 	    	 s.setNation(rs.getString(4));
	 	    	
	      	   }
	      	   
	      	  
			} catch (Exception e) {
		      e.printStackTrace();	
			}
	    	 
	    	 
	    	 return s;
	     }
	     
	     public boolean udpdateSdocument(modele.Document Doocumnt)
	     {
	    	 boolean f=false;
	    	 try {
				String sql="UPDATE documents set libelle=?,description=?,domaine=? where id=? ";
				PreparedStatement ps=conn.prepareStatement(sql);
				 ps.setString(1, Doocumnt.getLibelle());
				 ps.setString(3, Doocumnt.getDescription());
				 ps.setString(2, Doocumnt.getDomaine());
				 ps.setInt(4, Doocumnt.getId());
				
				int i=ps.executeUpdate();
				if(i==1)
					{
						f=true; 
					}
				} catch (Exception e) {
				 e.printStackTrace(); 
				}
		    	 return f;
	     }
	     
	     
	     
	     public boolean  supauteur(int id)
	     {
	    	 boolean f=false;
	    	 
	    	 try {
	    		 
	    		 String sql="delete from auteur where id=?";
	    		 PreparedStatement ps=conn.prepareStatement(sql);
	    		 
	    		 ps.setInt(1, id);
	    		 
				
	    		 int i=ps.executeUpdate();
	 			 if(i==1)
	 				{
	 					f=true; 
	 				}
		 			} catch (Exception e) {
		 			 e.printStackTrace(); 
		 			}
	 	    	  return f;
	    	  
	    	 
	     }

	
}
