package dlayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import fieldformat.Words;

public class InsertWords {
	DBConnectionInfo dbConnectionInfo = new DBConnectionInfo();
	final String url = dbConnectionInfo.getUrl();
	final String user = dbConnectionInfo.getUser();
	final String password = dbConnectionInfo.getPassword();


	public String insertToWords(Words words) {
		String result = "";

		try {
			Connection conn = DriverManager.getConnection(url, user, password);

			String sql = "INSERT INTO words (word, mean, wordtype, example) VALUE (?, ?, ?, ?)";

			PreparedStatement psttmt = conn.prepareStatement(sql);

			psttmt.setString(1, words.getWord());
			psttmt.setString(2, words.getMean());
			psttmt.setString(3, words.getWordtype());
			psttmt.setString(4, words.getExample());

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
