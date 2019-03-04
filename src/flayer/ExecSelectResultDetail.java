package flayer;

import consts.DBOperationResult;
import dlayer.SelectResultDetail;
import fieldformat.ResultDetail;
import fieldformat.ShowMessage;

public class ExecSelectResultDetail {
	private ShowMessage showMessage = new ShowMessage();

	private ResultDetail resultDetail = new ResultDetail();

	private int maxId;
	public void execSelectFromId(int id) {
		try {
			SelectResultDetail selectResultDetail = new SelectResultDetail();
			resultDetail = selectResultDetail.selectFromId(id);
		} catch (Exception e) {
			showMessage.setAbEnd(true);
			showMessage.setNomalEnd(false);
			showMessage.setMessage(DBOperationResult.operationResult.get("2"));
			e.printStackTrace();

			return;
		}
	}

	public void execSelectMaxId() {
		try {
			SelectResultDetail selectResultDetail = new SelectResultDetail();
			maxId = selectResultDetail.selectMaxId();
		} catch (Exception e) {
			showMessage.setAbEnd(true);
			showMessage.setNomalEnd(false);
			showMessage.setMessage(DBOperationResult.operationResult.get("2"));
			e.printStackTrace();

			return;
		}
	}

	public ShowMessage getShowMessage() {
		return showMessage;
	}

	public ResultDetail getResultDetail() {
		return resultDetail;
	}

	public int getMaxId() {
		return maxId;
	}
}
