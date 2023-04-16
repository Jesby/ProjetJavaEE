package maisonedition;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conn.conn;

/**
 * Servlet implementation class indexMaison
 */
@WebServlet("/indexMaison")
public class indexMaison extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public indexMaison() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**S
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		fonctionM maison = new fonctionM(conn.getConn());
		
		 request.setAttribute("maison", maison.getAllMaison());
		 
		this.getServletContext().getRequestDispatcher("/WEB-INF/Admin/maisonindex.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
