
/* AUTO-GENERATED CLASS */
 /* DOES NOT ADD ACCESSOR METHODS */
 /* DOES NOT CHANGE NAME OF ACCESSOR METHODS */
package model;

import java.math.BigDecimal;
import br.com.persistor.abstractClasses.Entity;
import br.com.persistor.annotations.PrimaryKey;
import br.com.persistor.enums.INCREMENT;
import br.com.persistor.annotations.OneToOne;
import br.com.persistor.enums.JOIN_TYPE;
import br.com.persistor.enums.LOAD;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Persistor4J
 */
public class Fornecedores extends Entity
{

    private int id;
    private int loja_fornecedor;

    @NotNull(message = "A razão social é obrigatória")
    @NotEmpty(message = "A razão social é obrigatória")
    @Size(max = 100, message = "A razão social não pode ter mais de 100 caracteres")
    private String razao_social;

    @NotNull(message = "O nome fantasia é obrigatório")
    @NotEmpty(message = "O nome fantasia é obrigatório")
    @Size(max = 100, message = "O nome fantasia razão social não pode ter mais de 100 caracteres")
    private String nome_fantasia;
    
    @Size(max = 20, message = "O telefone não pode ter mais de 100 caracteres")
    private String telefone;
    
    @Size(max = 20, message = "O fax não pode ter mais de 20 caracteres")
    private String fax;
    
    @Size(max = 100, message = "O email não pode ter mais de 100 caracteres")
    private String email;
    
    @Size(max = 1000, message = "As observações não podem ter mais de 1000 caracteres")
    private String observacoes;
    
    @Size(max = 100, message = "O website não pode ter mais de 100 caractetes")
    private String website;
    
    @NotNull(message = "Informe se o fornecedor está ativo")
    private boolean ativo;
    private BigDecimal credito;
    private String ultima_compra;
    
    @NotNull(message = "Informe o tipo de pessoa do fornecedor")
    private int tipo_pessoa;
    private int endereco_id;
    
    @Valid
    private Enderecos enderecos;
    private int documento_id;

    private Documentos documentos;
    private int banco_id;
    
    private String Data_cadastro;

    public void setId(int id)
    {
        this.id = id;
    }

    @PrimaryKey(increment = INCREMENT.MANUAL)
    public int getId()
    {
        return id;
    }

    public void setLoja_fornecedor(int loja_fornecedor)
    {
        this.loja_fornecedor = loja_fornecedor;
    }

    public int getLoja_fornecedor()
    {
        return loja_fornecedor;
    }

    public void setRazao_social(String razao_social)
    {
        this.razao_social = razao_social;
    }

    public String getRazao_social()
    {
        return razao_social;
    }

    public void setNome_fantasia(String nome_fantasia)
    {
        this.nome_fantasia = nome_fantasia;
    }

    public String getNome_fantasia()
    {
        return nome_fantasia;
    }

    public void setTelefone(String telefone)
    {
        this.telefone = telefone;
    }

    public String getTelefone()
    {
        return telefone;
    }

    public void setFax(String fax)
    {
        this.fax = fax;
    }

    public String getFax()
    {
        return fax;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getEmail()
    {
        return email;
    }

    public void setObservacoes(String observacoes)
    {
        this.observacoes = observacoes;
    }

    public String getObservacoes()
    {
        return observacoes;
    }

    public void setWebsite(String website)
    {
        this.website = website;
    }

    public String getWebsite()
    {
        return website;
    }

    public void setAtivo(boolean ativo)
    {
        this.ativo = ativo;
    }

    public boolean isAtivo()
    {
        return ativo;
    }

    public String getData_cadastro()
    {
        return Data_cadastro;
    }

    public void setData_cadastro(String Data_cadastro)
    {
        this.Data_cadastro = Data_cadastro;
    }

    public void setCredito(BigDecimal credito)
    {
        this.credito = credito;
    }

    public BigDecimal getCredito()
    {
        return credito;
    }

    public void setUltima_compra(String ultima_compra)
    {
        this.ultima_compra = ultima_compra;
    }

    public String getUltima_compra()
    {
        return ultima_compra;
    }

    public void setTipo_pessoa(int tipo_pessoa)
    {
        this.tipo_pessoa = tipo_pessoa;
    }

    public int getTipo_pessoa()
    {
        return tipo_pessoa;
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

    public void setDocumentos(Documentos documentos)
    {
        this.documentos = documentos;
    }

    public void setDocumento_id(int documento_id)
    {
        this.documento_id = documento_id;
    }

    public int getDocumento_id()
    {
        return documento_id;
    }

    @OneToOne(source = "documento_id", target = "id", load = LOAD.AUTO, join_type = JOIN_TYPE.INNER)
    public Documentos getDocumentos()
    {
        return documentos;
    }

    public void setBanco_id(int banco_id)
    {
        this.banco_id = banco_id;
    }

    public int getBanco_id()
    {
        return banco_id;
    }
}
