/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;
import br.com.persistor.interfaces.Session;
/**
 *
 * @author Marcos Vinícius
 */
public interface IRepository<T>
{
    void setSession(Session session);
    
    Session getSession();
    
    void save(T entity);

    void update(T entity, String... whereConditions);

    void delete(T entity, String... whereConditions);
    
    T find(Class entityClass, int id);
    
    T first(Class entityClass, String... whereConditions);
    
    T last(Class entityClass, String... whereConditions);
    
    boolean exists(Class entityClass, String field, Object value);
    
    void commit(boolean close);
    
    void setAutoCommitOrClose(boolean autoCommitOrClose);
    
    int count(Class entityClass, String whereParams);
    
    void close();
}
