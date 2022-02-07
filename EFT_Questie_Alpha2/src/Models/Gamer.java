package Models;

public class Gamer 
{
    private int gamer_ID;
    private String gamer_Name;
    private int gamer_Level;

    public Gamer(){
        
    }
    public Gamer(int gamer_ID, String gamer_Name, int gamer_Level){
        this.gamer_ID = gamer_ID;
        this.gamer_Name = gamer_Name;
        this.gamer_Level = gamer_Level;
    }
    
    public int getGamer_ID() {
        return this.gamer_ID;
    }
    public String getGamer_Name() {
        return this.gamer_Name;
    }
    public int getGamer_Level() {
        return this.gamer_Level;
    }
    public void setGamer_ID(int gamer_ID) {
        this.gamer_ID = gamer_ID;
    }
    public void setGamer_Name(String gamer_Name) {
        this.gamer_Name = gamer_Name;
    }
    public void setGamer_Level(int gamer_Level) {
        this.gamer_Level = gamer_Level;
    }
    
    @Override
    public String toString() {
        return this.gamer_Name;
    }
}
