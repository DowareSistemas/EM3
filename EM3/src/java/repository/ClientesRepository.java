/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import br.com.persistor.enums.FILTER_TYPE;
import br.com.persistor.enums.JOIN_TYPE;
import br.com.persistor.enums.MATCH_MODE;
import br.com.persistor.enums.RESULT_TYPE;
import br.com.persistor.generalClasses.Restrictions;
import br.com.persistor.interfaces.ICriteria;
import br.com.persistor.interfaces.Session;
import java.util.List;
import model.Bloqueios_Clientes;
import model.Clientes;
import model.Documentos;
import model.Enderecos;
import model.Movimentos;
import model.Parcelas;
import model.Pedidos_venda;
import sessionProvider.SessionProvider;

/**
 *
 * @author Marcos Vinícius
 */
public class ClientesRepository extends RepositoryImpl<Clientes>
{

    /**
     *
     * @param tipo 0 - APenas inativos; 1 - Apenas ativos; 2 - Todos
     * @return
     */
    public List<Clientes> listAll(int tipo, int loja_id)
    {
        Clientes cli = new Clientes();
        Documentos docs = new Documentos();
        Enderecos end = new Enderecos();
        
        Session session = SessionProvider.openSession();

        ICriteria c = session.createCriteria(cli, RESULT_TYPE.MULTIPLE);
        c.add(JOIN_TYPE.LEFT, docs, "clientes.documento_id = documentos.id");
        c.add(JOIN_TYPE.INNER, end, "clientes.endereco_id = enderecos.id");

        switch (tipo)
        {
            case 0: // apenas inativos
                c.add(Restrictions.eq(FILTER_TYPE.WHERE, "clientes.inativo", true));
                break;

            case 1: // apenas ativos
                c.add(Restrictions.eq(FILTER_TYPE.WHERE, "clientes.inativo", false));
                break;

            case 2: // todos
                c.add(Restrictions.in(FILTER_TYPE.WHERE, "clientes.inativo", new String[]
                {
                    "0", "1"
                }));
                break;
        }

        c.add(Restrictions.eq(FILTER_TYPE.AND, "clientes.empresa_id", loja_id));
        c.execute();
        c.loadList(end);
        c.loadList(cli);
        c.loadList(docs);

        session.close();

        List<Clientes> clientes = session.getList(cli);
        List<Documentos> documentos = session.getList(docs);
        List<Enderecos> enderecos = session.getList(end);

        for (int i = 0; i < clientes.size(); i++)
        {
            clientes.get(i).setDocumentos(documentos.get(i));
            clientes.get(i).setEnderecos(enderecos.get(i));
        }

        return clientes;
    }

    public List<Clientes> search(String searchTerm, int tipo, int loja_id)
    {
        Clientes cli = new Clientes();
        Documentos docs = new Documentos();
        Enderecos end = new Enderecos();
        
        Session session = SessionProvider.openSession();

        ICriteria c = session.createCriteria(cli, RESULT_TYPE.MULTIPLE);
        c.add(JOIN_TYPE.LEFT, docs, "clientes.documento_id = documentos.id");
        c.add(JOIN_TYPE.INNER, end, "clientes.endereco_id = enderecos.id");

        switch (tipo)
        {
            case 0: // apenas inativos
                c.add(Restrictions.eq(FILTER_TYPE.WHERE, "clientes.inativo", true));
                break;

            case 1: // apenas ativos
                c.add(Restrictions.eq(FILTER_TYPE.WHERE, "clientes.inativo", false));
                break;

            case 2: // todos
                c.add(Restrictions.in(FILTER_TYPE.WHERE, "clientes.inativo", new String[]
                {
                    "0", "1"
                }));
                break;
        }

        c.add(Restrictions.eq(FILTER_TYPE.AND, "clientes.empresa_id", loja_id));

        c.beginPrecedence();
        c.add(Restrictions.like(FILTER_TYPE.AND, "clientes.nome", searchTerm, MATCH_MODE.ANYWHERE));
        c.add(Restrictions.like(FILTER_TYPE.OR, "clientes.apelido", searchTerm, MATCH_MODE.ANYWHERE));
        c.add(Restrictions.like(FILTER_TYPE.OR, "clientes.telefone1", searchTerm, MATCH_MODE.ANYWHERE));
        c.add(Restrictions.like(FILTER_TYPE.OR, "clientes.telefone2", searchTerm, MATCH_MODE.ANYWHERE));
        c.add(Restrictions.like(FILTER_TYPE.OR, "clientes.celular", searchTerm, MATCH_MODE.ANYWHERE));
        c.add(Restrictions.like(FILTER_TYPE.OR, "clientes.email1", searchTerm, MATCH_MODE.ANYWHERE));
        c.add(Restrictions.like(FILTER_TYPE.OR, "clientes.email2", searchTerm, MATCH_MODE.ANYWHERE));
        c.add(Restrictions.eq(FILTER_TYPE.OR, "documentos.cpf", searchTerm));
        c.add(Restrictions.eq(FILTER_TYPE.OR, "documentos.cnpj", searchTerm));
        c.add(Restrictions.eq(FILTER_TYPE.OR, "documentos.rg", searchTerm));
        c.endPrecedence();

        c.execute();
        c.loadList(end);
        c.loadList(cli);
        c.loadList(docs);

        session.close();

        List<Clientes> clientes = session.getList(cli);
        List<Documentos> documentos = session.getList(docs);
        List<Enderecos> enderecos = session.getList(end);

        for (int i = 0; i < clientes.size(); i++)
        {
            clientes.get(i).setDocumentos(documentos.get(i));
            clientes.get(i).setEnderecos(enderecos.get(i));
        }

        return clientes;
    }

    private String message = "";

    public boolean podeExcluir(int id)
    {
        Session session = SessionProvider.openSession();
        int countBloqueios = session.count(Bloqueios_Clientes.class, "cliente_id = " + id);
        int countMovimentos = session.count(Movimentos.class, "cliente_id = " + id);
        int countParcelas = session.count(Parcelas.class, "cliente_id = " + id);
        int countPedidos = session.count(Pedidos_venda.class, "cliente_id = " + id);
        session.close();
        
        if(countBloqueios > 0)
        {
            message = "Não é possível excluir este cliente. Ele possui bloqueios no financeiro.";
            return false;
        }
        
        if(countMovimentos > 0)
        {
            message = "Não é possível excluir este cliente. Existem um ou mais movimentos relacionados a ele.";
            return false;
        }
        
        if(countParcelas > 0)
        {
            message = "Não é possível excluir este cliente. Existem uma ou mais parcelas relacionadas e ele.";
            return false;
        }
        
        if(countPedidos > 0)
        {
            message = "Não é possível excluir este cliente. Existem um ou mais pedidos de venda relacionados a ele.";
            return false;
        }
        
        return true;
    }

    public String getMessage()
    {
        return message;
    }
}
