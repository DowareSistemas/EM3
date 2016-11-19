
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

public class Contatos_fornecedores extends Entity 
{
   private int filial; 
   private String pessoa_contato; 
   private String telefone; 
   private String email; 
   private String setor; 
   private int fornecedor_id; 
   private Fornecedores fornecedores; 

   public void setFilial(int filial)
   {
       this.filial = filial;
   }
 
   public int getFilial()
   {
       return filial;
   }

   public void setPessoa_contato(String pessoa_contato)
   {
       this.pessoa_contato = pessoa_contato;
   }
 
   public String getPessoa_contato()
   {
       return pessoa_contato;
   }

   public void setTelefone(String telefone)
   {
       this.telefone = telefone;
   }
 
   public String getTelefone()
   {
       return telefone;
   }

   public void setEmail(String email)
   {
       this.email = email;
   }
 
   public String getEmail()
   {
       return email;
   }

   public void setSetor(String setor)
   {
       this.setor = setor;
   }
 
   public String getSetor()
   {
       return setor;
   }

 
   public void setFornecedores(Fornecedores fornecedores)
   {
       this.fornecedores = fornecedores;
   }
   public void setFornecedor_id(int fornecedor_id)
   {
       this.fornecedor_id = fornecedor_id;
   }
 
   public int getFornecedor_id()
   {
       return fornecedor_id;
   }

   @OneToOne(source = "fornecedor_id", target = "id" , load = LOAD.AUTO, join_type = JOIN_TYPE.INNER)
   public Fornecedores getFornecedores()
   {
       return fornecedores;
   }
}