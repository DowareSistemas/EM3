/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import br.com.persistor.abstractClasses.Entity;
import br.com.persistor.annotations.OneToOne;
import br.com.persistor.annotations.PrimaryKey;
import br.com.persistor.enums.INCREMENT;
import br.com.persistor.enums.JOIN_TYPE;
import br.com.persistor.enums.LOAD;

/**
 *
 * @author Marcos Vinícius
 */
public class Clientes_formas_pagamento extends Entity
{

    private int id;
    private int cliente_id;
    private int forma_pagamento_id;

    private Clientes clientes;
    private Formas_pagamento formas_pagamento;

    @OneToOne(source = "cliente_id", target = "id", join_type = JOIN_TYPE.INNER, load = LOAD.AUTO)
    public Clientes getClientes()
    {
        return clientes;
    }

    public void setClientes(Clientes clientes)
    {
        this.clientes = clientes;
    }

    @OneToOne(source = "forma_pagamento_id", target = "id", join_type = JOIN_TYPE.INNER, load = LOAD.AUTO)
    public Formas_pagamento getFormas_pagamento()
    {
        return formas_pagamento;
    }

    public void setFormas_pagamento(Formas_pagamento formas_pagamento)
    {
        this.formas_pagamento = formas_pagamento;
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

    public int getCliente_id()
    {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id)
    {
        this.cliente_id = cliente_id;
    }

    public int getForma_pagamento_id()
    {
        return forma_pagamento_id;
    }

    public void setForma_pagamento_id(int forma_pagamento_id)
    {
        this.forma_pagamento_id = forma_pagamento_id;
    }
}
