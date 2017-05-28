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
 * Created by AmanpreetNagi on 2017-03-24.
 */
@WebServlet(name = "PlatformFilter1",urlPatterns = "/platform1")
public class PlatformFilter1 extends HttpServlet {

    public List<Integer> platformList, salesDate  ;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        platformList = new ArrayList<>();
        salesDate = new ArrayList<>();


        String platform = request.getParameter("platform");
        System.out.print(platform);

        String query = "SELECT "+platform+" ,saleDate FROM os_sale";


        Connection connection;
        SimpleDateFormat sf = new SimpleDateFormat("dd");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/Store", "root", "");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()){



               platformList.add(resultSet.getInt(platform));

               salesDate.add(Integer.decode(sf.format(resultSet.getDate("saleDate"))));
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
            request.setAttribute("salesDate",salesDate);
          

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
