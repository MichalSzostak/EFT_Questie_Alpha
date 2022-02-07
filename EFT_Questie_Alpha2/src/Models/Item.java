package Models;

public class Item 
{
    private int Item_ID;
    private String Item_Name;
    private String Image_Source;
    private String Item_Description;
    
    public Item() {
        
    }
    public Item(int Item_ID, String Item_Name, String Image_Source, String Item_Description){
        this.Item_ID = Item_ID;
        this.Item_Name = Item_Name;
        this.Image_Source = Image_Source;
        this.Item_Description = Item_Description;
    }
    
    public int getItem_ID() {
        return this.Item_ID;
    }
    public String getItem_Name() {
        return this.Item_Name;
    }
    public String getImage_Source() {
        return this.Image_Source;
    }
    public String getItem_Description() {
        return this.Item_Description;
    }
    public void setItem_ID(int Item_ID) {
        this.Item_ID = Item_ID;
    }
    public void setItem_Name(String Item_Name) {
        this.Item_Name = Item_Name;
    }
    public void setImage_Source(String Image_Source) {
        this.Image_Source = Image_Source;
    }
    public void setItem_Description(String Item_Description) {
        this.Item_Description = Item_Description;
    }
    
    @Override
    public String toString() {
        return this.Item_Name;
    }
    
}
