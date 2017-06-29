package by.epam.nikolaev.ilya.bean;

import java.util.ArrayList;
import java.util.regex.Pattern;

import by.epam.nikolaev.ilya.service.TextParser;



	public class Sentence implements PartOfText{
		
		private ArrayList<PartOfSentence> partOfSentences;
		
		public Sentence(String sentence) {
	        this.partOfSentences = TextParser.parseSentence(sentence);
	    }
	

		public ArrayList<PartOfSentence> getPartOfSentences() {
			return partOfSentences;
		}

		public void setPartOfSentences(ArrayList<PartOfSentence> partOfSentences) {
			this.partOfSentences = partOfSentences;
		}

		 @Override
		 public String toString() {
		    StringBuilder sentence = new StringBuilder();
		    for(PartOfSentence part : this.partOfSentences) {
		    	if(!Pattern.matches("[.?!/,:;]", part.toString())) {
		    		sentence.append(" ");
		        }
		            sentence.append(part.toString());
		            
		        }
		      return sentence.toString().trim();
		    }

}
