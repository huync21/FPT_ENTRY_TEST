/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem1;

/**
 *
 * @author LENOVO
 */
public class Word {
    private String content;
    private int length;

    public Word(String content, int length) {
        this.content = content;
        this.length = length;
    }

    public Word() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
    
}
