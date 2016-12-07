
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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Persistor4J
 */
public class Tipos_movimento extends Entity
{

    private int id;
    @Size(max = 100, message = "A descrição não pode conter mais de 100 caracteres.")
    private String descricao;

    @Min(value = 0, message = "Tipo de movimentação inválido")
    @Max(value = 2, message = "Tipo de movimentação inválido")
    private int movimentacao_financeiro;

    @Min(value = 0, message = "Tipo de movimentação inválido")
    @Max(value = 2, message = "Tipo de movimentação inválido")
    private int movimentacao_estoque;
    
    @NotNull(message = "Informe se o tipo de movimento gera comissão")
    private boolean gera_comissao;

    @NotNull(message = "Informe se o tipo de movimento gera NF-e")
    private boolean gera_nfe;

    @NotNull(message = "Informe se o tipo de movimento gera NFC-e")
    private boolean gera_nfce;

    @NotNull(message = "Informe se o tipo de movimento está inativo")
    private boolean inativo;

    public void setId(int id)
    {
        this.id = id;
    }

    @PrimaryKey(increment = INCREMENT.MANUAL)
    public int getId()
    {
        return id;
    }

    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }

    public String getDescricao()
    {
        return descricao;
    }

    public void setMovimentacao_financeiro(int movimentacao_financeiro)
    {
        this.movimentacao_financeiro = movimentacao_financeiro;
    }

    public int getMovimentacao_financeiro()
    {
        return movimentacao_financeiro;
    }

    public void setMovimentacao_estoque(int movimentacao_estoque)
    {
        this.movimentacao_estoque = movimentacao_estoque;
    }

    public int getMovimentacao_estoque()
    {
        return movimentacao_estoque;
    }

    public void setGera_comissao(boolean gera_comissao)
    {
        this.gera_comissao = gera_comissao;
    }

    public boolean isGera_comissao()
    {
        return gera_comissao;
    }

    public void setGera_nfe(boolean gera_nfe)
    {
        this.gera_nfe = gera_nfe;
    }

    public boolean isGera_nfe()
    {
        return gera_nfe;
    }

    public void setGera_nfce(boolean gera_nfce)
    {
        this.gera_nfce = gera_nfce;
    }

    public boolean isGera_nfce()
    {
        return gera_nfce;
    }

    public void setInativo(boolean inativo)
    {
        this.inativo = inativo;
    }

    public boolean isInativo()
    {
        return inativo;
    }
}
