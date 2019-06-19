package loginServletApp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginServletDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public LoginServletDemo() {
    	
		
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String username=request.getParameter("username");
		
		pw.println("you are using GET method and request parameter username :"+username);
		
		HttpSession session=request.getSession();
		ServletContext context=request.getServletContext();
		if(username!="" && username!=null)
		{
		session.setAttribute("savedusername" ,username);
		context.setAttribute("savedusername" ,username);
		}
		
		pw.println("session parameter has username as" +(String)session.getAttribute("savedusername"));
		pw.println("context parameter has username as" +(String)context.getAttribute("savedusername"));
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		pw.println("you are using POST method" + username );
		
		String prof=request.getParameter("prof");
		pw.println("you are now a " +prof);
		
		//String location=request.getParameter("location");
		String[] location=request.getParameterValues("location");
		pw.println("you are @" + location.length + " places");
		
		for(int i=0;i<location.length;i++)
			pw.println(location[i]);
		
	}
	
}
