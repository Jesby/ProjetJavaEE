package tydocument;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import maisonedition.maisonedition;
import modele.modeleAuteur;

public class fonctionType {
	
	 private Connection conn;

		public fonctionType(Connection conn) {
			super();
			this.conn = conn;
		}
	    
	     public boolean addTypeDoc(model type)
	     {
	    	 boolean f=false;
	    	 try {
				String sql="insert into typedocument(Designation) value(?)";
				
				PreparedStatement ps=conn.prepareStatement(sql);
				 ps.setString(1, type.getDesignation());
				 
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
	     
	     
	     
	     
	     
	     public List<model> getAlltypeD()
	     {
	    	 List<model> list=new ArrayList<model>();
	    	 
	    	 model s=null;
	    	 
	    	 try {
	    		 
	    		 String sql="select * from typedocument";
	      	   
	      	   PreparedStatement ps=conn.prepareStatement(sql);
	      	   
	      	   ResultSet rs=ps.executeQuery();
	      	    
	      	     while(rs.next()) {
		    	 
	 	    	 s= new model();
	 	    	 s.setId_Doc(rs.getInt(1));
	 	    	 s.setDesignation(rs.getString(2)); 
	 	    	 list.add(s);
	      	   }
	      	     
			} catch (Exception e) {
		      e.printStackTrace();	
			}
	    	  
	    	    
	    	 return list;
	     }  

	     
	     
	     public model getTypeById(int id)
	     {
	    	 model s=null;
	    	 
	    	 try {
	    		 String sql="select * from typedocument where id_Doc=?";
	      	   
	      	   PreparedStatement ps=conn.prepareStatement(sql);
	      	   ps.setInt(1, id);
	      	   
	      	   ResultSet rs=ps.executeQuery();
	      	    
	      	     while(rs.next()) {
		    	 
	 	    	s= new model();
	 	    	
	 	    	 s.setId_Doc(rs.getInt(1));
	 	    	 s.setDesignation(rs.getString(2));
	      	   }
	      	
			} catch (Exception e) {
		      e.printStackTrace();	
			}
	    	
	    	
	    	 return s;
	     }
	     
	     
}
