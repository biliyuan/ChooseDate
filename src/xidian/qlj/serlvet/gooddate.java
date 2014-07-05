package xidian.qlj.serlvet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xidian.qlj.model.*;

public class gooddate extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    
		    PartyBean up=(PartyBean)request.getSession().getAttribute("partyInfo");
		    if(up==null)
		    {
		    	System.out.println("NULL");
		    }
			response.setContentType("text/html");
			response.setCharacterEncoding("GBK");
			PrintWriter out = response.getWriter();
			daybeanbo dbb=new daybeanbo();
			String end=dbb.goodDate(up.id_party);
			System.out.print(end);
			request.getSession().setAttribute("goodDayInfo",end);
			request.getRequestDispatcher("contact.jsp").forward(request, response);
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
}
