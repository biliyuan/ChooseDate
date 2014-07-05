package xidian.qlj.serlvet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xidian.qlj.model.*;

public class Party extends HttpServlet {

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
		response.setCharacterEncoding("gbk");
		PrintWriter out = response.getWriter();
		
		
		//�õ��û��������룬��֤�û��Ƿ�Ϸ�
		
		String u=request.getParameter("party_name");
		//��֤�û�
		PartyBeanBO ubb=new PartyBeanBO();
		if(ubb.checkParty(u)){
			
			PartyBean up=ubb.getPartyBean2(u);
			System.out.println(up.party_name);
			request.getSession().setAttribute("partyInfo", up);
		
			
			request.getRequestDispatcher("choose.jsp").forward(request, response);
		}
		else{
			//�û����Ϸ�
			System.out.println("error");
			request.getRequestDispatcher("party.jsp").forward(request, response);
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
