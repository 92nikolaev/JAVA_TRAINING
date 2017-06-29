package by.epam.nikolaev.ilya.bean;

import java.util.ArrayList;

import by.epam.nikolaev.ilya.service.TextParser;

public class Text {
	
ArrayList<PartOfText> partOfTexts;

	public Text(String text) {
		this.partOfTexts = TextParser.parseText(text);
	}

	public ArrayList<PartOfText> getPartOfTexts() {
		return partOfTexts;
	}

	public void setPartOfTexts(ArrayList<PartOfText> partOfTexts) {
		this.partOfTexts = partOfTexts;
	}

	@Override
	  public String toString() {
        StringBuilder result = new StringBuilder();
        for(PartOfText partOfText : this.partOfTexts) {
            result.append(partOfText.toString());
            result.append("\n");
        }
        return result.toString();
    }

}
