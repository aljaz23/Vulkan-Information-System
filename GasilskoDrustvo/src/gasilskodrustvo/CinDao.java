/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gasilskodrustvo;

import java.util.ArrayList;

/**
 *
 * @author aljaz
 */
public interface CinDao {
    public ArrayList<Cin> getAllCin();
    public Cin getCinById(int id);
}
