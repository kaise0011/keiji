package servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.info2;
/**
 * Servlet implementation class ResultServlet
 */
@WebServlet("/update")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//formに入力された検索キー(パラメータ)を取得
				request.setCharacterEncoding("UTF-8");
				int id = Integer.parseInt(request.getParameter("id"));
				String text =request.getParameter("text");
				String time = request.getParameter("time");
				info2 s = new info2(id,text,time);
				//データベースから値を取得
				info2 result = dao.update.Update(s);
				//取得した値をリクエストスコープへ保存
				request.setAttribute("info2", result);
				//結果画面へフォワード
				response.sendRedirect("/JavaScriptKadai/delete");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
