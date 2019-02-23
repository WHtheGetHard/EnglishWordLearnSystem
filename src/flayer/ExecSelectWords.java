package flayer;

import java.util.ArrayList;
import java.util.Random;

import consts.DBOperationResult;
import dlayer.SelectWords;
import fieldformat.ShowMessage;
import fieldformat.Words;

public class ExecSelectWords {
	private ShowMessage showMessage = new ShowMessage();

	private ArrayList<Words> wordsList = new ArrayList<Words>();

	final int wordNumber = 10;

	public void selectFromWords() {
		int maxId = 0;

		SelectWords selectWords = new SelectWords();

		try {
			maxId = selectWords.selectMaxId();

		} catch (Exception e) {
			showMessage.setAbEnd(true);
			showMessage.setNomalEnd(false);
			showMessage.setMessage(DBOperationResult.operationResult.get("2"));
			e.printStackTrace();

			return;
		}

		Random random = new Random();

		Words words;

		for (int i = 0; i < wordNumber; i++) {
			int targetId = random.nextInt(maxId) + 1;

			words = new Words();
			selectWords = new SelectWords();

			try {
				words = selectWords.selectFromId(targetId);

				wordsList.add(words);

				showMessage.setAbEnd(false);
				showMessage.setNomalEnd(true);
				showMessage.setMessage("");
			} catch (Exception e) {
				showMessage.setAbEnd(true);
				showMessage.setNomalEnd(false);
				showMessage.setMessage(DBOperationResult.operationResult.get("2"));
				e.printStackTrace();

				return;
			}
		}

		return;
	}

	public ShowMessage getShowMessage() {
		return showMessage;
	}

	public ArrayList<Words> getWordsList() {
		return wordsList;
	}
}
