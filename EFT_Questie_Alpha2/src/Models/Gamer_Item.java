package Models;

import controllers.DbHandler;

public class Gamer_Item 
{
    private int Gamer_ID;
    private int Item_ID;
    private int Amount;
    
    public Gamer_Item() {
        
    }
    public Gamer_Item(int Gamer_ID, int Item_ID, int Amount){
        this.Gamer_ID = Gamer_ID;
        this.Item_ID = Item_ID;
        this.Amount = Amount;
    }
    
    public int getGamer_ID() {
        return Gamer_ID;
    }
    public void setGamer_ID(int Gamer_ID) {
        this.Gamer_ID = Gamer_ID;
    }
    public int getItem_ID() {
        return Item_ID;
    }
    public void setItem_ID(int Item_ID) {
        this.Item_ID = Item_ID;
    }
    public int getAmount() {
        return Amount;
    }
    public void setAmount(int Amount) {
        this.Amount = Amount;
    }
    
     @Override
    public String toString(){
        DbHandler manager = new DbHandler();
        
        int tempItemID = this.getItem_ID();
        Item tempItem = manager.GetItemByID(tempItemID);
        String tempItemName = tempItem.getItem_Name();
        
        String listString = tempItemName + ": " + this.Amount + "x";
        return listString;
    }
}
