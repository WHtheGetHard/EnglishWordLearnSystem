package flayer;

import fieldformat.ExamTypes;

public class DisplayExamType {
	private ExamTypes examTypes = new ExamTypes();

	public ExamTypes decideExamType(String examType) {
		if ("note".equals(examType)) {
			this.examTypes.setNote(true);
			this.examTypes.setList(false);

		} else if ("list".equals(examType)) {
			this.examTypes.setNote(false);
			this.examTypes.setList(true);

		}

		return this.examTypes;
	}
}
