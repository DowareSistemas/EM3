
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

public class Intervalos_turnos extends Entity 
{
   private String descricao; 
   private String hora_inicio; 
   private String hora_termino; 
   private int turno_id; 

   public void setDescricao(String descricao)
   {
       this.descricao = descricao;
   }
 
   public String getDescricao()
   {
       return descricao;
   }

   public void setHora_inicio(String hora_inicio)
   {
       this.hora_inicio = hora_inicio;
   }
 
   public String getHora_inicio()
   {
       return hora_inicio;
   }

   public void setHora_termino(String hora_termino)
   {
       this.hora_termino = hora_termino;
   }
 
   public String getHora_termino()
   {
       return hora_termino;
   }

   public void setTurno_id(int turno_id)
   {
       this.turno_id = turno_id;
   }
 
   public int getTurno_id()
   {
       return turno_id;
   }
}