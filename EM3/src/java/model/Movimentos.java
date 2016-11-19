
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

public class Movimentos extends Entity 
{
   private int id; 
   private String data; 
   private boolean parcelado; 
   private boolean efetivado; 
   private String obs; 
   private BigDecimal valor_frete; 
   private BigDecimal base_icms; 
   private BigDecimal total_icms; 
   private BigDecimal base_icms_st; 
   private BigDecimal total_icms_st; 
   private BigDecimal base_pis; 
   private BigDecimal total_pis; 
   private BigDecimal base_cofins; 
   private BigDecimal total_cofins; 
   private BigDecimal base_ipi; 
   private BigDecimal total_ipi; 
   private BigDecimal despesa_acessoria; 
   private int fornecedor_id; 
   private int cliente_id; 
   private int transportadora_id; 
   private int nf_id; 
   private int usuario_id; 
   private Usuarios usuarios; 
   private int caixa_id; 
   private Caixas caixas; 
   private int empresa_id; 
   private Empresa empresa; 
   private int tipo_movimento_id; 
   private Tipos_movimento tipos_movimento; 

   public void setId(int id)
   {
       this.id = id;
   }
 
   @PrimaryKey(increment = INCREMENT.MANUAL)
   public int getId()
   {
       return id;
   }

   public void setData(String data)
   {
       this.data = data;
   }
 
   public String getData()
   {
       return data;
   }

   public void setParcelado(boolean parcelado)
   {
       this.parcelado = parcelado;
   }
 
   public boolean isParcelado()
   {
       return parcelado;
   }

   public void setEfetivado(boolean efetivado)
   {
       this.efetivado = efetivado;
   }
 
   public boolean isEfetivado()
   {
       return efetivado;
   }

   public void setObs(String obs)
   {
       this.obs = obs;
   }
 
   public String getObs()
   {
       return obs;
   }

   public void setValor_frete(BigDecimal valor_frete)
   {
       this.valor_frete = valor_frete;
   }
 
   public BigDecimal getValor_frete()
   {
       return valor_frete;
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

   public void setDespesa_acessoria(BigDecimal despesa_acessoria)
   {
       this.despesa_acessoria = despesa_acessoria;
   }
 
   public BigDecimal getDespesa_acessoria()
   {
       return despesa_acessoria;
   }

   public void setFornecedor_id(int fornecedor_id)
   {
       this.fornecedor_id = fornecedor_id;
   }
 
   public int getFornecedor_id()
   {
       return fornecedor_id;
   }

   public void setCliente_id(int cliente_id)
   {
       this.cliente_id = cliente_id;
   }
 
   public int getCliente_id()
   {
       return cliente_id;
   }

   public void setTransportadora_id(int transportadora_id)
   {
       this.transportadora_id = transportadora_id;
   }
 
   public int getTransportadora_id()
   {
       return transportadora_id;
   }

   public void setNf_id(int nf_id)
   {
       this.nf_id = nf_id;
   }
 
   public int getNf_id()
   {
       return nf_id;
   }

 
   public void setUsuarios(Usuarios usuarios)
   {
       this.usuarios = usuarios;
   }
   public void setUsuario_id(int usuario_id)
   {
       this.usuario_id = usuario_id;
   }
 
   public int getUsuario_id()
   {
       return usuario_id;
   }

   @OneToOne(source = "usuario_id", target = "id" , load = LOAD.AUTO, join_type = JOIN_TYPE.INNER)
   public Usuarios getUsuarios()
   {
       return usuarios;
   }

 
   public void setCaixas(Caixas caixas)
   {
       this.caixas = caixas;
   }
   public void setCaixa_id(int caixa_id)
   {
       this.caixa_id = caixa_id;
   }
 
   public int getCaixa_id()
   {
       return caixa_id;
   }

   @OneToOne(source = "caixa_id", target = "id" , load = LOAD.AUTO, join_type = JOIN_TYPE.INNER)
   public Caixas getCaixas()
   {
       return caixas;
   }

 
   public void setEmpresa(Empresa empresa)
   {
       this.empresa = empresa;
   }
   public void setEmpresa_id(int empresa_id)
   {
       this.empresa_id = empresa_id;
   }
 
   public int getEmpresa_id()
   {
       return empresa_id;
   }

   @OneToOne(source = "empresa_id", target = "id" , load = LOAD.AUTO, join_type = JOIN_TYPE.INNER)
   public Empresa getEmpresa()
   {
       return empresa;
   }

 
   public void setTipos_movimento(Tipos_movimento tipos_movimento)
   {
       this.tipos_movimento = tipos_movimento;
   }
   public void setTipo_movimento_id(int tipo_movimento_id)
   {
       this.tipo_movimento_id = tipo_movimento_id;
   }
 
   public int getTipo_movimento_id()
   {
       return tipo_movimento_id;
   }

   @OneToOne(source = "tipo_movimento_id", target = "id" , load = LOAD.AUTO, join_type = JOIN_TYPE.INNER)
   public Tipos_movimento getTipos_movimento()
   {
       return tipos_movimento;
   }
}