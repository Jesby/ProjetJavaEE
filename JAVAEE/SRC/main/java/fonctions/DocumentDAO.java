package fonctions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import modele.Document;


public class DocumentDAO {
	 private Connection conn;

		public DocumentDAO(Connection conn) {
			super();
			this.conn = conn;
		}
	    
	     public boolean addSdocument(Document Doocumnt)
	     {
	    	 boolean f=false;
	    	 try {
				String sql="insert into documents(id_auteur,id_type,id_maison,libelle,description,domaine) value(?,?,?,?,?,?) ";
				PreparedStatement ps=conn.prepareStatement(sql);
				 ps.setInt(1, Doocumnt.getId_auteur());
				 ps.setInt(2, Doocumnt.getId_type());
				 ps.setInt(3, Doocumnt.getId_maison());
				 ps.setString(4, Doocumnt.getLibelle());
				 ps.setString(5, Doocumnt.getDescription());
				 ps.setString(6, Doocumnt.getDomaine());
				
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
	     
	     
	     
	     public List<modele.Document> getAllDocument()
	     {
	    	 List<modele.Document> list=new ArrayList<modele.Document>();
	    	 modele.Document s=null;
	    	 try {
	    		 
	    		 String sql="select * from Documents";
	      	   
	      	   PreparedStatement ps=conn.prepareStatement(sql);
	      	   
	      	   ResultSet rs=ps.executeQuery();
	      	    
	      	     while(rs.next()) {
		    	 
	 	    	s= new modele.Document();
	 	    	
	 	    	 s.setId(rs.getInt(1));
	 	    	 s.setId_auteur(rs.getInt(2));
	 	    	 s.setId_type(rs.getInt(3));
	 	    	s.setId_maison(rs.getInt(4));
	 	    	 s.setLibelle(rs.getString(5));
	 	    	 s.setDescription(rs.getString(6));
	 	    	 s.setDomaine(rs.getString(7));
	 	    	 list.add(s);
	      	   }
	      	     
			} catch (Exception e) {
		      e.printStackTrace();	
			}
	    	  
	    	    
	    	 return list;
	     }
	     
	     
	     public modele.Document getDocumentById(int id)
	     {
	    	 modele.Document s=null;
	    	 
	    	 try {
	    		 	
	    	  String sql="select * from Documents where id=?";
	      	   
	      	   PreparedStatement ps=conn.prepareStatement(sql);
	      	   ps.setInt(1, id);
	      	   
	      	   ResultSet rs=ps.executeQuery();
	      	    
	      	     while(rs.next()) {
		    	 
	 	    	s= new modele.Document();
	 	    	
	 	    	 s.setId(rs.getInt(1));
	 	    	 s.setId_auteur(rs.getInt(2));
	 	    	 s.setId_type(rs.getInt(3));
	 	    	 s.setId_maison(rs.getInt(4));
	 	    	 s.setLibelle(rs.getString(5));
	 	    	 s.setDescription(rs.getString(6));
	 	    	 s.setDomaine(rs.getString(7));
	 	    	 
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
				String sql="UPDATE documents set id_auteur=?,id_type=?,id_maison=?,libelle=?,description=?,domaine=? where id=? ";
				PreparedStatement ps=conn.prepareStatement(sql);
				 ps.setInt(1, Doocumnt.getId_auteur());
				 ps.setInt(2, Doocumnt.getId_type());
				 ps.setInt(3, Doocumnt.getId_maison());
				 ps.setString(4, Doocumnt.getLibelle());
				 ps.setString(5, Doocumnt.getDescription());
				 ps.setString(6, Doocumnt.getDomaine());
				 ps.setInt(7, Doocumnt.getId());
				
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
	     
	     
	     
	     public boolean supprimerDocument(int id)
	     {
	    	 boolean f=false;
	    	 
	    	 try {
	    		 
	    		 String sql="delete from documents where id=?";
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
