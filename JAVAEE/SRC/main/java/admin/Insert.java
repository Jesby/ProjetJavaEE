package admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auteur.AutFonction;
import conn.conn;
import fonctions.DocumentDAO;
import maisonedition.fonctionM;
import modele.Document;
import modele.modeleAuteur;
import tydocument.fonctionType;

/**
 * Servlet implementation class Insert
 */
@WebServlet("/Insert")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		 AutFonction auteur = new AutFonction(conn.getConn());
			 
		request.setAttribute("auteur", auteur.getAllAuteur());
		
		
		fonctionType type = new fonctionType(conn.getConn());
		 
		 request.setAttribute("type", type.getAlltypeD());
		 
		 fonctionM maison = new fonctionM(conn.getConn());
			
		 request.setAttribute("maison", maison.getAllMaison());
		
		  
		this.getServletContext().getRequestDispatcher("/WEB-INF/Admin/adddoc.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    
		   String name=request.getParameter("libelle");
	       String description=request.getParameter("description");
	       String domaine=request.getParameter("domaine");
	       int idAuteur  = Integer.parseInt(request.getParameter("idAuteur"));
	       int idTypeDoc  = Integer.parseInt(request.getParameter("idTypeDocument"));
	       int idMaison  = Integer.parseInt(request.getParameter("idMaison"));
	      
	           Document Document = new Document(idAuteur,idTypeDoc,idMaison, name, description, domaine);
	       
	           DocumentDAO dao = new DocumentDAO(conn.getConn());
	     
	           
	           javax.servlet.http.HttpSession session=request.getSession();
	           
	           boolean f=  dao.addSdocument(Document);
	           
	           if(f)
		           {
		        	   session.setAttribute("succMsg", "Document ajouté avec success");
		        	   this.getServletContext().getRequestDispatcher("/WEB-INF/Admin/adddoc.jsp").forward(request, response);
		        	   
		           }
	           else
		           { 
		        	   session.setAttribute("succMsg", "errorMsg\", \"error d'ajout");
		        	   this.getServletContext().getRequestDispatcher("/WEB-INF/Admin/adddoc.jsp").forward(request, response);
		           }
	             
				}

	

}
