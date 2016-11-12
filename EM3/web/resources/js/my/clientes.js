$(document).ready(function ()
{
    
   $('#formulario').hide();

    var table = $('#tabela').DataTable
            ({
                "ordering": true,
                "scrollCollapse": false,
                "paging": false,
                "info": false
            });

    $('#tabela tbody').on('click', 'tr', function ()
    {
        if ($(this).hasClass('selected'))
        {
            $(this).removeClass('selected');
        } else
        {
            table.$('tr.selected').removeClass('selected');
            $(this).addClass('selected');
        }
    });
    
    $('#tabela tr').dblclick(function ()
    {
        $('#visualizacao').hide();
        $('#formulario').show();
     //   $('#titulo-form').text('Produtos - Alterar');
    });


    $('#tabela_filter').hide(); 

});


$('#btnNovo').click(function ()
{
    
    $('#visualizacao').hide();
    $('#formulario').show();
});

$('#btnCancelar').click(function ()
{
    
    $('#visualizacao').show();
    $('#formulario').hide();
});