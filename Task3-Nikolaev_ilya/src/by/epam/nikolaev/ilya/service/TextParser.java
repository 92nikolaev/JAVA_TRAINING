package by.epam.nikolaev.ilya.service;

import java.util.ArrayList;
import java.util.regex.Pattern;

import by.epam.nikolaev.ilya.bean.BlockOfCode;
import by.epam.nikolaev.ilya.bean.PartOfSentence;
import by.epam.nikolaev.ilya.bean.PartOfText;
import by.epam.nikolaev.ilya.bean.PartOfWord;
import by.epam.nikolaev.ilya.bean.Sentence;
import by.epam.nikolaev.ilya.bean.Symbol;
import by.epam.nikolaev.ilya.bean.Syntax;
import by.epam.nikolaev.ilya.bean.Word;

public class TextParser {
	
	public static  ArrayList<PartOfText> parseText(String book){
		ArrayList<PartOfText> texts = new ArrayList<>();
		String paragraphPattern = NameParameter.PART_OF_KODE;
		String[] partOfText = (book.toString()).split(paragraphPattern);
		if(partOfText.length > 0){
			for (String partText : partOfText) {
				if(Pattern.matches(NameParameter.LISTING, partText)){
				texts.add(new BlockOfCode(partText));
				}else{
					String pattern = NameParameter.SENTENCE;
					String[] sentence = partText.toString().split(pattern);
					for (String string : sentence) {
						Sentence sent = new Sentence(string);
						texts.add(sent);
					}
				}
			}
		}
		return texts;
	}

	public static ArrayList<PartOfSentence> parseSentence(String sentence) {
		ArrayList<PartOfSentence> partOfSentences = new ArrayList<PartOfSentence>();
		String[] pieces = sentence.split(NameParameter.SPLIT);
		for(String piece : pieces) {
			int length = piece.length();
			if(length != 0){
					if(!checkForSyntax(Character.toString(piece.charAt(length-1)))) {
				partOfSentences.add(new Word(piece));
            }else if(length <= 1) {
            	partOfSentences.add(new Syntax(piece.charAt(0)));
            }  else {             
                int lastSyntax = length - 1;
                while(lastSyntax >= 0) {
                    if(checkForSyntax(Character.toString(piece.charAt(lastSyntax)))) lastSyntax--;
                    else break;
                }
                partOfSentences.add(new Word((piece.substring(0, lastSyntax+1))));
                
                for(int pos = lastSyntax+1; pos < length; pos++) {
                	partOfSentences.add(new Syntax(piece.charAt(pos)));
                }
            }
			}
		
        }
        return partOfSentences;
		}
		
		
		
	public static ArrayList<PartOfWord> parseWord(String word) {
		 ArrayList<PartOfWord> partOfWords = new ArrayList<PartOfWord>();
	        for(char c : word.toCharArray()) {
	            if(checkForSyntax(Character.toString(c))){
	            	partOfWords.add(new Syntax(c));
	            }else{ 
	            	partOfWords.add( new Symbol(c));
	            }
	        }
	        return partOfWords;
	}

	public static boolean checkForSyntax(String s) {
        return Pattern.matches(NameParameter.PUNCT, s);
    }

}
