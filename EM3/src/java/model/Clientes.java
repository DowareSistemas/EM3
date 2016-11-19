
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
   private String data_nascimanto; 
   private String data_cadastro; 
   private String ultima_alteracao; 
   private BigDecimal credito; 
   private BigDecimal debito; 
   private int tipo_pessoa; 
   private int sexo; 
   private int documento_id; 
   private Documentos documentos; 
   private int endereco_id; 
   private Enderecos enderecos; 
   private int grupo_id; 

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

   public void setBloqueado(boolean bloqueado)
   {
       this.bloqueado = bloqueado;
   }
 
   public boolean isBloqueado()
   {
       return bloqueado;
   }

   public void setInativo(boolean inativo)
   {
       this.inativo = inativo;
   }
 
   public boolean isInativo()
   {
       return inativo;
   }

   public void setData_nascimanto(String data_nascimanto)
   {
       this.data_nascimanto = data_nascimanto;
   }
 
   public String getData_nascimanto()
   {
       return data_nascimanto;
   }

   public void setData_cadastro(String data_cadastro)
   {
       this.data_cadastro = data_cadastro;
   }
 
   public String getData_cadastro()
   {
       return data_cadastro;
   }

   public void setUltima_alteracao(String ultima_alteracao)
   {
       this.ultima_alteracao = ultima_alteracao;
   }
 
   public String getUltima_alteracao()
   {
       return ultima_alteracao;
   }

   public void setCredito(BigDecimal credito)
   {
       this.credito = credito;
   }
 
   public BigDecimal getCredito()
   {
       return credito;
   }

   public void setDebito(BigDecimal debito)
   {
       this.debito = debito;
   }
 
   public BigDecimal getDebito()
   {
       return debito;
   }

   public void setTipo_pessoa(int tipo_pessoa)
   {
       this.tipo_pessoa = tipo_pessoa;
   }
 
   public int getTipo_pessoa()
   {
       return tipo_pessoa;
   }

   public void setSexo(int sexo)
   {
       this.sexo = sexo;
   }
 
   public int getSexo()
   {
       return sexo;
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

   @OneToOne(source = "documento_id", target = "id" , load = LOAD.AUTO, join_type = JOIN_TYPE.INNER)
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

   @OneToOne(source = "endereco_id", target = "id" , load = LOAD.AUTO, join_type = JOIN_TYPE.INNER)
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