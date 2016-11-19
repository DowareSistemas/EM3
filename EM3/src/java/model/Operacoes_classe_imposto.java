
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

public class Operacoes_classe_imposto extends Entity 
{
   private int id; 
   private String icms_cst; 
   private BigDecimal icms_perc; 
   private BigDecimal icms_perc_st; 
   private BigDecimal icms_mva; 
   private String impressora_fiscal_tipo; 
   private BigDecimal impressora_fiscal_perc; 
   private String pis_cofins_tipo; 
   private BigDecimal pis_perc; 
   private BigDecimal pis_perc_st; 
   private BigDecimal cofins_perc; 
   private BigDecimal cofins_perc_st; 
   private BigDecimal perc_credito_icms; 
   private int classe_imposto_id; 
   private Classes_imposto classes_imposto; 
   private int tipos_movimento_id; 
   private Tipos_movimento tipos_movimento; 
   private int cfop_id; 
   private Cfop cfop; 

   public void setId(int id)
   {
       this.id = id;
   }
 
   @PrimaryKey(increment = INCREMENT.MANUAL)
   public int getId()
   {
       return id;
   }

   public void setIcms_cst(String icms_cst)
   {
       this.icms_cst = icms_cst;
   }
 
   public String getIcms_cst()
   {
       return icms_cst;
   }

   public void setIcms_perc(BigDecimal icms_perc)
   {
       this.icms_perc = icms_perc;
   }
 
   public BigDecimal getIcms_perc()
   {
       return icms_perc;
   }

   public void setIcms_perc_st(BigDecimal icms_perc_st)
   {
       this.icms_perc_st = icms_perc_st;
   }
 
   public BigDecimal getIcms_perc_st()
   {
       return icms_perc_st;
   }

   public void setIcms_mva(BigDecimal icms_mva)
   {
       this.icms_mva = icms_mva;
   }
 
   public BigDecimal getIcms_mva()
   {
       return icms_mva;
   }

   public void setImpressora_fiscal_tipo(String impressora_fiscal_tipo)
   {
       this.impressora_fiscal_tipo = impressora_fiscal_tipo;
   }
 
   public String getImpressora_fiscal_tipo()
   {
       return impressora_fiscal_tipo;
   }

   public void setImpressora_fiscal_perc(BigDecimal impressora_fiscal_perc)
   {
       this.impressora_fiscal_perc = impressora_fiscal_perc;
   }
 
   public BigDecimal getImpressora_fiscal_perc()
   {
       return impressora_fiscal_perc;
   }

   public void setPis_cofins_tipo(String pis_cofins_tipo)
   {
       this.pis_cofins_tipo = pis_cofins_tipo;
   }
 
   public String getPis_cofins_tipo()
   {
       return pis_cofins_tipo;
   }

   public void setPis_perc(BigDecimal pis_perc)
   {
       this.pis_perc = pis_perc;
   }
 
   public BigDecimal getPis_perc()
   {
       return pis_perc;
   }

   public void setPis_perc_st(BigDecimal pis_perc_st)
   {
       this.pis_perc_st = pis_perc_st;
   }
 
   public BigDecimal getPis_perc_st()
   {
       return pis_perc_st;
   }

   public void setCofins_perc(BigDecimal cofins_perc)
   {
       this.cofins_perc = cofins_perc;
   }
 
   public BigDecimal getCofins_perc()
   {
       return cofins_perc;
   }

   public void setCofins_perc_st(BigDecimal cofins_perc_st)
   {
       this.cofins_perc_st = cofins_perc_st;
   }
 
   public BigDecimal getCofins_perc_st()
   {
       return cofins_perc_st;
   }

   public void setPerc_credito_icms(BigDecimal perc_credito_icms)
   {
       this.perc_credito_icms = perc_credito_icms;
   }
 
   public BigDecimal getPerc_credito_icms()
   {
       return perc_credito_icms;
   }

 
   public void setClasses_imposto(Classes_imposto classes_imposto)
   {
       this.classes_imposto = classes_imposto;
   }
   public void setClasse_imposto_id(int classe_imposto_id)
   {
       this.classe_imposto_id = classe_imposto_id;
   }
 
   public int getClasse_imposto_id()
   {
       return classe_imposto_id;
   }

   @OneToOne(source = "classe_imposto_id", target = "id" , load = LOAD.AUTO, join_type = JOIN_TYPE.INNER)
   public Classes_imposto getClasses_imposto()
   {
       return classes_imposto;
   }

 
   public void setTipos_movimento(Tipos_movimento tipos_movimento)
   {
       this.tipos_movimento = tipos_movimento;
   }
   public void setTipos_movimento_id(int tipos_movimento_id)
   {
       this.tipos_movimento_id = tipos_movimento_id;
   }
 
   public int getTipos_movimento_id()
   {
       return tipos_movimento_id;
   }

   @OneToOne(source = "tipos_movimento_id", target = "id" , load = LOAD.AUTO, join_type = JOIN_TYPE.INNER)
   public Tipos_movimento getTipos_movimento()
   {
       return tipos_movimento;
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
}