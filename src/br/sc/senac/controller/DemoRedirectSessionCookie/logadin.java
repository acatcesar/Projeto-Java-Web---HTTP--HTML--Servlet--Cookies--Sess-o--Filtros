package br.sc.senac.controller.DemoRedirectSessionCookie;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

/**
 * Servlet implementation class logadin
 */
@WebServlet("/logadin")

public class logadin extends HttpServlet {

    		private static final long serialVersionUID = 1L;



    		/**
    	      @see HttpFilter#HttpFilter()
    	     */
    		
    		
    		
    	    public logadin() {
    	        super();
    	    }
    	    
    	    
  		
    		public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    			HttpServletRequest req = (HttpServletRequest) request;
    			HttpServletResponse res = (HttpServletResponse) response;
    		 if(req.getSession().getAttribute("usuario") ==null) {
    		       
    			 
        		 Cookie [] ck1 = req.getCookies();
        			for(Cookie atual: ck1){
        				if(atual.getValue().equals("cookielogin")){
        					res.sendRedirect("acesso.jsp");
        				}
        			}
        			request.getRequestDispatcher("Logado.jsp").forward(request, response);

    			 //chain.doFilter(request, response);
    		    	 RequestDispatcher rd= request.getRequestDispatcher("login.html");
    		 		rd.forward(request, response);
    		 		
    		 		
    		     } else {
    		    	 RequestDispatcher rd= request.getRequestDispatcher("acesso.jsp");
    			 		rd.forward(request, response);
    		     }
    		
    		
    		}
    	}
