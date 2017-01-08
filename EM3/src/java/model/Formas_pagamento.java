
/* AUTO-GENERATED CLASS */
 /* DOES NOT ADD ACCESSOR METHODS */
 /* DOES NOT CHANGE NAME OF ACCESSOR METHODS */
package model;

import java.math.BigDecimal;
import br.com.persistor.abstractClasses.Entity;
import br.com.persistor.annotations.PrimaryKey;
import br.com.persistor.enums.INCREMENT;
import br.com.persistor.annotations.OneToOne;
import br.com.persistor.enums.JOIN_TYPE;
import br.com.persistor.enums.LOAD;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Persistor4J
 */
public class Formas_pagamento extends Entity
{

    private int id;
    @NotNull(message = "A descrição é obrigatória")
    @NotEmpty(message = "A descrição é obrigatória")
    @Size(max = 100, message = "A descrição não pode conter mais de 100 caracteres")
    private String descricao;

    /**
     * 0 - Dinheiro; 1 - Cartao; 2 - Cheque; 3 - Credito cliente; 4 - Boleto;
     */
    @Min(value = 0, message = "Condição de pagamento não identificada")
    @Max(value = 4, message = "Condição de pagamento não identificada")
    private int tipo_pagamento;
    private int conta_bancaria_id;
    private int operadora_cartao_id;
    private boolean permite_entrada;

    /**
     * I - Intervalo --> Intervalo em dias para os vencimentos da parcelas
     *
     * D - Dia base --> Dia base de todo mes para o vencimento das parcelas
     */
    private String tipo_intervalo;
    private int intervalo;
    private int dia_base;
    private int tolerancia_dias;
    private BigDecimal juros_atraso;
    
    @Min(value = 0, message =  "O número de parcelas não pode ser inferior a 0")
    private int parcelas;
    
    @NotNull(message = "Informe se a condição de pagamento está inativa")
    private boolean inativo;

    private Operadoras_cartao operadoras_cartao;
    private Contas_bancarias contas_bancarias;

    @OneToOne(source = "conta_bancaria_id", target = "id", join_type = JOIN_TYPE.LEFT, load = LOAD.AUTO)
    public Contas_bancarias getContas_bancarias()
    {
        return contas_bancarias;
    }

    public void setContas_bancarias(Contas_bancarias contas_bancarias)
    {
        this.contas_bancarias = contas_bancarias;
    }

    @OneToOne(source = "operadora_cartao_id", target = "id", join_type = JOIN_TYPE.LEFT, load = LOAD.AUTO)
    public Operadoras_cartao getOperadoras_cartao()
    {
        return operadoras_cartao;
    }

    public void setOperadoras_cartao(Operadoras_cartao operadoras_cartao)
    {
        this.operadoras_cartao = operadoras_cartao;
    }

    @PrimaryKey(increment = INCREMENT.MANUAL)
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getDescricao()
    {
        return descricao;
    }

    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }

    public int getTipo_pagamento()
    {
        return tipo_pagamento;
    }

    public void setTipo_pagamento(int tipo_pagamento)
    {
        this.tipo_pagamento = tipo_pagamento;
    }

    public int getConta_bancaria_id()
    {
        return conta_bancaria_id;
    }

    public void setConta_bancaria_id(int conta_bancaria_id)
    {
        this.conta_bancaria_id = conta_bancaria_id;
    }

    public int getOperadora_cartao_id()
    {
        return operadora_cartao_id;
    }

    public void setOperadora_cartao_id(int operadora_cartao_id)
    {
        this.operadora_cartao_id = operadora_cartao_id;
    }

    public boolean isPermite_entrada()
    {
        return permite_entrada;
    }

    public void setPermite_entrada(boolean permite_entrada)
    {
        this.permite_entrada = permite_entrada;
    }

    public String getTipo_intervalo()
    {
        return tipo_intervalo;
    }

    public void setTipo_intervalo(String tipo_intervalo)
    {
        this.tipo_intervalo = tipo_intervalo;
    }

    public int getIntervalo()
    {
        return intervalo;
    }

    public void setIntervalo(int intervalo)
    {
        this.intervalo = intervalo;
    }

    public int getDia_base()
    {
        return dia_base;
    }

    public void setDia_base(int dia_base)
    {
        this.dia_base = dia_base;
    }

    public int getTolerancia_dias()
    {
        return tolerancia_dias;
    }

    public void setTolerancia_dias(int tolerancia_dias)
    {
        this.tolerancia_dias = tolerancia_dias;
    }

    public BigDecimal getJuros_atraso()
    {
        return juros_atraso;
    }

    public void setJuros_atraso(BigDecimal juros_atraso)
    {
        this.juros_atraso = juros_atraso;
    }

    public int getParcelas()
    {
        return parcelas;
    }

    public void setParcelas(int parcelas)
    {
        this.parcelas = parcelas;
    }

    public boolean isInativo()
    {
        return inativo;
    }

    public void setInativo(boolean inativo)
    {
        this.inativo = inativo;
    }
}
