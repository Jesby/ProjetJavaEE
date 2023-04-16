package maisonedition;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import tydocument.model;

public class fonctionM {
	
	
	 private Connection conn;

		public fonctionM(Connection conn) {
			super();
			this.conn = conn;
		}
	    
	     public boolean addmaison(maisonedition maison)
	     {
	    	 boolean f=false;
	    	 try {
				String sql="insert into maisonedition(NomsMaison) value(?)";
				
				PreparedStatement ps=conn.prepareStatement(sql);
				 ps.setString(1, maison.getNomsMaison());
				 
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
	     
	     
	     
	     public List<maisonedition> getAllMaison()
	     {
	    	 List<maisonedition> list=new ArrayList<maisonedition>();
	    	 
	    	 maisonedition s=null;
	    	 try {
	    		 
	    		 String sql="select * from maisonedition";
	      	   
	      	   PreparedStatement ps=conn.prepareStatement(sql);
	      	   
	      	   ResultSet rs=ps.executeQuery();
	      	    
	      	     while(rs.next()) {
		    	 
	 	    	s= new maisonedition();
	 	    	 s.setId_Maison(rs.getInt(1));
	 	    	 s.setNomsMaison(rs.getString(2));
	 	    	 
	 	    	 list.add(s);
	      	   }
	      	     
			} catch (Exception e) {
		      e.printStackTrace();	
			}
	    	  
	    	    
	    	 return list;
	     }  
	    
	     
	     public maisonedition getMasionById(int id)
	     {
	    	 maisonedition d=null;
	    	 
	    	 try {
	    		 String sql="select * from maisonedition where id_Maison=?";
	      	   
	      	   PreparedStatement ps=conn.prepareStatement(sql);
	      	 
	      	     ps.setInt(1, id);  
	      	   ResultSet rs=ps.executeQuery();
	      	    
	      	     while(rs.next()) {
		    	 
	 	    	d= new maisonedition();
	 	    	
	 	    	 d.setId_Maison(rs.getInt(1));
	 	    	 d.setNomsMaison(rs.getString(2));
	      	   }
	      	     
			} catch (Exception e) {
		      e.printStackTrace();	
			}
	  
	    	
	    	 return d;
	     }

}
