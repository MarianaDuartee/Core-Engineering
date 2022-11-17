package org.marianaduarte.Tema05;

public class EstadoLampada {

    private Lampada lampada;
    private boolean estado=false;

    public EstadoLampada(Lampada lampada){

        this.lampada = lampada;
    }

    public void switchState(){
        if(estado){
            lampada.Off();
            this.estado = false;
        }
        else{
            lampada.On();
            this.estado = true;
        }
    }

    public boolean Estado(){
        return estado;
    }


}
