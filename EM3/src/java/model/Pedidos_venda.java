/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import br.com.persistor.abstractClasses.Entity;
import br.com.persistor.annotations.OneToOne;
import br.com.persistor.annotations.PrimaryKey;
import br.com.persistor.enums.INCREMENT;
import br.com.persistor.enums.JOIN_TYPE;
import br.com.persistor.enums.LOAD;
import java.math.BigDecimal;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Marcos Vinícius
 */
public class Pedidos_venda extends Entity
{

    private int id;
    private int status;

    @NotNull(message = "A data do pedido é obrigatória")
    @NotEmpty(message = "A data do pedido é obrigatória")
    private String data;

    private String hora;
    private int cliente_id;

    @Min(value = 1, message = "Informe a empresa")
    private int empresa_id;
    private int transportadora_id;

    @Min(value = 1, message = "Informe a condição de pagamento")
    private int forma_pagamento_id;
    private int tabela_preco_id;
    private int funcionario1;
    private int funcionario2;
    private int funcionario3;
    private BigDecimal frete;
    private int tipo_frete;
    private BigDecimal valor_outro;
    private String mensagem_nf;
    private String data_entrega;

    private Clientes clientes;
    private Formas_pagamento formas_pagamento;
    
    @OneToOne(source = "forma_pagamento_id", target = "id", join_type = JOIN_TYPE.INNER, load = LOAD.AUTO)
    public Formas_pagamento getFormas_pagamento()
    {
        return formas_pagamento;
    }

    public void setFormas_pagamento(Formas_pagamento formas_pagamento)
    {
        this.formas_pagamento = formas_pagamento;
    }

    public String getMensagem_nf()
    {
        return mensagem_nf;
    }

    public void setMensagem_nf(String mensagem_nf)
    {
        this.mensagem_nf = mensagem_nf;
    }

    @OneToOne(source = "cliente_id", target = "id", join_type = JOIN_TYPE.LEFT, load = LOAD.AUTO)
    public Clientes getClientes()
    {
        return clientes;
    }

    public void setClientes(Clientes clientes)
    {
        this.clientes = clientes;
    }

    @PrimaryKey(increment = INCREMENT.MANUAL)
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getStatus()
    {
        return status;
    }

    public void setStatus(int status)
    {
        this.status = status;
    }

    public String getData()
    {
        return data;
    }

    public void setData(String data)
    {
        this.data = data;
    }

    public String getHora()
    {
        return hora;
    }

    public void setHora(String hora)
    {
        this.hora = hora;
    }

    public int getCliente_id()
    {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id)
    {
        this.cliente_id = cliente_id;
    }

    public int getEmpresa_id()
    {
        return empresa_id;
    }

    public void setEmpresa_id(int empresa_id)
    {
        this.empresa_id = empresa_id;
    }

    public int getTransportadora_id()
    {
        return transportadora_id;
    }

    public void setTransportadora_id(int transportadora_id)
    {
        this.transportadora_id = transportadora_id;
    }

    public int getForma_pagamento_id()
    {
        return forma_pagamento_id;
    }

    public void setForma_pagamento_id(int forma_pagamento_id)
    {
        this.forma_pagamento_id = forma_pagamento_id;
    }

    public int getTabela_preco_id()
    {
        return tabela_preco_id;
    }

    public void setTabela_preco_id(int tabela_preco_id)
    {
        this.tabela_preco_id = tabela_preco_id;
    }

    public int getFuncionario1()
    {
        return funcionario1;
    }

    public void setFuncionario1(int funcionario1)
    {
        this.funcionario1 = funcionario1;
    }

    public int getFuncionario2()
    {
        return funcionario2;
    }

    public void setFuncionario2(int funcionario2)
    {
        this.funcionario2 = funcionario2;
    }

    public int getFuncionario3()
    {
        return funcionario3;
    }

    public void setFuncionario3(int funcionario3)
    {
        this.funcionario3 = funcionario3;
    }

    public BigDecimal getFrete()
    {
        return frete;
    }

    public void setFrete(BigDecimal frete)
    {
        this.frete = frete;
    }

    public int getTipo_frete()
    {
        return tipo_frete;
    }

    public void setTipo_frete(int tipo_frete)
    {
        this.tipo_frete = tipo_frete;
    }

    public BigDecimal getValor_outro()
    {
        return valor_outro;
    }

    public void setValor_outro(BigDecimal valor_outro)
    {
        this.valor_outro = valor_outro;
    }

    public String getData_entrega()
    {
        return data_entrega;
    }

    public void setData_entrega(String data_entrega)
    {
        this.data_entrega = data_entrega;
    }

}
