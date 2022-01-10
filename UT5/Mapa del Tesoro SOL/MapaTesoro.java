import java.util.Random;

/**
 * Guarda mediante un array bidimensional de valores boolean
 * un mapa del tesoro indicando si en una determinada fila,columna
 * hay o no un tesoro (la posici�n del array guarda true o false)
 */
public class MapaTesoro {
    private static final char CARACTER = '\u0024';
    private static final char PUNTO = '.';
    private static Random generador = new Random();
    private boolean[][] mapa;

    /**
     * construye el mapa de las dimensiones indicadas
     * y lo inicializa a valores boolean aleatorios
     * 
     */
    public MapaTesoro(int filas, int columnas) {
        mapa = new boolean[filas][columnas];
        inicializar();

    }

    /**
     * inicializa el array mapa a valores aleatorios true / false
     *  
     */
    private void inicializar() {
        for (int f = 0; f < mapa.length; f++) {
            for (int c = 0; c < mapa[0].length; c++) {
                // double valor = Math.random();
                // mapa[f][c] = Math.random() < 0.5;
                mapa[f][c] = generador.nextBoolean();

            }
        }
    }

    /**
     *    
     * @return  el n� de filas del mapa    
     */
    public int getFilas() {
        return mapa.length;

    }
    
    /**
     *    
     * @return  el n� de columnas del mapa    
     */
    public int getColumnas() {
        return mapa[0].length;

    }


    /**
     * representaci�n textual del mapa
     * (leer enunciado)
     */
    public String toString() {
        String str = "  ";
        for (int c = 0; c < mapa[0].length; c++) {
            str += String.format("%2s", String.valueOf(c));
        }
        str += "\n";
        for (int f = 0; f < mapa.length; f++) {
            str += String.format("%2s", String.valueOf(f));
            for (int c = 0; c < mapa[0].length; c++) {
                char car;
                if (mapa[f][c]) {
                    car = CARACTER;
                } else {
                    car = PUNTO;
                }
                str += String.format("%2c", car);

            }
            str += "\n";
        }
        return str;
    }

    

    /**
     * devuelve true si en la posici�n indicada hay un tesoro
     * false si la posici�n (f,c) no est� dentro de los l�mites del mapa
     * o no hay un tesoro en esa posici�n
     * 
     * Para saber si una posici�n est� dentro de los l�mites
     * del mapa del tesoro se usar� dentroLimites() 
     */
    public boolean hayTesoro(int f, int c) {
        return dentroLimites(f, c) && mapa[f][c];
    }

    /**
     * devuelve true si f,c est� dentro de los l�mites, false en otro caso
     * 
     */
    private boolean dentroLimites(int f, int c) {
        return f >= 0 && f < mapa.length && c >= 0 && c < mapa[f].length;
    }

    /**
     * devuelve el n� de tesoros  adyacentes a una posici�n dada f,c
     * Las posiciones adyacentes en el mapa a f,c son las ocho celdas (posiciones)
     * que la bordean (horizontal, vertical y diagonalmente)
     * Un tesoro en la posici�n dada f,c  no cuenta como adyacente.
     * El n� de tesoros adyacentes en una posici�n fuera de los l�mites es 0.
     */
    public int calcularNumeroTesorosAdyacentes(int f, int c) {
        if (!dentroLimites(f, c)) {
            return 0;
        }
        int total = 0;
        for (int i = f - 1; i <= f + 1; i++) {
            for (int j = c - 1; j <= c + 1; j++) {
                if (dentroLimites(i, j)) {
                    //                    if (this.hayTesoro(i, j)) {
                    //                        total++;
                    //                        if (i == f && j == c) {
                    //                            total--;
                    //                        }
                    //                    }

                    if (this.hayTesoro(i, j)) {
                        if (i != f || (i == f && j != c)) {
                            total++;
                        }
                    }

                }
            }

        }
        return total;
    }

    /**
     * Crea y devuelve un array bidimensional de enteros 
     * En este nuevo array se asignar� un 9 en la posici�n
     * f,c si hay un tesoro
     * Si no lo hay se asignar� el n� de tesoros adyacentes
     * a la posici�n f,c
     * 
     */
    public int[][] calcularTesoros() {
        int[][] tesoros = new int[mapa.length][mapa[0].length];
        for (int f = 0; f < mapa.length; f++) {
            for (int c = 0; c < mapa[0].length; c++) {
                if (this.hayTesoro(f, c)) {
                    tesoros[f][c] = 9;
                } else {
                    tesoros[f][c] = this.calcularNumeroTesorosAdyacentes(f, c);
                }

            }
        }
        return tesoros;
    }

}
