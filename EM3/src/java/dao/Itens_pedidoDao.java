/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Itens_pedido;
import repository.Itens_pedidoRepository;

/**
 *
 * @author Marcos Vinícius
 */
public class Itens_pedidoDao
{

    private Itens_pedidoRepository db = null;

    public Itens_pedidoDao(boolean... autoCommitOrClose)
    {
        db = new Itens_pedidoRepository();
        if (autoCommitOrClose.length > 0)
            db.setAutoCommitOrClose(autoCommitOrClose[0]);
    }

    public void commit()
    {
        db.commit(true);
    }
    
    public void save(Itens_pedido ip)
    {
        if(db.exists(Itens_pedido.class, "id", ip.getId()))
            db.update(ip);
        else
            db.save(ip);
    }
    
    public Itens_pedido find(int id)
    {
        return db.find(Itens_pedido.class, id);
    }
    
    public void delete(Itens_pedido ip)
    {
        db.delete(ip);
    }
    
    public List<Itens_pedido> listByPedido(int pedido_id)
    {
      return db.listByPedido(pedido_id);
    }
}
