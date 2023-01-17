import java.util.*;
public class Bog extends Kunstvaerk
{
    private String genre;
    private int antalSider;
    
    public Bog(String titel, int aar, String genre, int antalSider){
       this.titel = titel;
       this.aar = aar;
       this.genre = genre;
       this.antalSider = antalSider;
    }

    int getAntalSider(){
        return antalSider;
    }
}
