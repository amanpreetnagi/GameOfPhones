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
 * Created by AmanpreetNagi on 2017-04-01.
 */
@WebServlet(name = "Char3Filter3", urlPatterns = "/c3f3")
public class Char3Filter3 extends HttpServlet {

    List<String> titles;
    List<Integer> ps4Players;
    List<Integer> xboxPlayers;
    List<Integer> pcPlayers;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        titles = new ArrayList<>();
        ps4Players = new ArrayList<>();
        xboxPlayers = new ArrayList<>();
        pcPlayers = new ArrayList<>();

        String game = request.getParameter("game");

        String query = "SELECT * FROM os_users where Game = '" + game + "'";

        Statement statement = null;

        Connection connection = null;

        ResultSet resultSet = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost/Store", "root", "");

            statement = connection.createStatement();

            resultSet = statement.executeQuery(query);

            while(resultSet.next()){

                titles.add(resultSet.getString("week"));
                xboxPlayers.add(resultSet.getInt("androidUsers"));
                ps4Players.add(resultSet.getInt("iosUsers"));
                pcPlayers.add(resultSet.getInt("otherUsers"));
            }

            request.setAttribute("games", titles);
            request.setAttribute("xboxHours", xboxPlayers);
            request.setAttribute("ps4Hours", ps4Players);
            request.setAttribute("pcHours", pcPlayers);

            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/index.jsp");

            requestDispatcher.forward(request, response);

            System.out.print(titles);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
