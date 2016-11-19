
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

public class Documentos extends Entity 
{
   private int id; 
   private String rg; 
   private String ie; 
   private String im; 
   private String cpf; 
   private String cnpj; 
   private String cnh; 
   private String rntc; 

   public void setId(int id)
   {
       this.id = id;
   }
 
   @PrimaryKey(increment = INCREMENT.MANUAL)
   public int getId()
   {
       return id;
   }

   public void setRg(String rg)
   {
       this.rg = rg;
   }
 
   public String getRg()
   {
       return rg;
   }

   public void setIe(String ie)
   {
       this.ie = ie;
   }
 
   public String getIe()
   {
       return ie;
   }

   public void setIm(String im)
   {
       this.im = im;
   }
 
   public String getIm()
   {
       return im;
   }

   public void setCpf(String cpf)
   {
       this.cpf = cpf;
   }
 
   public String getCpf()
   {
       return cpf;
   }

   public void setCnpj(String cnpj)
   {
       this.cnpj = cnpj;
   }
 
   public String getCnpj()
   {
       return cnpj;
   }

   public void setCnh(String cnh)
   {
       this.cnh = cnh;
   }
 
   public String getCnh()
   {
       return cnh;
   }

   public void setRntc(String rntc)
   {
       this.rntc = rntc;
   }
 
   public String getRntc()
   {
       return rntc;
   }
}