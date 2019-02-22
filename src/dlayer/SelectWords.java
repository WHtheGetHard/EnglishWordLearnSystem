package dlayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fieldformat.Words;

public class SelectWords {
	DBConnectionInfo dbConnectionInfo = new DBConnectionInfo();
	final String url = dbConnectionInfo.getUrl();
	final String user = dbConnectionInfo.getUser();
	final String password = dbConnectionInfo.getPassword();

	private Words words = new Words();
	private int maxId;

	public Words selectFromId(int id) throws Exception {
		Connection conn = DriverManager.getConnection(url, user, password);

		String sql = "SELECT * FROM words WHERE id = ?";

		PreparedStatement psttmt = conn.prepareStatement(sql);
		psttmt.setInt(1, id);

		ResultSet rs = psttmt.executeQuery();
		while(rs.next()) {
			this.words.setId(id);
			this.words.setWord(rs.getString("word"));
			this.words.setMean(rs.getString("mean"));
			this.words.setWordtype(rs.getString("wordtype"));
			this.words.setExample(rs.getString("example"));
		}

		rs.close();
		psttmt.close();
		conn.close();

		return this.words;
	}

	public int selectMaxId() throws Exception {
		Connection conn = DriverManager.getConnection(url, user, password);

		String sql = "SELECT MAX(id) FROM words";

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
