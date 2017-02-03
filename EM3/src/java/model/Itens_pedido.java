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

/**
 *
 * @author Marcos Vinícius
 */
public class Itens_pedido extends Entity
{

    private int id;
    private int pedido_id;
    
    @Min(value = 1, message = "Um dos itens do pedido não foi informado o produto. Verifique os itens e tente novamente")
    private int produto_id;
    
    @Min(value = 1, message = "Um dos itens do pedido não foi informado a unidade de venda. Verifique os itens e tente novamente")
    private int unidade_id;
    
    @Min(value = 1, message = "Um dos itens do pedido está com o preço unitário = 0 ou inferior. Verifique os itens e tente novamente")
    private BigDecimal preco_unit;
    
    @Min(value = 1, message = "Um dos itens do pedido está com a quantidade = 0 ou inferior. Verifique os itens e tente novamente")
    private BigDecimal quantidade;
    private BigDecimal total;
    
    @Min(value = 1, message = "Em um dos itens do pedido, não foi informado o local de estoque para retirada da quantidade solicitada. Verifique os itens e tente novamente")
    private int local_estoque_id;
    private BigDecimal outros_valores;
    private BigDecimal perc_desconto;
    private BigDecimal valor_desconto;
    private BigDecimal valor_final;

    private Unidades unidades;
    private Locais_estoque locais_estoque;
    private Pedidos_venda pedidos_venda;
    private Produtos produtos;

    @OneToOne(source = "produto_id", target = "id", join_type = JOIN_TYPE.INNER, load = LOAD.AUTO)
    public Produtos getProdutos()
    {
        return produtos;
    }

    public void setProdutos(Produtos produtos)
    {
        this.produtos = produtos;
    }

    public int getProduto_id()
    {
        return produto_id;
    }

    public void setProduto_id(int produto_id)
    {
        this.produto_id = produto_id;
    }

    @OneToOne(source = "unidade_id", target = "id", join_type = JOIN_TYPE.INNER, load = LOAD.AUTO)
    public Unidades getUnidades()
    {
        return unidades;
    }

    public void setUnidades(Unidades unidades)
    {
        this.unidades = unidades;
    }

    @OneToOne(source = "local_estoque_id", target = "id", join_type = JOIN_TYPE.INNER, load = LOAD.AUTO)
    public Locais_estoque getLocais_estoque()
    {
        return locais_estoque;
    }

    public void setLocais_estoque(Locais_estoque locais_estoque)
    {
        this.locais_estoque = locais_estoque;
    }

    @OneToOne(source = "pedido_id", target = "id", join_type = JOIN_TYPE.INNER, load = LOAD.AUTO)
    public Pedidos_venda getPedidos_venda()
    {
        return pedidos_venda;
    }

    public void setPedidos_venda(Pedidos_venda pedidos_venda)
    {
        this.pedidos_venda = pedidos_venda;
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

    public int getPedido_id()
    {
        return pedido_id;
    }

    public void setPedido_id(int pedido_id)
    {
        this.pedido_id = pedido_id;
    }

    public int getUnidade_id()
    {
        return unidade_id;
    }

    public void setUnidade_id(int unidade_id)
    {
        this.unidade_id = unidade_id;
    }

    public BigDecimal getPreco_unit()
    {
        return preco_unit;
    }

    public void setPreco_unit(BigDecimal preco_unit)
    {
        this.preco_unit = preco_unit;
    }

    public BigDecimal getQuantidade()
    {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade)
    {
        this.quantidade = quantidade;
    }

    public BigDecimal getTotal()
    {
        return total;
    }

    public void setTotal(BigDecimal total)
    {
        this.total = total;
    }

    public int getLocal_estoque_id()
    {
        return local_estoque_id;
    }

    public void setLocal_estoque_id(int local_estoque_id)
    {
        this.local_estoque_id = local_estoque_id;
    }

    public BigDecimal getOutros_valores()
    {
        return outros_valores;
    }

    public void setOutros_valores(BigDecimal outros_valores)
    {
        this.outros_valores = outros_valores;
    }

    public BigDecimal getPerc_desconto()
    {
        return perc_desconto;
    }

    public void setPerc_desconto(BigDecimal perc_desconto)
    {
        this.perc_desconto = perc_desconto;
    }

    public BigDecimal getValor_desconto()
    {
        return valor_desconto;
    }

    public void setValor_desconto(BigDecimal valor_desconto)
    {
        this.valor_desconto = valor_desconto;
    }

    public BigDecimal getValor_final()
    {
        return valor_final;
    }

    public void setValor_final(BigDecimal valor_final)
    {
        this.valor_final = valor_final;
    }

}
