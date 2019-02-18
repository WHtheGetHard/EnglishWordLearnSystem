package flayer;

import consts.DBOperationResult;
import dlayer.InsertWords;
import fieldformat.ShowMessage;
import fieldformat.Words;

public class ExecInsertWords {
	public ShowMessage execInsertWords(Words words) {
		String result;
		InsertWords insertWords = new InsertWords();
		result = insertWords.insertToWords(words);

		ShowMessage showMessage = new ShowMessage();

		if("0".equals(result)) {
			showMessage.setAbEnd(false);
			showMessage.setNomalEnd(true);
			showMessage.setMessage(DBOperationResult.operationResult.get(result));

		} else if ("1".equals(result)) {
			showMessage.setAbEnd(true);
			showMessage.setNomalEnd(false);
			showMessage.setMessage(DBOperationResult.operationResult.get(result));
		}

		return showMessage;
	}
}
