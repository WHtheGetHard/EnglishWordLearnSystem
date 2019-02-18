package player;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fieldformat.ErrorAndMessage;
import fieldformat.RegistedWord;
import flayer.CheckInput;

/**
 * Servlet implementation class WordRegisted
 */
@WebServlet("/WordRegisted")
public class WordRegisted extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public WordRegisted() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");


		RegistedWord registedWord = new RegistedWord();
		registedWord.setNewWord(request.getParameter("newWord"));
		registedWord.setMean(request.getParameter("mean"));
		registedWord.setWordType(request.getParameter("wordType"));
		registedWord.setExampleSentence(request.getParameter("exampleSentence"));


		// CheckInput
		ErrorAndMessage errorAndMessage = new ErrorAndMessage();
		CheckInput checkInput = new CheckInput();
		errorAndMessage = checkInput.checkWordRegist(registedWord);

		if(errorAndMessage.isShowError()) {
			request.setAttribute("errorAndMessage", errorAndMessage);

			RequestDispatcher rd = request.getRequestDispatcher("WordRegisted.jsp");
			rd.forward(request, response);

			return;
		}


		// Next(temp)
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
