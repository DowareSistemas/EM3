
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

public class Contas_bancarias extends Entity 
{
   private int id; 
   private String nome; 
   private String agencia; 
   private String conta; 
   private String numero_banco; 
   private String telefone; 
   private String correntista; 
   private BigDecimal saldo_atual; 
   private BigDecimal limite_credito; 
   private String cnpj; 
   private int endereco_id; 
   private int banco_id; 
   private Bancos bancos; 

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

   public void setAgencia(String agencia)
   {
       this.agencia = agencia;
   }
 
   public String getAgencia()
   {
       return agencia;
   }

   public void setConta(String conta)
   {
       this.conta = conta;
   }
 
   public String getConta()
   {
       return conta;
   }

   public void setNumero_banco(String numero_banco)
   {
       this.numero_banco = numero_banco;
   }
 
   public String getNumero_banco()
   {
       return numero_banco;
   }

   public void setTelefone(String telefone)
   {
       this.telefone = telefone;
   }
 
   public String getTelefone()
   {
       return telefone;
   }

   public void setCorrentista(String correntista)
   {
       this.correntista = correntista;
   }
 
   public String getCorrentista()
   {
       return correntista;
   }

   public void setSaldo_atual(BigDecimal saldo_atual)
   {
       this.saldo_atual = saldo_atual;
   }
 
   public BigDecimal getSaldo_atual()
   {
       return saldo_atual;
   }

   public void setLimite_credito(BigDecimal limite_credito)
   {
       this.limite_credito = limite_credito;
   }
 
   public BigDecimal getLimite_credito()
   {
       return limite_credito;
   }

   public void setCnpj(String cnpj)
   {
       this.cnpj = cnpj;
   }
 
   public String getCnpj()
   {
       return cnpj;
   }

   public void setEndereco_id(int endereco_id)
   {
       this.endereco_id = endereco_id;
   }
 
   public int getEndereco_id()
   {
       return endereco_id;
   }

 
   public void setBancos(Bancos bancos)
   {
       this.bancos = bancos;
   }
   public void setBanco_id(int banco_id)
   {
       this.banco_id = banco_id;
   }
 
   public int getBanco_id()
   {
       return banco_id;
   }

   @OneToOne(source = "banco_id", target = "id" , load = LOAD.AUTO, join_type = JOIN_TYPE.INNER)
   public Bancos getBancos()
   {
       return bancos;
   }
}