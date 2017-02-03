/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import br.com.persistor.enums.FILTER_TYPE;
import br.com.persistor.enums.JOIN_TYPE;
import br.com.persistor.enums.RESULT_TYPE;
import br.com.persistor.generalClasses.Restrictions;
import br.com.persistor.interfaces.ICriteria;
import br.com.persistor.interfaces.Session;
import java.util.List;
import model.Itens_pedido;
import model.Locais_estoque;
import model.Produtos;
import model.Unidades;
import sessionProvider.SessionProvider;

/**
 *
 * @author Marcos Vinícius
 */
public class Itens_pedidoRepository extends RepositoryImpl<Itens_pedido>
{
    public List<Itens_pedido> listByPedido(int pedido_id)
    {
          Itens_pedido itens = new Itens_pedido();
          Produtos prods = new Produtos();
          Unidades unds = new Unidades();
          Locais_estoque le = new Locais_estoque();
          
          Session session = SessionProvider.openSession();
          ICriteria c = session.createCriteria(itens, RESULT_TYPE.MULTIPLE);
          c.add(JOIN_TYPE.INNER, prods, "itens_pedido.produto_id = produtos.id");
          c.add(JOIN_TYPE.INNER, unds, "itens_pedido.unidade_id = unidades.id");
          c.add(JOIN_TYPE.INNER, le, "itens_pedido.local_estoque_id = locais_estoque.id");
          c.add(Restrictions.eq(FILTER_TYPE.WHERE, "itens_pedido.pedido_id", pedido_id));
          c.execute();
          c.loadList(itens);
          c.loadList(prods);
          c.loadList(le);
          c.loadList(unds);
          session.close();
          
          List<Itens_pedido> l_itens = session.getList(itens);
          List<Produtos> l_prods = session.getList(prods);
          List<Unidades> l_uns = session.getList(unds);
          List<Locais_estoque> l_les = session.getList(le);
          
          for(int i = 0; i < l_itens.size(); i++)
          {
              l_itens.get(i).setProdutos(l_prods.get(i));
              l_itens.get(i).setUnidades(l_uns.get(i));
              l_itens.get(i).setLocais_estoque(l_les.get(i));
          }
          
          return l_itens;
    }
}
