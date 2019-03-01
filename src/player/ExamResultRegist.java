package player;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fieldformat.ExamResult;
import flayer.ExamResultEvaluating;

/**
 * Servlet implementation class ExamResultRegist
 */
@WebServlet("/ExamResultRegist")
public class ExamResultRegist extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExamResultRegist() {
        super();
        // TODO Auto-generated constructor stub
     }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		ArrayList<ExamResult> examResultList = new ArrayList<ExamResult>();
		for(int i = 0; i < 10; i++) {
			ExamResult examResult = new ExamResult();
			examResult.setWordId(Integer.parseInt(request.getParameter("wordId" + i)));
			examResult.setResult(request.getParameter("result" + i));
			examResultList.add(examResult);
		}

		ExamResultEvaluating examResultEvaluating = new ExamResultEvaluating();
		examResultList = examResultEvaluating.execEvaluating(examResultList);


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
