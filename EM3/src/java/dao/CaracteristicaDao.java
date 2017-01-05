/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Caracteristicas;
import repository.CaracteristicasRepository;

/**
 *
 * @author Marcos Vinícius
 */
public class CaracteristicaDao
{
    private CaracteristicasRepository db = null;

    public CaracteristicaDao(boolean... autoCommitOrClose)
    {
        db = new CaracteristicasRepository();

        if (autoCommitOrClose != null)
            if (autoCommitOrClose.length > 0)
                db.setAutoCommitOrClose(autoCommitOrClose[0]);
    }

    public Caracteristicas find(int id)
    {
        return db.find(Caracteristicas.class, id);
    }

    public void save(Caracteristicas c)
    {
        if (db.exists(Caracteristicas.class, "id", c.getId()))
            db.update(c);
        else
            db.save(c);
    }
    
    public List<Caracteristicas> search(String searchTerm)
    {
        List<Caracteristicas> result;

        result = (searchTerm.isEmpty()
                ? db.getAll()
                : db.search(searchTerm));

        return result;
    }
    
    public boolean podeExcluir(int id)
    {
        return db.podeExcluir(id);
    }
    
    public String getMessage()
    {
        return db.getMessage();
    }

    public void commit()
    {
        db.commit(true);
    }

    public void delete(Caracteristicas c)
    {
        db.delete(c);
    }
}
