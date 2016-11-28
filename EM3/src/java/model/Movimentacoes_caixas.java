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
public class Movimentacoes_caixas extends Entity
{
    private int id;
    private String data_abertura;
    private int usuario_abertura;
    private String data_fechamento;
    private int usuario_fechamento;
    private BigDecimal dinheiro;
    private BigDecimal cartao;
    private BigDecimal cheque;
    private BigDecimal credito_cliente;
    private BigDecimal boleto;
    private BigDecimal troco;
    private int caixa_id;
    
    private Usuarios usuarioAbertura;
    private Usuarios usuarioFechamento;

    @OneToOne(source = "usuario_fechamento", target = "id", join_type = JOIN_TYPE.LEFT, load = LOAD.AUTO)
    public Usuarios getUsuarioFechamento()
    {
        return usuarioFechamento;
    }

    public void setUsuarioFechamento(Usuarios usuarioFechamento)
    {
        this.usuarioFechamento = usuarioFechamento;
    }
    
    @OneToOne(source = "usuario_abertura", target = "id", join_type = JOIN_TYPE.INNER, load = LOAD.AUTO)
    public Usuarios getUsuarioAbertura()
    {
        return usuarioAbertura;
    }

    public void setUsuarioAbertura(Usuarios usuarioAbertura)
    {
        this.usuarioAbertura = usuarioAbertura;
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

    public String getData_abertura()
    {
        return data_abertura;
    }

    public void setData_abertura(String data_abertura)
    {
        this.data_abertura = data_abertura;
    }

    public int getUsuario_abertura()
    {
        return usuario_abertura;
    }

    public void setUsuario_abertura(int usuario_abertura)
    {
        this.usuario_abertura = usuario_abertura;
    }

    public String getData_fechamento()
    {
        return data_fechamento;
    }

    public void setData_fechamento(String data_fechamento)
    {
        this.data_fechamento = data_fechamento;
    }

    public int getUsuario_fechamento()
    {
        return usuario_fechamento;
    }

    public void setUsuario_fechamento(int usuario_fechamento)
    {
        this.usuario_fechamento = usuario_fechamento;
    }

    public BigDecimal getDinheiro()
    {
        return dinheiro;
    }

    public void setDinheiro(BigDecimal dinheiro)
    {
        this.dinheiro = dinheiro;
    }

    public BigDecimal getCartao()
    {
        return cartao;
    }

    public void setCartao(BigDecimal cartao)
    {
        this.cartao = cartao;
    }

    public BigDecimal getCheque()
    {
        return cheque;
    }

    public void setCheque(BigDecimal cheque)
    {
        this.cheque = cheque;
    }

    public BigDecimal getCredito_cliente()
    {
        return credito_cliente;
    }

    public void setCredito_cliente(BigDecimal credito_cliente)
    {
        this.credito_cliente = credito_cliente;
    }

    public BigDecimal getBoleto()
    {
        return boleto;
    }

    public void setBoleto(BigDecimal boleto)
    {
        this.boleto = boleto;
    }

    public BigDecimal getTroco()
    {
        return troco;
    }

    public void setTroco(BigDecimal troco)
    {
        this.troco = troco;
    }

    public int getCaixa_id()
    {
        return caixa_id;
    }

    public void setCaixa_id(int caixa_id)
    {
        this.caixa_id = caixa_id;
    }
    
}
