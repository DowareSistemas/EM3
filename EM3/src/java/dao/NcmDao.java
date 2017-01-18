/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Ncm;
import repository.NcmRepisitory;

/**
 *
 * @author Marcos Vinícius
 */
public class NcmDao
{
    private NcmRepisitory db = null;
    
    public NcmDao()
    {
        db = new NcmRepisitory();
    }
    
    public int count()
    {
        int count = db.count(Ncm.class, "");
        db.commit(true);
        return count;
    }
    
    public List<Ncm> search(String searchTerm, int page)
    {
        return (searchTerm.isEmpty()
                ? db.listAll(page)
                : db.search(searchTerm, page));
    }
}
