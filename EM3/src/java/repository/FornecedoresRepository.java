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
import controllers.Utility;
import interfaces.IFornecedor;
import java.util.List;
import model.Documentos;
import model.Enderecos;
import model.Fornecedores;
import sessionProvider.SessionProvider;

/**
 *
 * @author Marcos Vinícius
 */
public class FornecedoresRepository extends Repository<Fornecedores> implements IFornecedor
{

    public List<Fornecedores> getAll()
    {
        Documentos docs = new Documentos();
        Enderecos ends = new Enderecos();
        Fornecedores forn = new Fornecedores();

        Session session = SessionProvider.openSession();
        ICriteria c = session.createCriteria(forn, RESULT_TYPE.MULTIPLE);
        c.add(JOIN_TYPE.INNER, docs, "fornecedores.documento_id = documentos.id");
        c.add(JOIN_TYPE.INNER, ends, "fornecedores.endereco_id = enderecos.id");
        c.execute();
        c.loadList(forn);
        c.loadList(ends);
        c.loadList(docs);
        session.close();

        List<Fornecedores> fornecedores = session.getList(forn);
        List<Documentos> documentos = session.getList(docs);
        List<Enderecos> enderecos = session.getList(ends);

        for (int i = 0; i < fornecedores.size(); i++)
        {
            fornecedores.get(i).setEnderecos(enderecos.get(i));
            fornecedores.get(i).setDocumentos(documentos.get(i));
        }

        return session.getList(forn);
    }

    public List<Fornecedores> search(String searchTerm)
    {
        Documentos docs = new Documentos();
        Enderecos ends = new Enderecos();
        Fornecedores forn = new Fornecedores();

        Session session = SessionProvider.openSession();
        ICriteria c = session.createCriteria(forn, RESULT_TYPE.MULTIPLE);
        c.add(JOIN_TYPE.INNER, docs, "fornecedores.documento_id = documentos.id");
        c.add(JOIN_TYPE.INNER, ends, "fornecedores.endereco_id = enderecos.id");
        c.add(Restrictions.like(FILTER_TYPE.WHERE, "razao_social", searchTerm, MATCH_MODE.ANYWHERE));
        c.add(Restrictions.like(FILTER_TYPE.OR, "nome_fantasia", searchTerm, MATCH_MODE.ANYWHERE));
        c.add(Restrictions.like(FILTER_TYPE.OR, "telefone", searchTerm, MATCH_MODE.ANYWHERE));
        c.add(Restrictions.like(FILTER_TYPE.OR, "inscr_municipal", searchTerm, MATCH_MODE.ANYWHERE));
        c.add(Restrictions.like(FILTER_TYPE.OR, "inscr_estadual", searchTerm, MATCH_MODE.ANYWHERE));
        c.add(Restrictions.like(FILTER_TYPE.OR, "fax", searchTerm, MATCH_MODE.ANYWHERE));
        c.add(Restrictions.like(FILTER_TYPE.OR, "website", searchTerm, MATCH_MODE.ANYWHERE));
        c.add(Restrictions.like(FILTER_TYPE.OR, "documentos.im", searchTerm, MATCH_MODE.ANYWHERE));
        c.add(Restrictions.like(FILTER_TYPE.OR, "documentos.ie", searchTerm, MATCH_MODE.ANYWHERE));
        c.add(Restrictions.like(FILTER_TYPE.OR, "documentos.cpf", searchTerm, MATCH_MODE.ANYWHERE));
        c.add(Restrictions.like(FILTER_TYPE.OR, "enderecos.logradouro", searchTerm, MATCH_MODE.ANYWHERE));
        c.add(Restrictions.like(FILTER_TYPE.OR, "enderecos.bairro", searchTerm, MATCH_MODE.ANYWHERE));
        c.add(Restrictions.like(FILTER_TYPE.OR, "enderecos.municipio", searchTerm, MATCH_MODE.ANYWHERE));
        c.add(Restrictions.like(FILTER_TYPE.OR, "enderecos.uf", searchTerm, MATCH_MODE.ANYWHERE));
        if (Utility.tryParse(searchTerm) > 0)
            c.add(Restrictions.eq(FILTER_TYPE.OR, "fornecedores.id", Utility.tryParse(searchTerm)));
        c.execute();
        c.loadList(forn);
        c.loadList(ends);
        c.loadList(docs);
        session.close();

        List<Fornecedores> fornecedores = session.getList(forn);
        List<Documentos> documentos = session.getList(docs);
        List<Enderecos> enderecos = session.getList(ends);

        for (int i = 0; i < fornecedores.size(); i++)
        {
            fornecedores.get(i).setEnderecos(enderecos.get(i));
            fornecedores.get(i).setDocumentos(documentos.get(i));
        }

        return fornecedores;
    }
}
