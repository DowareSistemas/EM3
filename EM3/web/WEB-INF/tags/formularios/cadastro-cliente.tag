<div class="col-md-12">
    <div class="row">
        <div>
            <h4> Clientes - Incluir </h4>
        </div>
    </div>

    <div class="row">
        <button type="button" id="btnSalvar" class="btn btn-primary">
            Salvar
        </button>

        <button type="button" id="btnSalvarEContinuar" class="btn btn-default">
            Salvar e continuar
        </button>

        <button type="button" id="btnCancelar" class="btn btn-default">
            Cancelar
        </button>
    </div>
</div>


<div class="row">
    <div class="col-md-12" style="margin-top: 10px;">
        <form role="form" >

            <div class="row">
                <div class="col-md-2">
                    <label class="h5"> Codigo </label>
                    <input type="number" min="1" class="form-control" disabled/>
                </div>

                <div class="col-md-4">
                    <label class="h5"> Nome </label>
                    <input type="text" maxlength="100" class="form-control"/>
                </div>

                <div class="col-md-2">
                    <label class="h5"> Apelido </label>
                    <input type="text" maxlength="100" class="form-control"/>
                </div>

                <div class="col-md-2">
                    <label class="h5"> Telefone 1 </label>
                    <input type="tel" maxlength="15" class="form-control"/>
                </div>

                <div class="col-md-2">
                    <label class="h5"> Telefone 2 </label>
                    <input type="tel" maxlength="15" class="form-control"/>
                </div>
            </div>

            <div class="row">
                <div class="col-md-2">
                    <label> Celular </label>
                    <input type="tel" maxlength="15" class="form-control"/>
                </div>

                <div class="col-md-2">
                    <label class="h5"> Fax </label>0
                    <input type="tel" maxlength="30" class="form-control"/>
                </div>

                <div class="col-md-4">
                    <label class="h5"> Email 1 </label>
                    <input type="email" maxlength="100" class="form-control"/>
                </div>

                <div class="col-md-4">
                    <label class="h5"> Email 2 </label>
                    <input type="email" maxlength="100" class="form-control"/>
                </div>

                <div class="col-md-12">
                    <label class="h5"> Observações </label>
                    <textarea cols="20" maxlength="300" rows="4" class="form-control"> </textarea>
                </div>
            </div>

            <div class="row">
                <div class="col-md-1">
                    <label class="h5"> Bloqueado </label>
                    <select class="form-control">
                        <option value="0"> NÃO </option>
                        <option value="1"> SIM </option>
                    </select>
                </div>

                <div class="col-md-1">
                    <label class="h5"> Inativo </label>
                    <select class="form-control">
                        <option value="0"> NÃO </option>
                        <option value="1"> SIM </option>
                    </select>
                </div>

                <div class="col-md-2">
                    <label class="h5"> Data de nascimento </label>
                    <input type="date" class="form-control"/>
                </div>

                <div class="col-md-1">
                    <label class="h5"> Crédito (R$) </label>
                    <input type="number" class="form-control"/>
                </div>

                <div class="col-md-1">
                    <label class="h5"> Débito (R$) </label>
                    <input type="number" class="form-control"/>
                </div>

                <div class="col-md-2">
                    <label class="h5"> Tipo pessoa </label>
                    <select class="form-control">
                        <option value="0"> Física </option>
                        <option value="1"> Jurídica </option>
                    </select>
                </div>

                <div class="col-md-2">
                    <label class="h5"> Sexo </label>
                    <select class="form-control">
                        <option value="2"> Não informar </option>
                        <option value="0"> Masculino </option>
                        <option value="1"> Feminino </option>
                    </select>
                </div>

                <div class="col-md-2">
                    <label class="h5"> CPF </label>
                    <input type="number" min="1" class="form-control"/>
                </div>
            </div>

            <div class="row">

                <div class="col-md-2">
                    <label class="h5"> RG </label>
                    <input type="number" min="1" class="form-control"/>
                </div>

                <div class="col-md-2">
                    <label class="h5"> CNPJ </label>
                    <input type="number" min="1" class="form-control"/>
                </div>

                <div class="col-md-2">
                    <label class="h5"> IE </label>
                    <input type="number" min="1" class="form-control"/>
                </div>

                <div class="col-md-4">
                    <label class="h5"> Website </label>
                    <input type="text" maxlength="100" class="form-control"/>
                </div>
            </div>

            <div class="row">
                <div class="col-md-2">
                    <label class="h5"> CEP </label>
                    <input class="form-control" min="1" type="number"/>
                </div>

                <div class="col-md-4">
                    <label class="h5"> Logradouro </label>
                    <input class="form-control" type="text" maxlength="100"/>
                </div>

                <div class="col-md-4">
                    <label class="h5"> Município </label>
                    <input class="form-control" maxlength="100"/>
                </div>

                <div class="col-md-1">
                    <label class="h5"> UF </label>
                    <select class="form-control">
                        <%-- Carregar lista de UFs aqui --%>
                    </select>
                </div>

                <div class="col-md-1">
                    <label class="h5"> Número </label>
                    <input type="number" min="1" class="form-control"/>
                </div>
            </div>

            <div class="row">
                <div class="col-md-4">
                    <label class="h5"> País </label>
                    <select class="form-control">
                        <option value="Brasil"> Brasil </option>
                        <%-- Carregar lista de países aqui --%>
                    </select>
                </div>

                <div class="col-md-8">
                    <label class="h5"> Complemento </label>
                    <input type="text" maxlength="300" class="form-control"/>
                </div>
            </div>
        </form>

        <div style="margin-top: 100px;"></div>
    </div>
</div>