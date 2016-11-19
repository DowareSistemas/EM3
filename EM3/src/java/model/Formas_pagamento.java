
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

public class Formas_pagamento extends Entity 
{
   private int id; 
   private String descricao; 
   private int tipo_pagamento; 
   private int banco_id; 
   private int operadora_cartao_id; 
   private boolean permite_entrada; 
   private int dia_base; 
   private int maximo_parcelas; 

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

   public void setTipo_pagamento(int tipo_pagamento)
   {
       this.tipo_pagamento = tipo_pagamento;
   }
 
   public int getTipo_pagamento()
   {
       return tipo_pagamento;
   }

   public void setBanco_id(int banco_id)
   {
       this.banco_id = banco_id;
   }
 
   public int getBanco_id()
   {
       return banco_id;
   }

   public void setOperadora_cartao_id(int operadora_cartao_id)
   {
       this.operadora_cartao_id = operadora_cartao_id;
   }
 
   public int getOperadora_cartao_id()
   {
       return operadora_cartao_id;
   }

   public void setPermite_entrada(boolean permite_entrada)
   {
       this.permite_entrada = permite_entrada;
   }
 
   public boolean isPermite_entrada()
   {
       return permite_entrada;
   }

   public void setDia_base(int dia_base)
   {
       this.dia_base = dia_base;
   }
 
   public int getDia_base()
   {
       return dia_base;
   }

   public void setMaximo_parcelas(int maximo_parcelas)
   {
       this.maximo_parcelas = maximo_parcelas;
   }
 
   public int getMaximo_parcelas()
   {
       return maximo_parcelas;
   }
}