
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

public class Caixas extends Entity 
{
   private int id; 
   private String nome; 
   private String data_abertura; 
   private String data_fechamento; 
   private int usuario_id; 
   private Usuarios usuarios; 

   public void setId(int id)
   {
       this.id = id;
   }
 
   @PrimaryKey(increment = INCREMENT.MANUAL)
   public int getId()
   {
       return id;
   }

   public void setNome(String nome)
   {
       this.nome = nome;
   }
 
   public String getNome()
   {
       return nome;
   }

   public void setData_abertura(String data_abertura)
   {
       this.data_abertura = data_abertura;
   }
 
   public String getData_abertura()
   {
       return data_abertura;
   }

   public void setData_fechamento(String data_fechamento)
   {
       this.data_fechamento = data_fechamento;
   }
 
   public String getData_fechamento()
   {
       return data_fechamento;
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
}