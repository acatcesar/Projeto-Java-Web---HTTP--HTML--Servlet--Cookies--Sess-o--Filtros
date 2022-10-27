package br.sc.senac.controller.DemoRedirectSessionCookie;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ProcessaLogin")
public class ProcessaLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ProcessaLogin() {
        super();

    }
    			
    			
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		


		
		request.getRequestDispatcher("WEB-INF/acesso.jsp").forward(request, response);
		

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("senha");
		String continuarOn = request.getParameter("continuarOn");
		
		if(login!=null && password!=null && !login.isEmpty() && !password.isEmpty()) {
			
		HttpSession session = request.getSession();
		session.getAttribute("login");
		session.setAttribute("usuario", login);
		
		
			
		Cookie ck = new Cookie("cookielogin", login);
		ck.setMaxAge(60*1000*60*24*3);
		response.addCookie(ck);
		
		
	/*	Cookie [] ck1 = request.getCookies();
		for(Cookie atual: ck1){
			if(atual.getUsuario().equals("cookielogin")){
				response.sendRedirect("acesso.jsp");
			}
		}
		request.getRequestDispatcher("Logado.jsp").forward(request, response); */



		
		if(login.equals("admin") && password.equals("123")) {

			session.setAttribute("usuario", login);
			request.getRequestDispatcher("WEB-INF/acesso.jsp").forward(request, response);

		}else if(login.equals("Augusto") && password.equals("123")) {
			session.setAttribute("usuario", login);
			
			if (continuarOn != null) {		
			 ck = new Cookie("cookielogin", login);
			ck.setMaxAge(60*1000*60*24*3);
			response.addCookie(ck);	}
			
			request.setAttribute("usuario", login);
				request.getRequestDispatcher("WEB-INF/acesso.jsp").forward(request, response);
				
	}else {
		response.sendRedirect("demoRedirectSessionCookie/loginincorreto.html");
		

		}

		
	}}}




