
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

/**
 *
 * @author Persistor4J
 */
public class Clientes extends Entity
{

    private int id;
    private String nome;
    private String apelido;
    private String contato;
    private String telefone1;
    private String telefone2;
    private String fax;
    private String celular;
    private String email1;
    private String email2;
    private String website;
    private String obs;
    private boolean inativo;
    private String data_nascimento;
    private String data_cadastro;
    private BigDecimal credito;
    private int tipo_cliente;
    private int tipo_pessoa;
    private int frete;
    private int documento_id;
    private int endereco_id;
    private int grupo_id;
    private int tabela_preco_id;
    private int empresa_id;
    private int forma_pagamento_id;
    private int vendedor;

    private Documentos documentos;
    private Enderecos enderecos;
    private Empresa empresa;

    public int getTipo_cliente()
    {
        return tipo_cliente;
    }

    public String getContato()
    {
        return contato;
    }

    public void setContato(String contato)
    {
        this.contato = contato;
    }

    public int getVendedor()
    {
        return vendedor;
    }

    public void setVendedor(int vendedor)
    {
        this.vendedor = vendedor;
    }

    public void setTipo_cliente(int tipo_cliente)
    {
        this.tipo_cliente = tipo_cliente;
    }

    public int getForma_pagamento_id()
    {
        return forma_pagamento_id;
    }

    public void setForma_pagamento_id(int forma_pagamento_id)
    {
        this.forma_pagamento_id = forma_pagamento_id;
    }

    public int getFrete()
    {
        return frete;
    }

    public void setFrete(int frete)
    {
        this.frete = frete;
    }

    public int getTabela_preco_id()
    {
        return tabela_preco_id;
    }

    public void setTabela_preco_id(int tabela_preco_id)
    {
        this.tabela_preco_id = tabela_preco_id;
    }

    public int getEmpresa_id()
    {
        return empresa_id;
    }

    public void setEmpresa_id(int empresa_id)
    {
        this.empresa_id = empresa_id;
    }

    @OneToOne(source = "empresa_id", target = "id", join_type = JOIN_TYPE.INNER, load = LOAD.AUTO)
    public Empresa getEmpresa()
    {
        return empresa;
    }

    public void setEmpresa(Empresa empresa)
    {
        this.empresa = empresa;
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

    public void setApelido(String apelido)
    {
        this.apelido = apelido;
    }

    public String getApelido()
    {
        return apelido;
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

    public void setFax(String fax)
    {
        this.fax = fax;
    }

    public String getFax()
    {
        return fax;
    }

    public void setCelular(String celular)
    {
        this.celular = celular;
    }

    public String getCelular()
    {
        return celular;
    }

    public void setEmail1(String email1)
    {
        this.email1 = email1;
    }

    public String getEmail1()
    {
        return email1;
    }

    public void setEmail2(String email2)
    {
        this.email2 = email2;
    }

    public String getEmail2()
    {
        return email2;
    }

    public void setWebsite(String website)
    {
        this.website = website;
    }

    public String getWebsite()
    {
        return website;
    }

    public void setObs(String obs)
    {
        this.obs = obs;
    }

    public String getObs()
    {
        return obs;
    }

    public void setInativo(boolean inativo)
    {
        this.inativo = inativo;
    }

    public boolean isInativo()
    {
        return inativo;
    }

    public void setData_nascimento(String data_nascimento)
    {
        this.data_nascimento = data_nascimento;
    }

    public String getData_nascimento()
    {
        return data_nascimento;
    }

    public void setData_cadastro(String data_cadastro)
    {
        this.data_cadastro = data_cadastro;
    }

    public String getData_cadastro()
    {
        return data_cadastro;
    }

    public void setCredito(BigDecimal credito)
    {
        this.credito = credito;
    }

    public BigDecimal getCredito()
    {
        return credito;
    }

    public void setTipo_pessoa(int tipo_pessoa)
    {
        this.tipo_pessoa = tipo_pessoa;
    }

    public int getTipo_pessoa()
    {
        return tipo_pessoa;
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

    @OneToOne(source = "documento_id", target = "id", load = LOAD.AUTO, join_type = JOIN_TYPE.LEFT)
    public Documentos getDocumentos()
    {
        return documentos;
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

    public void setGrupo_id(int grupo_id)
    {
        this.grupo_id = grupo_id;
    }

    public int getGrupo_id()
    {
        return grupo_id;
    }
}
