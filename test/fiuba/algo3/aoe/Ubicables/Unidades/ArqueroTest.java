package fiuba.algo3.aoe.Ubicables.Unidades;
import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Tablero.Tablero;
import fiuba.algo3.aoe.Ubicables.Direccion.DireccionDerecha;
import fiuba.algo3.aoe.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.Ubicables.Ubicable;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class ArqueroTest {
    @Test
    public void test01SeCreaCorrectamenteArquero(){
        Tablero tablero = new Tablero(10,10);
        Jugador jugador = new Jugador("Mauricio",tablero);
        Arquero arquero1 = new Arquero(jugador);

        Assert.assertEquals(arquero1.getVidaMaxima(), 75);
        Assert.assertEquals(arquero1.getVidaActual(), 75);
        Assert.assertEquals(arquero1.getCosto(),75);
    }


    @Test
    public void test02AlColocarUnaPiezaEnelTableroCambiaLaPosicionDeLaPiezaYEnElTablero(){
        Tablero tablero = new Tablero(10,10);
        Jugador jugador = new Jugador("Mauricio",tablero);
        Ubicable arquero1 = new Arquero(jugador);
        Posicion origen = new Posicion(2,5);
        tablero.colocar(arquero1,origen);
        Assert.assertThat(tablero.puedoColocar(origen), is(false) );
        Assert.assertThat(arquero1.getPosicion(), is(origen) );


    }


    @Test
    public void test03MoverCambiaLaPosicionEnElTableroYLaUnidadQuedaConLaNuevaPosicion(){
        Tablero tablero = new Tablero(10,10);
        Jugador jugador = new Jugador("Mauricio",tablero);
        UnidadMovil arquero1 = new Arquero(jugador);
        Direccionable direccion = new DireccionDerecha();

        Posicion origen = new Posicion(2,5);
        Posicion calculada = origen.calcularPosicionSiguiente(direccion);
        tablero.colocar(arquero1,origen);

        // le digo que se mueva y le paso la direccion
        arquero1.mover(tablero, direccion);
        Assert.assertThat(arquero1.getPosicion().seSuperponeCon(calculada), is(true) );
        Assert.assertThat(arquero1.getPosicion().seSuperponeCon(origen), is(false) ); // tiene la nueva posicion
        Assert.assertThat(tablero.puedoColocar(calculada), is(false) ); // la posicion en el tablero esta ocupada
        Assert.assertThat(tablero.puedoColocar(origen), is(true) ); // el origen esta libre

    }

    @Test
    public void test04Disminuir50VidaArmaDeAsedioDevuelve25DeVida(){
        Tablero tablero = new Tablero(10,10);
        Jugador jugador = new Jugador("Mauricio",tablero);
        Arquero arquero = new Arquero(jugador);
        arquero.disminuirVida(50);
        Assert.assertEquals(arquero.getVidaActual(), 25);
    }


}
