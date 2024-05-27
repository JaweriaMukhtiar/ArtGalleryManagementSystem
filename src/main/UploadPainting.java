package main;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//import Dao.UploadFileDao;
//import connection.copy.MyConnection;

// This is the annotation-based
// mapping URL to Servlet.
//@WebServlet("/UploadPainting")

// This annotation defines the maximum
// file size which can be taken.
//@MultipartConfig(maxFileSize = 16177215)
@MultipartConfig(maxFileSize = 1024 * 1024 * 10)

public class UploadPainting extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        PreparedStatement pst;
        String connectionURL = "jdbc:mysql://localhost:3306/ArtGallery";
        String driver = "com.mysql.jdbc.Driver";
        String username = "root";
        String password = "Families*878";
        String sql = "INSERT INTO Art(title, artType, price, image, artistID) values(?, ?, ?, ?, ?)";
        int row = 0;


        try {

            String title = request.getParameter("title");
            String stringPrice = request.getParameter("price");
            //Part file = request.getPart("imageFile");
            Part filePart = request.getPart("imageFile");
            //String fileName = filePart.getSubmittedFileName();
           InputStream imageStream = filePart.getInputStream();
            String type = request.getParameter("ptype");
            int price = Integer.parseInt(stringPrice);


            Class.forName(driver).newInstance();
            Connection conn = DriverManager.getConnection(connectionURL, username, password);
            pst = conn.prepareStatement(sql);

            pst.setString(1, title);

            pst.setString(2, type);
            pst.setInt(3, price);

               pst.setBlob(4, imageStream);
            pst.setString(5, "Art0");
            row = pst.executeUpdate();

            String msg=" ";
            if(row!=0){
                msg="Record has been inserted";
                pw.println("<font size='6' color=blue>" + msg + "</font>");
                RequestDispatcher rd=request.getRequestDispatcher("thankyou.jsp");
                rd.forward(request,response);


            }
            else{
                msg="failed to insert the data";
                pw.println("<font size='6' color=blue>" + msg + "</font>");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }


    }
}



