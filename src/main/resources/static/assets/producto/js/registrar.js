$(document).ready(function (){
    $.ajax({
        url: "http://localhost:8080/api/marca/listar",
        type: "GET",

        success: function (respuesta) {

            respuesta.forEach((data)=>{
                $("#idMarca").append('<option value="' +data.id+ '">' + data.descripcion+ '</option>')
            })


        }
    });
    $("#btn-guardar").click(function () {
        guardar({

            id:null,
            codigo: $("#codigo").val(),
            descripcion: $("#descripcion").val(),
            cantidad: $("#cantidad").val(),
            valor: $("#valor").val(),
            idMarca:$("#idMarca").val()

        })
    });
});

function guardar(data) {

    $.ajax({
        url: "http://localhost:8080/api/producto/crear",
       // type: "POST",
        //data: $("#frm-producto").serialize(),
        data:JSON.stringify(data),
        method: 'POST',
        dataType : 'json',
        contentType: "application/json; charset=utf-8",
        success : function(json) {
            alert("Producto creado\n"+"id:"+json.id+"nom:"+json.descripcion);
                $("#codigo").val("");
                $("#descripcion").val("");
                $("#cantidad").val("");
                $("#valor").val("");
                $("#idMarca").val("");

        },
        error : function(error) {
               alert("Error"+error);
        }
    });


}