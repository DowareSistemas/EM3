
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Persistor4J
 */ 

public class Caracteristicas extends Entity 
{
   private int id; 
   
   @NotNull(message = "O atributo é obrigatório")
   @NotEmpty(message = "O atributo é obrigatório")
   @Size(max = 100, message = "O atributo não pode ter mais de 100 caracteres")
   private String atributo; 
   
   @NotNull(message = "O valor do atributo é obrigatório")
   @NotEmpty(message = "O valor do atributo é obrigatório")
   @Size(max = 100, message = "O valor não pode ter mais de 100 caracteres")
   private String valor; 

   public void setId(int id)
   {
       this.id = id;
   }
 
   @PrimaryKey(increment = INCREMENT.MANUAL)
   public int getId()
   {
       return id;
   }

   public void setAtributo(String atributo)
   {
       this.atributo = atributo;
   }
 
   public String getAtributo()
   {
       return atributo;
   }

   public void setValor(String valor)
   {
       this.valor = valor;
   }
 
   public String getValor()
   {
       return valor;
   }
}