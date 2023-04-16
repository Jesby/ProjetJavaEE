package admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class connect
 */
@WebServlet("/connect")
public class connect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public connect() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/Admin/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/javaee","root","");
			String n=request.getParameter("username");
			String p=request.getParameter("password");
			PreparedStatement ps=con.prepareStatement("SELECT id_user FROM user WHERE login=? and pwd=? ");
			ps.setString(1, n);
			ps.setString(2, p);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
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
				
				RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/Admin/index.jsp");
				rd.forward(request, response);
			}else {
				
				RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/Admin/login.jsp");
				rd.forward(request, response);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	

}
