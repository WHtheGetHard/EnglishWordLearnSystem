package player;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fieldformat.DailyExamResult;
import fieldformat.ExamResult;
import fieldformat.ResultDetail;
import fieldformat.ShowMessage;
import flayer.ExamResultEvaluating;
import flayer.ExecInsertDailyExamResult;
import flayer.ExecInsertResultDetail;
import flayer.ExecSelectResultDetail;

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

		String yyyymmdd = examResultList.get(0).getExamDate();
		String accuracy = examResultList.get(0).getValidity();


		ExecSelectResultDetail execSelectResultDetail = new ExecSelectResultDetail();
		execSelectResultDetail.execSelectMaxId();

		ShowMessage showMessage = new ShowMessage();
		showMessage = execSelectResultDetail.getShowMessage();

		if(showMessage.isAbEnd()) {
			request.setAttribute("showMessage", showMessage);

			RequestDispatcher rd = request.getRequestDispatcher("Exam.jsp");

			rd.forward(request, response);

			return;
		}

		ResultDetail resultDetail = new ResultDetail();
		resultDetail.setId(execSelectResultDetail.getMaxId() + 1);
		resultDetail.setYyyymmdd(yyyymmdd);
		resultDetail.setAccuracy(accuracy);

		ExecInsertResultDetail execInsertResultDetail = new ExecInsertResultDetail();
		showMessage = execInsertResultDetail.execInsertResultDetail(resultDetail);

		if(showMessage.isAbEnd()) {
			request.setAttribute("showMessage", showMessage);

			RequestDispatcher rd = request.getRequestDispatcher("Exam.jsp");

			rd.forward(request, response);

			return;
		}

		ArrayList<DailyExamResult> dailyExamResultList = new ArrayList<DailyExamResult>();
		for(int i = 0; i < 10; i++) {
			DailyExamResult dailyExamResult = new DailyExamResult();
			dailyExamResult.setYyyymmdd(yyyymmdd);
			dailyExamResult.setDetailid(resultDetail.getId());
			dailyExamResult.setWordid(examResultList.get(i).getWordId());
			dailyExamResult.setResult(examResultList.get(i).getResult());

			dailyExamResultList.add(dailyExamResult);
		}

		ExecInsertDailyExamResult execInsertDailyExamResult = new ExecInsertDailyExamResult();
		showMessage = execInsertDailyExamResult.execInsertDailyExamResult(dailyExamResultList);

		request.setAttribute("showMessage", showMessage);

		RequestDispatcher rd = request.getRequestDispatcher("Exam.jsp");

		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
