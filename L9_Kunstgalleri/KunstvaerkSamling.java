import java.util.*;
public class KunstvaerkSamling 
{
    private ArrayList<Kunstvaerk> Kunstvaerker;
    
    public KunstvaerkSamling(){
        Kunstvaerker = new ArrayList<Kunstvaerk>();
    }

    void findSangeMedFlereKomponister(){
        for(Kunstvaerk i: Kunstvaerker){
            if(i.getClass() == Komposition.class){
                if(i.ophavsmænd[1] != null){
                    System.out.println(i.getTitel());
                }
            }
        }
    }

    void findMalerierPaaMuseum(String navn){
        for(Kunstvaerk i: Kunstvaerker){
            if(i.getClass() == Maleri.class){
                Maleri j = (Maleri)i;
                if(j.getMuseum() == navn){
                    System.out.println(i.getTitel());
                }
            }
        }
    }

    void beregnAntalLaesteSider(){
        int siderTotal = 0;

        for(Kunstvaerk i: Kunstvaerker){
            if(i.getClass() == Bog.class){
                Bog j = (Bog)i;
                siderTotal += j.getAntalSider();
            }
        }
        System.out.println(siderTotal);
    }

    void add(Kunstvaerk kunststykke){
        Kunstvaerker.add(kunststykke);
    }

}
