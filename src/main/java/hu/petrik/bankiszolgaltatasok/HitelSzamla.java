package hu.petrik.bankiszolgaltatasok;

public class HitelSzamla extends Szamla {

    private int hitelKeret;

    public HitelSzamla(Tulajdonos tulajdonos, int hitelkeret) {
        super(tulajdonos);
        this.hitelKeret = hitelkeret;
    }
    public int getHitelKeret() {
        return hitelKeret;
    }



    @Override
    public boolean kivesz(int osszeg) {
        boolean sikeresKivétel = false;
        if (aktualisEgyenleg - osszeg >= (0-hitelKeret)) {
            sikeresKivétel = true;
            aktualisEgyenleg -= osszeg;
        }
        return sikeresKivétel;
    }
}
