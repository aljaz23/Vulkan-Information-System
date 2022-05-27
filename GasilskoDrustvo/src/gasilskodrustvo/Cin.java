package gasilskodrustvo;

public class Cin {

    private int id;
    private String naziv;

    public Cin() {

    }

    public Cin(int id, String naziv) {
        this.id = id;
        this.naziv = naziv;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getId() {
        return this.id;
    }

    public String getNaziv() {
        return this.naziv;
    }
}
