
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
public class Locais_estoque extends Entity
{

    private int id;
    
    @NotNull(message = "O nome é obrigatório")
    @NotEmpty(message = "O nome é obrigatório")
    @Size(max = 20, message= "O nome não pode ter mais 20 caracteres")
    private String nome;
    
    @Max(value = 999999, message = "A largura não deve ter um valor maior que 999999")
    private double largura;
    private String unidade_largura;
    
    @Max(value = 999999, message = "A altura não deve ter um valor maior que 999999")
    private double altura;
    private String unidade_altura;
    
    @Max(value = 999999, message = "O comprimento não deve ter um valor maior que 999999")
    private double comprimento;
    private String unidade_compr;
    
    @Min(value = 1, message = "Informe o armazém")
    private int armazem_id;

    private Armazens armazens;

    @OneToOne(source = "armazem_id", target = "id", join_type = JOIN_TYPE.INNER, load = LOAD.AUTO)
    public Armazens getArmazens()
    {
        return armazens;
    }

    public void setArmazens(Armazens armazem)
    {
        this.armazens = armazem;
    }
    
    public double getLargura()
    {
        return largura;
    }

    public void setLargura(double largura)
    {
        this.largura = largura;
    }

    public String getUnidade_largura()
    {
        return unidade_largura;
    }

    public void setUnidade_largura(String unidade_largura)
    {
        this.unidade_largura = unidade_largura;
    }

    public double getAltura()
    {
        return altura;
    }

    public void setAltura(double altura)
    {
        this.altura = altura;
    }

    public String getUnidade_altura()
    {
        return unidade_altura;
    }

    public void setUnidade_altura(String unidade_altura)
    {
        this.unidade_altura = unidade_altura;
    }

    public double getComprimento()
    {
        return comprimento;
    }

    public void setComprimento(double comprimento)
    {
        this.comprimento = comprimento;
    }

    public String getUnidade_compr()
    {
        return unidade_compr;
    }

    public void setUnidade_compr(String unidade_compr)
    {
        this.unidade_compr = unidade_compr;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    @PrimaryKey(increment = INCREMENT.MANUAL)
    public int getId()
    {
        return id;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getNome()
    {
        return nome;
    }

    public void setArmazem_id(int armazem_id)
    {
        this.armazem_id = armazem_id;
    }

    public int getArmazem_id()
    {
        return armazem_id;
    }
}
