package maisonedition;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import conn.conn;


/**
 * Servlet implementation class ajoutemaison
 */
@WebServlet("/ajoutemaison")
public class ajoutemaison extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ajoutemaison() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/Admin/maisonedit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		      String noms=request.getParameter("noms");
	            
		      
		      maisonedition maison = new maisonedition(noms);
		      
		      maison.setNomsMaison(noms);
		      
		       fonctionM maison1 = new fonctionM(conn.getConn());
		       
	           javax.servlet.http.HttpSession session=request.getSession();
	           
	           boolean f=maison1.addmaison(maison);
	           
	           if(f)
		           {
		        	   session.setAttribute("succMsg", "Auteur ajouté avec success");
		        	   this.getServletContext().getRequestDispatcher("/WEB-INF/Admin/maisonedit.jsp").forward(request, response);
		        	   
		           }
	           else
		           {
		        	   
		        	   session.setAttribute("succMsg", "errorMsg\", \"error d'ajout");
		        	   this.getServletContext().getRequestDispatcher("/WEB-INF/Admin/maisonedit.jsp").forward(request, response);
		           }
	             
				}
		
	

}
