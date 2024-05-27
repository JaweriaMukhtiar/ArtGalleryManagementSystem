package main;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
        
        String n=request.getParameter("email");  
        String p=request.getParameter("password");
        System.out.println(n+ "\n"+ p);
        String options = request.getParameter("option");
       // HttpSession session = request.getSession(false);
        //if(session!=null)
       // session.setAttribute("l_id", n);
        
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "ArtGallery";
        String driver = "com.mysql.cj.jdbc.Driver";
        String userName = "root";
        String password = "Families*878";

        try {
            if(options.equals("Artist")) {
                String query = "select email, password from Artist";
                Class.forName(driver).newInstance();
                conn = DriverManager.getConnection(url + dbName, userName, password);

                st = conn.createStatement();
                rs = st.executeQuery(query);
                //while() {
                while(rs.next()) {
                      String user = rs.getString("email");
                     String pass = rs.getString("password");

                    if (n.equals(user) && p.equals(pass)) {
                        System.out.println("Artist");
                        out.print("You are on Artist page");
                        RequestDispatcher rd = request.getRequestDispatcher("My_profile.jsp");
                        rd.forward(request, response);
                    }
                }
                String user = rs.getString("email");
                String pass = rs.getString("password");

                if (n.equals(user) && p.equals(pass)) {
                    System.out.println("Artist");
                    out.print("You are on Artist page");
                    RequestDispatcher rd = request.getRequestDispatcher("My_profile.jsp");
                    rd.forward(request, response);
                }
                else{
                    out.print("<p style=\"color:red\">Sorry username or password error</p>");
                    RequestDispatcher rd=request.getRequestDispatcher("Sigin.jsp");
                    rd.include(request,response);
                }

                out.close();
            }
            else
            {
                String query = "select email, password from Bidder";
                System.out.println("Customer");
                out.print("You are on Customer page");

                Class.forName(driver).newInstance();
                conn = DriverManager.getConnection(url + dbName, userName, password);

                st = conn.createStatement();
                rs = st.executeQuery(query);
                //while() {
            while(rs.next()) {
                String user = rs.getString("email");
                String pass = rs.getString("password");
                if (n.equals(user) && p.equals(pass)) {
                    System.out.println("Customer");
                    out.print("You are on Customer page");
                    ServletDisplay d=new ServletDisplay();
                    d.doGet(request, response);
                    //RequestDispatcher rd = request.getRequestDispatcher("JSPDisplay.jsp");
                   // rd.forward(request, response);
                }
            }
                String user = rs.getString("email");
                String pass = rs.getString("password");
                if (n.equals(user) && p.equals(pass)) {
                    System.out.println("Customer");
                    out.print("You are on Customer page");
                    ServletDisplay d=new ServletDisplay();
                    d.doGet(request, response);
                    //RequestDispatcher rd = request.getRequestDispatcher("JSPDisplay.jsp");
                   // rd.forward(request, response);
                }
                else{
                    out.print("<p style=\"color:red\">Sorry username or password error</p>");
                    RequestDispatcher rd=request.getRequestDispatcher("Sigin.jsp");
                    rd.include(request,response);
                }
                // }
                // System.out.println("hellllloooooo"+user);
                //String user;


                out.close();
            }
    } 
        catch (Exception e) {
            System.out.println(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
	}
}


