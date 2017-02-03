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
import java.util.List;
import model.Clientes;
import model.Formas_pagamento;
import model.Pedidos_venda;
import sessionProvider.SessionProvider;

/**
 *
 * @author Marcos Vinícius
 */
public class Pedidos_vendaRepository extends RepositoryImpl<Pedidos_venda>
{

    public List<Pedidos_venda> listAll(String data_inicio, String data_fim)
    {
        Clientes clientes = new Clientes();
        Pedidos_venda pedidos = new Pedidos_venda();
        Formas_pagamento fpg = new Formas_pagamento();

        Session session = SessionProvider.openSession();
        ICriteria c = session.createCriteria(pedidos, RESULT_TYPE.MULTIPLE)
                .add(JOIN_TYPE.LEFT, clientes, "pedidos_venda.cliente_id = clientes.id")
                .add(JOIN_TYPE.INNER, fpg, "pedidos_venda.forma_pagamento_id = formas_pagamento.id")
                .add(Restrictions.between(FILTER_TYPE.WHERE, "pedidos_venda.data", data_inicio, data_fim));

        c.execute();
        c.loadList(clientes);
        c.loadList(pedidos);
        c.loadList(fpg);
        session.close();

        List<Pedidos_venda> l_pedidos = session.getList(pedidos);
        List<Clientes> l_clientes = session.getList(clientes);
        List<Formas_pagamento> l_fpg = session.getList(fpg);

        for (int i = 0; i < l_pedidos.size(); i++)
        {
            l_pedidos.get(i).setClientes(l_clientes.get(i));
            l_pedidos.get(i).setFormas_pagamento(l_fpg.get(i));
        }

        return l_pedidos;
    }

    public List<Pedidos_venda> search(String searchTerm, String data_inicio, String data_fim)
    {
        Clientes clientes = new Clientes();
        Pedidos_venda pedidos = new Pedidos_venda();
        Formas_pagamento fpg = new Formas_pagamento();

        Session session = SessionProvider.openSession();
        ICriteria c = session.createCriteria(pedidos, RESULT_TYPE.MULTIPLE)
                .add(JOIN_TYPE.LEFT, clientes, "pedidos_venda.cliente_id = clientes.id")
                .add(JOIN_TYPE.INNER, fpg, "pedidos_venda.forma_pagamento_id = formas_pagamento.id")
                .add(Restrictions.like(FILTER_TYPE.WHERE, "clientes.nome", searchTerm, MATCH_MODE.ANYWHERE));

        if (Utility.tryParse(searchTerm) > 0)
            c.add(Restrictions.eq(FILTER_TYPE.OR, "pedidos_venda.id", Utility.tryParse(searchTerm)));

        c.add(Restrictions.between(FILTER_TYPE.AND, "pedidos_venda.data", data_inicio, data_fim));

        c.execute();
        c.loadList(clientes);
        c.loadList(pedidos);
        c.loadList(fpg);
        session.close();

        List<Pedidos_venda> l_pedidos = session.getList(pedidos);
        List<Clientes> l_clientes = session.getList(clientes);
        List<Formas_pagamento> l_fpg = session.getList(fpg);

        for (int i = 0; i < l_pedidos.size(); i++)
        {
            l_pedidos.get(i).setClientes(l_clientes.get(i));
            l_pedidos.get(i).setFormas_pagamento(l_fpg.get(i));
        }

        return l_pedidos;
    }
}
