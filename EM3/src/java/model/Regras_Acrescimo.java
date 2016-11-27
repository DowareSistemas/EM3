
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

public class Regras_Acrescimo extends Entity 
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
   private BigDecimal acrescimo_perc; 
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

   public void setGrupo_clientes_Id(int grupo_clientes_id)
   {
       this.grupo_clientes_id = grupo_clientes_id;
   }
 
   public int getGrupo_clientes_Id()
   {
       return grupo_clientes_id;
   }

   public void setCliente_Id(int cliente_id)
   {
       this.cliente_id = cliente_id;
   }
 
   public int getCliente_Id()
   {
       return cliente_id;
   }

   public void setTabela_preco_Id(int tabela_preco_id)
   {
       this.tabela_preco_id = tabela_preco_id;
   }
 
   public int getTabela_preco_Id()
   {
       return tabela_preco_id;
   }

   public void setTipo_movimento_Id(int tipo_movimento_id)
   {
       this.tipo_movimento_id = tipo_movimento_id;
   }
 
   public int getTipo_movimento_Id()
   {
       return tipo_movimento_id;
   }

   public void setForma_pagamento_Id(int forma_pagamento_id)
   {
       this.forma_pagamento_id = forma_pagamento_id;
   }
 
   public int getForma_pagamento_Id()
   {
       return forma_pagamento_id;
   }

   public void setFaixa_Valores(BigDecimal faixa_valores)
   {
       this.faixa_valores = faixa_valores;
   }
 
   public BigDecimal getFaixa_Valores()
   {
       return faixa_valores;
   }

   public void setTipo_faixa_Vlr(int tipo_faixa_vlr)
   {
       this.tipo_faixa_vlr = tipo_faixa_vlr;
   }
 
   public int getTipo_faixa_Vlr()
   {
       return tipo_faixa_vlr;
   }

   public void setAcrescimo_Perc(BigDecimal acrescimo_perc)
   {
       this.acrescimo_perc = acrescimo_perc;
   }
 
   public BigDecimal getAcrescimo_Perc()
   {
       return acrescimo_perc;
   }

   public void setInativo(boolean inativo)
   {
       this.inativo = inativo;
   }
 
   public boolean isInativo()
   {
       return inativo;
   }

   public void setData_Final(String data_final)
   {
       this.data_final = data_final;
   }
 
   public String getData_Final()
   {
       return data_final;
   }
}