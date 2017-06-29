/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.nikolaev.ilya.bean;

import java.util.ArrayList;

import by.epam.nikolaev.ilya.service.TextParser;

public class Word implements PartOfSentence {
    
   
    private ArrayList<PartOfWord> contents;
    
    public Word(String word) {
        this.contents = TextParser.parseWord(word);
    }
    
    public ArrayList<PartOfWord> getContents() {
        return this.contents;
    }
    
    
    public void setContents(ArrayList<PartOfWord> contents) {
		this.contents = contents;
	}

	@Override
    public String toString() {
        StringBuilder word = new StringBuilder();
        for(PartOfWord c : this.contents) {
            word.append(c.toString());
        }
        return word.toString();
    }
}
