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
public class VideoDAOImpl extends DAO implements VideoDAO {

    @Override
    public boolean addVideo(Video video) {
        boolean result = true;
        try {
            con.setAutoCommit(false);
            String sqlInsertIntoThingTable = "INSERT INTO thing VALUES(?,?,?)";
            String sqlInsertIntoFurnitureTable = "INSERT INTO video VALUES(?,?,?)";

            PreparedStatement pps = con.prepareStatement(sqlInsertIntoThingTable);
            pps.setString(1, video.getSerialNumber());
            pps.setString(2, video.getName());
            pps.setFloat(3, video.getPrice());
            pps.executeUpdate();

            pps = con.prepareStatement(sqlInsertIntoFurnitureTable);
            pps.setString(1, video.getSerialNumber());
            pps.setString(2, video.getQuality());
            pps.setString(3, video.getDuration());

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
    public List<Video> getVideoBySerialNumber(String serialNumber) {
        String sqlGetAll = "SELECT * FROM thing JOIN video ON video.serialNumber = thing.serialNumber WHERE thing.serialNumber=?";
        List<Video> result = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sqlGetAll);
            ps.setString(1, serialNumber);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Video video = new Video(
                        rs.getString("serialNumber"), rs.getString("name"), rs.getFloat("price"),
                         rs.getString("quality"), rs.getString("duration")
                );
                result.add(video);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FurnitureDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

}
