/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem2.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static problem2.dao.DAO.con;
import problem2.models.Furniture;
import problem2.models.Video;

/**
 *
 * @author LENOVO
 */
public class FurnitureDAOImpl extends DAO implements FurnitureDAO{
    @Override
    public boolean addFurniture(Furniture furniture) {
        boolean result = true;
        try {
            con.setAutoCommit(false);
            String sqlInsertIntoThingTable = "INSERT INTO thing VALUES(?,?,?)";
            String sqlInsertIntoFurnitureTable = "INSERT INTO furniture VALUES(?,?,?,?,?)";
            
            PreparedStatement pps = con.prepareStatement(sqlInsertIntoThingTable);
            pps.setString(1, furniture.getSerialNumber());
            pps.setString(2, furniture.getName());
            pps.setFloat(3, furniture.getPrice());
            pps.executeUpdate();
            
            pps = con.prepareStatement(sqlInsertIntoFurnitureTable);
            pps.setString(1, furniture.getSerialNumber());
            pps.setString(2,furniture.getCategory());
            pps.setString(3, furniture.getColor());
            pps.setFloat(4, furniture.getHeight());
            pps.setFloat(5, furniture.getWidth());
            pps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
            result = false;
            try {
                con.rollback();
            } catch (SQLException ex1) {
                System.out.println(ex1);
                result = false;
            }
           
        }
        
        try {
            con.setAutoCommit(true);
        } catch (SQLException ex) {
            System.out.println(ex);
            result = false;
        }
        
        return result;
    }

    @Override
    public List<Furniture> getAllFurnitures() {
        String sqlGetAll = "SELECT * FROM thing JOIN furniture ON furniture.serialNumber = thing.serialNumber";
        List<Furniture> result = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sqlGetAll);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Furniture furniture = new Furniture(
                        rs.getString("serialNumber"),rs.getString("name"),rs.getFloat("price")
                        , rs.getString("category"), rs.getString("color"),
                        rs.getFloat("height"), rs.getFloat("width")
                );
                result.add(furniture);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FurnitureDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }   

    @Override
    public List<Furniture> getFurnitureBySerialNumber(String serialNumber) {
        String sqlGetAll = "SELECT * FROM thing JOIN furniture ON furniture.serialNumber = thing.serialNumber WHERE thing.serialNumber=?";
        List<Furniture> result = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sqlGetAll);
            ps.setString(1, serialNumber);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Furniture furniture = new Furniture(
                        rs.getString("serialNumber"),rs.getString("name"),rs.getFloat("price")
                        , rs.getString("category"), rs.getString("color"),
                        rs.getFloat("height"), rs.getFloat("width")
                );
                result.add(furniture);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FurnitureDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    
}
