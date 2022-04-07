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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import video.video;

import com.google.gson.Gson;

/**
 *
 * @author alumne
 */
public class VideoSearcher {
    
    public String getVideoSearchList(String title, String author, int date_day, int date_month, int date_year)
    {
        String retStr = "";
        
        // Generate a list with videos
        List<video> videosToReturn = new ArrayList();
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
                String title_ = rs.getString("TITLE");
                String author_ = rs.getString("AUTHOR");
                String creation_date_ = rs.getString("UPDATE_DATE");
                String time_ = rs.getString("TIME");
                String description_ = rs.getString("DESCRIPTION");
                String format_ = rs.getString("FORMAT");
                int nb_ = rs.getInt("NB_OF_REPRODUCTIONS");
                int id_ = rs.getInt("ID");
                video video = new video(title_, author_, creation_date_, time_, description_, format_,nb_);
                video.setId(id_);
                
                // Get date
                int day_t   = Integer.valueOf("" + creation_date_.charAt(8) + creation_date_.charAt(9));
                int month_t = Integer.valueOf("" + creation_date_.charAt(5) + creation_date_.charAt(6));
                int year_t  = Integer.valueOf("" + creation_date_.charAt(0) + creation_date_.charAt(1) + creation_date_.charAt(2) + creation_date_.charAt(3));

                // Check if values are searched
                if (title.compareTo(title_) ==0 || author.compareTo(author_) == 0 || date_day == day_t || date_month == month_t || date_year == year_t)
                {
                    retStr += String.valueOf(day_t);
                    videosToReturn.add(video);
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
        
        // Encapsulate it
        try{
            Gson gson = new Gson();
            retStr = gson.toJson(videosToReturn);
        }catch(Exception e)
        {
            System.out.println(e.getStackTrace());
            retStr = "Error!";
        }
        
        return retStr;
    }
    
public int sumView(int VideoID)
    {        
        int nb_of_reproductions = 0;
        int nb_rows = 0;
        String query_count = "select count(*) from videos where id=?";
        String query = "select * from videos where id=?";
        String query_update = "update videos set nb_of_reproductions=? where id=?";
        Connection c = null;
        try{
            // create connection to db
            c = DriverManager.getConnection("jdbc:derby://localhost:1527/isdcm_lab_db;user=isdcm_lab_db;password=isdcm_lab_db");
            
            // prepare statement
            PreparedStatement statement;
            
            // execute query_count
            statement = c.prepareStatement(query_count);
            statement.setInt(1, VideoID);
            ResultSet r = statement.executeQuery();
            
            // test if r is not empty  
            if (r.next())
                {                   
                    nb_rows = r.getInt(1);
                }
            
            // test if r has only one row/video 
            if (nb_rows == 1){
                // execute query to get the video with id = id_video
                statement = c.prepareStatement(query);
                statement.setInt(1, VideoID);
                ResultSet r2 = statement.executeQuery();
                if(r2.next()){
                    // get nb of reproductions of the video
                nb_of_reproductions = r2.getInt("NB_OF_REPRODUCTIONS");
                }else{
                    nb_of_reproductions= 50;
                }
      
                // add 1 to nb of reproductions
                nb_of_reproductions++;                
                
                // execute query_update to update nb of reproductions
                statement = c.prepareStatement(query_update);
                statement.setInt(1, nb_of_reproductions);
                statement.setInt(2, VideoID);
                statement.executeUpdate();
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
        
        return nb_of_reproductions;        
    }

}
