package hu.petrik.bankiszolgaltatasok;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private List<Szamla> szamlaLista =new ArrayList<>();

    public Szamla szamlaNyitas(Tulajdonos tulajdonos, int hitelkeret){
        Szamla szamla;
        if (hitelkeret < 0){
            throw new IllegalArgumentException();
        }
        else if (hitelkeret == 0){
            szamla = new MegtakaritasiSzamla(tulajdonos);
        } else{
            szamla = new HitelSzamla(tulajdonos, hitelkeret);
        }

        szamlaLista.add(szamla);
        return szamla;
    }

    public int getOsszEgyenleg( Tulajdonos tulajdonos){
        int osszEgyenleg = 0;
        for (Szamla szamla : szamlaLista) {
            if (szamla.getTulajdonos() == tulajdonos) {
                osszEgyenleg += szamla.aktualisEgyenleg;
            }
        }
        return osszEgyenleg;
    }
    public Szamla getLegnagyobbEgyenleguSzamla(Tulajdonos tulajdonos){

        Szamla legnagyobbEgyenleguSzamla =  szamlaLista.get(0);
        for (Szamla szamla : szamlaLista) {
            if (szamla.getTulajdonos() == tulajdonos){
                if (szamla.aktualisEgyenleg > legnagyobbEgyenleguSzamla.aktualisEgyenleg){
                    legnagyobbEgyenleguSzamla = szamla;
                }
            }
        }
        return legnagyobbEgyenleguSzamla;
    }

    public long getOsszHitelkeret(){
        long osszHitelkeret = 0;
        for (Szamla szamla : szamlaLista) {
            if (szamla instanceof HitelSzamla) {
                HitelSzamla hitelSzamla = (HitelSzamla) szamla;
                osszHitelkeret += hitelSzamla.getHitelKeret();
            }
        }
        return osszHitelkeret;
    }
}
