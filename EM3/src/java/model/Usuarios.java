
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

public class Usuarios extends Entity 
{
   private int id; 
   private String nome; 
   private String senha; 
   private boolean admin; 
   private boolean ativo; 

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

   public void setSenha(String senha)
   {
       this.senha = senha;
   }
 
   public String getSenha()
   {
       return senha;
   }

   public void setAdmin(boolean admin)
   {
       this.admin = admin;
   }
 
   public boolean isAdmin()
   {
       return admin;
   }

   public void setAtivo(boolean ativo)
   {
       this.ativo = ativo;
   }
 
   public boolean isAtivo()
   {
       return ativo;
   }
}