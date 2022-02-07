/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import javax.swing.JOptionPane;

import Models.Gamer;
import Models.Gamer_Item;
import Models.Item;


/**
 *
 * @author micha
 */
public class DbHandler 
{
    final String DbConnectionString = "jdbc:ucanaccess://data/EFT_Questie_DB.accdb";

    //***********************
    //* CONSTRUCTOR
    //***********************
    
    public void DbHandler(){
    }
    
    //***********************
    //* GAMER handling
    //***********************
    
    public int GetAmountOfGamers(){
        
        int amountOfGamers = 0;
        try 
        {

            Connection con = DriverManager.getConnection(DbConnectionString);
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM Gamers");//wildcard

            
                    
            while (rs.next()) 
            {
                amountOfGamers = amountOfGamers +1;
               
            }
            
            return amountOfGamers;
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null, "SQL exception occured" + e);
            System.out.println("SQL exception occured" + e);
        }        
    return amountOfGamers;
       
    }
    public Gamer GetGamerByID(int Gamer_ID) {
        Gamer tempGamer = new Gamer(0, "", 0);
        try 
        {

            Connection con = DriverManager.getConnection(DbConnectionString);
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM Gamers WHERE Gamer_ID = " + Gamer_ID);//wildcard

            while (rs.next()) 
            {
                
                int temp_Gamer_ID = rs.getInt("Gamer_ID");
                String temp_Gamer_name = rs.getString("Gamer_Name");
                int temp_Gamer_level = rs.getInt("level");
                
                
                tempGamer = new Gamer( temp_Gamer_ID , temp_Gamer_name , temp_Gamer_level );
                return tempGamer;
            }
            
            
        } 
        
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null, "SQL exception occured" + e);
            System.out.println("SQL exception occured" + e);
        }
        
        return tempGamer;
    }    
    public HashMap<Integer, Gamer> Get_All_Gamers_HashMap() {
        DbHandler manager = new DbHandler();
        HashMap<Integer, Gamer> gamersHashMap = new HashMap<>();
        Gamer tempGamer;
        try 
        {
            Connection con = DriverManager.getConnection(DbConnectionString);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Gamers");//wildcard
            while (rs.next()) 
            {
                int Gamer_ID = rs.getInt("Gamer_ID");
                String Gamer_Name = rs.getString("Gamer_Name");
                int Level = rs.getInt("Level");
                tempGamer = new Gamer(Gamer_ID, Gamer_Name, Level);
                gamersHashMap.put(Gamer_ID, tempGamer);
            }
            return gamersHashMap;
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null, "SQL exception occured" + e);
        }
        return gamersHashMap; 
    }
       
    //***********************
    //* ITEM handling
    //***********************
    
    public Item GetItemByID(int Item_ID)    {
        Item tempItem;
        try 
        {

            Connection con = DriverManager.getConnection(DbConnectionString);
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM Items WHERE Item_ID = " + Item_ID);//wildcard
            while(rs.next())
            {
                int tempItem_ID = rs.getInt("Item_ID");
                String tempItem_Name = rs.getString("Item_Name");
                String tempImage_Source = rs.getString("Image_Source");
                String tempItem_Description = rs.getString("Item_Description");
                tempItem = new Item(tempItem_ID, tempItem_Name, tempImage_Source, tempItem_Description);
                return tempItem;
            }
           
        } 
        
        catch (SQLException e) 
        {
            System.out.println("SQL exception occured" + e);
        }
        tempItem = new Item();
        return tempItem;
    }
    public int GetAmountOfItems()   {
        
        int amountOfItems = 0;
        try 
        {

            Connection con = DriverManager.getConnection(DbConnectionString);
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM Items");//wildcard

            
                    
            while (rs.next()) 
            {
                amountOfItems = amountOfItems +1;
               
            }
            
            return amountOfItems;
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null, "SQL exception occured" + e);
            System.out.println("SQL exception occured" + e);
        }        
    return amountOfItems;
       
    }
    public HashMap<Integer, Item> Get_All_Items_Hashmap()   {
        DbHandler manager = new DbHandler();
        HashMap<Integer, Item> itemsHashMap = new HashMap<>();
        
        try 
        {
            Connection con = DriverManager.getConnection(DbConnectionString);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Items");//wildcard
            while (rs.next()) 
            {
                int Item_ID = rs.getInt("Item_ID");
                String Item_Name = rs.getString("Item_Name");
                String Image_Source = rs.getString("Image_Source");
                String Item_Description = rs.getString("Item_Description");
                Item tempItem = new Item(Item_ID, Item_Name, Image_Source, Item_Description);
                itemsHashMap.put(Item_ID, tempItem);
            }
            return itemsHashMap;
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null, "SQL exception occured" + e);
            System.out.println("SQL exception occured" + e);
        }
        return itemsHashMap; 
    }
    
    //***********************
    //* GAMER_ITEM handling
    //***********************
    
    public HashMap<Integer, Gamer_Item> Get_Gamer_Item_Hashmap(int Gamer_ID)    {
        DbHandler manager = new DbHandler();
        HashMap<Integer, Gamer_Item> gamerItemsHashMap = new HashMap<>();
        
        try 
        {
            Connection con = DriverManager.getConnection(DbConnectionString);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Gamer_Items WHERE Gamer_ID = " + Gamer_ID);//wildcard
            Integer keyCounterForHashMap = 1;
            
            while (rs.next()) 
            {
                int tempGamer_ID = rs.getInt("Gamer_ID");
                int tempItem_ID = rs.getInt("Item_ID");
                int tempAmount = rs.getInt("Amount");
                Gamer_Item tempGamerItem = new Gamer_Item(tempGamer_ID, tempItem_ID, tempAmount);
                gamerItemsHashMap.put(keyCounterForHashMap, tempGamerItem);
                keyCounterForHashMap += 1;
                
            }
            return gamerItemsHashMap;
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null, "SQL exception occured" + e);
            System.out.println("SQL exception occured" + e);
        }
        return gamerItemsHashMap; 
    }
    
}
