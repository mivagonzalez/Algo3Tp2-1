package Entrega1;

import fiuba.algo3.aoe.modelo.Jugadores.Jugador;
import fiuba.algo3.aoe.modelo.Mapa.Mapa;
import fiuba.algo3.aoe.modelo.Ubicables.Edificios.Castillo;
import fiuba.algo3.aoe.modelo.Ubicables.Edificios.EdificioConstruible;
import fiuba.algo3.aoe.modelo.Ubicables.Edificios.PlazaCentral;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadAldeano.Aldeano;
import fiuba.algo3.aoe.modelo.Ubicables.posicion.PosicionReal;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

public class IntegracionTest {

    private Castillo castillo= new Castillo();
    private ArrayList<Aldeano> aldeanos = new ArrayList<>();
    private PlazaCentral plaza;
    private Jugador jugador;

    @Before
    public void setUp(){
        plaza = new PlazaCentral();
        aldeanos.add(new Aldeano());
        aldeanos.add(new Aldeano());
        aldeanos.add(new Aldeano());
        jugador = new Jugador("ElDiego",castillo,plaza,aldeanos);
    }

    @Test
    public void test01AldeanoAlContruirEdificioYpasar3TurnosQuedaLibre(){
        Mapa mapa = new Mapa(500,500);
        PosicionReal posicionReal = new PosicionReal(10,10);
        Castillo castillo = new Castillo();
        Aldeano aldeano = new Aldeano();
        EdificioConstruible plaza = new PlazaCentral();

        jugador.agregarPieza(aldeano);
        jugador.sumarOro(25);

        aldeano.construirEdificio(plaza,mapa,jugador, posicionReal);

        jugador.esTuTurno(); //turno 1
        Assert.assertFalse( aldeano.estasDisponible());
        jugador.esTuTurno(); //turno 2
        Assert.assertFalse( aldeano.estasDisponible());
        jugador.esTuTurno(); //turno 3
        Assert.assertTrue( aldeano.estasDisponible());

    }
    @Test
    public void test02AldeanoConstruyendoAlPasar3TurnosNoSumaOro(){

        Mapa mapa = new Mapa(500,500);
        PosicionReal posicionReal = new PosicionReal(10,10);
        Castillo castillo = new Castillo();
        Aldeano aldeano = new Aldeano();
        EdificioConstruible plaza = new PlazaCentral();

        jugador.agregarPieza(aldeano);
        jugador.sumarOro(25);
        aldeano.construirEdificio(plaza,mapa,jugador, posicionReal);

        Aldeano mockAldeano = Mockito.mock (Aldeano.class);
        Mockito.when(mockAldeano.getCosto()).thenReturn(1);

        Assert.assertFalse(jugador.puedoAgregar(mockAldeano));
        jugador.esTuTurno(); //turno 1 (3 aldeanos * 20) = 60
        jugador.esTuTurno(); //turno 2 = 120
        jugador.esTuTurno(); //turno 3 = 180

        Aldeano mockAldeano180 = Mockito.mock (Aldeano.class);
        Mockito.when(mockAldeano180.getCosto()).thenReturn(180);

        Aldeano mockAldeano181 = Mockito.mock (Aldeano.class);
        Mockito.when(mockAldeano181.getCosto()).thenReturn(181);

        Assert.assertTrue(jugador.puedoAgregar(mockAldeano180));
        Assert.assertFalse(jugador.puedoAgregar(mockAldeano181));

    }
    @Test
    public void test03AldeanoConstruyendoAlPasar4TurnosSumaOro(){

        Mapa mapa = new Mapa(500,500);
        PosicionReal posicionReal = new PosicionReal(10,10);
        Castillo castillo = new Castillo();
        Aldeano aldeano = new Aldeano();
        EdificioConstruible plaza = new PlazaCentral();

        jugador.agregarPieza(aldeano);
        jugador.sumarOro(25);
        aldeano.construirEdificio(plaza,mapa,jugador, posicionReal);

        Aldeano mockAldeano = Mockito.mock (Aldeano.class);
        Mockito.when(mockAldeano.getCosto()).thenReturn(1);

        jugador.esTuTurno(); //turno 1   60
        jugador.esTuTurno(); //turno 2   120
        jugador.esTuTurno(); //turno 3  180
        jugador.esTuTurno(); //turno 4  240 +20 del aldeano libre


        Aldeano mockAldeano260 = Mockito.mock (Aldeano.class);
        Mockito.when(mockAldeano260.getCosto()).thenReturn(260);

        Aldeano mockAldeano261 = Mockito.mock (Aldeano.class);
        Mockito.when(mockAldeano261.getCosto()).thenReturn(261);

        Assert.assertTrue(jugador.puedoAgregar(mockAldeano260));
        Assert.assertFalse(jugador.puedoAgregar(mockAldeano261));


    }

}
