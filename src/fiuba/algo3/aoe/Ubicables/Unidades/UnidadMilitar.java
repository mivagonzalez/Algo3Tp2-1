package fiuba.algo3.aoe.Ubicables.Unidades;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Ubicables.Atacable;
import fiuba.algo3.aoe.Ubicables.Atacante;


public abstract class UnidadMilitar extends UnidadMovil implements Atacante {

  //
    protected int danioUnidad;
    protected int danioEdificio;
    protected int distanciaAtaque;

    public void atacar(Atacable receptorDelAtaque, Jugador jugadorAtacante){

        if(!jugadorAtacante.esMio(this))
            throw new NoEsMiJugadorException(); // TODO reever esta excepcion

        /*if(jugadorAtacante.esMio(receptorDelAtaque))
            throw */ // TODO chequear que la unidad a atacar no sea mia

        if(this.posicion == null)
            throw new UnidadSinPosicionException();

        if(distanciaAtaque >= this.posicion.distancia(receptorDelAtaque.getPosicion()))
            receptorDelAtaque.serAtacadoPor(this);
        else
            throw new UnidadFueraDeRangoDeAtaqueException();
    }


    public int getDanioUnidad(){return danioUnidad;}

    public int getDanioEdificio() {return danioEdificio;}

    public int getDistanciaAtaque() { return distanciaAtaque;}
}
