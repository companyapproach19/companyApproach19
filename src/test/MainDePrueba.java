package test;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
//NECESARIOS PARA TRAZABILIDAD:
import equipo6.otros.BlockchainServices;

import model.*;
import otros.*;
import controller.*;
public class MainDePrueba {

    public static void main(String[] args) {

        // Crea el directorio donde se guardan las peticiones
        new File("./peticiones").mkdirs();

        // ID arbitrario para un pedido de prueba
        int id = 49126;

        
        try {

            BufferedWriter escritor = new BufferedWriter(
                    new FileWriter("./peticiones/" + Integer.toString(id) + ".json")
            );

            Transportista transportistaPrueba = new Transportista(
                    "Juan Jose Romagosa", "Povas",
                    "08-03-2019", "13-03-2019");

            Productos productos = new Productos(20, 40, 0, 0, 0, 0, 0, 0, 0, 0, 0);

            OrdenTrazabilidad pedidoPrueba = new OrdenTrazabilidad(id, "Petici�n de prueba.",
                    OrdenTrazabilidad.Actor.FABRICA, OrdenTrazabilidad.Actor.COOPERATIVA,
                    transportistaPrueba, productos);
            
            //NECESARIO PARA TRAZABILIDAD:
            BlockchainServices bloque = new BlockchainServices();
            bloque.guardarOrden(pedidoPrueba);
            CodificadorJSON ejemplo=new CodificadorJSON();
           String json=ejemplo.crearJSON(pedidoPrueba);
           
            Main_pedidos a= new Main_pedidos(json);
            a.crear_pedido_pedido();
            escritor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
