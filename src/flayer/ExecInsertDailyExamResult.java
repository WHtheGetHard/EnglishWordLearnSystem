package flayer;

import java.util.ArrayList;

import consts.DBOperationResult;
import dlayer.InsertDailyExamResult;
import fieldformat.DailyExamResult;
import fieldformat.ShowMessage;

public class ExecInsertDailyExamResult {
	public ShowMessage execInsertDailyExamResult(ArrayList<DailyExamResult> dailyExamResultList) {
		String result = "";
		InsertDailyExamResult insertDailyExamResult = new InsertDailyExamResult();
		result = insertDailyExamResult.insertToDailyExamResult(dailyExamResultList);

		ShowMessage showMessage = new ShowMessage();

		if("0".equals(result)) {
			showMessage.setAbEnd(false);
			showMessage.setNomalEnd(true);
			showMessage.setMessage(DBOperationResult.operationResult.get(result));
		} else if("1".equals(result)) {
			showMessage.setAbEnd(true);
			showMessage.setNomalEnd(false);
			showMessage.setMessage(DBOperationResult.operationResult.get(result));
		}

		return showMessage;
	}
}
