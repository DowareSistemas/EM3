
/* AUTO-GENERATED CLASS */
/* DOES NOT ADD ACCESSOR METHODS */
/* DOES NOT CHANGE NAME OF ACCESSOR METHODS */
package model;


import br.com.persistor.abstractClasses.Entity;
import br.com.persistor.annotations.PrimaryKey;
import br.com.persistor.enums.INCREMENT;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Persistor4J
 */ 

public class Enderecos extends Entity 
{
   private int id; 
   
   @Size(max = 100, message = "O CEP não pode ter mais de 100 caracteres")
   @NotNull(message = "O CEP é obrigatório")
   @NotEmpty(message = "O CEP é obrigatório")
   private String cep; 
   
   @Size(max = 100, message = "O logradouro não pode ter mais de 100 caracteres")
   @NotEmpty(message = "O logradouro é obrigatório")
   @NotNull(message = "O logradouro é obrigatório")
   private String logradouro; 
   
   @Size(max = 100, message = "O bairro não pode ter mais de 100 caracteres")
   @NotEmpty(message = "O bairro é obrigatório")
   @NotNull(message = "O bairro é obrigatório")
   private String bairro;
   
   @Size(max = 100, message = "O município não pode ter mais de 100 caracteres")
   @NotEmpty(message = "O município é obrigatório")
   @NotNull(message = "O município é obrigatório")
   private String municipio; 
   
   @Size(max = 2, message ="A UF não pode ter mais de 2 caracteres")
   @NotEmpty(message = "A UF é obrigatória")
   @NotNull(message = "A UF é obrigatória")
   private String uf; 
   
   @Max(value = 99999, message = "O valor máximo permitido para o número é 99999")
   private int numero; 
   private String pais; 
   private String complemento; 

   public void setId(int id)
   {
       this.id = id;
   }
 
   @PrimaryKey(increment = INCREMENT.MANUAL)
   public int getId()
   {
       return id;
   }

   public void setCep(String cep)
   {
       this.cep = cep;
   }
 
   public String getCep()
   {
       return cep;
   }

   public void setLogradouro(String logradouro)
   {
       this.logradouro = logradouro;
   }
 
   public String getLogradouro()
   {
       return logradouro;
   }

   public void setBairro(String bairro)
   {
       this.bairro = bairro;
   }
 
   public String getBairro()
   {
       return bairro;
   }

   public void setMunicipio(String municipio)
   {
       this.municipio = municipio;
   }
 
   public String getMunicipio()
   {
       return municipio;
   }

   public void setUf(String uf)
   {
       this.uf = uf;
   }
 
   public String getUf()
   {
       return uf;
   }

   public void setNumero(int numero)
   {
       this.numero = numero;
   }
 
   public int getNumero()
   {
       return numero;
   }

   public void setPais(String pais)
   {
       this.pais = pais;
   }
 
   public String getPais()
   {
       return pais;
   }

   public void setComplemento(String complemento)
   {
       this.complemento = complemento;
   }
 
   public String getComplemento()
   {
       return complemento;
   }
}