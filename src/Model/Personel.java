package Model;
public class Personel {
    private String personelAd,level;

    public Personel(String personelAd, String level) {
        this.personelAd = personelAd;
        this.level = level;
    }

    public String getPersonelAd() {
        return personelAd;
    }

    public void setPersonelAd(String personelAd) {
        this.personelAd = personelAd;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
    
}
