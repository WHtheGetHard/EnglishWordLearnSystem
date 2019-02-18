package flayer;

import fieldformat.RegistedWord;
import fieldformat.ShowMessage;

public class CheckInput {
	public ShowMessage checkWordRegist(RegistedWord registedWord) {
		StringInputCheck stringInputCheck = new StringInputCheck();

		boolean newWordLack = stringInputCheck.check(registedWord.getNewWord());
		boolean meanLack = stringInputCheck.check(registedWord.getMean());
		boolean wordTypeLack = stringInputCheck.check(registedWord.getWordType());
		boolean exampleSentenceLack = stringInputCheck.check(registedWord.getExampleSentence());

		ShowMessage showMessage = new ShowMessage();

		if(newWordLack && meanLack && wordTypeLack && exampleSentenceLack) {
			showMessage.setAbEnd(true);
			showMessage.setNomalEnd(false);
			showMessage.setMessage("please input all words.");

		} else if (!newWordLack && meanLack && wordTypeLack && exampleSentenceLack) {
			showMessage.setAbEnd(true);
			showMessage.setNomalEnd(false);
			showMessage.setMessage("please input bellow words.<br>"
					+ "mean, word type, example sentence.");


		} else if (newWordLack && !meanLack && wordTypeLack && exampleSentenceLack) {
			showMessage.setAbEnd(true);
			showMessage.setNomalEnd(false);
			showMessage.setMessage("please input bellow words.<br>"
					+ "new word, word type, example sentence.");

		} else if (newWordLack && meanLack && !wordTypeLack && exampleSentenceLack) {
			showMessage.setAbEnd(true);
			showMessage.setNomalEnd(false);
			showMessage.setMessage("please input bellow words.<br>"
					+ "new word, mean, example sentence.");

		} else if (newWordLack && meanLack && wordTypeLack && !exampleSentenceLack) {
			showMessage.setAbEnd(true);
			showMessage.setNomalEnd(false);
			showMessage.setMessage("please input bellow words.<br>"
					+ "new word, mean, word type.");

		} else if (!newWordLack && !meanLack && wordTypeLack && exampleSentenceLack) {
			showMessage.setAbEnd(true);
			showMessage.setNomalEnd(false);
			showMessage.setMessage("please input bellow words.<br>"
					+ "word type, example sentence.");

		} else if (!newWordLack && meanLack && !wordTypeLack && exampleSentenceLack) {
			showMessage.setAbEnd(true);
			showMessage.setNomalEnd(false);
			showMessage.setMessage("please input bellow words.<br>"
					+ "mean, example sentence.");

		} else if (!newWordLack && meanLack && wordTypeLack && !exampleSentenceLack) {
			showMessage.setAbEnd(true);
			showMessage.setNomalEnd(false);
			showMessage.setMessage("please input bellow words.<br>"
					+ "mean, word type.");

		} else if (newWordLack && !meanLack && !wordTypeLack && exampleSentenceLack) {
			showMessage.setAbEnd(true);
			showMessage.setNomalEnd(false);
			showMessage.setMessage("please input bellow words.<br>"
					+ "new word, example sentence.");

		} else if (newWordLack && !meanLack && wordTypeLack && !exampleSentenceLack) {
			showMessage.setAbEnd(true);
			showMessage.setNomalEnd(false);
			showMessage.setMessage("please input bellow words.<br>"
					+ "new word, word type.");

		} else if (newWordLack && meanLack && !wordTypeLack && !exampleSentenceLack) {
			showMessage.setAbEnd(true);
			showMessage.setNomalEnd(false);
			showMessage.setMessage("please input bellow words.<br>"
					+ "new word, mean.");

		} else if (!newWordLack && !meanLack && !wordTypeLack && exampleSentenceLack) {
			showMessage.setAbEnd(true);
			showMessage.setNomalEnd(false);
			showMessage.setMessage("please input example sentence");

		} else if (newWordLack && !meanLack && !wordTypeLack && !exampleSentenceLack) {
			showMessage.setAbEnd(true);
			showMessage.setNomalEnd(false);
			showMessage.setMessage("please input new word");

		} else if (!newWordLack && meanLack && !wordTypeLack && !exampleSentenceLack) {
			showMessage.setAbEnd(true);
			showMessage.setNomalEnd(false);
			showMessage.setMessage("please input mean");

		} else if (!newWordLack && !meanLack && wordTypeLack && !exampleSentenceLack) {
			showMessage.setAbEnd(true);
			showMessage.setNomalEnd(false);
			showMessage.setMessage("please input word type");

		} else {
			showMessage.setAbEnd(false);
			showMessage.setNomalEnd(false);
			showMessage.setMessage("");

		}

		return showMessage;
	}
}
