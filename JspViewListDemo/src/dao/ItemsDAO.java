package dao;

import entity.Items;
import util.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//商品业务逻辑类
public class ItemsDAO {
    public ArrayList<Items>getAllItems()
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Items>list = new ArrayList<>();
        try
        {
            conn = DBHelper.getConnection();
            String sql = "select * from items;";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next())
            {
                Items item = new Items();
                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));
                item.setCity(rs.getString("city"));
                item.setNumber(rs.getInt("number"));
                item.setPicture(rs.getString("picture"));
                list.add(item);
            }
            return list;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
        finally
        {
            if(rs!=null)
            {
                try {
                    rs.close();
                    rs = null;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(stmt!=null)
            {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
