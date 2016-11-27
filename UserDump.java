
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserDump
 */
public class UserDump extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDump() {
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
				
		PrintWriter out = response.getWriter();
		
		String name = " ";
		String email = " ";
		String phone = " ";
						
		// JDBC driver name and database URL
		String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		//String DB_URL = "jdbc:mysql://52.26.86.130:3306/testDB";
		String DB_URL = "jdbc:mysql://localhost:3306/webDB";
		// Database credentials
		String USER = "root";
		String PASS = "";
		Connection conn = null;
		Statement stmt = null;
		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">\n";
		out.println(docType +
		"<html\n" +
		"<head><title>Tutor retrieval</title></head>\n" +
		"<body>\n" +
		"<h3><b>Student List</b></h3>");
		
		//STEP 2: Register JDBC driver
		try {
			Class.forName(JDBC_DRIVER);
			//STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);
			//STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = (Statement) conn.createStatement();
			String sql;
			sql = "SELECT * FROM student";
			ResultSet rs = (ResultSet) stmt.executeQuery(sql);
			//STEP 5: Extract data from result set
			
			while (rs.next()) {
			//Retrieve by column name
			name = rs.getString("name");
			phone = rs.getString("phone");
			email = rs.getString("email");
			out.println(docType +
			"<ul>\n" +
			" <li><b>Tutor name</b>: " + name + "\n" +
			" <li><b>Tutor email</b>: " + email + "\n" +
			" <li><b>Tutor phone</b>: " + phone + "\n" +
			"</ul>\n");
			}			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		out.println(docType + "</body></html>");		
	}
}