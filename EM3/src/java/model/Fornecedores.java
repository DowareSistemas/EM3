
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

public class Fornecedores extends Entity 
{
   private int id; 
   private int loja_fornecedor; 
   private String razao_social; 
   private String nome_fantasia; 
   private String telefone1; 
   private String inscr_municipal; 
   private String inscr_estadual; 
   private String fax; 
   private String email; 
   private String observacoes; 
   private String website; 
   private boolean ativo; 
   private BigDecimal credito; 
   private String ultima_compra; 
   private int tipo_pessoa; 
   private int endereco_id; 
   private Enderecos enderecos; 
   private int documento_id; 
   private Documentos documentos; 
   private int banco_id; 

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

   public void setTelefone1(String telefone1)
   {
       this.telefone1 = telefone1;
   }
 
   public String getTelefone1()
   {
       return telefone1;
   }

   public void setInscr_municipal(String inscr_municipal)
   {
       this.inscr_municipal = inscr_municipal;
   }
 
   public String getInscr_municipal()
   {
       return inscr_municipal;
   }

   public void setInscr_estadual(String inscr_estadual)
   {
       this.inscr_estadual = inscr_estadual;
   }
 
   public String getInscr_estadual()
   {
       return inscr_estadual;
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

   @OneToOne(source = "endereco_id", target = "id" , load = LOAD.AUTO, join_type = JOIN_TYPE.INNER)
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

   @OneToOne(source = "documento_id", target = "id" , load = LOAD.AUTO, join_type = JOIN_TYPE.INNER)
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