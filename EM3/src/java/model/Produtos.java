
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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Persistor4J
 */
public class Produtos extends Entity
{

    private int id;

    @Size(max = 13, message = "O EAN não pode conter mais de 13 caracteres")
    private String ean;

    @Size(max = 10, message = "A referência não pode conter mais de 10 caracteres")
    private String referencia;

    @NotNull(message = "A descrição é obrigatória")
    @NotEmpty(message = "A descrição é obrigatória")
    @Size(max = 100, message = "A descrição não pode conter mais de 100 caracteres")
    private String descricao;

    @Size(max = 10, message = "O NCM não pode conter mais de 10 caracteres")
    private String ncm;

    @Size(max = 15, message = "O código ANP não pode conter mais de 15 caracteres")
    private String anp;
    private String data_cadastro;
    private String ultima_alteracao;
    private boolean fabricado;
    private boolean insumo;
    private boolean fracionado;
    private boolean inativo;
    private boolean para_balanca;

    @Size(max = 100, message = "O fabricante não pode conter mais de 100 caracteres")
    private String fabricante;

    @Size(max = 50, message = "O código do fabricante não pode conter mais de 50 caracteres")
    private String cod_fabricante;

    @Min(value = 1, message = "O código da unidade 1 é obrigatória")
    private int unidade1;
    private int fator_conversao;
    private int unidade2;

    @Min(value = 1, message = "A classe de imposto é obrigatória")
    private int classe_imposto_id;
    private int cest_id;
    private int grupo_produtos_id;
    private int marca_id;
    private int validade;
    private BigDecimal peso_liquido;
    private int ponto_pedido;
    private int fornecedor_padrao;

    private Classes_imposto classes_imposto;
    private Unidades unidades;
    private Cest cest;
    private Marcas marcas;
    private Grupos_produtos grupos_produtos;
    private Fornecedores fornecedores;

    private BigDecimal custo_standard;
    private BigDecimal preco_venda;
    private BigDecimal ult_preco;
    private BigDecimal comissao;
    private String ultima_compra;
    private int prod_equivalente;
    private int empresa_padrao;
    private int garantia_loja;
    private int garantia_forn;
    private int foto_id;
    private int origem;

    public int getOrigem()
    {
        return origem;
    }

    public void setOrigem(int origem)
    {
        this.origem = origem;
    }

    public int getFoto_id()
    {
        return foto_id;
    }

    public void setFoto_id(int foto_id)
    {
        this.foto_id = foto_id;
    }

    public BigDecimal getCusto_standard()
    {
        return custo_standard;
    }

    public void setCusto_standard(BigDecimal custo_standard)
    {
        this.custo_standard = custo_standard;
    }

    public BigDecimal getPreco_venda()
    {
        return preco_venda;
    }

    public void setPreco_venda(BigDecimal preco_venda)
    {
        this.preco_venda = preco_venda;
    }

    public BigDecimal getUlt_preco()
    {
        return ult_preco;
    }

    public void setUlt_preco(BigDecimal ult_preco)
    {
        this.ult_preco = ult_preco;
    }

    public BigDecimal getComissao()
    {
        return comissao;
    }

    public void setComissao(BigDecimal comissao)
    {
        this.comissao = comissao;
    }

    public String getUltima_compra()
    {
        return ultima_compra;
    }

    public void setUltima_compra(String ultima_compra)
    {
        this.ultima_compra = ultima_compra;
    }

    public int getProd_equivalente()
    {
        return prod_equivalente;
    }

    public void setProd_equivalente(int prod_equivalente)
    {
        this.prod_equivalente = prod_equivalente;
    }

    public int getEmpresa_padrao()
    {
        return empresa_padrao;
    }

    public void setEmpresa_padrao(int empresa_padrao)
    {
        this.empresa_padrao = empresa_padrao;
    }

    public int getGarantia_loja()
    {
        return garantia_loja;
    }

    public void setGarantia_loja(int garantia_loja)
    {
        this.garantia_loja = garantia_loja;
    }

    public int getGarantia_forn()
    {
        return garantia_forn;
    }

    public void setGarantia_forn(int garantia_forn)
    {
        this.garantia_forn = garantia_forn;
    }

    public int getFornecedor_padrao()
    {
        return fornecedor_padrao;
    }

    public void setFornecedor_padrao(int fornecedor_padrao)
    {
        this.fornecedor_padrao = fornecedor_padrao;
    }

    @OneToOne(source = "fornecedor_padrao", target = "id", join_type = JOIN_TYPE.LEFT, load = LOAD.AUTO)
    public Fornecedores getFornecedores()
    {
        return fornecedores;
    }

    public void setFornecedores(Fornecedores fornecedores)
    {
        this.fornecedores = fornecedores;
    }

    @OneToOne(source = "grupo_produtos_id", target = "id", join_type = JOIN_TYPE.LEFT, load = LOAD.AUTO)
    public Grupos_produtos getGrupos_produtos()
    {
        return grupos_produtos;
    }

    public void setGrupos_produtos(Grupos_produtos grupos_produtos)
    {
        this.grupos_produtos = grupos_produtos;
    }

    @OneToOne(source = "classe_imposto_id", target = "id", join_type = JOIN_TYPE.INNER, load = LOAD.AUTO)
    public Classes_imposto getClasses_imposto()
    {
        return classes_imposto;
    }

    public void setClasses_imposto(Classes_imposto classes_imposto)
    {
        this.classes_imposto = classes_imposto;
    }

    @OneToOne(source = "unidade1", target = "id", join_type = JOIN_TYPE.INNER, load = LOAD.AUTO)
    public Unidades getUnidades()
    {
        return unidades;
    }

    public void setUnidades(Unidades unidades)
    {
        this.unidades = unidades;
    }

    @OneToOne(source = "cest_id", target = "id", join_type = JOIN_TYPE.LEFT, load = LOAD.AUTO)
    public Cest getCest()
    {
        return cest;
    }

    public void setCest(Cest cest)
    {
        this.cest = cest;
    }

    @OneToOne(source = "marca_id", target = "id", join_type = JOIN_TYPE.LEFT, load = LOAD.AUTO)
    public Marcas getMarcas()
    {
        return marcas;
    }

    public void setMarcas(Marcas marcas)
    {
        this.marcas = marcas;
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

    public String getEan()
    {
        return ean;
    }

    public void setEan(String ean)
    {
        this.ean = ean;
    }

    public String getReferencia()
    {
        return referencia;
    }

    public void setReferencia(String referencia)
    {
        this.referencia = referencia;
    }

    public String getDescricao()
    {
        return descricao;
    }

    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }

    public String getNcm()
    {
        return ncm;
    }

    public void setNcm(String ncm)
    {
        this.ncm = ncm;
    }

    public String getAnp()
    {
        return anp;
    }

    public void setAnp(String anp)
    {
        this.anp = anp;
    }

    public String getData_cadastro()
    {
        return data_cadastro;
    }

    public void setData_cadastro(String data_cadastro)
    {
        this.data_cadastro = data_cadastro;
    }

    public String getUltima_alteracao()
    {
        return ultima_alteracao;
    }

    public void setUltima_alteracao(String ultima_alteracao)
    {
        this.ultima_alteracao = ultima_alteracao;
    }

    public boolean isFabricado()
    {
        return fabricado;
    }

    public void setFabricado(boolean fabricado)
    {
        this.fabricado = fabricado;
    }

    public boolean isInsumo()
    {
        return insumo;
    }

    public void setInsumo(boolean insumo)
    {
        this.insumo = insumo;
    }

    public boolean isFracionado()
    {
        return fracionado;
    }

    public void setFracionado(boolean fracionado)
    {
        this.fracionado = fracionado;
    }

    public boolean isInativo()
    {
        return inativo;
    }

    public void setInativo(boolean inativo)
    {
        this.inativo = inativo;
    }

    public boolean isPara_balanca()
    {
        return para_balanca;
    }

    public void setPara_balanca(boolean para_balanca)
    {
        this.para_balanca = para_balanca;
    }

    public String getFabricante()
    {
        return fabricante;
    }

    public void setFabricante(String fabricante)
    {
        this.fabricante = fabricante;
    }

    public String getCod_fabricante()
    {
        return cod_fabricante;
    }

    public void setCod_fabricante(String cod_fabricante)
    {
        this.cod_fabricante = cod_fabricante;
    }

    public int getUnidade1()
    {
        return unidade1;
    }

    public void setUnidade1(int unidade1)
    {
        this.unidade1 = unidade1;
    }

    public int getFator_conversao()
    {
        return fator_conversao;
    }

    public void setFator_conversao(int fator_conversao)
    {
        this.fator_conversao = fator_conversao;
    }

    public int getUnidade2()
    {
        return unidade2;
    }

    public void setUnidade2(int unidade2)
    {
        this.unidade2 = unidade2;
    }

    public int getClasse_imposto_id()
    {
        return classe_imposto_id;
    }

    public void setClasse_imposto_id(int classe_imposto_id)
    {
        this.classe_imposto_id = classe_imposto_id;
    }

    public int getCest_id()
    {
        return cest_id;
    }

    public void setCest_id(int cest_id)
    {
        this.cest_id = cest_id;
    }

    public int getGrupo_produtos_id()
    {
        return grupo_produtos_id;
    }

    public void setGrupo_produtos_id(int grupo_produtos_id)
    {
        this.grupo_produtos_id = grupo_produtos_id;
    }

    public int getMarca_id()
    {
        return marca_id;
    }

    public void setMarca_id(int marca_id)
    {
        this.marca_id = marca_id;
    }

    public int getValidade()
    {
        return validade;
    }

    public void setValidade(int validade)
    {
        this.validade = validade;
    }

    public BigDecimal getPeso_liquido()
    {
        return peso_liquido;
    }

    public void setPeso_liquido(BigDecimal peso_liquido)
    {
        this.peso_liquido = peso_liquido;
    }

    public int getPonto_pedido()
    {
        return ponto_pedido;
    }

    public void setPonto_pedido(int ponto_pedido)
    {
        this.ponto_pedido = ponto_pedido;
    }
}
