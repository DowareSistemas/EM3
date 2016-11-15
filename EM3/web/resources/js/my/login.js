$('#btnLogin').click(function ()
{
    var usuario =
            {
                nome: $('#txNome').val(),
                senha: $('#txSenha').val()
            };

    $.post('usr-login', usuario, function (response)
    {
        if(response.status === 600)
            window.location = '/em3';
        else
            showMsg(response.message);
    });
});

function showMsg(text)
{
    $('#msg-login .msg').text(text);
    $('#msg-login').modal('toggle');
    $('#msg-login').modal('show');
}