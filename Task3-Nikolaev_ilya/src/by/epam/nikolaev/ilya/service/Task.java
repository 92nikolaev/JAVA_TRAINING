package by.epam.nikolaev.ilya.service;

import by.epam.nikolaev.ilya.bean.PartOfSentence;
import by.epam.nikolaev.ilya.bean.PartOfText;
import by.epam.nikolaev.ilya.bean.Sentence;
import by.epam.nikolaev.ilya.bean.Text;
import by.epam.nikolaev.ilya.bean.Word;

public class Task {
	public static Text convertWordFirstSymbol(Text text){
		for (PartOfText element : text.getPartOfTexts()) {
			if(element instanceof Sentence){
				parsePartText(element);
			}
		}
		return text;
	}
	private static void parsePartText(PartOfText element) {
		for (PartOfSentence word : ((Sentence) element).getPartOfSentences()) {
			if(word instanceof Word){
				StringBuilder wrd = new StringBuilder(word.toString());
				if(wrd.length()>0){
					parsePartWord(wrd);
				}
			}	
		}
	}
	private static void parsePartWord(StringBuilder wrd) {
		char first = wrd.charAt(0);
		for (int i = 1; i < wrd.length(); i++) {
			if(wrd.charAt(i) == first){
				wrd.deleteCharAt(i);
			}
		}
	}
	public static Text convertWordLastSymbol(Text text){
		for (PartOfText element : text.getPartOfTexts()) {
			if(element instanceof Sentence){
				parsePartTextLastSymbol(element);
			}
		}
		return text;
	}
	
	private static void parsePartTextLastSymbol(PartOfText element) {
		for (PartOfSentence word : ((Sentence) element).getPartOfSentences()) {
			if(word instanceof Word){
				StringBuilder wrd = new StringBuilder(word.toString());
				if(wrd.length()>0){
					parsePartWordLastSymbol(wrd);
				}
			}
		}
		
	}
	private static void parsePartWordLastSymbol(StringBuilder wrd) {
		if(TextParser.checkForSyntax(Character.toString(wrd.charAt(wrd.length()-1)))){
			char lastChar = wrd.charAt(wrd.length()-2);
			
			for (int i = 1; i < wrd.length()-2; i++) {
				if(wrd.charAt(i) == lastChar){
					wrd.deleteCharAt(i);
				}
			}
		}else{
			char lastChar = wrd.charAt(wrd.length()-1);
			for (int i = 0; i < wrd.length()-1; i++) {
				if(wrd.charAt(i) == lastChar){
					wrd.deleteCharAt(i);
				}
			}
		}
	}
	
	public static Text replacementWordSentense(Text text, int sentenceNumber, int wordLength, String line ){
		int count = 0;
		for (PartOfText element : text.getPartOfTexts()) {
			if(element instanceof Sentence){
				if(count == sentenceNumber){
					for (PartOfSentence word : ((Sentence) element).getPartOfSentences()) {
						String templ = word.toString();
						if(templ.length() == wordLength){
							templ = line;
							Word templWord = new Word(line);
							((Word) word).setContents(templWord.getContents());
							count++;
						}
						
					}
				}else{
					count++;
				}
			}
		}
		return text;
	}
	
}
