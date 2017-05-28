package Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Chart4Filter2
 */
@WebServlet(name="/Chart4Filter2",urlPatterns="/c4f2")
public class Chart4Filter2 extends HttpServlet {
	List<String> day;
	List<Integer> johnHours;
	List<Integer> janeHours;
	List<Integer> joeHours;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Chart4Filter2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		day = new ArrayList<>();
		johnHours = new ArrayList<>();
		janeHours = new ArrayList<>();
		joeHours = new ArrayList<>();
		String employee = request.getParameter("employee");
		
		String query = "SELECT day, "+employee+" FROM Week_Hours";
		System.out.println(query);
	
	
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/Store", "root", "");
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);

			while (resultSet.next()) {

			
				day.add(resultSet.getString("day"));
				johnHours.add(resultSet.getInt(employee));

				
			}

			
			request.setAttribute("day", day);
			
			switch(employee){
			
			case "games":
				request.setAttribute("john", johnHours);
				break;
			case "utility":
				request.setAttribute("jane", johnHours);
				break;
			case "music":
				request.setAttribute("joe", johnHours);
				break;
			
			
			}
			
			
			
			
			
			

			RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
			rd.forward(request, response);


		}

		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
