
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

public class Produtos extends Entity 
{
   private int id; 
   private String ean; 
   private String referencia; 
   private String descricao; 
   private String ncm; 
   private String anp; 
   private String data_cadastro; 
   private String ultima_alteracao; 
   private boolean fabricado; 
   private boolean insumo; 
   private boolean fracionado; 
   private boolean inativo; 
   private boolean para_balanca; 
   private String marca; 
   private String fabricante; 
   private String cod_fabricante; 
   private int unidade1; 
   private Unidades unidades; 
   private int fator_conversao; 
   private int unidade2; 
   private BigDecimal custo_medio; 
   private int classes_imposto_id; 
   private int cest_id; 

   public void setId(int id)
   {
       this.id = id;
   }
 
   @PrimaryKey(increment = INCREMENT.MANUAL)
   public int getId()
   {
       return id;
   }

   public void setEan(String ean)
   {
       this.ean = ean;
   }
 
   public String getEan()
   {
       return ean;
   }

   public void setReferencia(String referencia)
   {
       this.referencia = referencia;
   }
 
   public String getReferencia()
   {
       return referencia;
   }

   public void setDescricao(String descricao)
   {
       this.descricao = descricao;
   }
 
   public String getDescricao()
   {
       return descricao;
   }

   public void setNcm(String ncm)
   {
       this.ncm = ncm;
   }
 
   public String getNcm()
   {
       return ncm;
   }

   public void setAnp(String anp)
   {
       this.anp = anp;
   }
 
   public String getAnp()
   {
       return anp;
   }

   public void setData_cadastro(String data_cadastro)
   {
       this.data_cadastro = data_cadastro;
   }
 
   public String getData_cadastro()
   {
       return data_cadastro;
   }

   public void setUltima_alteracao(String ultima_alteracao)
   {
       this.ultima_alteracao = ultima_alteracao;
   }
 
   public String getUltima_alteracao()
   {
       return ultima_alteracao;
   }

   public void setFabricado(boolean fabricado)
   {
       this.fabricado = fabricado;
   }
 
   public boolean isFabricado()
   {
       return fabricado;
   }

   public void setInsumo(boolean insumo)
   {
       this.insumo = insumo;
   }
 
   public boolean isInsumo()
   {
       return insumo;
   }

   public void setFracionado(boolean fracionado)
   {
       this.fracionado = fracionado;
   }
 
   public boolean isFracionado()
   {
       return fracionado;
   }

   public void setInativo(boolean inativo)
   {
       this.inativo = inativo;
   }
 
   public boolean isInativo()
   {
       return inativo;
   }

   public void setPara_balanca(boolean para_balanca)
   {
       this.para_balanca = para_balanca;
   }
 
   public boolean isPara_balanca()
   {
       return para_balanca;
   }

   public void setMarca(String marca)
   {
       this.marca = marca;
   }
 
   public String getMarca()
   {
       return marca;
   }

   public void setFabricante(String fabricante)
   {
       this.fabricante = fabricante;
   }
 
   public String getFabricante()
   {
       return fabricante;
   }

   public void setCod_fabricante(String cod_fabricante)
   {
       this.cod_fabricante = cod_fabricante;
   }
 
   public String getCod_fabricante()
   {
       return cod_fabricante;
   }

 
   public void setUnidades(Unidades unidades)
   {
       this.unidades = unidades;
   }
   public void setUnidade1(int unidade1)
   {
       this.unidade1 = unidade1;
   }
 
   public int getUnidade1()
   {
       return unidade1;
   }

   @OneToOne(source = "unidade1", target = "id" , load = LOAD.AUTO, join_type = JOIN_TYPE.INNER)
   public Unidades getUnidades()
   {
       return unidades;
   }

   public void setFator_conversao(int fator_conversao)
   {
       this.fator_conversao = fator_conversao;
   }
 
   public int getFator_conversao()
   {
       return fator_conversao;
   }

   public void setUnidade2(int unidade2)
   {
       this.unidade2 = unidade2;
   }
 
   public int getUnidade2()
   {
       return unidade2;
   }

   public void setCusto_medio(BigDecimal custo_medio)
   {
       this.custo_medio = custo_medio;
   }
 
   public BigDecimal getCusto_medio()
   {
       return custo_medio;
   }

   public void setClasses_imposto_id(int classes_imposto_id)
   {
       this.classes_imposto_id = classes_imposto_id;
   }
 
   public int getClasses_imposto_id()
   {
       return classes_imposto_id;
   }

   public void setCest_id(int cest_id)
   {
       this.cest_id = cest_id;
   }
 
   public int getCest_id()
   {
       return cest_id;
   }
}