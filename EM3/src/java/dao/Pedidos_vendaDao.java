/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Pedidos_venda;
import repository.Pedidos_vendaRepository;

/**
 *
 * @author Marcos Vinícius
 */
public class Pedidos_vendaDao
{
    private Pedidos_vendaRepository db = null;
    
    public Pedidos_vendaDao(boolean... autoCommitOrClose)
    {
        db = new Pedidos_vendaRepository();
        if(autoCommitOrClose.length > 0)
            db.setAutoCommitOrClose(autoCommitOrClose[0]);
    }
    
    public void commit()
    {
        db.commit(true);
    }
    
    public void save(Pedidos_venda pv)
    {
        if(db.exists(Pedidos_venda.class, "id", pv.getId()))
            db.update(pv);
        else
            db.save(pv);
    }
    
    public void remove(Pedidos_venda pv)
    {
        db.delete(pv);
    }
    
    public Pedidos_venda find(int id)
    {
        return db.find(Pedidos_venda.class, id);
    }
    
    public List<Pedidos_venda> search(String searchTerm, String data_inicio, String data_fim)
    {
        return (searchTerm.isEmpty()
                ? db.listAll(data_inicio, data_fim)
                : db.search(searchTerm, data_inicio, data_fim));
    }
}
