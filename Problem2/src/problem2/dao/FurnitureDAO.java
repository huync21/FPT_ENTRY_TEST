/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem2.dao;

import java.util.List;
import problem2.models.Furniture;

/**
 *
 * @author LENOVO
 */
public interface FurnitureDAO{
    public boolean addFurniture(Furniture furniture);
    public List<Furniture> getAllFurnitures();
    public List<Furniture> getFurnitureBySerialNumber(String serialNumber);
}
