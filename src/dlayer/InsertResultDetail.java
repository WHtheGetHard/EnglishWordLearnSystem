package dlayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import fieldformat.ResultDetail;

public class InsertResultDetail {
	DBConnectionInfo dbConnectionInfo = new DBConnectionInfo();
	String url = dbConnectionInfo.getUrl();
	String user = dbConnectionInfo.getUser();
	String password = dbConnectionInfo.getPassword();

	public String insertToResultDetail(ResultDetail resultDetail) {
		String result = "";

		try {
			Connection conn = DriverManager.getConnection(url, user, password);

			String sql = "INSERT INTO resultdetail (id, yyyymmdd, accuracy) VALUE (?, ?, ?)";

			PreparedStatement psttmt = conn.prepareStatement(sql);
			psttmt.setInt(1, resultDetail.getId());
			psttmt.setString(2, resultDetail.getYyyymmdd());
			psttmt.setString(3, resultDetail.getAccuracy());

			psttmt.executeUpdate();

			result = "0";

			psttmt.close();
			conn.close();

		} catch (Exception e) {
			result = "1";
			e.printStackTrace();
		}

		return result;
	}

}
