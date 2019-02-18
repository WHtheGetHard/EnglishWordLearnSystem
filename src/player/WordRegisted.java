package player;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fieldformat.RegistedWord;
import fieldformat.ShowMessage;
import fieldformat.Words;
import flayer.CheckInput;
import flayer.ExecInsertWords;

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
		ShowMessage showMessage = new ShowMessage();
		CheckInput checkInput = new CheckInput();
		showMessage = checkInput.checkWordRegist(registedWord);

		if(showMessage.isAbEnd()) {
			request.setAttribute("showMessage", showMessage);

			RequestDispatcher rd = request.getRequestDispatcher("WordRegisted.jsp");
			rd.forward(request, response);

			return;
		}


		// Insert to table
		Words words = new Words();
		words.setWord(registedWord.getNewWord());
		words.setMean(registedWord.getMean());
		words.setWordtype(registedWord.getWordType());
		words.setExample(registedWord.getExampleSentence());

		ExecInsertWords execInsertWords = new ExecInsertWords();
		showMessage = execInsertWords.execInsertWords(words);

		request.setAttribute("showMessage", showMessage);

		RequestDispatcher rd = request.getRequestDispatcher("WordRegisted.jsp");

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
