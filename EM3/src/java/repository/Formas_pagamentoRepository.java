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
import enums.Tipos_pagamento;
import java.util.List;
import model.Clientes_formas_pagamento;
import model.Contas_bancarias;
import model.Formas_pagamento;
import model.Itens_pagamento;
import model.Operadoras_cartao;
import model.Parcelas;
import sessionProvider.SessionProvider;

/**
 *
 * @author Marcos Vinícius
 */
public class Formas_pagamentoRepository extends RepositoryImpl<Formas_pagamento>
{

    private String message = "";

    public String getMessage()
    {
        return message;
    }

    public boolean podeExcluir(int fpg_id)
    {
        Session session = SessionProvider.openSession();
        int count_itens_pg = session.count(Itens_pagamento.class, "forma_pagamento_id = " + fpg_id);
        int count_parcelas = session.count(Parcelas.class, "forma_pagamento_id = " + fpg_id);
        int count_clientes_fpg = session.count(Clientes_formas_pagamento.class, "forma_pagamento_id = " + fpg_id);
        session.close();

        if (count_itens_pg > 0)
        {
            message = "Não é possível excluir esta condição de pagamento. Existem um ou mais movimentos relacionados e ela";
            return false;
        }

        if (count_parcelas > 0)
        {
            message = "Não é possivel excluir esta condição de pagamento. Existem uma ou mais parcelas relacionadas a ela";
            return false;
        }

        if (count_clientes_fpg > 0)
        {
            message = "Não é possível excluir esta condição de pagamento. Existem um ou mais clientes relacionados a ela";
            return false;
        }

        return true;
    }

    public List<Formas_pagamento> listAll(int tipo)
    {
        Formas_pagamento fpg = new Formas_pagamento();
        Contas_bancarias conta = new Contas_bancarias();
        Operadoras_cartao opc = new Operadoras_cartao();

        Session session = SessionProvider.openSession();
        ICriteria c = session.createCriteria(fpg, RESULT_TYPE.MULTIPLE);
        c.add(JOIN_TYPE.LEFT, conta, "formas_pagamento.conta_bancaria_id = contas_bancarias.id");
        c.add(JOIN_TYPE.LEFT, opc, "formas_pagamento.operadora_cartao_id = operadoras_cartao.id");

        switch (tipo)
        {
            case 0: // somente inativos
                c.add(Restrictions.eq(FILTER_TYPE.WHERE, "formas_pagamento.inativo", true));
                break;

            case 1: // somente ativos
                c.add(Restrictions.eq(FILTER_TYPE.WHERE, "formas_pagamento.inativo", false));
                break;

            case 2: //todos
                c.add(Restrictions.in(FILTER_TYPE.WHERE, "formas_pagamento.inativo", new String[]
                {
                    "0", "1"
                }));
                break;
        }

        c.execute();
        c.loadList(fpg);
        c.loadList(conta);
        c.loadList(opc);
        session.close();

        List<Formas_pagamento> formas = session.getList(fpg);
        List<Contas_bancarias> contas = session.getList(conta);
        List<Operadoras_cartao> operadoras = session.getList(opc);

        for (int i = 0; i < formas.size(); i++)
        {
            formas.get(i).setContas_bancarias(contas.get(i));
            formas.get(i).setOperadoras_cartao(operadoras.get(i));
        }

        return formas;
    }

    public List<Formas_pagamento> search(String searchTerm, int tipo)
    {
        Formas_pagamento fpg = new Formas_pagamento();
        Contas_bancarias conta = new Contas_bancarias();
        Operadoras_cartao opc = new Operadoras_cartao();

        Session session = SessionProvider.openSession();
        ICriteria c = session.createCriteria(fpg, RESULT_TYPE.MULTIPLE);
        c.add(JOIN_TYPE.LEFT, conta, "formas_pagamento.conta_bancaria_id = contas_bancarias.id");
        c.add(JOIN_TYPE.LEFT, opc, "formas_pagamento.operadora_cartao_id = operadoras_cartao.id");
        c.add(Restrictions.like(FILTER_TYPE.WHERE, "formas_pagamento.descricao", searchTerm, MATCH_MODE.ANYWHERE));

        switch (tipo)
        {
            case 0: // somente inativos
                c.add(Restrictions.eq(FILTER_TYPE.AND, "formas_pagamento.inativo", true));
                break;

            case 1: // somente ativos
                c.add(Restrictions.eq(FILTER_TYPE.AND, "formas_pagamento.inativo", false));
                break;

            case 2: //todos
                c.add(Restrictions.in(FILTER_TYPE.AND, "formas_pagamento.inativo", new String[]
                {
                    "0", "1"
                }));
                break;
        }

        c.execute();
        c.loadList(fpg);
        c.loadList(conta);
        c.loadList(opc);
        session.close();

        List<Formas_pagamento> formas = session.getList(fpg);
        List<Contas_bancarias> contas = session.getList(conta);
        List<Operadoras_cartao> operadoras = session.getList(opc);

        for (int i = 0; i < formas.size(); i++)
        {
            formas.get(i).setContas_bancarias(contas.get(i));
            formas.get(i).setOperadoras_cartao(operadoras.get(i));
        }

        return formas;
    }

    public boolean valid(Formas_pagamento fpg)
    {
        if (fpg.getTipo_pagamento() == Tipos_pagamento.DINHEIRO)
        {
            if (fpg.getDia_base() > 0)
            {
                message = "Dia base não permitido para tipo pagamento Dinheiro";
                return false;
            }

            if (fpg.getParcelas() > 0)
            {
                message = "Número de parcelas não permitido para o tipo pagamento Dinheiro";
                return false;
            }

            if (fpg.getTolerancia_dias() > 0)
            {
                message = "Tolerância não permitida para o tipo pagamento Dinheiro";
                return false;
            }

            if (fpg.getConta_bancaria_id() > 0)
            {
                message = "Código da conta bancária não permitido para o tipo pagamento Cartão";
                return false;
            }

            if (fpg.getOperadora_cartao_id() > 0)
            {
                message = "Código da conta operadora de cartão não permitido para o tipo pagamento Cartão";
                return false;
            }
        }

        if (fpg.getTipo_pagamento() == Tipos_pagamento.CARTAO)
        {
            if (fpg.getConta_bancaria_id() > 0)
            {
                message = "Código da conta bancária não permitido para o tipo pagamento Cartão";
                return false;
            }
        }
        
        return true;
    }

}
