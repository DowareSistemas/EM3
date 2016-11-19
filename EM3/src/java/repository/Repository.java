/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import br.com.persistor.enums.FILTER_TYPE;
import br.com.persistor.enums.RESULT_TYPE;
import br.com.persistor.generalClasses.Restrictions;
import br.com.persistor.interfaces.ICriteria;
import br.com.persistor.interfaces.Session;
import interfaces.IRepository;
import sessionProvider.SessionProvider;

/**
 *
 * @author Marcos Vinícius
 */
public abstract class Repository<T> implements IRepository<T>
{

    private Session mainSession = null;

    private void checkInitialization()
    {
        if (mainSession == null)
            mainSession = SessionProvider.openSession();
    }

    @Override
    public void add(T entity)
    {
        checkInitialization();
        mainSession.save(entity);
    }

    @Override
    public void add(T entity, Session session)
    {
        session.save(entity);
    }

    @Override
    public void merge(T entity)
    {
        checkInitialization();
        mainSession.update(entity);
    }

    @Override
    public void merge(T entity, Session session)
    {
        session.update(entity);
    }

    @Override
    public void remove(T entity)
    {
        checkInitialization();
        mainSession.delete(entity);
    }

    @Override
    public void remove(T entity, Session session)
    {
        session.delete(entity);
    }

    @Override
    public void commit(boolean close)
    {
        mainSession.commit();
        if(close)
            this.close();
    }

    @Override
    public void close()
    {
        mainSession.close();
        mainSession = null;
    }

    @Override
    public T get(Class entityClass, int id)
    {
        checkInitialization();
        return mainSession.onID(entityClass, id);
    }

    @Override
    public boolean exists(Class entityClass, String field, Object value)
    {
        try
        {
            checkInitialization();
            Object entity = entityClass.newInstance();
            ICriteria c = mainSession.createCriteria(entity, RESULT_TYPE.MULTIPLE)
                    .add(Restrictions.eq(FILTER_TYPE.WHERE, field, value))
                    .execute();
            return (!mainSession.getList(entity).isEmpty());
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Session getCurrentSession()
    {
        checkInitialization();
        return mainSession;
    }

}
