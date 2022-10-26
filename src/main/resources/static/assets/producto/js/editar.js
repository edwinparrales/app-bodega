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
     const producto = JSON.parse(localStorage.getItem("producto"));
     console.log(producto);
     $("#cantidad").val(producto.cantidad);

     $("#idMarca").val(producto.idMarca);
     $("#idMarca").change();

     $("#codigo").val(producto.codigo);
     $("#descripcion").val(producto.descripcion);
     $("#valor").val(producto.valor);

     $("#btn-actualizar").click(function () {

          actualizar(
              {

                   id:producto.id,
                   codigo: $("#codigo").val(),
                   descripcion: $("#descripcion").val(),
                   cantidad: $("#cantidad").val(),
                   valor: $("#valor").val(),
                   idMarca:$("#idMarca").val()

              }
          )
     })

});

function actualizar(data) {
     console.log(data)
     if(data.idMarca==0){
          alert("Debe seleccionar una marca valida");
     }else {
          $.ajax({
               url: "http://localhost:8080/api/producto/crear",
               // type: "POST",
               //data: $("#frm-producto").serialize(),
               data: JSON.stringify(data),
               method: 'POST',
               dataType: 'json',
               contentType: "application/json; charset=utf-8",
               success: function (json) {
                    alert("Producto creado\n" + "id:" + json.id + "nom:" + json.descripcion);
                    $("#codigo").val("");
                    $("#descripcion").val("");
                    $("#cantidad").val("");
                    $("#valor").val("");
                    $("#idMarca").val("");
                    localStorage.removeItem("producto");

               },
               error: function (error) {
                    alert("Error" + error);
               }
          });

     }


}