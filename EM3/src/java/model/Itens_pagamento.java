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

/**
 *
 * @author Marcos Vinícius
 */
public class Itens_pagamento extends Entity
{

    private int id;
    private BigDecimal desconto_perc;
    private BigDecimal desconto_valor;
    private BigDecimal acrescimo_perc;
    private BigDecimal acrescimo_valor;
    private BigDecimal valor_item;
    private BigDecimal total_item;
    private int forma_pagamento_id;
    private int movimento_id;

    private Formas_pagamento formaPagamento;
    private Movimentos movimento;

    @OneToOne(source = "forma_pagamento_id", target = "id", join_type = JOIN_TYPE.INNER, load = LOAD.AUTO)
    public Formas_pagamento getFormaPagamento()
    {
        return formaPagamento;
    }

    public void setFormaPagamento(Formas_pagamento formaPagamento)
    {
        this.formaPagamento = formaPagamento;
    }

    @OneToOne(source = "movimento_id", target = "id", join_type = JOIN_TYPE.INNER, load = LOAD.AUTO)
    public Movimentos getMovimento()
    {
        return movimento;
    }

    public void setMovimento(Movimentos movimento)
    {
        this.movimento = movimento;
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

    public BigDecimal getDesconto_perc()
    {
        return desconto_perc;
    }

    public void setDesconto_perc(BigDecimal desconto_perc)
    {
        this.desconto_perc = desconto_perc;
    }

    public BigDecimal getDesconto_valor()
    {
        return desconto_valor;
    }

    public void setDesconto_valor(BigDecimal desconto_valor)
    {
        this.desconto_valor = desconto_valor;
    }

    public BigDecimal getAcrescimo_perc()
    {
        return acrescimo_perc;
    }

    public void setAcrescimo_perc(BigDecimal acrescimo_perc)
    {
        this.acrescimo_perc = acrescimo_perc;
    }

    public BigDecimal getAcrescimo_valor()
    {
        return acrescimo_valor;
    }

    public void setAcrescimo_valor(BigDecimal acrescimo_valor)
    {
        this.acrescimo_valor = acrescimo_valor;
    }

    public BigDecimal getValor_item()
    {
        return valor_item;
    }

    public void setValor_item(BigDecimal valor_item)
    {
        this.valor_item = valor_item;
    }

    public BigDecimal getTotal_item()
    {
        return total_item;
    }

    public void setTotal_item(BigDecimal total_item)
    {
        this.total_item = total_item;
    }

    public int getForma_pagamento_id()
    {
        return forma_pagamento_id;
    }

    public void setForma_pagamento_id(int forma_pagamento_id)
    {
        this.forma_pagamento_id = forma_pagamento_id;
    }

    public int getMovimento_id()
    {
        return movimento_id;
    }

    public void setMovimento_id(int movimento_id)
    {
        this.movimento_id = movimento_id;
    }

}
