$('#teste').click(function ()
{
    $('#menulateral').animate({width:'toggle'},350);
});


$('#btnClientes').click(function ()
{
    add('li-clientes', 'tab-clientes', 'Clientes', 'clientes');
});

function add(li_id, tab_id, title, url)
{
    var exist = (exists(li_id));
    if (exist)
        return;

    $('#conteudo-abas').append("<div id=\"" + tab_id + "\" class=\"tab-pane\"> </div>");
    $('#abas').append("<li id=\"" + li_id + "\"> <a data-toggle=\"tab\" href=\"#" + tab_id + "\"> " + title + " </a> </li>");
    $.get('/em3/' + url, function (page)
    {
        $("#" + tab_id).html(page);
    });
}

function exists(id)
{
    var result = false;
    $('#abas li').each(function ()
    {
        var self = this;
        var current_id = ($(self).attr('id'));

        if (current_id === id)
            result = true;
    });

    return result;
}