package Servlets;

import jdk.nashorn.internal.ir.WhileNode;
import org.omg.CORBA.Request;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by AmanpreetNagi on 2017-03-24.
 */
@WebServlet(name = "DateFilter1", urlPatterns = "/date1")
public class DateFilter1 extends HttpServlet {

    public List<Integer> xboxSales ;
    public List<Integer> ps4Sales;
    public List<Integer> pcSales;
    public List<Integer> salesDate;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String startDate;
        String endDate;
        xboxSales = new ArrayList<>();
        ps4Sales = new ArrayList<>();
        pcSales = new ArrayList<>();
        salesDate = new ArrayList<>();





        if(! (request.getParameter("startDate").equals("")) && ! (request.getParameter("endDate").equals(""))) {
            startDate = request.getParameter("startDate");
             endDate = request.getParameter("endDate");
        }
        else {
            startDate ="";
            endDate = "";
        }

        SimpleDateFormat sf = new SimpleDateFormat("dd");




        String query = "SELECT * FROM os_Sale WHERE saleDate BETWEEN "+"'"+ startDate + "'" + "AND " +"'"+ endDate +"'";

        Connection connection ;

        try {


            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/Store", "root", "");



            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){

                xboxSales.add(resultSet.getInt("androidSale"));
                ps4Sales.add(resultSet.getInt("iosSale"));
                pcSales.add(resultSet.getInt("otherSale"));

                salesDate.add(Integer.decode(sf.format(resultSet.getDate("saleDate"))));

            }

            request.setAttribute("xboxSales",xboxSales);
            request.setAttribute("ps4Sales",ps4Sales);
            request.setAttribute("pcSales",pcSales);
            request.setAttribute("salesDate",salesDate);


            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            requestDispatcher.forward(request,response);

            System.out.println(salesDate);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
