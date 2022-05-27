/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem2.models;

/**
 *
 * @author LENOVO
 */
public class BookOnTape extends Thing{
    private String bookCategory;
    private String duration;

    public BookOnTape(String serialNumber, String name, float price,String category, String duration) {
        super(serialNumber,name,price);
        this.bookCategory = category;
        this.duration = duration;
    }
    
    @Override
    public String getDescription() {
        return "Information of Book on tape: "+super.toString()+toString();
    }

    @Override
    public String toString() {
        return " " + "category=" + bookCategory + ", duration=" + duration;
    }

    public String getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

}
