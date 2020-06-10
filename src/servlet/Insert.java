package servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.info;
import dao.insert;
import dao.select;

/**
 * Servlet implementation class Insert
 */
@WebServlet("/Insert")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm");
		 String a = sdf.format(timestamp);
//insert
		int id = 0;
		String name= request.getParameter("name");
		String mail= request.getParameter("mail");
		String text= request.getParameter("text");
		String time = a;
		info s = new info(id,name,mail,text,time);
		info result = insert.Insert(s);
//取得した値をリクエストスコープへ保存
		request.setAttribute("info", result);

//select
		ArrayList<info> list = new ArrayList<info>();
		list = select.searchDao();
		request.setAttribute("keiji", list);

		response.sendRedirect("/JavaScriptKadai/index");
		//String view = "/WEB-INF/view/index.jsp";
		//RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		//dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
