package auteur;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conn.conn;
import modele.modeleAuteur;

/**
 * Servlet implementation class Insertauteur
 */
@WebServlet("/Insertauteur")
public class Insertauteur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insertauteur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/Admin/addaut.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		   String noms=request.getParameter("noms");
	       String prenom=request.getParameter("prenom");
	       String nation=request.getParameter("nation");
	       
	          modeleAuteur  Auteur = new modeleAuteur(noms,prenom,nation);
	           AutFonction dao=new AutFonction(conn.getConn());
	           javax.servlet.http.HttpSession session=request.getSession();
	           
	           boolean f=  dao.addAuteur(Auteur);
	           
	           if(f)
		           {
		        	   session.setAttribute("succMsg", "Auteur ajouté avec success");
		        	   this.getServletContext().getRequestDispatcher("/WEB-INF/Admin/addaut.jsp").forward(request, response);
		        	   
		           }
	           else
		           {
		        	   
		        	   session.setAttribute("succMsg", "errorMsg\", \"error d'ajout");
		        	   this.getServletContext().getRequestDispatcher("/WEB-INF/Admin/addaut.jsp").forward(request, response);
		           }
	             
				}
	

}
