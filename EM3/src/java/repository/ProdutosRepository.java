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
import br.com.persistor.generalClasses.Limit;
import br.com.persistor.generalClasses.Restrictions;
import br.com.persistor.interfaces.ICriteria;
import br.com.persistor.interfaces.Session;
import java.util.List;
import model.*;
import sessionProvider.SessionProvider;

/**
 *
 * @author Marcos Vinícius
 */
public class ProdutosRepository extends RepositoryImpl<Produtos>
{
    private String message = "";
    
    public String getMessage()
    {
        return message;
    }

    public List<Produtos> listAll(int tipo, int page)
    {
        Produtos prod = new Produtos();
        Fornecedores forn = new Fornecedores();
        Classes_imposto classes = new Classes_imposto();
        Grupos_produtos grupos = new Grupos_produtos();
        Marcas marcas = new Marcas();
        Unidades unidades = new Unidades();

        Session session = SessionProvider.openSession();
        ICriteria c = session.createCriteria(prod, RESULT_TYPE.MULTIPLE);
        c.add(JOIN_TYPE.LEFT, forn, "produtos.fornecedor_padrao = fornecedores.id");
        c.add(JOIN_TYPE.LEFT, classes, "produtos.classe_imposto_id = classes_imposto.id");
        c.add(JOIN_TYPE.LEFT, grupos, "produtos.grupo_produtos_id = grupos_produtos.id");
        c.add(JOIN_TYPE.LEFT, marcas, "produtos.marca_id = marcas.id");
        c.add(JOIN_TYPE.LEFT, unidades, "produtos.unidade1 = unidades.id");

        switch (tipo)
        {
            case 0: //apenas inativos
                c.add(Restrictions.eq(FILTER_TYPE.WHERE, "produtos.inativo", true));
                break;
            case 1: //apenas ativos
                c.add(Restrictions.eq(FILTER_TYPE.WHERE, "produtos.inativo", false));
                break;
            case 2: //todos
                c.add(Restrictions.in(FILTER_TYPE.WHERE, "produtos.inativo", new String[]
                {
                    "0", "1"
                }));
                break;
        }

        c.addLimit(Limit.paginate(page, 300, "produtos.id"));
        c.execute();
        c.loadList(prod);
        c.loadList(forn);
        c.loadList(classes);
        c.loadList(grupos);
        c.loadList(marcas);
        c.loadList(unidades);
        session.close();

        List<Produtos> l_produtos = session.getList(prod);
        List<Fornecedores> l_forn = session.getList(forn);
        List<Classes_imposto> l_classes = session.getList(classes);
        List<Grupos_produtos> l_grupos = session.getList(grupos);
        List<Marcas> l_marcas = session.getList(marcas);
        List<Unidades> l_unid = session.getList(unidades);

        for (int i = 0; i < l_produtos.size(); i++)
        {
            l_produtos.get(i).setFornecedores(l_forn.get(i));
            l_produtos.get(i).setClasses_imposto(l_classes.get(i));
            l_produtos.get(i).setGrupos_produtos(l_grupos.get(i));
            l_produtos.get(i).setMarcas(l_marcas.get(i));
            l_produtos.get(i).setUnidades(l_unid.get(i));
        }

        return l_produtos;
    }

    public List<Produtos> search(String searchTerm, int tipo, int page)
    {
        Produtos prod = new Produtos();
        Fornecedores forn = new Fornecedores();
        Classes_imposto classes = new Classes_imposto();
        Grupos_produtos grupos = new Grupos_produtos();
        Marcas marcas = new Marcas();
        Unidades unidades = new Unidades();

        Session session = SessionProvider.openSession();
        ICriteria c = session.createCriteria(prod, RESULT_TYPE.MULTIPLE);
        c.add(JOIN_TYPE.LEFT, forn, "produtos.fornecedor_padrao = fornecedores.id");
        c.add(JOIN_TYPE.LEFT, classes, "produtos.classe_imposto_id = classes_imposto.id");
        c.add(JOIN_TYPE.LEFT, grupos, "produtos.grupo_produtos_id = grupos_produtos.id");
        c.add(JOIN_TYPE.LEFT, marcas, "produtos.marca_id = marcas.id");
        c.add(JOIN_TYPE.LEFT, unidades, "produtos.unidade1 = unidades.id");

        switch (tipo)
        {
            case 0: //apenas inativos
                c.add(Restrictions.eq(FILTER_TYPE.WHERE, "produtos.inativo", true));
                break;
            case 1: //apenas ativos
                c.add(Restrictions.eq(FILTER_TYPE.WHERE, "produtos.inativo", false));
                break;
            case 2: //todos
                c.add(Restrictions.in(FILTER_TYPE.WHERE, "produtos.inativo", new String[]
                {
                    "0", "1"
                }));
                break;
        }

        c.beginPrecedence();
        c.add(Restrictions.like(FILTER_TYPE.AND, "produtos.ean", searchTerm, MATCH_MODE.ANYWHERE));
        c.add(Restrictions.like(FILTER_TYPE.OR, "produtos.referencia", searchTerm, MATCH_MODE.ANYWHERE));
        c.add(Restrictions.like(FILTER_TYPE.OR, "produtos.descricao", searchTerm, MATCH_MODE.ANYWHERE));
        c.add(Restrictions.like(FILTER_TYPE.OR, "marcas.nome", searchTerm, MATCH_MODE.ANYWHERE));
        c.add(Restrictions.like(FILTER_TYPE.OR, "grupos_produtos.descricao", searchTerm, MATCH_MODE.ANYWHERE));
        c.add(Restrictions.like(FILTER_TYPE.OR, "produtos.fabricante", searchTerm, MATCH_MODE.ANYWHERE));
        c.add(Restrictions.eq(FILTER_TYPE.OR, "produtos.cod_fabricante", searchTerm));
        c.endPrecedence();

        c.addLimit(Limit.paginate(page, 300, "produtos.id"));
        c.execute();

        c.loadList(prod);
        c.loadList(forn);
        c.loadList(classes);
        c.loadList(grupos);
        c.loadList(marcas);
        c.loadList(unidades);
        session.close();

        List<Produtos> l_produtos = session.getList(prod);
        List<Fornecedores> l_forn = session.getList(forn);
        List<Classes_imposto> l_classes = session.getList(classes);
        List<Grupos_produtos> l_grupos = session.getList(grupos);
        List<Marcas> l_marcas = session.getList(marcas);
        List<Unidades> l_unid = session.getList(unidades);

        for (int i = 0; i < l_produtos.size(); i++)
        {
            l_produtos.get(i).setFornecedores(l_forn.get(i));
            l_produtos.get(i).setClasses_imposto(l_classes.get(i));
            l_produtos.get(i).setGrupos_produtos(l_grupos.get(i));
            l_produtos.get(i).setMarcas(l_marcas.get(i));
            l_produtos.get(i).setUnidades(l_unid.get(i));
        }

        return l_produtos;
    }

    public boolean podeExcluir(int id)
    {
        Session session = SessionProvider.openSession();

        int countPrecos = session.count(Produtos_precos.class, "produto_id = " + id);
        int countEstoque = session.count(Estoque.class, "produto_id = " + id + " and local_padrao = 0");
        int countItensMovimento = session.count(Itens_movimento.class, "produto_id = " + id);

        session.close();
        
        if(countPrecos > 0)
        {
            message = "Não é possível excluir este produto. Ele está presente em uma ou mais tabelas de preço.";
            return false;
        }
        
        if(countEstoque > 0)
        {
            message = "Não é possível excluir este produto. Ele está presente em um ou mais locais de estoque.";
            return false;
        }
        
        if(countItensMovimento > 0)
        {
            message = "Não é possível excluir este produto. Ele está presente em um ou mais movimentos.";
            return false;
        }
        
        return true;
    }

}
