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
public interface ClanDao {
    public ArrayList<Clan> getAllClan();
    public Clan getClanById(int id);
    public void insertClan(Clan cl);
    public void updateClan(Clan cl);
    public void deleteClan(int id);
}
