package Servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by AmanpreetNagi on 2017-03-26.
 */
@WebServlet(name = "Chart2Data", urlPatterns = "/data2")
public class Chart2Data extends HttpServlet {
    List<String> months;
    List<Integer> xRevenue;
    List<Integer> p4Revenue;
    List<Integer> pcRevenue;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        months = new ArrayList<>();
        xRevenue =new ArrayList<>();
        p4Revenue = new ArrayList<>();
        pcRevenue =new ArrayList<>();

        String query = "SELECT * FROM Monthly_Revenue";
        Connection connection;
        Statement statement;
        ResultSet resultSet;


        try {
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost/Store","root","");

            statement =connection.createStatement();

            resultSet = statement.executeQuery(query);

           while(resultSet.next()){

               months.add(resultSet.getString("month"));
               xRevenue.add(resultSet.getInt("androidRevenue"));
               p4Revenue.add(resultSet.getInt("iosRevenue"));
               pcRevenue.add(resultSet.getInt("otherRevenue"));
           }

           request.setAttribute("months",months);
           request.setAttribute("androidRevenue",xRevenue);
           request.setAttribute("iosRevenue",p4Revenue);
           request.setAttribute("otherRevenue",pcRevenue);

            RequestDispatcher requestDispatcher =getServletContext().getRequestDispatcher("/index.jsp");

            requestDispatcher.forward(request,response);

            System.out.print(months);
            System.out.print(xRevenue);
            System.out.print(p4Revenue);
            System.out.print(pcRevenue);




        }




        catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
