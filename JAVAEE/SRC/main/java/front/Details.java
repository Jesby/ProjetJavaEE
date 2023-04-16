package front;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auteur.AutFonction;
import conn.conn;
import maisonedition.fonctionM;
import tydocument.fonctionType;

/**
 * Servlet implementation class Details
 */
@WebServlet("/Details")
public class Details extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Details() {
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
		     
		     this.getServletContext().getRequestDispatcher("/WEB-INF/details.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
