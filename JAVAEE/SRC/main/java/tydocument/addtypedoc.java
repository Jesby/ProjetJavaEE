package tydocument;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conn.conn;
import maisonedition.fonctionM;
import maisonedition.maisonedition;

/**
 * Servlet implementation class addtypedoc
 */
@WebServlet("/addtypedoc")
public class addtypedoc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addtypedoc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/Admin/typeDocAdd.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   
		  String noms=request.getParameter("noms");
         
	      model type = new model(noms);
	      
	      
	       type.setDesignation(noms);
	      
	       fonctionType type1 = new fonctionType(conn.getConn()); 
	       
	       
          javax.servlet.http.HttpSession session=request.getSession();
          
          boolean f=type1.addTypeDoc(type);
          
          if(f)
	           {
	        	   session.setAttribute("succMsg", "document ajouté avec success");
	        	  
	        	   this.getServletContext().getRequestDispatcher("/WEB-INF/Admin/typeDocAdd.jsp").forward(request, response);
	        	   
	           }
          else
	           {
	        	   
	        	   session.setAttribute("succMsg", "errorMsg\", \"error d'ajout");
	        	   this.getServletContext().getRequestDispatcher("/WEB-INF/Admin/typeDocAdd.jsp").forward(request, response);
	           }
            
	}

}
