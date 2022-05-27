/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem2.dao;

import java.util.ArrayList;
import java.util.List;
import problem2.models.Thing;

/**
 *
 * @author LENOVO
 */
public class ThingDAOImpl extends DAO implements ThingDAO{
    private VideoDAO videoDAO;
    private BookOnTapeDAO bookOnTapeDAO;
    private FurnitureDAO furnitureDAO;

    public ThingDAOImpl(VideoDAO videoDAO, BookOnTapeDAO bookOnTapeDAO, FurnitureDAO furnitureDAO) {
        super();
        this.videoDAO = videoDAO;
        this.bookOnTapeDAO = bookOnTapeDAO;
        this.furnitureDAO = furnitureDAO;
    }
    
    @Override
    public Thing getThingBySerialNumber(String serialNumber) {
        List<Thing> result = new ArrayList<>();
        result.addAll(videoDAO.getVideoBySerialNumber(serialNumber));
        result.addAll(bookOnTapeDAO.getBookOnTapeBySerialNumber(serialNumber));
        result.addAll(furnitureDAO.getFurnitureBySerialNumber(serialNumber));
        return result.get(0);
    }
    
}
