
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

public class Parcelas extends Entity 
{
   private int id; 
   private int tipo; 
   private String parcela_numero; 
   private int plano_conta_id; 
   private Plano_contas plano_contas; 
   private int forma_pagamento_id; 
   private Formas_pagamento formas_pagamento; 
   private int conta_bancaria_id; 
   private int operadora_cartao_id; 
   private int cheque_numero; 
   private String data_emissao; 
   private String data_vencimento; 
   private BigDecimal valor; 
   private boolean pago; 
   private int movimento_id; 

   public void setId(int id)
   {
       this.id = id;
   }
 
   @PrimaryKey(increment = INCREMENT.MANUAL)
   public int getId()
   {
       return id;
   }

   public void setTipo(int tipo)
   {
       this.tipo = tipo;
   }
 
   public int getTipo()
   {
       return tipo;
   }

   public void setParcela_numero(String parcela_numero)
   {
       this.parcela_numero = parcela_numero;
   }
 
   public String getParcela_numero()
   {
       return parcela_numero;
   }

 
   public void setPlano_contas(Plano_contas plano_contas)
   {
       this.plano_contas = plano_contas;
   }
   public void setPlano_conta_id(int plano_conta_id)
   {
       this.plano_conta_id = plano_conta_id;
   }
 
   public int getPlano_conta_id()
   {
       return plano_conta_id;
   }

   @OneToOne(source = "plano_conta_id", target = "id" , load = LOAD.AUTO, join_type = JOIN_TYPE.INNER)
   public Plano_contas getPlano_contas()
   {
       return plano_contas;
   }

 
   public void setFormas_pagamento(Formas_pagamento formas_pagamento)
   {
       this.formas_pagamento = formas_pagamento;
   }
   public void setForma_pagamento_id(int forma_pagamento_id)
   {
       this.forma_pagamento_id = forma_pagamento_id;
   }
 
   public int getForma_pagamento_id()
   {
       return forma_pagamento_id;
   }

   @OneToOne(source = "forma_pagamento_id", target = "id" , load = LOAD.AUTO, join_type = JOIN_TYPE.INNER)
   public Formas_pagamento getFormas_pagamento()
   {
       return formas_pagamento;
   }

   public void setConta_bancaria_id(int conta_bancaria_id)
   {
       this.conta_bancaria_id = conta_bancaria_id;
   }
 
   public int getConta_bancaria_id()
   {
       return conta_bancaria_id;
   }

   public void setOperadora_cartao_id(int operadora_cartao_id)
   {
       this.operadora_cartao_id = operadora_cartao_id;
   }
 
   public int getOperadora_cartao_id()
   {
       return operadora_cartao_id;
   }

   public void setCheque_numero(int cheque_numero)
   {
       this.cheque_numero = cheque_numero;
   }
 
   public int getCheque_numero()
   {
       return cheque_numero;
   }

   public void setData_emissao(String data_emissao)
   {
       this.data_emissao = data_emissao;
   }
 
   public String getData_emissao()
   {
       return data_emissao;
   }

   public void setData_vencimento(String data_vencimento)
   {
       this.data_vencimento = data_vencimento;
   }
 
   public String getData_vencimento()
   {
       return data_vencimento;
   }

   public void setValor(BigDecimal valor)
   {
       this.valor = valor;
   }
 
   public BigDecimal getValor()
   {
       return valor;
   }

   public void setPago(boolean pago)
   {
       this.pago = pago;
   }
 
   public boolean isPago()
   {
       return pago;
   }

   public void setMovimento_id(int movimento_id)
   {
       this.movimento_id = movimento_id;
   }
 
   public int getMovimento_id()
   {
       return movimento_id;
   }
}