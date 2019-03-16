package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Task;

/**
 * Servlet implementation class NewServlet
 */
@WebServlet("/new")
public class NewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    //CSRF対策
	    request.setAttribute("_token",request.getSession().getId());

	    //おまじないとしてインスタンスを生成
	    request.setAttribute("tasks", new Task());

	    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/tasks/new.jsp");
	    rd.forward(request, response);

	    /* 修正前
	   EntityManager em = DBUtil.createEntityManager();
	   em.getTransaction().begin();

	   //Taskのインスタンスを生成
	   Task tk = new Task();

	   //tkの各フィールドにデータを代入
	   String content = "タスクを作る";
	   tk.setContent(content);

	   Timestamp currentTime = new Timestamp(System.currentTimeMillis()); //現在の日時を取得
	   tk.setCreated_at(currentTime);
	   tk.setUpdated_at(currentTime);

	   //データベースの保存
	   em.persist(tk);
	   em.getTransaction().commit();

	   //自動採番されたIDの値を表示
	   response.getWriter().append(Integer.valueOf(tk.getId()).toString());

	   em.close();
	   */

	}

}
