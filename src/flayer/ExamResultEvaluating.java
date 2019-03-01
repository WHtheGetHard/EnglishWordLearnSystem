package flayer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import fieldformat.ExamResult;

public class ExamResultEvaluating {
	private String date;

	public ArrayList<ExamResult> execEvaluating(ArrayList<ExamResult> examResultList) {
		Calendar calendar = Calendar.getInstance();

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("y/M/d");

		date = simpleDateFormat.format(calendar.getTime());

		double denominator = 0, numerator = 0;
		double examResultListSize = examResultList.size();

		denominator = examResultListSize;

		for (int i = 0; i < examResultListSize; i++) {
			String result = examResultList.get(i).getResult();

			if("〇".equals(result)) {
				numerator++;
			}

		}

		double calcu = (numerator / denominator) * 100;
		int validity = (int) calcu;

		for (int i = 0; i < examResultListSize; i++) {
			examResultList.get(i).setValidity(validity + "%");
			examResultList.get(i).setExamDate(date);
		}

		return examResultList;
	}
}
