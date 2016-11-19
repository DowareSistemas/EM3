
/* AUTO-GENERATED CLASS */
 /* DOES NOT ADD ACCESSOR METHODS */
 /* DOES NOT CHANGE NAME OF ACCESSOR METHODS */
package model;

import br.com.persistor.abstractClasses.Entity;
import br.com.persistor.annotations.PrimaryKey;
import br.com.persistor.enums.INCREMENT;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Persistor4J
 */
public class Unidades extends Entity
{

    private int id;

    @NotEmpty(message = "A sigla é obrigatória")
    @NotNull(message = "A sigla é obrigatória")
    @Size(max = 6, message = "A sigla não pode possuir mais de 6 caracteres")
    private String sigla;

    @NotEmpty(message = "A descrição é obrigatória")
    @NotNull(message = "A descrição é obrigatória")
    @Size(max = 12, message = "A descrição não pode possuir mais de 12 caracteres")
    private String descricao;

    public void setId(int id)
    {
        this.id = id;
    }

    @PrimaryKey(increment = INCREMENT.MANUAL)
    public int getId()
    {
        return id;
    }

    public void setSigla(String sigla)
    {
        this.sigla = sigla;
    }

    public String getSigla()
    {
        return sigla;
    }

    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }

    public String getDescricao()
    {
        return descricao;
    }
}
