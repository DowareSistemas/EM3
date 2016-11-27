
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

public class Bloqueios_Clientes extends Entity 
{
   private int id; 
   private String data_bloqueio; 
   private String data_desbloqueio; 
   private int gatilho_desbloqueio; 
   private int cliente_id; 
   private Clientes clientes; 

   public void setId(int id)
   {
       this.id = id;
   }
 
   @PrimaryKey(increment = INCREMENT.MANUAL)
   public int getId()
   {
       return id;
   }

   public void setData_Bloqueio(String data_bloqueio)
   {
       this.data_bloqueio = data_bloqueio;
   }
 
   public String getData_Bloqueio()
   {
       return data_bloqueio;
   }

   public void setData_Desbloqueio(String data_desbloqueio)
   {
       this.data_desbloqueio = data_desbloqueio;
   }
 
   public String getData_Desbloqueio()
   {
       return data_desbloqueio;
   }

   public void setGatilho_Desbloqueio(int gatilho_desbloqueio)
   {
       this.gatilho_desbloqueio = gatilho_desbloqueio;
   }
 
   public int getGatilho_Desbloqueio()
   {
       return gatilho_desbloqueio;
   }

 
   public void setClientes(Clientes clientes)
   {
       this.clientes = clientes;
   }
   public void setCliente_Id(int cliente_id)
   {
       this.cliente_id = cliente_id;
   }
 
   public int getCliente_Id()
   {
       return cliente_id;
   }

   @OneToOne(source = "cliente_id", target = "id" , load = LOAD.AUTO, join_type = JOIN_TYPE.INNER)
   public Clientes getClientes()
   {
       return clientes;
   }
}