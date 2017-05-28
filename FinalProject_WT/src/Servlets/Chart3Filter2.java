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
import java.util.Arrays;
import java.util.List;

/**
 * Created by AmanpreetNagi on 2017-04-01.
 */
@WebServlet(name = "Chart3Filter2", urlPatterns = "/c3f2")
public class Chart3Filter2 extends HttpServlet {

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
        String[] platforms = new String[5];


        if (!request.getParameter("platform").equals("")) {
            platforms = request.getParameterValues("platform");

        } else {
            Arrays.fill(platforms, "");
        }

        System.out.println(platforms);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < platforms.length; i++) {

            sb.append(platforms[i]).append(",");
        }

        System.out.println(sb);


        String query = "SELECT " + sb + "week FROM os_users";

        Connection connection;
        Statement statement;
        ResultSet resultSet;


        try {
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost/Store", "root", "");
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            while(resultSet.next()){

                titles.add(resultSet.getString("week"));


                if (Arrays.asList(platforms).contains("androidUsers")) {
                    xboxPlayers.add(resultSet.getInt("androidUsers"));
                }
                if (Arrays.asList(platforms).contains("iosUsers")) {
                    ps4Players.add(resultSet.getInt("iosUsers"));
                }
                if (Arrays.asList(platforms).contains("otherUsers")) {
                    pcPlayers.add(resultSet.getInt("otherUsers"));
                }
            }

            request.setAttribute("games", titles);
            request.setAttribute("xboxHours", xboxPlayers);
            request.setAttribute("ps4Hours", ps4Players);
            request.setAttribute("pcHours", pcPlayers);


            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/index.jsp");

            requestDispatcher.forward(request, response);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
