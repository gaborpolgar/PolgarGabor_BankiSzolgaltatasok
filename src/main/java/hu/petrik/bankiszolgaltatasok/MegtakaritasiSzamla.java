package hu.petrik.bankiszolgaltatasok;

public class MegtakaritasiSzamla extends Szamla {

    private double kamat;
    public static double alapKamat= 1.1;

    public MegtakaritasiSzamla(Tulajdonos tulajdonos) {
        super(tulajdonos);
        kamat = alapKamat;
    }

    public double getKamat() {
        return kamat;
    }

    public void setKamat(double kamat) {
        this.kamat = kamat;
    }

    public void kamatJovairas(){
        this.aktualisEgyenleg = (int) (this.aktualisEgyenleg*kamat);
    }

    @Override
    public boolean kivesz(int osszeg) {
        boolean sikeresKivétel = false;
        if (aktualisEgyenleg - osszeg >= 0) {
            sikeresKivétel = true;
            aktualisEgyenleg -= osszeg;
        }
        return sikeresKivétel;
    }
}
