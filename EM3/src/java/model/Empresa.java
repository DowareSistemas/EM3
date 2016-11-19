
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
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Persistor4J
 */
public class Empresa extends Entity
{

    private int id;
    @Size(max = 100, message = "O nome fantasia não pode ter mais de 100 caracteres")
    @NotNull(message = "O nome fantasia é obrigatório")
    @NotEmpty(message = "O nome fantasia é obrigatório")
    private String nome_fantasia;

    @Size(max = 100, message = "A razão social não pode ter mais de 100 caracteres")
    @NotNull(message = "A razão social é obrigatória")
    @NotEmpty(message = "A razão social é obrigatória")
    private String razao_social;

    @Size(max = 20, message = "O CNPJ não pode ter mais de 20 digitos")
    @NotNull(message = "O CNPJ é obrigatório")
    @NotEmpty(message = "O CNPJ é obrigatório")
    private String cnpj;

    @Max(value = 3, message = "Código do Regime Tributário (CRT) não identificado")
    private int crt;
    private String telefone1;
    private String telefone2;
    private String celular;
    private String email;
    private String responsavel;

    @NotNull(message = "Informe se a empresa está ou não ativa")
    private boolean ativo;
    private int tipo;
    private int endereco_id;

    @NotNull(message = "A empresa deve possuir um endereço")
    @Valid()
    private Enderecos enderecos;
    private int foto_id;

    public void setId(int id)
    {
        this.id = id;
    }

    @PrimaryKey(increment = INCREMENT.MANUAL)
    public int getId()
    {
        return id;
    }

    public void setNome_fantasia(String nome_fantasia)
    {
        this.nome_fantasia = nome_fantasia;
    }

    public String getNome_fantasia()
    {
        return nome_fantasia;
    }

    public void setRazao_social(String razao_social)
    {
        this.razao_social = razao_social;
    }

    public String getRazao_social()
    {
        return razao_social;
    }

    public void setCnpj(String cnpj)
    {
        this.cnpj = cnpj;
    }

    public String getCnpj()
    {
        return cnpj;
    }

    public void setCrt(int crt)
    {
        this.crt = crt;
    }

    public int getCrt()
    {
        return crt;
    }

    public void setTelefone1(String telefone1)
    {
        this.telefone1 = telefone1;
    }

    public String getTelefone1()
    {
        return telefone1;
    }

    public void setTelefone2(String telefone2)
    {
        this.telefone2 = telefone2;
    }

    public String getTelefone2()
    {
        return telefone2;
    }

    public void setCelular(String celular)
    {
        this.celular = celular;
    }

    public String getCelular()
    {
        return celular;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getEmail()
    {
        return email;
    }

    public void setResponsavel(String responsavel)
    {
        this.responsavel = responsavel;
    }

    public String getResponsavel()
    {
        return responsavel;
    }

    public void setAtivo(boolean ativo)
    {
        this.ativo = ativo;
    }

    public boolean isAtivo()
    {
        return ativo;
    }

    public void setTipo(int tipo)
    {
        this.tipo = tipo;
    }

    public int getTipo()
    {
        return tipo;
    }

    public void setEnderecos(Enderecos enderecos)
    {
        this.enderecos = enderecos;
    }

    public void setEndereco_id(int endereco_id)
    {
        this.endereco_id = endereco_id;
    }

    public int getEndereco_id()
    {
        return endereco_id;
    }

    @OneToOne(source = "endereco_id", target = "id", load = LOAD.AUTO, join_type = JOIN_TYPE.INNER)
    public Enderecos getEnderecos()
    {
        return enderecos;
    }

    public void setFoto_id(int foto_id)
    {
        this.foto_id = foto_id;
    }

    public int getFoto_id()
    {
        return foto_id;
    }
}
