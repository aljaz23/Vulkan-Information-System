package gasilskodrustvo;

public class Clan {

    private int id;
    private String imePriimek;
    private int starost;
    private String ulica;
    private String datumRoj;
    private String telSt;
    private String prizOdlike;
    private String specialnost;
    private int Idcina;
    private int Idstatus;
    private String clanarina;

    public Clan() {

    }

    public Clan(String imePriimek, int starost, String ulica, String datumRoj, String telSt,String clanarina, String prizOdlike, String specialnost, int Idcina, int Idstatus) {
        this.imePriimek = imePriimek;
        this.starost = starost;
        this.ulica = ulica;
        this.datumRoj = datumRoj;
        this.telSt = telSt;
        this.clanarina = clanarina;
        this.prizOdlike = prizOdlike;
        this.specialnost = specialnost;
        this.Idcina = Idcina;
        this.Idstatus = Idstatus;
    }

    public Clan(int id, String imePriimek, int starost, String ulica, String datumRoj, String telSt,String clanarina, String prizOdlike, String specialnost, int Idcina, int Idstatus) {
        this(imePriimek, starost, ulica, datumRoj, telSt, clanarina,prizOdlike, specialnost, Idcina, Idstatus);
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdStatus() {
        return this.Idstatus;
    }

    public void setIdStatus(int idStatus) {
        this.Idstatus = idStatus;
    }

    public int getIdCina() {
        return this.Idcina;
    }

    public void setIdCina(int idCina) {
        this.Idcina = idCina;
    }

    public String getClanarina() {
        return this.clanarina;
    }

    public void setClanarina(String clanarina) {
        this.clanarina = clanarina;
    }

    public String getImePriimek() {
        return this.imePriimek;
    }

    public int getStarost() {
        return this.starost;
    }

    public String getUlica() {
        return this.ulica;
    }

    public String getDatumRoj() {
        return this.datumRoj;
    }

    public String getTelSt() {
        return this.telSt;
    }

    public String getPrizOdlike() {
        return this.prizOdlike;
    }

    public String getSpecialnost() {
        return this.specialnost;
    }

    public void setImePriimek(String imePriimek) {
        this.imePriimek = imePriimek;
    }

    public void setStarost(int starost) {
        this.starost = starost;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public void setDatumRoj(String datum) {
        this.datumRoj = datum;
    }

    public void setTelSt(String tel) {
        this.telSt = tel;
    }

    public void setPrizOdlike(String odlike) {
        this.prizOdlike = odlike;
    }

    public void setSpecialnost(String spec) {
        this.specialnost = spec;
    }

}
