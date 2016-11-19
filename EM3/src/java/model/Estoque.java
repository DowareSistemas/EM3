
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

public class Estoque extends Entity 
{
   private int id; 
   private int produto_id; 
   private Produtos produtos; 
   private int local_estoque_id; 
   private Locais_estoque locais_estoque; 
   private BigDecimal quant; 

   public void setId(int id)
   {
       this.id = id;
   }
 
   @PrimaryKey(increment = INCREMENT.MANUAL)
   public int getId()
   {
       return id;
   }

 
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

 
   public void setLocais_estoque(Locais_estoque locais_estoque)
   {
       this.locais_estoque = locais_estoque;
   }
   public void setLocal_estoque_id(int local_estoque_id)
   {
       this.local_estoque_id = local_estoque_id;
   }
 
   public int getLocal_estoque_id()
   {
       return local_estoque_id;
   }

   @OneToOne(source = "local_estoque_id", target = "id" , load = LOAD.AUTO, join_type = JOIN_TYPE.INNER)
   public Locais_estoque getLocais_estoque()
   {
       return locais_estoque;
   }

   public void setQuant(BigDecimal quant)
   {
       this.quant = quant;
   }
 
   public BigDecimal getQuant()
   {
       return quant;
   }
}