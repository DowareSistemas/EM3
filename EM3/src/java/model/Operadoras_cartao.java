
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

public class Operadoras_cartao extends Entity 
{
   private int id; 
   private String nome; 
   private int credito_dias_recebimento; 
   private int debito_horas_recebimento; 
   private BigDecimal taxa; 

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

   public void setCredito_dias_recebimento(int credito_dias_recebimento)
   {
       this.credito_dias_recebimento = credito_dias_recebimento;
   }
 
   public int getCredito_dias_recebimento()
   {
       return credito_dias_recebimento;
   }

   public void setDebito_horas_recebimento(int debito_horas_recebimento)
   {
       this.debito_horas_recebimento = debito_horas_recebimento;
   }
 
   public int getDebito_horas_recebimento()
   {
       return debito_horas_recebimento;
   }

   public void setTaxa(BigDecimal taxa)
   {
       this.taxa = taxa;
   }
 
   public BigDecimal getTaxa()
   {
       return taxa;
   }
}