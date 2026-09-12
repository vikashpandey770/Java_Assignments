package com.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.Dao.EmployeeDao;
import com.bean.EmployeePersonalInfo;
import com.bean.Product;
import com.dao.ProductDao;
@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String action=request.getParameter("action");

if(action.equalsIgnoreCase("insert")) {
	
	Product p=new Product();
	p.setName(request.getParameter("name"));
	p.setBrand(request.getParameter("brand"));
	p.setPrice(Integer.parseInt(request.getParameter("price")));
	
	ProductDao.insert(p);
	response.sendRedirect("insertpages.jsp");
	
}


else if(action.equalsIgnoreCase("edit")) {
	
	int Id=Integer.parseInt(request.getParameter("Id"));
	Product p=ProductDao.getPro(Id);
	request.setAttribute("p", p);
	request.getRequestDispatcher("update.jsp").forward(request, response);	
}

else if(action.equalsIgnoreCase("update")) {
	Product p=new Product();
	p.setId(Integer.parseInt(request.getParameter("Id")));
	p.setName(request.getParameter("name"));
	p.setBrand(request.getParameter("brand"));
	p.setPrice(Integer.parseInt( request.getParameter("price")));
	
	ProductDao.insert(p);
	response.sendRedirect("show.jsp");
}

else if(action.equalsIgnoreCase("delete")) {
	int Id=Integer.parseInt(request.getParameter("Id"));
	ProductDao.delete(Id);
	response.sendRedirect("show.jsp");
}


		
	}

}
