package main;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SignupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");  
        PrintWriter pw = response.getWriter(); 
        //String connectionURL = "jdbc:mysql://127.0.0.1:3306/newData";// newData is the database  
        //Connection connection;  
        Connection conn= null;
        String url="jdbc:mysql://localhost:3306/";
        String dbName="ArtGallery";
        String driver="com.mysql.jdbc.Driver";
    
    try{  
      String fullname = request.getParameter("fullname");
      String artistId = request.getParameter("ArtistId");
      String state = request.getParameter("state");  
      String city = request.getParameter("city");  
      String pincode = request.getParameter("pincode");
      String address = request.getParameter("address");
      String mobileno = request.getParameter("mobileno");
      String email= request.getParameter("email");  
      String password = request.getParameter("password");
      String option = request.getParameter("option");
        //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
      if(option.equals("Artist")) {
          Class.forName(driver).newInstance();
          conn = DriverManager.getConnection(url + dbName, "root", "Families*878");
          PreparedStatement pst = conn.prepareStatement("insert into Artist (artistID, artistName, email, password, country, city, pincode, address, phoneNo) values(?,?,?,?,?,?,?,?,?)");//try2 is the name of the table
          //PreparedStatement pst1 =conn.prepareStatement("insert into login values(?,1,?)");//try2 is the name of the table

          pst.setString(1, artistId);
          pst.setString(2, fullname);
          pst.setString(3, email);
          pst.setString(4, password);
          pst.setString(5, state);
          pst.setString(6, city);
          pst.setString(7, pincode);
          pst.setString(8, address);
          pst.setString(9, mobileno);


          int i = pst.executeUpdate();
          // pst1.executeUpdate();
          //conn.commit();
          String msg = " ";
          if (i != 0) {
              msg = "Record has been inserted";
              pw.println("<font size='6' color=blue>" + msg + "</font>");
              RequestDispatcher rd = request.getRequestDispatcher("My_profile.jsp");

              rd.forward(request, response);


          } else {
              msg = "failed to insert the data";
              pw.println("<font size='6' color=blue>" + msg + "</font>");
          }
          pst.close();
      }
      else
      {
          Class.forName(driver).newInstance();
          conn = DriverManager.getConnection(url+dbName,"root", "Families*878");
          PreparedStatement pst =conn.prepareStatement("insert into Bidder (bID, bName, email, password, country, city, pincode, address, phoneNo) values(?,?,?,?,?,?,?,?,?)");//try2 is the name of the table
          //PreparedStatement pst1 =conn.prepareStatement("insert into login values(?,1,?)");//try2 is the name of the table

          pst.setString(1, artistId);
          pst.setString(2, fullname);
          pst.setString(3, email);
          pst.setString(4, password);
          pst.setString(5, state);
          pst.setString(6, city);
          pst.setString(7, pincode);
          pst.setString(8, address);
          pst.setString(9, mobileno);



          int i = pst.executeUpdate();
          // pst1.executeUpdate();
          //conn.commit();
          String msg=" ";
          if(i!=0){
              msg="Record has been inserted";
              pw.println("<font size='6' color=blue>" + msg + "</font>");
              RequestDispatcher rd=request.getRequestDispatcher("ServletDisplay.java");

              rd.forward(request,response);


          }
          else{
              msg="failed to insert the data";
              pw.println("<font size='6' color=blue>" + msg + "</font>");
          }
          pst.close();

    }
    }  
    catch (Exception e){  
      pw.println(e);  
    }  


}
}
