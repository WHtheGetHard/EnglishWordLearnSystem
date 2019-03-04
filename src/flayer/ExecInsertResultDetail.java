package flayer;

import consts.DBOperationResult;
import dlayer.InsertResultDetail;
import fieldformat.ResultDetail;
import fieldformat.ShowMessage;

public class ExecInsertResultDetail {
	public ShowMessage execInsertResultDetail(ResultDetail resultDetail) {
		String result = "";
		InsertResultDetail insertResultDetail = new InsertResultDetail();
		result = insertResultDetail.insertToResultDetail(resultDetail);

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
