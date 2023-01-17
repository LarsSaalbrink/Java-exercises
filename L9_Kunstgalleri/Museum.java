import java.util.*;
public class Museum
{
    private String navn;
    private String adresse;
    
    public Museum(String navn, String adresse){
       this.navn = navn;
       this.adresse = adresse;
    }

    String getNavn(){
        return navn;
    }
}
