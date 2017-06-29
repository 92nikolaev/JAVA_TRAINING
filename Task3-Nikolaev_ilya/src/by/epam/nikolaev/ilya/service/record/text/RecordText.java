package by.epam.nikolaev.ilya.service.record.text;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Logger;

import by.epam.nikolaev.ilya.service.NameParameter;


public class RecordText {
	private static int count = 0;
	final static Logger logger = Logger.getLogger(RecordText.class);
	 private static BufferedWriter bufferedWriter;
	
	public static void recordingText(String text){
		try {
			bufferedWriter = new BufferedWriter(new FileWriter(NameParameter.WRITER_TEXT+count+NameParameter.WRITER_TEXT_PART));
			bufferedWriter.write(text);
			bufferedWriter.flush();
			count++;
		} catch (IOException e) {
			logger.error(NameParameter.IO_EXCEPTION, e);
		}finally {
			if(bufferedWriter != null){
				try {
					bufferedWriter.close();
				} catch (IOException e) {
					logger.error(NameParameter.IO_EXCEPTION, e);
				}
			}
		}
		
	}
	
	
	
	
	

}
