
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
public class Tabelas_precos extends Entity
{

    private int id;
    
    @NotNull(message = "O nome da tabela é obrigatório")
    @NotEmpty(message = "O nome da tabela é obrigatório")
    @Size(max = 100, message = "O nome da tabela não pode conter mais de 100 caracteres")
    private String nome;
    
    @NotNull(message = "Informe a data de inicío")
    @NotEmpty(message = "Informe a data de inicío")
    private String data_inicio;
    private String data_inativacao;
    
    private int forma_pagamento_id;
    
    @NotNull(message = "Informe se a tabela está inativa")
    private boolean inativo;

    private Formas_pagamento formas_pagamento;

    @OneToOne(source = "forma_pagamento_id", target = "id", join_type = JOIN_TYPE.LEFT, load = LOAD.AUTO)
    public Formas_pagamento getFormas_pagamento()
    {
        return formas_pagamento;
    }

    public void setFormas_pagamento(Formas_pagamento formas_pagamento)
    {
        this.formas_pagamento = formas_pagamento;
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

    public String getData_inicio()
    {
        return data_inicio;
    }

    public void setData_inicio(String data_inicio)
    {
        this.data_inicio = data_inicio;
    }

    public String getData_inativacao()
    {
        return data_inativacao;
    }

    public void setData_inativacao(String data_inativacao)
    {
        this.data_inativacao = data_inativacao;
    }

    public int getForma_pagamento_id()
    {
        return forma_pagamento_id;
    }

    public void setForma_pagamento_id(int forma_pagamento_id)
    {
        this.forma_pagamento_id = forma_pagamento_id;
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
