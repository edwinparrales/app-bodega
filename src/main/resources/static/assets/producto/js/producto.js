$(document).ready(function () {

    var tabla =  $('#tb-productos').DataTable(
        {

            ajax: {
                url: 'http://localhost:8080/api/producto/listar',
                type: 'GET',
                dataSrc:function (json) {
                    return json;
                }
            },
            columns:[
                {data:"codigo"},
                {data:"descripcion"},
                {data:"marca.descripcion"},
                {data:"cantidad"},
                {data:"valor"},
                {defaultContent: '<button  id="btneditar" class="btn btn-success editar"  ><span class="glyphicon glyphicon-pencil"></span>E</button> <button class="btn btn-danger" id="btneliminar" type="button"><span class="glyphicon glyphicon-trash"></span>X</button>'
                }
            ],
            "language": {
                "lengthMenu": "Mostrar _MENU_ registros por pagina",
                "zeroRecords": "Nothing found - sorry",
                "info": " Pagina actual _PAGE_ de _PAGES_",
                "infoEmpty": "No hay registros",
                "infoFiltered": "(Encontrados de _MAX_ Registros)",
                "search":         "Buscar:",
                "paginate": {
                    "first":      "Primero",
                    "last":       "Ultimo",
                    "next":       "Siguiente",
                    "previous":   "Anterior"
                },
            }
        });


    tabla.on('click', 'tr', function (e) {
        var data = tabla.row(this).data();
        // console.log(e.target.id);
        if(e.target.id === "btneliminar"){
            eliminar(data);
        }
        if(e.target.id === "btneditar"){
            editar(data);
        }

    });


});



function eliminar(producto){
    const confr = confirm("Esta seguro que desea elimianar el producto\n"
        +producto.descripcion) ;
    if(confr){
        $.ajax({
            url: "http://localhost:8080/api/producto/eliminar/"+producto.id,
            type: "DELETE",
            //data: {id: producto.id},
            success: function (respuesta) {



            }
        });
        alert("Producto eliminado");

        location.reload();

    }else{
        alert("operacion cancelada");
    }

}

function editar(data) {
    console.log(data);
    localStorage.setItem("producto", JSON.stringify(data));

    document.location.href = "http://localhost:8080/producto/editar.html";

}