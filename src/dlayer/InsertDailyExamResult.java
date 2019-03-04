package dlayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import fieldformat.DailyExamResult;

public class InsertDailyExamResult {
	DBConnectionInfo dbConnectionInfo = new DBConnectionInfo();
	String url = dbConnectionInfo.getUrl();
	String user = dbConnectionInfo.getUser();
	String password = dbConnectionInfo.getPassword();

	public String insertToDailyExamResult(ArrayList<DailyExamResult> dailyExamResultList) {
		String result = "";

		int dailyExamResultSize = dailyExamResultList.size();

		try {
			Connection conn = DriverManager.getConnection(url, user, password);

			String sql = "INSERT INTO dailyexamresult (yyyymmdd, detailid, wordid, result) VALUE (?, ?, ?, ?)";

			PreparedStatement psttmt = conn.prepareStatement(sql);

			for (int i = 0; i < dailyExamResultSize; i++) {
				psttmt.setString(1, dailyExamResultList.get(i).getYyyymmdd());
				psttmt.setInt(2, dailyExamResultList.get(i).getDetailid());
				psttmt.setInt(3, dailyExamResultList.get(i).getWordid());
				psttmt.setString(4, dailyExamResultList.get(i).getResult());
				psttmt.executeUpdate();
			}

			psttmt.close();
			conn.close();

			result = "0";
		} catch (Exception e) {
			result = "1";
			e.printStackTrace();
		}
		return result;
	}
}
