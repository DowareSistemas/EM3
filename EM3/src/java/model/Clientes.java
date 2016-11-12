/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import br.com.persistor.abstractClasses.Entity;
import br.com.persistor.annotations.PrimaryKey;
import br.com.persistor.enums.INCREMENT;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Marcos Vinícius
 */
public class Clientes extends Entity
{
    private int id;
    private String nome;
    private String apelido;
    private String telefone1;
    private String telefone2;
    private String fax;
    private String celular;
    private String email1;
    private String email2;
    private String website;
    private String obs;
    private boolean bloqueado;
    private boolean inativo;
    private Date data_nascimento;
    private Date data_cadastro;
    private Date ultima_alteracao;
    private BigDecimal credito;
    private BigDecimal debito;
    private int tipo_pessoa; /* enum */
    private int sexo; /* enum */
    private int documentos_id;
    private int endereco_id;
    private int grupo_id;
    
    /* Joins */


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

    public String getApelido()
    {
        return apelido;
    }

    public void setApelido(String apelido)
    {
        this.apelido = apelido;
    }

    public String getTelefone1()
    {
        return telefone1;
    }

    public void setTelefone1(String telefone1)
    {
        this.telefone1 = telefone1;
    }

    public String getTelefone2()
    {
        return telefone2;
    }

    public void setTelefone2(String telefone2)
    {
        this.telefone2 = telefone2;
    }

    public String getFax()
    {
        return fax;
    }

    public void setFax(String fax)
    {
        this.fax = fax;
    }

    public String getCelular()
    {
        return celular;
    }

    public void setCelular(String celular)
    {
        this.celular = celular;
    }

    public String getEmail1()
    {
        return email1;
    }

    public void setEmail1(String email1)
    {
        this.email1 = email1;
    }

    public String getEmail2()
    {
        return email2;
    }

    public void setEmail2(String email2)
    {
        this.email2 = email2;
    }

    public String getWebsite()
    {
        return website;
    }

    public void setWebsite(String website)
    {
        this.website = website;
    }

    public String getObs()
    {
        return obs;
    }

    public void setObs(String obs)
    {
        this.obs = obs;
    }

    public boolean isBloqueado()
    {
        return bloqueado;
    }

    public void setBloqueado(boolean bloqueado)
    {
        this.bloqueado = bloqueado;
    }

    public boolean isInativo()
    {
        return inativo;
    }

    public void setInativo(boolean inativo)
    {
        this.inativo = inativo;
    }

    public Date getData_nascimento()
    {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento)
    {
        this.data_nascimento = data_nascimento;
    }

    public Date getData_cadastro()
    {
        return data_cadastro;
    }

    public void setData_cadastro(Date data_cadastro)
    {
        this.data_cadastro = data_cadastro;
    }

    public Date getUltima_alteracao()
    {
        return ultima_alteracao;
    }

    public void setUltima_alteracao(Date ultima_alteracao)
    {
        this.ultima_alteracao = ultima_alteracao;
    }

    public BigDecimal getCredito()
    {
        return credito;
    }

    public void setCredito(BigDecimal credito)
    {
        this.credito = credito;
    }

    public BigDecimal getDebito()
    {
        return debito;
    }

    public void setDebito(BigDecimal debito)
    {
        this.debito = debito;
    }

    public int getTipo_pessoa()
    {
        return tipo_pessoa;
    }

    public void setTipo_pessoa(int tipo_pessoa)
    {
        this.tipo_pessoa = tipo_pessoa;
    }

    public int getSexo()
    {
        return sexo;
    }

    public void setSexo(int sexo)
    {
        this.sexo = sexo;
    }

    public int getDocumentos_id()
    {
        return documentos_id;
    }

    public void setDocumentos_id(int documentos_id)
    {
        this.documentos_id = documentos_id;
    }

    public int getEndereco_id()
    {
        return endereco_id;
    }

    public void setEndereco_id(int endereco_id)
    {
        this.endereco_id = endereco_id;
    }

    public int getGrupo_id()
    {
        return grupo_id;
    }

    public void setGrupo_id(int grupo_id)
    {
        this.grupo_id = grupo_id;
    }
}
