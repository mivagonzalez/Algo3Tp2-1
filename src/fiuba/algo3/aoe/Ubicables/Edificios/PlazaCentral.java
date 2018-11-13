package fiuba.algo3.aoe.Ubicables.Edificios;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable.EstadoEnConstruccion;
import fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable.EstadoEnReparacion;

public class PlazaCentral extends Edificio {

    public PlazaCentral( Jugador jugador ){
        this.costo = 100;
        this.vidaMaxima = 450;
        this.vidaActual = 450;
        this.estado = new EstadoEnConstruccion(3);
        this.jugador = jugador;
    }

    public void reparar(){
        if(estado.enConstruccion()){
            throw new EdificioSinDaniarException();
        }
        if(!this.estaDaniado()){
            throw new EdificioSinDaniarException();
        }
        if (estado.enReparacion()){
            estado.reparar(this);
        }else {
            this.aumentarVida(25);
            this.estado = new EstadoEnReparacion(25);
        }
    }

}

