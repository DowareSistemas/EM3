
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

public class Icms_ufs extends Entity 
{
   private int id; 
   private String uf_origem; 
   private String uf_destino; 
   private BigDecimal aliquota; 
   private BigDecimal fundo_combate_pobresa; 
   private String data_alteracao; 

   public void setId(int id)
   {
       this.id = id;
   }
 
   @PrimaryKey(increment = INCREMENT.MANUAL)
   public int getId()
   {
       return id;
   }

   public void setUf_origem(String uf_origem)
   {
       this.uf_origem = uf_origem;
   }
 
   public String getUf_origem()
   {
       return uf_origem;
   }

   public void setUf_destino(String uf_destino)
   {
       this.uf_destino = uf_destino;
   }
 
   public String getUf_destino()
   {
       return uf_destino;
   }

   public void setAliquota(BigDecimal aliquota)
   {
       this.aliquota = aliquota;
   }
 
   public BigDecimal getAliquota()
   {
       return aliquota;
   }

   public void setFundo_combate_pobresa(BigDecimal fundo_combate_pobresa)
   {
       this.fundo_combate_pobresa = fundo_combate_pobresa;
   }
 
   public BigDecimal getFundo_combate_pobresa()
   {
       return fundo_combate_pobresa;
   }

   public void setData_alteracao(String data_alteracao)
   {
       this.data_alteracao = data_alteracao;
   }
 
   public String getData_alteracao()
   {
       return data_alteracao;
   }
}