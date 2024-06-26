package main;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;



public class ChangePassword extends HttpServlet

{

   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException

    {
        doPost(req,res);

     }

  public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException

    {
	  
      String n=req.getParameter("email");  
      String p=req.getParameter("password"); 
      
	  res.setContentType("text/html");  
      PrintWriter pw = res.getWriter();  
      Connection conn=null;
        try

       {
        String url = "jdbc:mysql://localhost:3306/";
        String dbName="ArtGallery";
        String driver = "com.mysql.jdbc.Driver";

        String user = "root";

        String pass = "Families*878";

        HttpSession session=req.getSession();
        
        String email=req.getParameter("email");
        String oldpwd=req.getParameter("oldpwd");

        String newpwd=req.getParameter("newpwd");

        String cnfpwd=req.getParameter("cnfpwd");

        if (newpwd.equals("") || cnfpwd.equals(""))

            {

                    pw.println("New Password and Comfirm password , both are required.");
                    String msg = "New Password and Comfirm password , both are required.";
                    req.setAttribute("reg", msg);

                getServletContext().getRequestDispatcher("ChangePassword.jsp").forward(req,res);

                return;    

                }

                else if (!newpwd.equals(cnfpwd))

            {

                 pw.println("Your New password and confirm password does not match.");

                 String msg = "Your New password and confirm password does not match.";
                 req.setAttribute("reg", msg);

                  getServletContext().getRequestDispatcher("ChangePassword.jsp").forward(req,res);

                return;

                }

        try

        {    
            Class.forName(driver).newInstance();

            conn = DriverManager.getConnection(url+dbName,"root", "Families*878");
            

                try

                {

                     PreparedStatement ps=conn.prepareStatement("update login set password= ? where email=? and password= ?");

                    try

                    {

               

                        ps.setString(1,newpwd);

                        ps.setString(2, email );

                        ps.setString(3, oldpwd);

                        int i= ps.executeUpdate();

                     if(i==0)

                     {

                       pw.println("Password doesnot Change..Try Again…");
                       String msg = "Password doesnot Change..Try Again…";
                        req.setAttribute("reg", msg);

                        RequestDispatcher rd=req.getRequestDispatcher("Forgot_password.jsp");  
                        rd.forward(req,res);  


                    return;

                     }

                    else
                    {
                      pw.println("Your password Change Successfully….");
                       String msg = "Your password Change Successfully….";
                        req.setAttribute("reg", msg);
                        	RequestDispatcher rd=req.getRequestDispatcher("index1.jsp");  
                            rd.forward(req,res); 
                        }

                        

                    return;
                    

                    }

                    finally

                    {

                        ps.close();

                    }

                }

                finally

                {

                    conn.close();

                }   

            }

        catch(Exception e)

        {

            e.getMessage();

        }

       }

    catch(Exception e)

    {

        e.getMessage();

    }

   }

}

