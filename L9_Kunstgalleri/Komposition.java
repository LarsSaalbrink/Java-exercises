import java.util.*;
public class Komposition extends Kunstvaerk
{
    private String genre;
    private int spilletid;
    
    public Komposition(String titel, int aar, String genre, int spilletid){
        super();  //Kald superklassens constructor for at oprette array "ophavsmænd"
        this.titel = titel;
        this.aar = aar;
        this.genre = genre;
        this.spilletid = spilletid;
    }
}
