/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem2.dao;

import java.util.List;
import problem2.models.Video;



/**
 *
 * @author LENOVO
 */
public interface VideoDAO{
    public boolean addVideo(Video video);
    public List<Video> getVideoBySerialNumber(String serialNumber);
}
