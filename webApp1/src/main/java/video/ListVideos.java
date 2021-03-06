/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package video;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.ArrayList;
/**
 *
 * @author alumne
 */

public class ListVideos{
    //Constructor   
    public ListVideos() {
    }
    
    //to get all videos registered in database
    public ArrayList<video> getList_videos() {
        ArrayList<video> list_videos = new ArrayList();
        String query = "select * from videos";
        Connection c = null;
        try{
            c = DriverManager.getConnection("jdbc:derby://localhost:1527/isdcm_lab_db;user=isdcm_lab_db;password=isdcm_lab_db");
            PreparedStatement statement;
            statement = c.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            int counter = 0;
            while(rs.next()){
                counter +=1;
                String title = rs.getString("TITLE");
                String author = rs.getString("AUTHOR");
                String creation_date = rs.getString("UPDATE_DATE");
                String time = rs.getString("TIME");
                String description = rs.getString("DESCRIPTION");
                String format = rs.getString("FORMAT");
                int nb = rs.getInt("NB_OF_REPRODUCTIONS");
                int id = rs.getInt("ID");                       
                video video = new video(title, author, creation_date, time, description, format,nb);
                video.setId(id);
                list_videos.add(video);
            }
        }catch (SQLException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        } finally {
            try {
                if (c != null) 
                    c.close();                
            } catch (SQLException e) {
                System.out.println(Arrays.toString(e.getStackTrace()));
            }
        }
        return list_videos;
    }
    
    public video GetVideoFromID(int id)
    {
        video v = new video();
        String query = "select * from videos";
        Connection c = null;
        try{
            c = DriverManager.getConnection("jdbc:derby://localhost:1527/isdcm_lab_db;user=isdcm_lab_db;password=isdcm_lab_db");
            PreparedStatement statement;
            statement = c.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            int counter = 0;
            while(rs.next()){
                counter +=1;
                String title = rs.getString("TITLE");
                String author = rs.getString("AUTHOR");
                String creation_date = rs.getString("UPDATE_DATE");
                String time = rs.getString("TIME");
                String description = rs.getString("DESCRIPTION");
                String format = rs.getString("FORMAT");
                int nb = rs.getInt("NB_OF_REPRODUCTIONS");
                int id_ = rs.getInt("ID");                       
                video video = new video(title, author, creation_date, time, description, format,nb);
                video.setId(id_);
                
                if (id == id_)
                {
                    v = video;
                }
            }
        }catch (SQLException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        } finally {
            try {
                if (c != null) 
                    c.close();                
            } catch (SQLException e) {
                System.out.println(Arrays.toString(e.getStackTrace()));
            }
        }
        return v;
    }
}
