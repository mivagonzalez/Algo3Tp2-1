package fiuba.algo3.aoe.Tablero;

public class Casillero {

    private int x;
    private int y;

   public Casillero(int x, int y){

       this.x = x;
       this.y = y;

   }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

/*
    @Override
    public String toString(){
        return getX() + " " + getY();
    }
    */

//sobreescritura de metodos para poder usar la coordenada como key valida en el HashMap
   /*
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }*/
    //sobreescritura de metodos para poder usar la coordenada como key valida en el HashMap

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Casillero other = (Casillero) obj;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        return true;
    }
}