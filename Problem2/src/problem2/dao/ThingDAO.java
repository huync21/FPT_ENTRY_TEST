/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem2.dao;

import java.util.List;
import problem2.models.Thing;

/**
 *
 * @author LENOVO
 */
public interface ThingDAO {
    public Thing getThingBySerialNumber(String serialNumber);
}
