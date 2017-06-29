/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.nikolaev.ilya.bean;

public class Symbol implements PartOfWord {
    
    private char letter;
    
    public Symbol(char s) {
        this.letter = s;
    }
    
    public char getContents() {
        return this.letter;
    }
    
    @Override
    public String toString() {
        return Character.toString(this.letter);
    }
}
