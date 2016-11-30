

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class RegisterUser
 */
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUser() {
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
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
	
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        Connection con=null;
        
        try{        
	        //loading drivers for mysql
	        Class.forName("com.mysql.jdbc.Driver");
		    //creating connection with the database 
	        con=(Connection) DriverManager.getConnection("jdbc:mysql://35.160.31.195:3306/webDB","root","");
	        PreparedStatement ps=(PreparedStatement) con.prepareStatement("insert into student values(?,?,?)");
	        ps.setString(1, name);
	        ps.setString(2, email);
	        ps.setString(3, phone);
	        int i=ps.executeUpdate();        
	          if(i>0)
	          {
	            out.println("You are sucessfully registered as a Student\n");
	          }        
        }
        catch(Exception se)
        {
            se.printStackTrace();
        }	
        String docType = "<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">\n";
		out.println(docType +
		"<html\n" +
		"<head><title>Student Registration</title></head>\n" +
		"<body>\n" +
        "</br></br><a href='http://www.geauxtutors.com/home.html'>" +
        "Return to GeauxTutors Home page</a>" +
		"</body></html>");
      }		
}


