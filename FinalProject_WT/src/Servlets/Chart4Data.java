package Servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by AmanpreetNagi on 2017-04-16.
 */
@WebServlet(name = "Chart4Data", urlPatterns = "/data4")
public class Chart4Data extends HttpServlet {

	List<String> day;
	List<Integer> johnHours;
	List<Integer> janeHours;
	List<Integer> joeHours;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		day = new ArrayList<>();
		johnHours = new ArrayList<>();
		janeHours = new ArrayList<>();
		joeHours = new ArrayList<>();

		String query = "SELECT * FROM Week_Hours";

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
				johnHours.add(resultSet.getInt("games"));
				janeHours.add(resultSet.getInt("utility"));
				joeHours.add(resultSet.getInt("music"));
			}

			request.setAttribute("day", day);
			request.setAttribute("john", johnHours);
			request.setAttribute("jane", janeHours);
			request.setAttribute("joe", joeHours);

			RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
			rd.forward(request, response);


		}

		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
