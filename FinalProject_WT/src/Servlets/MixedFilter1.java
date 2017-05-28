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
 * Created by AmanpreetNagi on 2017-03-25.
 */
@WebServlet(name = "MixedFilter1",urlPatterns = "/combined1")
public class MixedFilter1 extends HttpServlet {

    List<Integer> platformList, salesDateList;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        platformList = new ArrayList<>();
        salesDateList = new ArrayList<>();
        String date;
        String platform = request.getParameter("platform");

        if(!request.getParameter("pDate").equals("")){
            date = request.getParameter("pDate");
        }
        else {
            date ="";
        }

        System.out.print(platform);
        System.out.print(date);
        String query = "SELECT "+platform+" ,saleDate FROM os_Sale WHERE saleDate = "+"'"+date+"'"+" ";

        Connection connection;
        SimpleDateFormat sf =new SimpleDateFormat("dd");


        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/Store","root","");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()){

                platformList.add(resultSet.getInt(platform));
                salesDateList.add(Integer.decode(sf.format(resultSet.getDate("saleDate"))));
            }

            switch (platform){
                case "androidSale":
                    request.setAttribute("xboxSales",platformList);
                    break;
                case "iosSale":
                    request.setAttribute("ps4Sales",platformList);
                    break;
                case "otherSale":
                    request.setAttribute("pcSales",platformList);
                    break;
            }
            request.setAttribute("salesDate",salesDateList);

            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            requestDispatcher.forward(request,response);


        }

        catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
