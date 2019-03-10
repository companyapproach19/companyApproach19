//Descomentar esto para cuando se termine la seccion de las pruebas...
//alert("Los datos que está rellenando se enviarán una vez se le dé al botón de enviar.\n "+ "Estos no se pordrán cambiar una vez se envien." );
	/*var json2Txt = '{' + 
 ' "ID": 92839282, ' +
 ' "Destinatario": "Productor" ,'
 ' "Actor": "hoso", ' +
 ' "Transportista": [' +
 '     { ' + 
 '      "Empresa": "", ' +
 '      "Nombre" : "", ' +
 '      "Fecha de recogida" : "",'+       
  '      "Fecha de entrega" : "" ' +
  '   }'+
  '],' +

  ' "Mensaje": "Hola", '+
  ' "Estado" : "No entregado", ' +
  ' "Firmado": "No" ' +

'}';
var json2Obj = JSON.parse(json2Txt);
json2Obj.Transportista.Nombre=$("#customer_name").value;
*/
var prueba = {"ID": 92839282,"Destinatario":"", "Actor":"", Transportista:[{"Empresa":"", "Nombre":"", "Fecha_de_recogida":"","Fecha _de_Entrega":""}],"Firmado":"Pendiente"}

function actualizarJsonEmpresa(){
  var empresa = document.getElementById("company").value
  prueba.Transportista.Empresa= empresa;
}
//Cada vez que se quiera actualizar la fecha de entrega
function actualizarJsonFechaDeEntrega(){
  var fecha_de_entrega = document.getElementById("departure_date").value
  prueba.Transportista.Fecha_de_entrega=fecha_de_entrega;

}


//Cada vez que se quiera actualizar la fecha de recogida
function actualizarJsonFechaDeRecogida(){
  var fecha_de_recogida = document.getElementById("delivered_date").value
  prueba.Transportista.Fecha_de_recogida=fecha_de_recogida;

}

//Cada vez que se quiera actualizar el nombre del Transportista
function actualizarJsonNombreTransportista(){
  var nombre = document.getElementById("customer_name").value;
	prueba.Transportista.Nombre=nombre;
	/* alert(prueba.Transportista.Nombre);*/

}
function actualizarJsonIdentificador(){
  var identificador=document.getElementById("identificador").value;
  prueba.ID=identificador;
}

function actualizarFirma(){
  prueba.Firmado="Firmado";
}

function display(){
  alert("Se han rellenado los datos correspondientes: \n" + "Nombre del Transportista: "
    +prueba.Transportista.Nombre+"\n Identificador del Transportista: " +prueba.ID +"\n Fecha Entrega: "+prueba.Transportista.Fecha_de_entrega+",     Fecha Recogida: "+prueba.Transportista.Fecha_de_recogida+"\n Empresa: "+prueba.Transportista.Empresa+"\n Estado de la firma: "+prueba.Firmado);


}