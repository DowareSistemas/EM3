/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.com.persistor.interfaces.Session;
import java.math.BigDecimal;
import java.util.List;
import model.Tabelas_precos;
import repository.Tabelas_precosRepository;

/**
 *
 * @author Marcos Vinícius
 */
public class Tabelas_precosDao
{

    private Tabelas_precosRepository db = null;

    public Tabelas_precosDao(boolean... autoCommitOrClose)
    {
        db = new Tabelas_precosRepository();
        if (autoCommitOrClose.length > 0)
            db.setAutoCommitOrClose(autoCommitOrClose[0]);
    }

    public Tabelas_precosDao(Session session)
    {
        db = new Tabelas_precosRepository();
        db.setSession(session);
    }

    public void commit()
    {
        db.commit(true);
    }
    
    public void save(Tabelas_precos tb)
    {
        if(db.exists(Tabelas_precos.class, "id", tb.getId()))
            db.update(tb);
        else
            db.save(tb);
    }
    
    public void delete(Tabelas_precos tb)
    {
        db.delete(tb);
    }
    
    public Tabelas_precos find(int id)
    {
        return db.find(Tabelas_precos.class, id);
    }
    
    public List<Tabelas_precos> search(String searchTerm, int tipo)
    {
        return (searchTerm.isEmpty()
                ? db.listAll(tipo)
                : db.search(searchTerm, tipo));
    }

    public Tabelas_precos last()
    {
        return db.last(Tabelas_precos.class);
    }

    public BigDecimal getPreco(int produto_id, String uf, double faixa, int unidade_id, int tabela_id)
    {
        return db.getPreco(produto_id, uf, faixa, unidade_id, tabela_id);
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
