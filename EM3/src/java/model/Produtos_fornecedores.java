
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
public class Produtos_fornecedores extends Entity
{

    private int id;
    private int produto_id;
    private Produtos produtos;
    private int fornecedor_id;
    private Fornecedores fornecedores;
    private int tabela_preco_id;
    private Tabelas_precos tabelas_precos;

    @PrimaryKey(increment = INCREMENT.AUTO)
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getTabela_preco_id()
    {
        return tabela_preco_id;
    }

    public void setTabela_preco_id(int tabela_preco_id)
    {
        this.tabela_preco_id = tabela_preco_id;
    }

    @OneToOne(source = "tabela_preco_id", target = "id", join_type = JOIN_TYPE.LEFT, load = LOAD.AUTO)
    public Tabelas_precos getTabelas_precos()
    {
        return tabelas_precos;
    }

    public void setTabelas_precos(Tabelas_precos tabelas_precos)
    {
        this.tabelas_precos = tabelas_precos;
    }

    public void setProdutos(Produtos produtos)
    {
        this.produtos = produtos;
    }

    public void setProduto_id(int produto_id)
    {
        this.produto_id = produto_id;
    }

    public int getProduto_id()
    {
        return produto_id;
    }

    @OneToOne(source = "produto_id", target = "id", load = LOAD.AUTO, join_type = JOIN_TYPE.INNER)
    public Produtos getProdutos()
    {
        return produtos;
    }

    public void setFornecedores(Fornecedores fornecedores)
    {
        this.fornecedores = fornecedores;
    }

    public void setFornecedor_id(int fornecedor_id)
    {
        this.fornecedor_id = fornecedor_id;
    }

    public int getFornecedor_id()
    {
        return fornecedor_id;
    }

    @OneToOne(source = "fornecedor_id", target = "id", load = LOAD.AUTO, join_type = JOIN_TYPE.INNER)
    public Fornecedores getFornecedores()
    {
        return fornecedores;
    }
}
