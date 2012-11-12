package controllers;

import play.*;
import play.mvc.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;



public class Application extends Controller {

    public static void index() throws SQLException {
    	Connection conn=play.db.DB.getConnection();
    	String str="select * from SCORE_TB";
    	ResultSet rs = conn.prepareStatement(str).executeQuery();
    	rs.last(); 
    	int rowCount = rs.getRow(); //获得ResultSet的总行数 
        renderText(rowCount);
    }

}