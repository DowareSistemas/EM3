
/* AUTO-GENERATED CLASS */
 /* DOES NOT ADD ACCESSOR METHODS */
 /* DOES NOT CHANGE NAME OF ACCESSOR METHODS */
package model;

import java.math.BigDecimal;
import br.com.persistor.abstractClasses.Entity;
import br.com.persistor.abstractClasses.Entity;
import br.com.persistor.annotations.PrimaryKey;
import br.com.persistor.enums.INCREMENT;
import br.com.persistor.annotations.OneToOne;
import br.com.persistor.annotations.OneToMany;
import br.com.persistor.enums.JOIN_TYPE;
import br.com.persistor.enums.LOAD;
import java.util.Date;
import java.io.InputStream;

/**
 *
 * @author Persistor4J
 */
public class Produtos_precos extends Entity
{

    private int id;
    private int produto_id;
    private int tabela_id;
    private BigDecimal valor;
    private boolean preco_padrao;
    private String uf;

    private Produtos produtos;
    private Tabelas_precos tabelas_precos;

    @OneToOne(source = "produto_id", target = "id", join_type = JOIN_TYPE.INNER, load = LOAD.AUTO)
    public Produtos getProdutos()
    {
        return produtos;
    }

    public void setProdutos(Produtos produtos)
    {
        this.produtos = produtos;
    }

    @OneToOne(source = "tabela_id", target = "id", join_type = JOIN_TYPE.INNER, load = LOAD.AUTO)
    public Tabelas_precos getTabelas_precos()
    {
        return tabelas_precos;
    }

    public void setTabelas_precos(Tabelas_precos tabelas_precos)
    {
        this.tabelas_precos = tabelas_precos;
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

    public int getProduto_id()
    {
        return produto_id;
    }

    public void setProduto_id(int produto_id)
    {
        this.produto_id = produto_id;
    }

    public int getTabela_id()
    {
        return tabela_id;
    }

    public void setTabela_id(int tabela_id)
    {
        this.tabela_id = tabela_id;
    }

    public BigDecimal getValor()
    {
        return valor;
    }

    public void setValor(BigDecimal valor)
    {
        this.valor = valor;
    }

    public boolean isPreco_padrao()
    {
        return preco_padrao;
    }

    public void setPreco_padrao(boolean preco_padrao)
    {
        this.preco_padrao = preco_padrao;
    }

    public String getUf()
    {
        return uf;
    }

    public void setUf(String uf)
    {
        this.uf = uf;
    }

}
