
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
    private int tipo_ie;
    private String inscr_estadual;
    private String inscr_municipal;
    private boolean optante_simples;
    private String nfe_cert_serie;
    private int nfe_serie;
    private int nfe_modelo;
    private int nfe_ambiente;
    private int nfce_serie;
    private int nfce_modelo;
    private int nfce_ambiente;
    private String nfce_token;
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

    public int getTipo_ie()
    {
        return tipo_ie;
    }

    public void setTipo_ie(int tipo_ie)
    {
        this.tipo_ie = tipo_ie;
    }

    public String getInscr_estadual()
    {
        return inscr_estadual;
    }

    public void setInscr_estadual(String inscr_estadual)
    {
        this.inscr_estadual = inscr_estadual;
    }

    public String getInscr_municipal()
    {
        return inscr_municipal;
    }

    public void setInscr_municipal(String inscr_municipal)
    {
        this.inscr_municipal = inscr_municipal;
    }

    public boolean isOptante_simples()
    {
        return optante_simples;
    }

    public void setOptante_simples(boolean optante_simples)
    {
        this.optante_simples = optante_simples;
    }

    public String getNfe_cert_serie()
    {
        return nfe_cert_serie;
    }

    public void setNfe_cert_serie(String nfe_cert_serie)
    {
        this.nfe_cert_serie = nfe_cert_serie;
    }

    public int getNfe_serie()
    {
        return nfe_serie;
    }

    public void setNfe_serie(int nfe_serie)
    {
        this.nfe_serie = nfe_serie;
    }

    public int getNfe_modelo()
    {
        return nfe_modelo;
    }

    public void setNfe_modelo(int nfe_modelo)
    {
        this.nfe_modelo = nfe_modelo;
    }

    public int getNfe_ambiente()
    {
        return nfe_ambiente;
    }

    public void setNfe_ambiente(int nfe_ambiente)
    {
        this.nfe_ambiente = nfe_ambiente;
    }

    public int getNfce_serie()
    {
        return nfce_serie;
    }

    public void setNfce_serie(int nfce_serie)
    {
        this.nfce_serie = nfce_serie;
    }

    public int getNfce_modelo()
    {
        return nfce_modelo;
    }

    public void setNfce_modelo(int nfce_modelo)
    {
        this.nfce_modelo = nfce_modelo;
    }

    public int getNfce_ambiente()
    {
        return nfce_ambiente;
    }

    public void setNfce_ambiente(int nfce_ambiente)
    {
        this.nfce_ambiente = nfce_ambiente;
    }

    public String getNfce_token()
    {
        return nfce_token;
    }

    public void setNfce_token(String nfce_token)
    {
        this.nfce_token = nfce_token;
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
