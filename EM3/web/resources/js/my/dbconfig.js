$(document).ready(function ()
{
    $('#config').hide();
    $('#lbErro').hide();
});

$('#btnAutenticar').click(function ()
{
    var user =
            {
                user: $('#txUsuario').val(),
                passwd: $('#txSenha').val()
            };

    $.post("/em3/autconfig", user, function (response)
    {
        if (response === '1')
        {
            $('#autenticacao').hide();
            $('#config').show();
        } else
        {
            alert('Não autorizado');
        }
    });
});

$('#testar').click(function ()
{
    $('#form-config').attr('action', '/em3/testconfig');
    $('#form-config').ajaxForm(
            {
                success: function (data)
                {
                    if (data === '1')
                    {
                        alert('Conectado com sucesso');
                    } else
                    {
                        alert('Falha na comunicacao');
                    }
                }
            }).submit();
});

$('#salvar').click(function ()
{
    $('#form-config').attr('action', '/em3/saveconfig');
    $('#form-config').ajaxForm(
            {
                success: function (data)
                {
                    if (data === '1')
                        alert('Configuração salva com sucesso');
                    else
                        alert('Falha ao aplicar configuracoes');
                }
            }).submit();
});