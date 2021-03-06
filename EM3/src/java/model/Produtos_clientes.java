
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

public class Produtos_clientes extends Entity 
{
   private int produto_id; 
   private Produtos produtos; 
   private int cliente_id; 
   private Clientes clientes; 

 
   public void setProdutos(Produtos produtos)
   {
       this.produtos = produtos;
   }
   public void setProduto_id(int produto_id)
   {
       this.produto_id = produto_id;
   }
 
   public int getProduto_id()
   {
       return produto_id;
   }

   @OneToOne(source = "produto_id", target = "id" , load = LOAD.AUTO, join_type = JOIN_TYPE.INNER)
   public Produtos getProdutos()
   {
       return produtos;
   }

 
   public void setClientes(Clientes clientes)
   {
       this.clientes = clientes;
   }
   public void setCliente_id(int cliente_id)
   {
       this.cliente_id = cliente_id;
   }
 
   public int getCliente_id()
   {
       return cliente_id;
   }

   @OneToOne(source = "cliente_id", target = "id" , load = LOAD.AUTO, join_type = JOIN_TYPE.INNER)
   public Clientes getClientes()
   {
       return clientes;
   }
}