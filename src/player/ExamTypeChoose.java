package player;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fieldformat.ExamTypes;
import fieldformat.ShowMessage;
import fieldformat.Words;
import flayer.DisplayExamType;
import flayer.ExecSelectWords;

/**
 * Servlet implementation class ExamTypeChoose
 */
@WebServlet("/ExamTypeChoose")
public class ExamTypeChoose extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExamTypeChoose() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		ExecSelectWords execSelectWords = new ExecSelectWords();
		execSelectWords.selectFromWords();

		ArrayList<Words> wordList = new ArrayList<Words>();
		ShowMessage showMessage = new ShowMessage();

		wordList = execSelectWords.getWordsList();
		showMessage = execSelectWords.getShowMessage();


		String examType = request.getParameter("examType");

		DisplayExamType displayExamType = new DisplayExamType();
		ExamTypes examTypes = new ExamTypes();
		examTypes = displayExamType.decideExamType(examType);


		request.setAttribute("wordList", wordList);
		request.setAttribute("showMessage", showMessage);
		request.setAttribute("examTypes", examTypes);


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
