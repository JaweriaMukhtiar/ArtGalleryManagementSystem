package main;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/imageDisplayServlet")
public class ServletDisplay extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String connectionURL = "jdbc:mysql://localhost:3306/ArtGallery";
        String username = "root";
        String password = "Families*878";

        try {
            Connection connection = DriverManager.getConnection(connectionURL, username, password);

            String query = "SELECT image from Art";
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet resultSet = pst.executeQuery();

            List<byte[]> imageList = new ArrayList<>();

            while (resultSet.next()) {
                InputStream inputStream = resultSet.getBinaryStream("image");
                byte[] imageBytes = inputStream.readAllBytes();
                imageList.add(imageBytes);
            }

            connection.close();

            request.setAttribute("imageList", imageList);
            request.getRequestDispatcher("JSPDisplay.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception
        }
    }
}