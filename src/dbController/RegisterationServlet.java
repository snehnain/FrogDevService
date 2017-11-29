package dbController;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.mysql.jdbc.Driver;

import dbConnection.DBConnectionHandler;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterationServlet
 */
@WebServlet("/RegisterationServlet")
public class RegisterationServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /*protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        PrintWriter printWriter = response.getWriter();
        printWriter.println("Sample Page !");
    }*/

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}*/

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Hi i am in registration servlet");
		response.setContentType("application/json");
		String name=request.getParameter("username");
		String mail=request.getParameter("email");
		String pass=request.getParameter("password");
		String confirmpass=request.getParameter("confirmpassword");
		String birth=request.getParameter("dob");
		String mobileno=request.getParameter("mobile");
		
		String sql="INSERT INTO `registration`(`username`, `email`, `password`, `confirmpassword`, `dob`, `mobileno`) VALUES (?,?,?,?,?,?)";
		try {
		DBConnectionHandler dbConnection = new DBConnectionHandler();
		Connection conn=dbConnection.getDBConnetion();
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, name);
		stmt.setString(2, mail);
		stmt.setString(3, pass);
		stmt.setString(4, confirmpass);
		stmt.setString(5, birth);
		stmt.setString(6, mobileno);
		int queryExecute=stmt.executeUpdate();
		if(queryExecute==1) {
//			PrintWriter pw = response.getWriter();
//			pw.w
			System.out.println("Query executed successfully and data inserted");
		}else {
			System.out.println("Query not executed");
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		//doGet(request, response);
	}

}
