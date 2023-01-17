import java.util.*;
public class Maleri extends Kunstvaerk
{
    private int laengde;
    private int bredde;
    private Museum udstilletHos;
    
    public Maleri(String titel, int aar, int laengde, int bredde, Museum udstilletHos){
        this.titel = titel;
        this.aar = aar;
        this.laengde = laengde;
        this.bredde = bredde;
        this.udstilletHos = udstilletHos;
    }

    String getMuseum(){
        return udstilletHos.getNavn();
    }
}
