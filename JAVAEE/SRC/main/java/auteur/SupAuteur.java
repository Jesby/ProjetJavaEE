package auteur;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conn.conn;
import fonctions.DocumentDAO;
import maisonedition.fonctionM;
import maisonedition.maisonedition;
import modele.Document;
import modele.modeleAuteur;
import tydocument.fonctionType;
import tydocument.model;

/**
 * Servlet implementation class SupAuteur
 */
@WebServlet("/SupAuteur")
public class SupAuteur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupAuteur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         
		    int id =Integer.parseInt(request.getParameter("id"));
			
			AutFonction auteur = new AutFonction(conn.getConn());
			
			boolean f=auteur.supauteur(id);
			
					javax.servlet.http.HttpSession session=request.getSession();
			
			   
	        if(f)
	        {
	        	
	        	
	        	
	        	 int Count=0;
		       	    
	    		   /**
	    		    * Appel de la liste des documents
	    		   */
	    		
	    		   DocumentDAO doumentDAO = new DocumentDAO(conn.getConn());
	    	      List<Document> documents1 = doumentDAO.getAllDocument();
	    		      
	    	        /**
	    			 * Appel de la liste des auteurs
	    			 */
	    	      
	    	      AutFonction auteurDAO = new AutFonction(conn.getConn());
	    		
	    		 
	    	      List<modeleAuteur> auteurs = new ArrayList<modeleAuteur>();
	    		  	   
	    		   
	    	         /**
	    			 * Appel des types du type de document 
	    			 */
	    	      
	    	       fonctionType typeDOA = new fonctionType(conn.getConn());
	    	      
	    	       List<model> types = new ArrayList<model>();
	    	    
	    	       
	    	       
	    	         /**
	    			 * Appel des types de maison d'edition 
	    			 */
	    	       fonctionM maisonDAO = new fonctionM(conn.getConn());
	    	        
	    	       List<maisonedition> maison = new ArrayList<maisonedition>();
	    	      
	    	       for (Document document: documents1 ) 
	    		       {
	    	    	        maison.add(maisonDAO.getMasionById(document.getId_maison()));
	    		    	    types.add(typeDOA.getTypeById(document.getId_type()));
	    					auteurs.add(auteurDAO.getAuteurById(document.getId_auteur()));
	    			        Count ++;
	    				
	    				}
	    	          
	    		       request.setAttribute("maisons", maison);
	    		       request.setAttribute("documents", documents1);
	    		       request.setAttribute("auteurs", auteurs);
	    		       request.setAttribute("types", types);
	    		       
	    		       request.setAttribute("listdoc", Count);
	     	   session.setAttribute("succMsg", "suppression realiser avec  avec success");
	     	   
	     	  this.getServletContext().getRequestDispatcher("/WEB-INF/Admin/index.jsp").forward(request, response);
	        }
	  else
	        {
	     	   
	     	   session.setAttribute("errorMsg", "error de suppression");
	     	   this.getServletContext().getRequestDispatcher("/WEB-INF/Admin/index.jsp").forward(request, response);
	        }
			 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
