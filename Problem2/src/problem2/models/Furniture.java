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
public class Furniture extends Thing{
    private String category;
    private String color;
    private float height;
    private float width;
    
    public Furniture(String serialNumber, String name, float price,String category, String color, float height, float width) {
        super(serialNumber,name,price);
        this.category = category;
        this.color = color;
        this.height = height;
        this.width = width;
    }

    @Override
    public String getDescription() {
        return "Information of Funiture: "+super.toString()+toString();
    }

    @Override
    public String toString() {
        return " " + "category=" + category + ", color=" + color + ", height=" + height + ", width=" + width;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }
}
