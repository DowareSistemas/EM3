
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

public class Permissoes extends Entity 
{
   private int usuarios_id; 
   private String telas_id; 
   private Telas telas; 
   private boolean acesso; 
   private boolean inserir; 
   private boolean atualizar; 
   private boolean excluir; 

   public void setUsuarios_id(int usuarios_id)
   {
       this.usuarios_id = usuarios_id;
   }
 
   public int getUsuarios_id()
   {
       return usuarios_id;
   }

 
   public void setTelas(Telas telas)
   {
       this.telas = telas;
   }
   public void setTelas_id(String telas_id)
   {
       this.telas_id = telas_id;
   }
 
   public String getTelas_id()
   {
       return telas_id;
   }

   @OneToOne(source = "telas_id", target = "id" , load = LOAD.AUTO, join_type = JOIN_TYPE.INNER)
   public Telas getTelas()
   {
       return telas;
   }

   public void setAcesso(boolean acesso)
   {
       this.acesso = acesso;
   }
 
   public boolean isAcesso()
   {
       return acesso;
   }

   public void setInserir(boolean inserir)
   {
       this.inserir = inserir;
   }
 
   public boolean isInserir()
   {
       return inserir;
   }

   public void setAtualizar(boolean atualizar)
   {
       this.atualizar = atualizar;
   }
 
   public boolean isAtualizar()
   {
       return atualizar;
   }

   public void setExcluir(boolean excluir)
   {
       this.excluir = excluir;
   }
 
   public boolean isExcluir()
   {
       return excluir;
   }
}