package equipo6.model;

import java.io.Serializable;

public class DatosContainer implements Serializable{
    Object datos;
    
    public DatosContainer(){}
    
    public DatosContainer(Object datos){
        this.datos=datos;
    }
    
    public Object getDatos(){
        return this.datos;   
    }
    
    public void setDatos(Object datos){
        this.datos=datos;   
    }
}
