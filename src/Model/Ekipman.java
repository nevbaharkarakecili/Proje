package Model;
import java.util.ArrayList;


public class Ekipman {
    private String ekipmanAd;
    private ArrayList<String> kutupMesafesi=new ArrayList<>();
    private ArrayList<String> MP=new ArrayList<>();
    private ArrayList<String> miknatislama=new ArrayList<>();
    private ArrayList<String> uvSiddet=new ArrayList<>();
    private ArrayList<String> isikMesafe=new ArrayList<>();

    public Ekipman(String ekipmanAd) {
        this.ekipmanAd = ekipmanAd;
    }
    @Override
    public String toString(){
    return ekipmanAd;
    }

    public String getEkipmanAd() {
        return ekipmanAd;
    }

    public void setEkipmanAd(String ekipmanAd) {
        this.ekipmanAd = ekipmanAd;
    }

    public ArrayList<String> getKutupMesafesi() {
        return kutupMesafesi;
    }

    public void setKutupMesafesi(ArrayList<String> kutupMesafesi) {
        this.kutupMesafesi = kutupMesafesi;
    }

    public ArrayList<String> getMP() {
        return MP;
    }

    public void setMP(ArrayList<String> MP) {
        this.MP = MP;
    }

    public ArrayList<String> getMiknatislama() {
        return miknatislama;
    }

    public void setMiknatislama(ArrayList<String> miknatislama) {
        this.miknatislama = miknatislama;
    }

    public ArrayList<String> getUvSiddet() {
        return uvSiddet;
    }

    public void setUvSiddet(ArrayList<String> uvSiddet) {
        this.uvSiddet = uvSiddet;
    }

    public ArrayList<String> getIsikMesafe() {
        return isikMesafe;
    }

    public void setIsikMesafe(ArrayList<String> isikMesafe) {
        this.isikMesafe = isikMesafe;
    }

    
    
}
