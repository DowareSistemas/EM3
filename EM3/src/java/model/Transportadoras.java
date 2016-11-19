
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

public class Transportadoras extends Entity 
{
   private int id; 
   private String razao_social; 
   private String nome_fantasia; 
   private String telefone1; 
   private String telefone2; 
   private String email; 
   private String website; 
   private String observacoes; 
   private boolean inativo; 
   private int endereco_id; 
   private Enderecos enderecos; 
   private int documento_id; 
   private Documentos documentos; 

   public void setId(int id)
   {
       this.id = id;
   }
 
   @PrimaryKey(increment = INCREMENT.MANUAL)
   public int getId()
   {
       return id;
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

   public void setTelefone2(String telefone2)
   {
       this.telefone2 = telefone2;
   }
 
   public String getTelefone2()
   {
       return telefone2;
   }

   public void setEmail(String email)
   {
       this.email = email;
   }
 
   public String getEmail()
   {
       return email;
   }

   public void setWebsite(String website)
   {
       this.website = website;
   }
 
   public String getWebsite()
   {
       return website;
   }

   public void setObservacoes(String observacoes)
   {
       this.observacoes = observacoes;
   }
 
   public String getObservacoes()
   {
       return observacoes;
   }

   public void setInativo(boolean inativo)
   {
       this.inativo = inativo;
   }
 
   public boolean isInativo()
   {
       return inativo;
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
}