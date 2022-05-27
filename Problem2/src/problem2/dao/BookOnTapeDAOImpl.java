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
import problem2.models.BookOnTape;
import problem2.models.Video;

/**
 *
 * @author LENOVO
 */
public class BookOnTapeDAOImpl extends DAO implements BookOnTapeDAO{
    
    @Override
    public boolean addBookOnTape(BookOnTape bookOnTApe) {
        boolean result = true;
        try {
            con.setAutoCommit(false);
            String sqlInsertIntoThingTable = "INSERT INTO thing VALUES(?,?,?)";
            String sqlInsertIntoFurnitureTable = "INSERT INTO video VALUES(?,?,?)";
            
            PreparedStatement pps = con.prepareStatement(sqlInsertIntoThingTable);
            pps.setString(1, bookOnTApe.getSerialNumber());
            pps.setString(2, bookOnTApe.getName());
            pps.setFloat(3, bookOnTApe.getPrice());
            pps.executeUpdate();
            
            pps = con.prepareStatement(sqlInsertIntoFurnitureTable);
            pps.setString(1, bookOnTApe.getSerialNumber());
            pps.setString(2, bookOnTApe.getBookCategory());
            pps.setString(3, bookOnTApe.getDuration());
            
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
    public List<BookOnTape> getAllBookOnTapes() {
        String sqlGetAll = "SELECT * FROM thing JOIN bookontape ON bookontape.serialNumber = thing.serialNumber";
        List<BookOnTape> result = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sqlGetAll);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BookOnTape bookOnTape = new BookOnTape(
                        rs.getString("serialNumber"), rs.getString("name"), rs.getFloat("price"),
                         rs.getString("bookcategory"), rs.getString("duration")
                );
                result.add(bookOnTape);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FurnitureDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public List<BookOnTape> getBookOnTapeBySerialNumber(String serialNumber) {
        String sqlGetAll = "SELECT * FROM thing JOIN bookontape ON bookontape.serialNumber = thing.serialNumber WHERE thing.serialNumber=?";
        List<BookOnTape> result = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sqlGetAll);
            ps.setString(1, serialNumber);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BookOnTape bookOnTape = new BookOnTape(
                        rs.getString("serialNumber"), rs.getString("name"), rs.getFloat("price"),
                         rs.getString("bookcategory"), rs.getString("duration")
                );
                result.add(bookOnTape);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FurnitureDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
}
