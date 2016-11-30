
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

public class Regras_desconto extends Entity 
{
   private int id; 
   private String descricao; 
   private int grupo_clientes_id; 
   private int cliente_id; 
   private int tabela_preco_id; 
   private int tipo_movimento_id; 
   private int forma_pagamento_id; 
   private BigDecimal faixa_valores; 
   private int tipo_faixa_vlr; 
   private BigDecimal desconto_perc; 
   private boolean inativo; 
   private String data_final; 

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

   public void setGrupo_clientes_id(int grupo_clientes_id)
   {
       this.grupo_clientes_id = grupo_clientes_id;
   }
 
   public int getGrupo_clientes_id()
   {
       return grupo_clientes_id;
   }

   public void setCliente_id(int cliente_id)
   {
       this.cliente_id = cliente_id;
   }
 
   public int getCliente_id()
   {
       return cliente_id;
   }

   public void setTabela_preco_id(int tabela_preco_id)
   {
       this.tabela_preco_id = tabela_preco_id;
   }
 
   public int getTabela_preco_id()
   {
       return tabela_preco_id;
   }

   public void setTipo_movimento_id(int tipo_movimento_id)
   {
       this.tipo_movimento_id = tipo_movimento_id;
   }
 
   public int getTipo_movimento_id()
   {
       return tipo_movimento_id;
   }

   public void setForma_pagamento_id(int forma_pagamento_id)
   {
       this.forma_pagamento_id = forma_pagamento_id;
   }
 
   public int getForma_pagamento_id()
   {
       return forma_pagamento_id;
   }

   public void setFaixa_valores(BigDecimal faixa_valores)
   {
       this.faixa_valores = faixa_valores;
   }
 
   public BigDecimal getFaixa_valores()
   {
       return faixa_valores;
   }

   public void setTipo_faixa_vlr(int tipo_faixa_vlr)
   {
       this.tipo_faixa_vlr = tipo_faixa_vlr;
   }
 
   public int getTipo_faixa_vlr()
   {
       return tipo_faixa_vlr;
   }

   public void setDesconto_perc(BigDecimal desconto_perc)
   {
       this.desconto_perc = desconto_perc;
   }
 
   public BigDecimal getDesconto_perc()
   {
       return desconto_perc;
   }

   public void setInativo(boolean inativo)
   {
       this.inativo = inativo;
   }
 
   public boolean isInativo()
   {
       return inativo;
   }

   public void setData_final(String data_final)
   {
       this.data_final = data_final;
   }
 
   public String getData_final()
   {
       return data_final;
   }
}