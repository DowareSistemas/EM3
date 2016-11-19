
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

public class Itens_movimento extends Entity 
{
   private int id; 
   private int movimento_id; 
   private Movimentos movimentos; 
   private int tipo_item; 
   private int produto_id; 
   private int servico_id; 
   private BigDecimal quant; 
   private BigDecimal valor_unit; 
   private BigDecimal base_icms; 
   private BigDecimal total_icms; 
   private BigDecimal base_icms_st; 
   private BigDecimal total_icms_st; 
   private BigDecimal icms_mva; 
   private BigDecimal base_ipi; 
   private BigDecimal total_ipi; 
   private BigDecimal base_pis; 
   private BigDecimal total_pis; 
   private BigDecimal base_cofins; 
   private BigDecimal total_cofins; 
   private int cfop_id; 
   private Cfop cfop; 
   private int icms_perc; 
   private int icms_perc_st; 
   private int cred_icms_perc; 
   private int total_cred_icms; 
   private BigDecimal desconto_perc; 
   private BigDecimal desconto_valor; 
   private BigDecimal comissao; 
   private int funcionario_id; 
   private BigDecimal valor_total; 

   public void setId(int id)
   {
       this.id = id;
   }
 
   @PrimaryKey(increment = INCREMENT.MANUAL)
   public int getId()
   {
       return id;
   }

 
   public void setMovimentos(Movimentos movimentos)
   {
       this.movimentos = movimentos;
   }
   public void setMovimento_id(int movimento_id)
   {
       this.movimento_id = movimento_id;
   }
 
   public int getMovimento_id()
   {
       return movimento_id;
   }

   @OneToOne(source = "movimento_id", target = "id" , load = LOAD.AUTO, join_type = JOIN_TYPE.INNER)
   public Movimentos getMovimentos()
   {
       return movimentos;
   }

   public void setTipo_item(int tipo_item)
   {
       this.tipo_item = tipo_item;
   }
 
   public int getTipo_item()
   {
       return tipo_item;
   }

   public void setProduto_id(int produto_id)
   {
       this.produto_id = produto_id;
   }
 
   public int getProduto_id()
   {
       return produto_id;
   }

   public void setServico_id(int servico_id)
   {
       this.servico_id = servico_id;
   }
 
   public int getServico_id()
   {
       return servico_id;
   }

   public void setQuant(BigDecimal quant)
   {
       this.quant = quant;
   }
 
   public BigDecimal getQuant()
   {
       return quant;
   }

   public void setValor_unit(BigDecimal valor_unit)
   {
       this.valor_unit = valor_unit;
   }
 
   public BigDecimal getValor_unit()
   {
       return valor_unit;
   }

   public void setBase_icms(BigDecimal base_icms)
   {
       this.base_icms = base_icms;
   }
 
   public BigDecimal getBase_icms()
   {
       return base_icms;
   }

   public void setTotal_icms(BigDecimal total_icms)
   {
       this.total_icms = total_icms;
   }
 
   public BigDecimal getTotal_icms()
   {
       return total_icms;
   }

   public void setBase_icms_st(BigDecimal base_icms_st)
   {
       this.base_icms_st = base_icms_st;
   }
 
   public BigDecimal getBase_icms_st()
   {
       return base_icms_st;
   }

   public void setTotal_icms_st(BigDecimal total_icms_st)
   {
       this.total_icms_st = total_icms_st;
   }
 
   public BigDecimal getTotal_icms_st()
   {
       return total_icms_st;
   }

   public void setIcms_mva(BigDecimal icms_mva)
   {
       this.icms_mva = icms_mva;
   }
 
   public BigDecimal getIcms_mva()
   {
       return icms_mva;
   }

   public void setBase_ipi(BigDecimal base_ipi)
   {
       this.base_ipi = base_ipi;
   }
 
   public BigDecimal getBase_ipi()
   {
       return base_ipi;
   }

   public void setTotal_ipi(BigDecimal total_ipi)
   {
       this.total_ipi = total_ipi;
   }
 
   public BigDecimal getTotal_ipi()
   {
       return total_ipi;
   }

   public void setBase_pis(BigDecimal base_pis)
   {
       this.base_pis = base_pis;
   }
 
   public BigDecimal getBase_pis()
   {
       return base_pis;
   }

   public void setTotal_pis(BigDecimal total_pis)
   {
       this.total_pis = total_pis;
   }
 
   public BigDecimal getTotal_pis()
   {
       return total_pis;
   }

   public void setBase_cofins(BigDecimal base_cofins)
   {
       this.base_cofins = base_cofins;
   }
 
   public BigDecimal getBase_cofins()
   {
       return base_cofins;
   }

   public void setTotal_cofins(BigDecimal total_cofins)
   {
       this.total_cofins = total_cofins;
   }
 
   public BigDecimal getTotal_cofins()
   {
       return total_cofins;
   }

 
   public void setCfop(Cfop cfop)
   {
       this.cfop = cfop;
   }
   public void setCfop_id(int cfop_id)
   {
       this.cfop_id = cfop_id;
   }
 
   public int getCfop_id()
   {
       return cfop_id;
   }

   @OneToOne(source = "cfop_id", target = "id" , load = LOAD.AUTO, join_type = JOIN_TYPE.INNER)
   public Cfop getCfop()
   {
       return cfop;
   }

   public void setIcms_perc(int icms_perc)
   {
       this.icms_perc = icms_perc;
   }
 
   public int getIcms_perc()
   {
       return icms_perc;
   }

   public void setIcms_perc_st(int icms_perc_st)
   {
       this.icms_perc_st = icms_perc_st;
   }
 
   public int getIcms_perc_st()
   {
       return icms_perc_st;
   }

   public void setCred_icms_perc(int cred_icms_perc)
   {
       this.cred_icms_perc = cred_icms_perc;
   }
 
   public int getCred_icms_perc()
   {
       return cred_icms_perc;
   }

   public void setTotal_cred_icms(int total_cred_icms)
   {
       this.total_cred_icms = total_cred_icms;
   }
 
   public int getTotal_cred_icms()
   {
       return total_cred_icms;
   }

   public void setDesconto_perc(BigDecimal desconto_perc)
   {
       this.desconto_perc = desconto_perc;
   }
 
   public BigDecimal getDesconto_perc()
   {
       return desconto_perc;
   }

   public void setDesconto_valor(BigDecimal desconto_valor)
   {
       this.desconto_valor = desconto_valor;
   }
 
   public BigDecimal getDesconto_valor()
   {
       return desconto_valor;
   }

   public void setComissao(BigDecimal comissao)
   {
       this.comissao = comissao;
   }
 
   public BigDecimal getComissao()
   {
       return comissao;
   }

   public void setFuncionario_id(int funcionario_id)
   {
       this.funcionario_id = funcionario_id;
   }
 
   public int getFuncionario_id()
   {
       return funcionario_id;
   }

   public void setValor_total(BigDecimal valor_total)
   {
       this.valor_total = valor_total;
   }
 
   public BigDecimal getValor_total()
   {
       return valor_total;
   }
}