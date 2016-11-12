$('#btnLogin').click(function ()
{
    var usuario =
            {
                nome: $('#txNome').val(),
                senha: $('#txSenha').val()
            };

    $.post('usr-login', usuario, function (data)
    {
        alert(data);
    });
});