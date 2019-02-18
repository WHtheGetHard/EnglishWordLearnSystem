package consts;

import java.util.HashMap;

public class DBOperationResult {
	public static HashMap<String, String> operationResult = new HashMap<String, String>();

	static {
		operationResult.put("0","登録が完了しました。");
		operationResult.put("1", "登録に失敗しました。");
	}
}
