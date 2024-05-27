package main;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class Gallery extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Gallery() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Gallery1 g = new 
		response.setContentType("text/html");  
        PrintWriter pw = response.getWriter(); 
		if(request.getParameter("JOIN") != null){
			Gallery1.validate();
			pw.print("Hii");
		}
			}
}
		
		
		
