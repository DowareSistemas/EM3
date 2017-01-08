/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.com.persistor.interfaces.Session;
import java.util.List;
import model.Formas_pagamento;
import repository.Formas_pagamentoRepository;

/**
 *
 * @author Marcos Vinícius
 */
public class Formas_pagamentoDao
{
    private Formas_pagamentoRepository db = null;
    
    public Formas_pagamentoDao(boolean... autoCommitOrClose)
    {
        db = new Formas_pagamentoRepository();
       
        if(autoCommitOrClose.length > 0)
            db.setAutoCommitOrClose(autoCommitOrClose[0]);
    }
    
    public Formas_pagamentoDao(Session session)
    {
        db = new Formas_pagamentoRepository();
        db.setSession(session);
    }
    
    public Session getSession()
    {
        return db.getSession();
    }
    
    public Formas_pagamento find(int id)
    {
        return db.find(Formas_pagamento.class, id);
    }
    
    public void save(Formas_pagamento fpg)
    {
        if(db.exists(Formas_pagamento.class, "id", fpg.getId()))
            db.update(fpg);
        else
            db.save(fpg);
    }
    
    public void commit()
    {
        db.commit(true);
    }
    
    public void delete(Formas_pagamento fpg)
    {
        db.delete(fpg);
    }
    
    public List<Formas_pagamento> search(String searchTerm, int tipo)
    {
        return (searchTerm.isEmpty()
                ? db.listAll(tipo)
                : db.search(searchTerm, tipo));
    }
    
    public boolean podeExcluir(int fpg_id)
    {
        return db.podeExcluir(fpg_id);
    }
    
    public String getMessage()
    {
        return db.getMessage();
    }

    public boolean valid(Formas_pagamento fpg)
    {
        return db.valid(fpg);
    }
}
