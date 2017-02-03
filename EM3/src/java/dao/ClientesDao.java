/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Clientes;
import repository.ClientesRepository;

/**
 *
 * @author Marcos Vinícius
 */
public class ClientesDao
{
    private ClientesRepository db = null;
    
    public ClientesDao(boolean... autoCommitOrClose)
    {
        db = new ClientesRepository();
        if(autoCommitOrClose.length > 0)
            db.setAutoCommitOrClose(autoCommitOrClose[0]);
    }
    
    public void save(Clientes cliente)
    {
        if(db.exists(Clientes.class, "id", cliente.getId()))
            db.update(cliente);
        else
            db.save(cliente);
    }
    
    public void delete(Clientes cliente)
    {
        db.delete(cliente);
    }
    
    public void commit()
    {
        db.commit(true);
    }
    
    public Clientes find(int id)
    {
        return db.find(Clientes.class, id);
    }
    
    public List<Clientes> search(String searchTerm, int tipo, int loja_id)
    {
        return (searchTerm.isEmpty()
                ? db.listAll(tipo, loja_id)
                : db.search(searchTerm, tipo, loja_id));
    }
    
    public String getMessage()
    {
        return db.getMessage();
    }
    
    public boolean podeExcluir(int id)
    {
        return db.podeExcluir(id);
    }
}
