package fiuba.algo3.aoe.Tablero;

import fiuba.algo3.aoe.Ubicables.Direccion.DireccionAbajo;
import fiuba.algo3.aoe.Ubicables.Direccion.DireccionDerecha;
import fiuba.algo3.aoe.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadMovil;
import fiuba.algo3.aoe.Ubicables.posicion.Casillero.Casillero;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;
import fiuba.algo3.aoe.Ubicables.Ubicable;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.hamcrest.CoreMatchers.is;

public class TableroTest {
//TODO: que no se pueda crear con numeros negativos y definir el tamanio minimo, que debe ser para que entren el castillo y la ciudad



    @Test
    public void test01AlCrearElTableroPuedoColocarDeberiaDarTrueSiLaPosicionPerteneceAlTablero() {

         Tablero tablero = new Tablero( 10,10);
         Posicion posicionDentroDeTablero = new Posicion(1,1);

        Assert.assertThat( tablero.puedoColocar(posicionDentroDeTablero), is( true ) );
   }

    @Test
    public void test02AlCrearElTableroPuedoColocarDeberiaDarFalseSiLaPosicionNoPerteneceAlTablero() {

        Tablero tablero = new Tablero( 10,10);
        Posicion posicionFueraDeTablero = new Posicion(11,1);
        Assert.assertFalse( tablero.puedoColocar(posicionFueraDeTablero) );
    }

    @Test
    public void test03PuedoColocarDebeDarTrueSiLaPosicionNoEstaOcupada() {

        Tablero tablero = new Tablero( 10,10);
        Posicion posicion = new Posicion(1,1);
        Assert.assertThat( tablero.puedoColocar(posicion), is( true ) );
    }

    @Test
    public void test04PuedoColocarDebeDarFalseSiLaPosicionEstaOcupadaPorUnidad()  {

        Tablero tablero = new Tablero( 10,10);
        Posicion posicion = new Posicion(1,1);
        Ubicable elemento = new UnidadMovil();
        tablero.colocar(elemento,posicion);

        Assert.assertThat( tablero.puedoColocar(posicion), is( false ) );
    }

    @Test
    public void test05PuedoColocarDebeDarTrueLuegoDeQuitarUnidadAnterior()  {

        Tablero tablero = new Tablero( 10,10);
        Posicion posicion = new Posicion(1,1);
        Ubicable elemento = new UnidadMovil();
        Assert.assertEquals( tablero.puedoColocar(posicion), true );
        tablero.colocar(elemento,posicion);
        Assert.assertEquals(tablero.puedoColocar(posicion), false);
        tablero.remover(elemento);
        Assert.assertEquals( tablero.puedoColocar(posicion),  true  );
    }


    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Test
    public void test06AgregarDebeLanzarExcepcionSiIntentoColocarUnidadFueraDelTablero() {

        Tablero tablero = new Tablero( 10,10);
        Posicion posicionFueraDeTablero = new Posicion(11,1);
        Ubicable elemento = new UnidadMovil();
        elemento.colocarEn(posicionFueraDeTablero);
        thrown.expect(FueraDeTableroException.class);
        tablero.colocar(elemento,posicionFueraDeTablero);
      }

   @Test
    public void test07AgregarDebeLanzarExcepcionSiIntentoColocarUnidadEnUnaPosicionOcupada(){

        Tablero tablero = new Tablero( 10,10);

        Posicion unaPosicion = new Posicion(3,3);
        unaPosicion.agregar(new Casillero(6,6));

        Posicion posicionSuperpuesta = new Posicion(6,6);


        Ubicable elemento = new UnidadMovil();
        elemento.colocarEn(unaPosicion);
        Ubicable elementoSuperpuesto = new UnidadMovil();
        elementoSuperpuesto.colocarEn(posicionSuperpuesta);
        tablero.colocar(elemento,unaPosicion);

        thrown.expect(Posicion.PosicionOcupadaException.class);
        tablero.colocar(elementoSuperpuesto,posicionSuperpuesta);
    }

    @Test
    public void test08PuedoColocarDebeDarFalseSiLaPosicionEstaOcupadaPorPosicionVariosCasilleros()  {

        Tablero tablero = new Tablero( 10,10);
        Posicion posicion = new Posicion(1,1);
        posicion.agregar(new Casillero(1,2));
        posicion.agregar(new Casillero(2,2));
        posicion.agregar(new Casillero(2,1));
        Ubicable elemento = new UnidadMovil();
        tablero.colocar(elemento,posicion);

        Assert.assertThat( tablero.puedoColocar(posicion), is( false ) );
    }

    @Test
    public void test09RemoverDebeLanzarExcepcionSiElElementoNoFueColocadoPreviamente(){

        Tablero tablero = new Tablero( 10,10);
        Ubicable elemento= new UnidadMovil();


        thrown.expect(NoExisteElementoException.class);
        tablero.remover(elemento);

    }

    @Test
    public void test10RemoverRemueveElElementoColocadoPreviamente(){

        Tablero tablero = new Tablero( 10,10);

        Posicion unaPosicion = new Posicion(3,3);
        Ubicable elemento= new UnidadMovil();

        tablero.colocar(elemento,unaPosicion);

        tablero.remover(elemento);
        Assert.assertThat( tablero.puedoColocar(unaPosicion), is( true ) );

    }



    @Test
   public void test12MoverDebeLanzarExcepcionSiElDestinoEstaFueraDelTablero(){
        Tablero tablero = new Tablero( 10,10);
        Posicion posicion = new Posicion(10,10);


        Ubicable elemento = new UnidadMovil();
        tablero.colocar(elemento,posicion);
        Direccionable derecha = new DireccionDerecha();



       thrown.expect(FueraDeTableroException.class);
       tablero.mover(elemento,derecha);
   }

    @Test
    public void test13AlMoverLaPosicionOriginalQuedaLibreYElDestinoOcupado(){
        Tablero tablero = new Tablero( 10,10);
        Posicion posicionInicial = new Posicion(9,10);

        Posicion posicionDestino = new Posicion(10,10);

        Ubicable elemento = new UnidadMovil();
        tablero.colocar(elemento,posicionInicial);
        Direccionable derecha = new DireccionDerecha();

        tablero.mover(elemento,derecha);

        Assert.assertThat( tablero.puedoColocar(posicionInicial), is( true ) );
        Assert.assertThat( tablero.puedoColocar(posicionDestino), is( false ) );

    }

    @Test
    public void test14MoverDebeLanzarExcepcionSiElElementoNoFueAgregadoPreviamente(){
        Tablero tablero = new Tablero( 10,10);

       // Posicion unaPosicion = new Posicion(3,3);
        Ubicable elemento= new UnidadMovil();

       // tablero.colocar(elemento,unaPosicion);
        Direccionable direccion = new DireccionAbajo();
        thrown.expect(NoExisteElementoException.class);
        tablero.mover(elemento, direccion);

    }

    @Test
   public void test14MoverDebeLanzarExcepcionSiElDestinoEstaOcupado(){
        Tablero tablero = new Tablero( 10,10);
        Direccionable derecha = new DireccionDerecha();

        Posicion posicionInicial = new Posicion(9,10);
        Posicion posicionDestino = new Posicion(10,10);

        Ubicable elemento = new UnidadMovil();
        tablero.colocar(elemento,posicionInicial);

        Ubicable elemento2 = new UnidadMovil();
        tablero.colocar(elemento2,posicionDestino);

        thrown.expect(Posicion.PosicionOcupadaException.class);
        tablero.mover(elemento,derecha);
    }


}



