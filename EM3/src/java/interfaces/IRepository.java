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

    /**
     * Salva uma entidade no banco passando como parametro a instancia da
     * entodade a ser salva
     *
     * @param entity entidade a ser adicionada ao contexto/banco
     */
    public void add(T entity);

    /**
     * Salva uma entidade no banco dentro de uma transacao passando como
     * paramatro a instancia da entidade a ser salva, e a Session em transação
     *
     * @param entity entidade a ser salva
     * @param session Session em transacao
     */
    public void add(T entity, Session session);

    /**
     * Faz o update da entidade passando como parametro a instancia da entidade
     * a ser atualizada
     *
     * @param entity entidade a ser atualizada
     */
    public void merge(T entity);

    /**
     * Atualiza uma entidade no banco dentro de uma transacao passando como
     * paramatro a instancia da entidade a ser atualizada, e a Session em
     * transação
     *
     * @param entity entidade a ser atualizada
     * @param session Session em transacao
     */
    public void merge(T entity, Session session);

    /**
     * Deleta uma entidade no banco dentro de uma transacao passando como
     * paramatro a instancia da entidade a ser deletada, e a Session em
     * transação
     *
     * @param entity entidade a ser removida
     */
    public void remove(T entity);

    /**
     * Deleta uma entidade no banco dentro de uma transacao passando como
     * paramatro a instancia da entidade a ser deletada, e a Session em
     * transação
     *
     * @param entity entidade a ser removida
     * @param session Session em transacao
     */
    public void remove(T entity, Session session);

    /**
     * Deleta uma entidade no banco dentro de uma transacao passando como
     * paramatro a instancia da entidade a ser deletada, e a Session em
     * transação
     *
     * @param entity entidade a ser removida
     * @param session Session em transacao
     * @param whereCondition condição (sem "where") para ser usada na operação
     */
    public void remove(T entity, String whereCondition);

    public void remove(T entity, Session session, String whereCondition);

    /**
     * Confirma as alterações nas entidades, fazendo commit no banco
     */
    public void commit(boolean close);

    /**
     * Fecha a Session utilizada, devolve a conexao para o pool e executa a
     * limpeza do cache
     */
    public void close();

    /**
     * Obtem uma instancia da entidade, pupulada com os dados do banco
     *
     * @param entityClass classe da entidade a carregar
     * @param id valor da chave primaria da entidade
     * @return
     */
    public T get(Class entityClass, int id);

    /**
     * Faz uma verificacao para saber se existe uma representacao da entidade no
     * banco
     *
     * @param entityClass classe da entidade a verificar
     * @param field campo a ser verificado
     * @param value valor esperado na verificacao
     * @return
     */
    public boolean exists(Class entityClass, String field, Object value);

    /**
     * Obtem a Session inicializada no repositorio
     *
     * @return
     */
    public Session getCurrentSession();
    
    public int count(Class entityClass, String whereConditions);
}
