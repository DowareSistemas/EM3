/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import br.com.persistor.interfaces.Session;
import interfaces.IRepository;
import sessionProvider.SessionProvider;

/**
 *
 * @author Marcos Vinícius
 * @param <T>
 */
public abstract class RepositoryImpl<T> implements IRepository<T>
{

    private Session session = null;
    private boolean autoCommitOrClose = false;

    private void checkInitialization()
    {
        try
        {
            if (this.session == null)
                this.session = SessionProvider.openSession();
            if (this.session.getActiveConnection().isClosed())
                this.session = SessionProvider.openSession();
        }
        catch (Exception ex)
        {

        }
    }

    @Override
    public void setSession(Session session)
    {
        this.session = session;
    }

    @Override
    public Session getSession()
    {
        checkInitialization();
        return this.session;
    }

    @Override
    public void save(T entity)
    {
        checkInitialization();
        this.session.save(entity);

        if (autoCommitOrClose)
            commit(autoCommitOrClose);
    }

    @Override
    public void update(T entity, String... whereConditions)
    {
        checkInitialization();

        if (whereConditions.length > 0)
            this.session.update(entity, whereConditions[0]);
        else
            this.session.update(entity);

        if (autoCommitOrClose)
            commit(autoCommitOrClose);
    }

    @Override
    public void delete(T entity, String... whereConditions)
    {
        checkInitialization();

        if (whereConditions.length > 0)
            this.session.delete(entity, whereConditions[0]);
        else
            this.session.delete(entity);

        if (autoCommitOrClose)
            commit(autoCommitOrClose);
    }

    @Override
    public T find(Class entityClass, int id)
    {
        checkInitialization();
        T entity = this.session.onID(entityClass, id);

        if (autoCommitOrClose)
            close();

        return entity;
    }

    @Override
    public T first(Class entityClass, String... whereConditions)
    {
        checkInitialization();
        T entity = null;

        if (whereConditions.length > 0)
            entity = this.session.first(entityClass, whereConditions[0]);
        else
            entity = this.session.first(entityClass, "");

        if (autoCommitOrClose)
            close();

        return entity;
    }

    @Override
    public T last(Class entityClass, String... whereConditions)
    {
        checkInitialization();
        T entity = null;

        if (whereConditions.length > 0)
            entity = this.session.last(entityClass, whereConditions[0]);
        else
            entity = this.session.last(entityClass, "");

        if (autoCommitOrClose)
            close();

        return entity;
    }

    @Override
    public boolean exists(Class entityClass, String field, Object value)
    {
        checkInitialization();
        int result = this.session.count(entityClass, field + " = " + value);
        return (result > 0);
    }

    @Override
    public void commit(boolean close)
    {
        this.session.commit();
        if (close)
            close();
    }

    @Override
    public void setAutoCommitOrClose(boolean autoCommitOrClose)
    {
        this.autoCommitOrClose = autoCommitOrClose;
    }

    @Override
    public void close()
    {
        this.session.close();
        this.session = null;
    }
}
