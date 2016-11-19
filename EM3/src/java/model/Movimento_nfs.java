
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

public class Movimento_nfs extends Entity 
{
   private int id; 
   private String chave_acesso; 
   private int tipo_documento; 
   private int tipo_emissao; 
   private int modelo; 
   private int serie; 
   private int lote; 
   private String data_emissao; 
   private int ambiente; 
   private String protocolo_autorizacao; 
   private String protocolo_denegado; 
   private int codigo_status; 
   private String descricao_status; 
   private String data_autorizacao; 
   private boolean cancelado; 
   private String data_cancelamento; 
   private String protocolo_cancelamento; 
   private boolean inutilizadado; 
   private String data_inutilizacao; 

   public void setId(int id)
   {
       this.id = id;
   }
 
   @PrimaryKey(increment = INCREMENT.MANUAL)
   public int getId()
   {
       return id;
   }

   public void setChave_acesso(String chave_acesso)
   {
       this.chave_acesso = chave_acesso;
   }
 
   public String getChave_acesso()
   {
       return chave_acesso;
   }

   public void setTipo_documento(int tipo_documento)
   {
       this.tipo_documento = tipo_documento;
   }
 
   public int getTipo_documento()
   {
       return tipo_documento;
   }

   public void setTipo_emissao(int tipo_emissao)
   {
       this.tipo_emissao = tipo_emissao;
   }
 
   public int getTipo_emissao()
   {
       return tipo_emissao;
   }

   public void setModelo(int modelo)
   {
       this.modelo = modelo;
   }
 
   public int getModelo()
   {
       return modelo;
   }

   public void setSerie(int serie)
   {
       this.serie = serie;
   }
 
   public int getSerie()
   {
       return serie;
   }

   public void setLote(int lote)
   {
       this.lote = lote;
   }
 
   public int getLote()
   {
       return lote;
   }

   public void setData_emissao(String data_emissao)
   {
       this.data_emissao = data_emissao;
   }
 
   public String getData_emissao()
   {
       return data_emissao;
   }

   public void setAmbiente(int ambiente)
   {
       this.ambiente = ambiente;
   }
 
   public int getAmbiente()
   {
       return ambiente;
   }

   public void setProtocolo_autorizacao(String protocolo_autorizacao)
   {
       this.protocolo_autorizacao = protocolo_autorizacao;
   }
 
   public String getProtocolo_autorizacao()
   {
       return protocolo_autorizacao;
   }

   public void setProtocolo_denegado(String protocolo_denegado)
   {
       this.protocolo_denegado = protocolo_denegado;
   }
 
   public String getProtocolo_denegado()
   {
       return protocolo_denegado;
   }

   public void setCodigo_status(int codigo_status)
   {
       this.codigo_status = codigo_status;
   }
 
   public int getCodigo_status()
   {
       return codigo_status;
   }

   public void setDescricao_status(String descricao_status)
   {
       this.descricao_status = descricao_status;
   }
 
   public String getDescricao_status()
   {
       return descricao_status;
   }

   public void setData_autorizacao(String data_autorizacao)
   {
       this.data_autorizacao = data_autorizacao;
   }
 
   public String getData_autorizacao()
   {
       return data_autorizacao;
   }

   public void setCancelado(boolean cancelado)
   {
       this.cancelado = cancelado;
   }
 
   public boolean isCancelado()
   {
       return cancelado;
   }

   public void setData_cancelamento(String data_cancelamento)
   {
       this.data_cancelamento = data_cancelamento;
   }
 
   public String getData_cancelamento()
   {
       return data_cancelamento;
   }

   public void setProtocolo_cancelamento(String protocolo_cancelamento)
   {
       this.protocolo_cancelamento = protocolo_cancelamento;
   }
 
   public String getProtocolo_cancelamento()
   {
       return protocolo_cancelamento;
   }

   public void setInutilizadado(boolean inutilizadado)
   {
       this.inutilizadado = inutilizadado;
   }
 
   public boolean isInutilizadado()
   {
       return inutilizadado;
   }

   public void setData_inutilizacao(String data_inutilizacao)
   {
       this.data_inutilizacao = data_inutilizacao;
   }
 
   public String getData_inutilizacao()
   {
       return data_inutilizacao;
   }
}