/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.com.persistor.interfaces.Session;
import java.util.List;
import model.Produtos_precos;
import repository.Produtos_precoRepository;

/**
 *
 * @author Marcos Vinícius
 */
public class Produtos_precosDao
{
    private Produtos_precoRepository db = null;
    
    public Produtos_precosDao(boolean... autoCommitOrClose)
    {
        db = new Produtos_precoRepository();
        if(autoCommitOrClose.length > 0)
            db.setAutoCommitOrClose(autoCommitOrClose[0]);
    }
    
    public void commit()
    {
        db.commit(true);
    }
    
    public Session getSession()
    {
        return db.getSession();
    }
    
    public void save(Produtos_precos pp)
    {
        if(db.exists(Produtos_precos.class, "id", pp.getId()))
            db.update(pp);
        else
            db.save(pp);
    }
    
    public boolean podeExcluir(int id)
    {
        int countTabelasFilhas = getSession().count(Produtos_precos.class, "preco_base = " + id);
        return countTabelasFilhas == 0;
    }
    
    public List<Produtos_precos> listByProduto_tabela(int produto_id, int tabela_id)
    {
        return db.list(produto_id, tabela_id);
    }
    
    public List<Produtos_precos> listByProduto(int produto_id, int tabela_ignorar)
    {
        return db.listByProduto(produto_id, tabela_ignorar);
    }
    
    public void delete(Produtos_precos pp)
    {
        db.delete(pp);
    }
    
    public Produtos_precos find(int id)
    {
        return db.find(Produtos_precos.class, id);
    }

    public List<Produtos_precos> listByTabela(int tabela_id)
    {
         return db.listByTabela(tabela_id);
    }
}
