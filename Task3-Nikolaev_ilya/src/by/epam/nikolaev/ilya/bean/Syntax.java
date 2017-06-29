/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.nikolaev.ilya.bean;


public class Syntax implements PartOfSentence, PartOfWord {
    
    private char contents;
    
    public Syntax(char syntax) {
        this.contents = syntax;
    }
    
    public char getContents() {
        return this.contents;
    }
    
    @Override
    public String toString() {
        return Character.toString(this.contents);
    }
}
