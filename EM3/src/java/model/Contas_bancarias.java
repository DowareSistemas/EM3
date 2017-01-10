
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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Persistor4J
 */
public class Contas_bancarias extends Entity
{

    private int id;
    
    @NotNull(message = "O nome é obrigatório")
    @NotEmpty(message = "O nome é obrigatório")
    @Size(max = 50, message = "O nome não pode conter mais de 50 caracteres")
    private String nome;
    
    @NotNull(message = "A agência é obrigatória")
    @NotEmpty(message = "A agência é obrigatória")
    @Size(max = 5, message = "A agência não pode conter mais de 2 caracteres")
    private String agencia;
    
    @NotNull(message = "Informe o dígito verificador da agência")
    @NotEmpty(message = "Informe o dígito verificador da agência")
    @Size(max = 2, message = "O dígito verificador da agência não pode conter mais de 2 caracteres")
    private String dv_agencia;
    
    @NotNull(message = "A conta é obrigatória")
    @NotEmpty(message = "A conta é obrigatória")
    @Size(max = 10, message = "A conta não pode conter mais de 10 caracteres")
    private String conta;
    
    @NotNull(message = "Informe o dígito verificador da conta")
    @NotEmpty(message = "Informe o dígito verificador da conta")
    @Size(max = 2, message = "O dígito verificador da conta não pode conter mais de 2 caracteres")
    private String dv_conta;
    
    @Size(max = 4, message = "A carteira não pode passar de 4 caracteres")
    private String carteira;
    
    @Size(max = 100, message = "O correntista não pode passar de 100 caracteres")
    private String correntista;
    private BigDecimal saldo_atual;
    private BigDecimal limite_credito;
    
    @Min(value = 1, message = "Informe o banco")
    private int banco_id;
    private boolean inativo;

    private Bancos bancos;

    public String getCarteira()
    {
        return carteira;
    }

    public void setCarteira(String carteira)
    {
        this.carteira = carteira;
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

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getAgencia()
    {
        return agencia;
    }

    public void setAgencia(String agencia)
    {
        this.agencia = agencia;
    }

    public String getDv_agencia()
    {
        return dv_agencia;
    }

    public void setDv_agencia(String dv_agencia)
    {
        this.dv_agencia = dv_agencia;
    }

    public String getConta()
    {
        return conta;
    }

    public void setConta(String conta)
    {
        this.conta = conta;
    }

    public String getDv_conta()
    {
        return dv_conta;
    }

    public void setDv_conta(String dv_conta)
    {
        this.dv_conta = dv_conta;
    }

    public String getCorrentista()
    {
        return correntista;
    }

    public void setCorrentista(String correntista)
    {
        this.correntista = correntista;
    }

    public BigDecimal getSaldo_atual()
    {
        return saldo_atual;
    }

    public void setSaldo_atual(BigDecimal saldo_atual)
    {
        this.saldo_atual = saldo_atual;
    }

    public BigDecimal getLimite_credito()
    {
        return limite_credito;
    }

    public void setLimite_credito(BigDecimal limite_credito)
    {
        this.limite_credito = limite_credito;
    }

    public int getBanco_id()
    {
        return banco_id;
    }

    public void setBanco_id(int banco_id)
    {
        this.banco_id = banco_id;
    }

    @OneToOne(source = "banco_id", target = "id", join_type = JOIN_TYPE.INNER, load = LOAD.AUTO)
    public Bancos getBancos()
    {
        return bancos;
    }

    public void setBancos(Bancos bancos)
    {
        this.bancos = bancos;
    }

    public boolean isInativo()
    {
        return inativo;
    }

    public void setInativo(boolean inativo)
    {
        this.inativo = inativo;
    }
}
