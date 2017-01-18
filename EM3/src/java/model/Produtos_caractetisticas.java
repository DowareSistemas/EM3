
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
public class Produtos_caractetisticas extends Entity
{

    private int caracteristica_id;
    private Caracteristicas caracteristicas;
    private int produto_id;
    private Produtos produtos;

    public void setCaracteristicas(Caracteristicas caracteristicas)
    {
        this.caracteristicas = caracteristicas;
    }

    public void setCaracteristica_id(int caracteristica_id)
    {
        this.caracteristica_id = caracteristica_id;
    }

    public int getCaracteristica_id()
    {
        return caracteristica_id;
    }

    @OneToOne(source = "caracteristica_id", target = "id", load = LOAD.AUTO, join_type = JOIN_TYPE.INNER)
    public Caracteristicas getCaracteristicas()
    {
        return caracteristicas;
    }

    public void setProdutos(Produtos produtos)
    {
        this.produtos = produtos;
    }

    public void setProduto_id(int produto_id)
    {
        this.produto_id = produto_id;
    }

    public int getProduto_id()
    {
        return produto_id;
    }

    @OneToOne(source = "produto_id", target = "id", load = LOAD.AUTO, join_type = JOIN_TYPE.INNER)
    public Produtos getProdutos()
    {
        return produtos;
    }
}
