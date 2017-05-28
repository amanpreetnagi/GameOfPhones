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
 * Created by AmanpreetNagi on 2017-03-29.
 */
@WebServlet(name = "Chart2Filter3", urlPatterns = "/combined2")
public class Chart2Filter3 extends HttpServlet {

    List<String> monthList;
    List<Integer> revenueList;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        monthList = new ArrayList<>();
        revenueList = new ArrayList<>();

        String[] months = request.getParameterValues("month");

        StringBuilder m = new StringBuilder();


        String platform = request.getParameter("platform");


        for (int i = 0; i < months.length; i++) {

            m.append("'").append(months[i]).append("'").append(",");

        }
        m.setLength(m.length() - 1);


        System.out.print(m);
        System.out.println(platform);

        String query = "SELECT month, " + platform + " FROM Monthly_Revenue WHERE month IN(" + m + ")";

        System.out.println(query);

        Connection connection;
        Statement statement;
        ResultSet resultSet;


        try {
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost/Store", "root", "");
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            while(resultSet.next()){

                monthList.add(resultSet.getString("month"));
                revenueList.add(resultSet.getInt(platform));
            }

            switch (platform) {

                case "androidRevenue":
                    request.setAttribute("androidRevenue", revenueList);
                    break;
                case "iosRevenue":
                    request.setAttribute("iosRevenue", revenueList);

                    break;
                case "otherRevenue":
                    request.setAttribute("otherRevenue", revenueList);
                    break;

            }

            request.setAttribute("months", monthList);


            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/index.jsp");

            requestDispatcher.forward(request, response);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
