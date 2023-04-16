package admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auteur.AutFonction;
import conn.conn;
import fonctions.DocumentDAO;
import maisonedition.fonctionM;
import maisonedition.maisonedition;
import modele.Document;
import modele.modeleAuteur;
import tydocument.fonctionType;
import tydocument.model;
/**
 * Servlet implementation class Editdoc
 */
@WebServlet("/Editdoc")
public class Editdoc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Editdoc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
         
		int id =Integer.parseInt(request.getParameter("id"));
		
		
		
		 fonctions.DocumentDAO documents = new fonctions.DocumentDAO(conn.getConn());
		
		    modele.Document document  = documents.getDocumentById(id);

		    AutFonction auteur = new AutFonction(conn.getConn());

			request.setAttribute("auteur", auteur.getAllAuteur());
			
			fonctionType type = new fonctionType(conn.getConn());
			 
			 request.setAttribute("type", type.getAlltypeD());
			 
			 fonctionM maison = new fonctionM(conn.getConn());
				
			 request.setAttribute("maison", maison.getAllMaison());
		 
		     request.setAttribute("document", document);
		
		
	 this.getServletContext().getRequestDispatcher("/WEB-INF/Admin/editdoc.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		       
		        int idAuteur  = Integer.parseInt(request.getParameter("idAuteur"));
		        
	            int idTypeDoc  = Integer.parseInt(request.getParameter("idTypeDocument"));
	            
	            int idMaison  = Integer.parseInt(request.getParameter("idMaison"));
	            
		       String name=request.getParameter("libelle");
		   
	           String description=request.getParameter("description");
	       
	           String domaine=request.getParameter("domaine");
	       
	           int id=Integer.parseInt(request.getParameter("id"));	
	       
	           modele.Document  Document = new modele.Document(id,idAuteur,idTypeDoc,idMaison,name,description,domaine);
	        
	           fonctions.DocumentDAO dao=new fonctions.DocumentDAO(conn.getConn());
	           
	           javax.servlet.http.HttpSession session=request.getSession();
	           
	           boolean f=dao.udpdateSdocument(Document);
	           
	           if(f)
	        	   
	           {
	        	   
	        	   
	        	   int Count=0;
	       	    
	    		   /**
	    		    * Appel de la liste des documents
	    		   */
	    		
	    		   DocumentDAO doumentDAO = new DocumentDAO(conn.getConn());
	    	      List<Document> documents = doumentDAO.getAllDocument();
	    		      
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
	    	      
	    	       for (Document document: documents ) 
	    		       {
	    	    	        maison.add(maisonDAO.getMasionById(document.getId_maison()));
	    		    	    types.add(typeDOA.getTypeById(document.getId_type()));
	    					auteurs.add(auteurDAO.getAuteurById(document.getId_auteur()));
	    			        Count ++;
	    				
	    				}
	    	          
	    		       request.setAttribute("maisons", maison);
	    		       request.setAttribute("documents", documents);
	    		       request.setAttribute("auteurs", auteurs);
	    		       request.setAttribute("types", types);
	    		       
	    		       request.setAttribute("listdoc", Count);
	    	      
	        	   session.setAttribute("succMsg", "Document mise a jour avec success");
	        	   this.getServletContext().getRequestDispatcher("/WEB-INF/Admin/index.jsp").forward(request, response);
	        	   
	           }
	           
           else
        	   
	           {
	        	   
	        	   session.setAttribute("succMsg", "errorMsg\", \"error d'ajout");
	        	   this.getServletContext().getRequestDispatcher("/WEB-INF/Admin/index.jsp").forward(request, response);
	           }
	          
	}

}
