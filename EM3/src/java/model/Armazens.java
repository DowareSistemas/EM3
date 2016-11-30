
/* AUTO-GENERATED CLASS */
 /* DOES NOT ADD ACCESSOR METHODS */
 /* DOES NOT CHANGE NAME OF ACCESSOR METHODS */
package model;

import br.com.persistor.abstractClasses.Entity;
import br.com.persistor.annotations.PrimaryKey;
import br.com.persistor.enums.INCREMENT;
import br.com.persistor.annotations.OneToOne;
import br.com.persistor.enums.JOIN_TYPE;
import br.com.persistor.enums.LOAD;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Persistor4J
 */
public class Armazens extends Entity
{

    private int id;
    
    @NotNull(message = "O nome do armazém é obrigatório.")
    @NotEmpty(message = "O nome do armazém é obrigatório.")
    @Size(max = 100, message = "O nome do armazém não pode ter mais de 100 caracteres.")
    private String nome;
    
    @Max(value = 2, message = "Tipo de armazém inválido")
    @Min(value = 0, message = "Tipo de armazém inválido")
    public int tipo_armazem;
    private int empresa_id;

    private Empresa empresa;

    @OneToOne(source = "empresa_id", target = "id", join_type = JOIN_TYPE.LEFT, load = LOAD.AUTO)
    public Empresa getEmpresa()
    {
        return empresa;
    }

    public void setEmpresa(Empresa empresa)
    {
        this.empresa = empresa;
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

    public int getTipo_armazem()
    {
        return tipo_armazem;
    }

    public void setTipo_armazem(int tipo_armazem)
    {
        this.tipo_armazem = tipo_armazem;
    }

    public int getEmpresa_id()
    {
        return empresa_id;
    }

    public void setEmpresa_id(int empresa_id)
    {
        this.empresa_id = empresa_id;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getNome()
    {
        return nome;
    }
}
