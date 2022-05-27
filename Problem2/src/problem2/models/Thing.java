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
public abstract class Thing {
    private String serialNumber;
    private String name;
    private float price;

    public Thing(String serialNumber, String name, float price) {
        this.serialNumber = serialNumber;
        this.name = name;
        this.price = price;
    }
    
    public abstract String getDescription();

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }    

    @Override
    public String toString() {
        return "serialNumber=" + serialNumber + ", name=" + name + ", price=" + price+",";
    }
    
}
