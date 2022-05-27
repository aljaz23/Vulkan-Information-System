/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gasilskodrustvo;

/**
 *
 * @author aljaz
 */
public class Status {
    private int id;
    private String naziv;

    public Status() {

    }

    public Status (int id, String naziv) {
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


