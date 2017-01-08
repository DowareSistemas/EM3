/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.com.persistor.interfaces.Session;
import java.util.List;
import model.Operacoes_classe_imposto;
import repository.Operacoes_ClasseImpostoRepository;

/**
 *
 * @author Marcos Vinícius
 */
public class Operacoes_ClasseImpostoDao
{

    private Operacoes_ClasseImpostoRepository db = null;

    public Operacoes_ClasseImpostoDao(boolean... autoCommitOrClose)
    {
        db = new Operacoes_ClasseImpostoRepository();

        if (autoCommitOrClose.length > 0)
            db.setAutoCommitOrClose(autoCommitOrClose[0]);
    }

    public Operacoes_ClasseImpostoDao(Session session)
    {
        db = new Operacoes_ClasseImpostoRepository();
        db.setSession(session);
    }

    public Session getSession()
    {
        return db.getSession();
    }

    public boolean exists(int id)
    {
        return db.exists(Operacoes_classe_imposto.class, "id", id);
    }

    public void save(Operacoes_classe_imposto operacao)
    {
        if (db.exists(Operacoes_classe_imposto.class, "id", operacao.getId()))
            db.update(operacao);
        else
            db.save(operacao);
    }

    public int countByUf(String uf, int classe_imposto_id, int tipo_movimento_id)
    {
        return db.count(Operacoes_classe_imposto.class, "uf = '" + uf + "' AND classe_imposto_id = " + classe_imposto_id + " AND tipos_movimento_id = " + tipo_movimento_id);
    }

    public Operacoes_classe_imposto find(int id)
    {
        return db.find(Operacoes_classe_imposto.class, id);
    }

    public void delete(Operacoes_classe_imposto operacao)
    {
        db.delete(operacao);
    }

    public void commit()
    {
        db.commit(true);
    }

    public List<Operacoes_classe_imposto> listAll(int classe_imposto_id)
    {
        return db.listAll(classe_imposto_id);
    }
}
