
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

public class Grupos_produtos extends Entity 
{
   private int id; 
   private String descricao; 
   private int foto_id; 
   private boolean inativo; 

   public void setId(int id)
   {
       this.id = id;
   }
 
   @PrimaryKey(increment = INCREMENT.MANUAL)
   public int getId()
   {
       return id;
   }

   public void setDescricao(String descricao)
   {
       this.descricao = descricao;
   }
 
   public String getDescricao()
   {
       return descricao;
   }

   public void setFoto_id(int foto_id)
   {
       this.foto_id = foto_id;
   }
 
   public int getFoto_id()
   {
       return foto_id;
   }

   public void setInativo(boolean inativo)
   {
       this.inativo = inativo;
   }
 
   public boolean isInativo()
   {
       return inativo;
   }
}