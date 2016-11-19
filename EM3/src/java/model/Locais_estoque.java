
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

public class Locais_estoque extends Entity 
{
   private int id; 
   private String nome; 
   private int armazem_id; 
   private Armazens armazens; 

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

 
   public void setArmazens(Armazens armazens)
   {
       this.armazens = armazens;
   }
   public void setArmazem_id(int armazem_id)
   {
       this.armazem_id = armazem_id;
   }
 
   public int getArmazem_id()
   {
       return armazem_id;
   }

   @OneToOne(source = "armazem_id", target = "id" , load = LOAD.AUTO, join_type = JOIN_TYPE.INNER)
   public Armazens getArmazens()
   {
       return armazens;
   }
}