
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

public class Lotes extends Entity 
{
   private int id; 
   private String lote; 
   private String data_fabricacao; 
   private String data_vencimento; 

   public void setId(int id)
   {
       this.id = id;
   }
 
   @PrimaryKey(increment = INCREMENT.MANUAL)
   public int getId()
   {
       return id;
   }

   public void setLote(String lote)
   {
       this.lote = lote;
   }
 
   public String getLote()
   {
       return lote;
   }

   public void setData_fabricacao(String data_fabricacao)
   {
       this.data_fabricacao = data_fabricacao;
   }
 
   public String getData_fabricacao()
   {
       return data_fabricacao;
   }

   public void setData_vencimento(String data_vencimento)
   {
       this.data_vencimento = data_vencimento;
   }
 
   public String getData_vencimento()
   {
       return data_vencimento;
   }
}