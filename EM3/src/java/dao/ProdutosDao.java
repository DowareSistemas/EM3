/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.com.persistor.interfaces.Session;
import java.util.List;
import model.Produtos;
import repository.ProdutosRepository;

/**
 *
 * @author Marcos Vinícius
 */
public class ProdutosDao
{

    private ProdutosRepository db = null;
    
    public ProdutosDao(boolean... autoCommitOrClose)
    {
        db = new ProdutosRepository();
        
        if (autoCommitOrClose.length > 0)
            db.setAutoCommitOrClose(autoCommitOrClose[0]);
    }
    
    public ProdutosDao(Session session)
    {
        db = new ProdutosRepository();
        db.setSession(session);
    }
    
    public Session getSession()
    {
        return db.getSession();
    }
    
    public void save(Produtos produto)
    {
        if (db.exists(Produtos.class, "id", produto.getId()))
        {
            produto.setUltima_alteracao(br.com.persistor.generalClasses.Util.getDateTime());
            db.update(produto);
        }
        else
        {
            produto.setUltima_alteracao(br.com.persistor.generalClasses.Util.getDateTime());
            produto.setData_cadastro(br.com.persistor.generalClasses.Util.getDateTime());
            db.save(produto);
        }
    }
    
    public void delete(Produtos produto)
    {
        db.delete(produto);
    }
    
    public Produtos find(int id)
    {
        return db.find(Produtos.class, id);
    }
    
    public int count()
    {
        return db.count(Produtos.class, "");
    }
    
    public void commit()
    {
        db.commit(true);
    }
    
    public List<Produtos> search(String searchTerm, int tipo, int page)
    {
        return (searchTerm.isEmpty()
                ? db.listAll(tipo, page)
                : db.search(searchTerm, tipo, page));
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
