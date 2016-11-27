
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

/**
 * Servlet implementation class AdminLogin
 */
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		String DB_URL = "jdbc:mysql://localhost:3306/webDB";
		String n1 = request.getParameter("username");
		String n2 = request.getParameter("password");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();		  

		try  {
			Class.forName(JDBC_DRIVER);
		    Connection con = (Connection) DriverManager.getConnection(DB_URL,"root","");
		    String sql = "SELECT * FROM auth WHERE username=? && password=?";
		    PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		    ps.setString(1,n1);
		    ps.setString(2,n2);
		    ResultSet rs = (ResultSet) ps.executeQuery();
		    //ServletRequest session = null;

		    if(rs.next()) {
		         response.sendRedirect("/ji02Td5aR1v8xAS5.html");	    
		         //session.setAttribute("userSession", "loggedin");
		    }   
		    else  {
		         response.sendRedirect("/home.html");
		    }
		} catch (Exception e)  {
			System.out.println(e);
		}
	}		
}
