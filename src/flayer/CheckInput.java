package flayer;

import fieldformat.ErrorAndMessage;
import fieldformat.RegistedWord;

public class CheckInput {
	public ErrorAndMessage checkWordRegist(RegistedWord registedWord) {
		StringInputCheck stringInputCheck = new StringInputCheck();

		boolean newWordLack = stringInputCheck.check(registedWord.getNewWord());
		boolean meanLack = stringInputCheck.check(registedWord.getMean());
		boolean wordTypeLack = stringInputCheck.check(registedWord.getWordType());
		boolean exampleSentenceLack = stringInputCheck.check(registedWord.getExampleSentence());

		ErrorAndMessage errorAndMessage = new ErrorAndMessage();

		if(newWordLack && meanLack && wordTypeLack && exampleSentenceLack) {
			errorAndMessage.setShowError(true);
			errorAndMessage.setMessage("please input all words.");

		} else if (!newWordLack && meanLack && wordTypeLack && exampleSentenceLack) {
			errorAndMessage.setShowError(true);
			errorAndMessage.setMessage("please input bellow words.<br>"
					+ "mean, word type, example sentence.");

		} else if (newWordLack && !meanLack && wordTypeLack && exampleSentenceLack) {
			errorAndMessage.setShowError(true);
			errorAndMessage.setMessage("please input bellow words.<br>"
					+ "new word, word type, example sentence.");

		} else if (newWordLack && meanLack && !wordTypeLack && exampleSentenceLack) {
			errorAndMessage.setShowError(true);
			errorAndMessage.setMessage("please input bellow words.<br>"
					+ "new word, mean, example sentence.");

		} else if (newWordLack && meanLack && wordTypeLack && !exampleSentenceLack) {
			errorAndMessage.setShowError(true);
			errorAndMessage.setMessage("please input bellow words.<br>"
					+ "new word, mean, word type.");

		} else if (!newWordLack && !meanLack && wordTypeLack && exampleSentenceLack) {
			errorAndMessage.setShowError(true);
			errorAndMessage.setMessage("please input bellow words.<br>"
					+ "word type, example sentence.");

		} else if (!newWordLack && meanLack && !wordTypeLack && exampleSentenceLack) {
			errorAndMessage.setShowError(true);
			errorAndMessage.setMessage("please input bellow words.<br>"
					+ "mean, example sentence.");

		} else if (!newWordLack && meanLack && wordTypeLack && !exampleSentenceLack) {
			errorAndMessage.setShowError(true);
			errorAndMessage.setMessage("please input bellow words.<br>"
					+ "mean, word type.");

		} else if (newWordLack && !meanLack && !wordTypeLack && exampleSentenceLack) {
			errorAndMessage.setShowError(true);
			errorAndMessage.setMessage("please input bellow words.<br>"
					+ "new word, example sentence.");

		} else if (newWordLack && !meanLack && wordTypeLack && !exampleSentenceLack) {
			errorAndMessage.setShowError(true);
			errorAndMessage.setMessage("please input bellow words.<br>"
					+ "new word, word type.");

		} else if (newWordLack && meanLack && !wordTypeLack && !exampleSentenceLack) {
			errorAndMessage.setShowError(true);
			errorAndMessage.setMessage("please input bellow words.<br>"
					+ "new word, mean.");

		} else if (!newWordLack && !meanLack && !wordTypeLack && exampleSentenceLack) {
			errorAndMessage.setShowError(true);
			errorAndMessage.setMessage("please input example sentence.");

		} else if (newWordLack && !meanLack && !wordTypeLack && !exampleSentenceLack) {
			errorAndMessage.setShowError(true);
			errorAndMessage.setMessage("please input new word.");

		} else if (!newWordLack && meanLack && !wordTypeLack && !exampleSentenceLack) {
			errorAndMessage.setShowError(true);
			errorAndMessage.setMessage("please input mean.");

		} else if (!newWordLack && !meanLack && wordTypeLack && !exampleSentenceLack) {
			errorAndMessage.setShowError(true);
			errorAndMessage.setMessage("please input word type.");

		} else {
			errorAndMessage.setShowError(false);
			errorAndMessage.setMessage("please input word type.");

		}





		return errorAndMessage;
	}
}
