package fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Ubicables.Edificios.Edificio;
import fiuba.algo3.aoe.Ubicables.Edificios.EdificioConstruible;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadAldeano.Aldeano;

public class EstadoAConstruir implements EstadoEdificioConstruible {

    public boolean puedoConstruir(){
        return true;
    }

    public boolean puedoReparar(){
        return false;
    }


    public void construir(EdificioConstruible edificio, Aldeano aldeano, Jugador jugador){
        edificio.comenzarConstruccion ( aldeano, jugador );

    }

    public void reparar(Edificio edificio,Aldeano aldeano){
       throw new EdificioNoPuedeRepararseEnEsteMomentoException();
    }

    @Override
    public void nuevoTurno (EdificioConstruible edificio,int curacion) {

    }

    public boolean puedoCrearUnidad(){
        return false;
    }

    public void liberarAldeano(){
        throw new EdificioNoEstaSiendoConstruidoOReparadoException();
    }
}
