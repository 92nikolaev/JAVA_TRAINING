package by.epam.nikolaev.ilya.servicemain;

import by.epam.nikolaev.ilya.bean.Text;
import by.epam.nikolaev.ilya.service.Task;
import by.epam.nikolaev.ilya.service.loader.text.LoaderText;
import by.epam.nikolaev.ilya.service.record.text.RecordText;
import by.epam.nikolaev.ilya.service.test.NameParameter;

public class Main {

	public static void main(String[] args) {
		
		Text text = new Text(LoaderText.getAlltext());
		RecordText.recordingText(text.toString());
		
		Text firstTask = Task.convertWordFirstSymbol(text);
		RecordText.recordingText(firstTask.toString());
		
		Text secondTask = Task.convertWordLastSymbol(text);
		RecordText.recordingText(secondTask.toString());
		
		Text thirdTask = Task.replacementWordSentense(text, 3, 2, NameParameter.FIRST_TEST_REPLACEMENT);
		RecordText.recordingText(thirdTask.toString());
		
	}

}
