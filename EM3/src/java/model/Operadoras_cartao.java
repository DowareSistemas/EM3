
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
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Persistor4J
 */
public class Operadoras_cartao extends Entity
{

    private int id;
    
    @NotNull(message = "O nome da operadora é obrigatório")
    @NotEmpty(message = "O nome da operadora é obrigatório")
    @Size(max = 100, message = "O nome da operadora não pode conter mais de 100 caracteres")
    private String nome;
    
    @Min(value = 0, message = "Operação não identificada")
    @Max(value = 1, message = "Operação não identificada")
    private int tipo;
    
    @Min(value = 0, message = "Tipo de recebimento não identificado")
    @Max(value = 1, message = "Tipo de recebimento não identificado")
    private int tipo_recebimento;
    
    @Min(value = 1, message = "O prazo para recebimento não pode ser inferior a 1")
    private int prazo_recebimento;
    
    @Min(value = 0, message = "A taxa de serviço não pode ser inferior a 0")
    private BigDecimal taxa;
    
    @NotNull(message = "Informe se a operadora está inativa")
    private boolean inativo;

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

    public int getTipo()
    {
        return tipo;
    }

    public void setTipo(int tipo)
    {
        this.tipo = tipo;
    }

    public int getTipo_recebimento()
    {
        return tipo_recebimento;
    }

    public void setTipo_recebimento(int tipo_recebimento)
    {
        this.tipo_recebimento = tipo_recebimento;
    }

    public int getPrazo_recebimento()
    {
        return prazo_recebimento;
    }

    public void setPrazo_recebimento(int prazo_recebimento)
    {
        this.prazo_recebimento = prazo_recebimento;
    }

    public BigDecimal getTaxa()
    {
        return taxa;
    }

    public void setTaxa(BigDecimal taxa)
    {
        this.taxa = taxa;
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
