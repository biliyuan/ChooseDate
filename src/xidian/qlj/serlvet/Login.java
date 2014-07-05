package xidian.qlj.serlvet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xidian.qlj.model.*;

public class Login extends HttpServlet {
	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("GBK");
		PrintWriter out = response.getWriter();
		
		
		//得到用户名和密码，验证用户是否合法
	    
		String u=request.getParameter("username");
	
		String p=request.getParameter("password");
		
		//验证用户
		UserBeanBO ubb=new UserBeanBO();
		System.out.println(u);
		System.out.println(p);
		
		if(ubb.checkUser(u, p)){
			
			//用户合法
			
			//把成功登录的用户信息放入session【后面用到】
			
			UserBean ub=ubb.getUserBean(u);
			request.getSession().setAttribute("userInfo", ub);
			

			
			request.getRequestDispatcher("party.jsp").forward(request, response);
		}else{
			
			//用户不合法
			System.out.println("error");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
