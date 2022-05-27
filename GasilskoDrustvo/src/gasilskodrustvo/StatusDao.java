/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gasilskodrustvo;

import java.util.ArrayList;

public interface StatusDao {
    public ArrayList<Status> getAllStatus();
    public Status getStatusById(int id);
}
