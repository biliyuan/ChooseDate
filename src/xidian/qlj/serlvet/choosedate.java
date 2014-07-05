package xidian.qlj.serlvet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.reflect.generics.scope.MethodScope;

import xidian.qlj.model.*;

@SuppressWarnings("serial")
public class choosedate extends HttpServlet {

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
			daybean db=new daybean();
		    daybeanbo dbb=new daybeanbo();
			String    year=request.getParameter("chooseyear");
			String    month=request.getParameter("choosemonth");
			String    day=request.getParameter("chooseday");
			System.out.println(month);
			System.out.println(day);
			db.id_party=up.id_party;
			db.year=year;
			db.month=month;
			db.day=day;
			dbb.newDay(db);
		    request.getSession().setAttribute("dayInfo", db);
		    System.out.println(db.year);
			request.getRequestDispatcher("afterChoose.jsp").forward(request, response);
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
}
