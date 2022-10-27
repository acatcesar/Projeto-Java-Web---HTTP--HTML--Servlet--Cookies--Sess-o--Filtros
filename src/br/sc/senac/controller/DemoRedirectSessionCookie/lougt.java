package br.sc.senac.controller.DemoRedirectSessionCookie;

import java.io.IOException;
import java.io.PrintWriter;
  
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

  
@WebServlet("/logout")
public class lougt extends HttpServlet {
    private static final long serialVersionUID = 1L;
  
    public lougt() {
        super();
    }
  
    // doGet() method
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
  

        PrintWriter out = response.getWriter();
  

        response.setContentType("text/html");
  

        System.out.println("Session before invalidate: "+ request.getSession(false));
  

        request.getSession(false).invalidate();
  

        System.out.println("Session after invalidate: "+ request.getSession(false));
  
  

        	Cookie ck = new Cookie ("cookielogin", "" );
        	ck .setMaxAge(0);
        	response.addCookie(ck);
        	   
           
		response.sendRedirect("demoRedirectSessionCookie/login.html");
        out.close();
    }
  
}
