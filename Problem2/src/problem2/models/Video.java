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
public class Video extends Thing{
    private String quality;
    private String duration;
    
    public Video(String serialNumber, String name, float price, String quality, String duration) {
        super(serialNumber,name,price);
        this.quality = quality;
        this.duration = duration;
    }
    
    @Override
    public String getDescription() {
     return "Information of Video: "+ super.toString()+toString();
    }

    @Override
    public String toString() {
        return " " +"quality=" + quality + ", duration=" + duration;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
