package dbController;
import dbConnection.DBConnectionHandler;
import Parser.JSONParser;

import java.io.IOException;
import java.sql.*;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.json.simple.JSONObject;

/**
 * Servlet implementation class LognServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	DBConnectionHandler dbConnection = new DBConnectionHandler();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		//JSONObject json = new JSONObject();

        //ObjectOutputStream out = new ObjectOutputStream(response.getOutputStream());
        Enumeration paramNames = request.getParameterNames();
        String params[] = new String[2];                                                     //What does this mean
        int i = 0;
        while (paramNames.hasMoreElements()) {
            String paramName = (String) paramNames.nextElement();

            System.out.println(paramName);
            String[] paramValues = request.getParameterValues(paramName);
            params[i] = paramValues[0];

            System.out.println(params[i]);
            i++;

        }

        String sql = "SELECT username, password FROM mobiledev where uname=? and password=?";
        Connection conn=dbConnection.getDBConnetion();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, params[0]);
            ps.setString(2, params[1]);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
            	System.out.println("success");
                //json.put("info", "success");
            } else {
            	System.out.println("credentials are not right");
                //json.put("info", "fail");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println(json);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        //response.getWriter().write(json.toString());
	}

}
