package dlayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fieldformat.ResultDetail;

public class SelectResultDetail {
	DBConnectionInfo dbConnectionInfo = new DBConnectionInfo();
	String url = dbConnectionInfo.getUrl();
	String user = dbConnectionInfo.getUser();
	String password = dbConnectionInfo.getPassword();

	private ResultDetail resultDetail = new ResultDetail();
	private int maxId;

	public ResultDetail selectFromId(int id) throws Exception{
		Connection conn = DriverManager.getConnection(url, user, password);

		String sql = "SELECT * FROM resultdetail WHERE id = ?";

		PreparedStatement psttmt = conn.prepareStatement(sql);
		psttmt.setInt(1, id);

		ResultSet rs = psttmt.executeQuery();

		while(rs.next()) {
			this.resultDetail.setId(id);
			this.resultDetail.setYyyymmdd(rs.getString("yyyymmdd"));
			this.resultDetail.setAccuracy(rs.getString("accuracy"));
		}

		rs.close();
		psttmt.close();
		conn.close();

		return this.resultDetail;
	}

	public int selectMaxId() throws Exception {
		Connection conn = DriverManager.getConnection(url, user, password);

		String sql = "SELECT MAX(id) FROM resultdetail";

		PreparedStatement psttmt = conn.prepareStatement(sql);

		ResultSet rs = psttmt.executeQuery();

		while(rs.next()) {
			this.maxId = rs.getInt("MAX(id)");
		}

		rs.close();
		psttmt.close();
		conn.close();

		return this.maxId;
	}
}
