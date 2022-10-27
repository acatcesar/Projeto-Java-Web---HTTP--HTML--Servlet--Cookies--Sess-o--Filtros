package br.sc.senac.controller.DemoRedirectSessionCookie;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.Cookie;



/**
 * Servlet Filter implementation class acessoRestrito
 */
@WebFilter("/ProcessaLogin")
public class acessoRestrito extends HttpFilter implements Filter {
       
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * @see HttpFilter#HttpFilter()
     */
    public acessoRestrito() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		String valorCookie = getCookie((HttpServletRequest)request, "cookielogin");
		
		
		// TODO Auto-generated method stub
		// place your code here

	
		
		// pass the request along the filter chain
		//chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
		}

		// TODO Auto-generated method stub
	
	
	 public String getCookie(HttpServletRequest request, String name){
		String value=null;
		Cookie[] cookieList=request.getCookies();
		for(Cookie c: cookieList){
		if(c.getName().equals(name)){
		value=c.getValue();
		break;
		}
		}
		return value;
		} 
	


}


