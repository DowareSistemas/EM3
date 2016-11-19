
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

public class Funcionarios extends Entity 
{
   private int id; 
   private int matricula; 
   private String nome; 
   private String nome_mae; 
   private String nome_pai; 
   private int sexo; 
   private int estado_civil; 
   private String data_nascimento; 
   private String nacionalidade; 
   private String naturalidade_uf; 
   private String apelido; 
   private String data_adm; 
   private String data_dem; 
   private int horas_dia; 
   private int horas_semana; 
   private BigDecimal salario; 
   private BigDecimal comissao_venda; 
   private BigDecimal comissao_servico; 
   private String data_pagamento; 
   private int cargo_id; 
   private Cargos cargos; 
   private int documento_id; 
   private Documentos documentos; 
   private int turno_id; 
   private int usuario_id; 
   private int endereco_id; 
   private Enderecos enderecos; 
   private int empresa_id; 
   private Empresa empresa; 

   public void setId(int id)
   {
       this.id = id;
   }
 
   @PrimaryKey(increment = INCREMENT.MANUAL)
   public int getId()
   {
       return id;
   }

   public void setMatricula(int matricula)
   {
       this.matricula = matricula;
   }
 
   public int getMatricula()
   {
       return matricula;
   }

   public void setNome(String nome)
   {
       this.nome = nome;
   }
 
   public String getNome()
   {
       return nome;
   }

   public void setNome_mae(String nome_mae)
   {
       this.nome_mae = nome_mae;
   }
 
   public String getNome_mae()
   {
       return nome_mae;
   }

   public void setNome_pai(String nome_pai)
   {
       this.nome_pai = nome_pai;
   }
 
   public String getNome_pai()
   {
       return nome_pai;
   }

   public void setSexo(int sexo)
   {
       this.sexo = sexo;
   }
 
   public int getSexo()
   {
       return sexo;
   }

   public void setEstado_civil(int estado_civil)
   {
       this.estado_civil = estado_civil;
   }
 
   public int getEstado_civil()
   {
       return estado_civil;
   }

   public void setData_nascimento(String data_nascimento)
   {
       this.data_nascimento = data_nascimento;
   }
 
   public String getData_nascimento()
   {
       return data_nascimento;
   }

   public void setNacionalidade(String nacionalidade)
   {
       this.nacionalidade = nacionalidade;
   }
 
   public String getNacionalidade()
   {
       return nacionalidade;
   }

   public void setNaturalidade_uf(String naturalidade_uf)
   {
       this.naturalidade_uf = naturalidade_uf;
   }
 
   public String getNaturalidade_uf()
   {
       return naturalidade_uf;
   }

   public void setApelido(String apelido)
   {
       this.apelido = apelido;
   }
 
   public String getApelido()
   {
       return apelido;
   }

   public void setData_adm(String data_adm)
   {
       this.data_adm = data_adm;
   }
 
   public String getData_adm()
   {
       return data_adm;
   }

   public void setData_dem(String data_dem)
   {
       this.data_dem = data_dem;
   }
 
   public String getData_dem()
   {
       return data_dem;
   }

   public void setHoras_dia(int horas_dia)
   {
       this.horas_dia = horas_dia;
   }
 
   public int getHoras_dia()
   {
       return horas_dia;
   }

   public void setHoras_semana(int horas_semana)
   {
       this.horas_semana = horas_semana;
   }
 
   public int getHoras_semana()
   {
       return horas_semana;
   }

   public void setSalario(BigDecimal salario)
   {
       this.salario = salario;
   }
 
   public BigDecimal getSalario()
   {
       return salario;
   }

   public void setComissao_venda(BigDecimal comissao_venda)
   {
       this.comissao_venda = comissao_venda;
   }
 
   public BigDecimal getComissao_venda()
   {
       return comissao_venda;
   }

   public void setComissao_servico(BigDecimal comissao_servico)
   {
       this.comissao_servico = comissao_servico;
   }
 
   public BigDecimal getComissao_servico()
   {
       return comissao_servico;
   }

   public void setData_pagamento(String data_pagamento)
   {
       this.data_pagamento = data_pagamento;
   }
 
   public String getData_pagamento()
   {
       return data_pagamento;
   }

 
   public void setCargos(Cargos cargos)
   {
       this.cargos = cargos;
   }
   public void setCargo_id(int cargo_id)
   {
       this.cargo_id = cargo_id;
   }
 
   public int getCargo_id()
   {
       return cargo_id;
   }

   @OneToOne(source = "cargo_id", target = "id" , load = LOAD.AUTO, join_type = JOIN_TYPE.INNER)
   public Cargos getCargos()
   {
       return cargos;
   }

 
   public void setDocumentos(Documentos documentos)
   {
       this.documentos = documentos;
   }
   public void setDocumento_id(int documento_id)
   {
       this.documento_id = documento_id;
   }
 
   public int getDocumento_id()
   {
       return documento_id;
   }

   @OneToOne(source = "documento_id", target = "id" , load = LOAD.AUTO, join_type = JOIN_TYPE.INNER)
   public Documentos getDocumentos()
   {
       return documentos;
   }

   public void setTurno_id(int turno_id)
   {
       this.turno_id = turno_id;
   }
 
   public int getTurno_id()
   {
       return turno_id;
   }

   public void setUsuario_id(int usuario_id)
   {
       this.usuario_id = usuario_id;
   }
 
   public int getUsuario_id()
   {
       return usuario_id;
   }

 
   public void setEnderecos(Enderecos enderecos)
   {
       this.enderecos = enderecos;
   }
   public void setEndereco_id(int endereco_id)
   {
       this.endereco_id = endereco_id;
   }
 
   public int getEndereco_id()
   {
       return endereco_id;
   }

   @OneToOne(source = "endereco_id", target = "id" , load = LOAD.AUTO, join_type = JOIN_TYPE.INNER)
   public Enderecos getEnderecos()
   {
       return enderecos;
   }

 
   public void setEmpresa(Empresa empresa)
   {
       this.empresa = empresa;
   }
   public void setEmpresa_id(int empresa_id)
   {
       this.empresa_id = empresa_id;
   }
 
   public int getEmpresa_id()
   {
       return empresa_id;
   }

   @OneToOne(source = "empresa_id", target = "id" , load = LOAD.AUTO, join_type = JOIN_TYPE.INNER)
   public Empresa getEmpresa()
   {
       return empresa;
   }
}