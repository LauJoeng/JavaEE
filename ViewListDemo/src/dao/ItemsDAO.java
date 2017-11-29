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
                item.setPrice(rs.getString("price"));
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
    public Items getItemById(int id)
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DBHelper.getConnection();
            String sql = "select * from items where id=?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1,id);
            rs = stmt.executeQuery();
            if(rs.next()) {
                Items item = new Items();
                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));
                item.setCity(rs.getString("city"));
                item.setNumber(rs.getInt("number"));
                item.setPicture(rs.getString("picture"));
                item.setPrice(rs.getString("price"));
                return item;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Items> getViewList(String list)
    {
        ArrayList<Items> itemList = new ArrayList<>();
        int iCount=5;//每次返回前五条记录
        if(list!=null&&list.length()>0)
        {
            String[] arr = list.split(",");
            if (arr.length>=5)
            {
                for (int i=arr.length-1;i>=arr.length-iCount;i--)
                {
                    itemList.add(getItemById(Integer.parseInt(arr[i])));
                }
            }
            else
            {
                for (int i=arr.length-1;i>0;i--)
                {
                    itemList.add(getItemById(Integer.parseInt(arr[i])));
                }
            }
            return itemList;
        }
        else
        {
            return null;
        }
    }


}
