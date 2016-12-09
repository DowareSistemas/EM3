
/* AUTO-GENERATED CLASS */
/* DOES NOT ADD ACCESSOR METHODS */
/* DOES NOT CHANGE NAME OF ACCESSOR METHODS */
package model;


import br.com.persistor.abstractClasses.Entity;
import br.com.persistor.annotations.PrimaryKey;
import br.com.persistor.enums.INCREMENT;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Persistor4J
 */ 

public class Classes_imposto extends Entity 
{
   private int id; 
   
   @NotNull(message = "O nome é obrigatório")
   @NotEmpty(message = "O nome é obrigatório")
   @Size(max = 100, message = "O nome não pode possuir mais de 100 caracteres")
   private String nome; 
 
   @NotNull(message = "A data de alteração é obrigatória")
   @NotEmpty(message = "A data de alteração é obrigatória")
   @Size(max = 19, message = "A data de alteração não pode conter mais de 19 caracteres")
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

   public void setNome(String nome)
   {
       this.nome = nome;
   }
 
   public String getNome()
   {
       return nome;
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