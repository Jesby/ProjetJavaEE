package front;

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
 * Servlet implementation class Accueil
 */
@WebServlet("/Accueil")
public class Accueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Accueil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
				}
	          
		       request.setAttribute("maisons", maison);
		       request.setAttribute("documents", documents);
		       request.setAttribute("auteurs", auteurs);
		       request.setAttribute("types", types);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/page.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
