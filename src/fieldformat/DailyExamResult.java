package fieldformat;

public class DailyExamResult {
	private int id;

	private String yyyymmdd;

	private int detailid;

	private int wordid;

	private String result;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYyyymmdd() {
		return yyyymmdd;
	}

	public void setYyyymmdd(String yyyymmdd) {
		this.yyyymmdd = yyyymmdd;
	}

	public int getDetailid() {
		return detailid;
	}

	public void setDetailid(int detailid) {
		this.detailid = detailid;
	}

	public int getWordid() {
		return wordid;
	}

	public void setWordid(int wordid) {
		this.wordid = wordid;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
