/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem2;

import problem2.UI.Lookup;
import problem2.dao.BookOnTapeDAO;
import problem2.dao.BookOnTapeDAOImpl;
import problem2.dao.FurnitureDAO;
import problem2.dao.FurnitureDAOImpl;
import problem2.dao.ThingDAO;
import problem2.dao.ThingDAOImpl;
import problem2.dao.VideoDAO;
import problem2.dao.VideoDAOImpl;

/**
 *
 * @author LENOVO
 */
public class Main {
    public static void main(String[] args) {
        FurnitureDAO furnitureDAO = new FurnitureDAOImpl();
        VideoDAO videoDAO = new VideoDAOImpl();
        BookOnTapeDAO bookOnTapeDAO = new BookOnTapeDAOImpl();
        ThingDAO thingDAO = new ThingDAOImpl(videoDAO, bookOnTapeDAO, furnitureDAO);
        Lookup lookupProgram = new Lookup(furnitureDAO, videoDAO, bookOnTapeDAO, thingDAO);
        lookupProgram.execute();
    }
}
