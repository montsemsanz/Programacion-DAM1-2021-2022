package ut8.matrices.modelo;

public class Matriz {

    private int[][] matriz;

    /**
     * Constructor de la clase Matriz
     * Crea una matriz vacía con el nº de filas y
     * columnas especificado
     *
     */
    public Matriz(int filas, int columnas) throws MatrizExcepcion {

        if (filas <= 0) {
            throw new MatrizExcepcion("Error, filas 0 o negativos");
        }
        if (columnas <= 0) {
            throw new MatrizExcepcion("Error, columnas 0 o negativos");
        }
        matriz = new int[filas][columnas];

    }

    /**
     * obtiene el valor de una determinada fila y columna de la matriz
     */
    public int getValor(int f, int c) throws MatrizExcepcion {

        if (f < 0 || f >= getFilas()) {
            throw new MatrizExcepcion("Fila incorrecta");
        }
        if (c < 0 || c >= getColumnas()) {
            throw new MatrizExcepcion("Columna incorrecta");
        }
        return matriz[f][c];
    }

    /**
     * accesor para las filas de la matriz
     *
     * @return el nº de filas de la matriz
     */
    public int getFilas() {

        return matriz.length;
    }

    /**
     * accesor para las columnas de la matriz
     *
     * @return el nº de columnas
     */
    public int getColumnas() {

        return matriz[0].length;
    }

    /**
     * mutador establece el nuevo valor en una fila y columnas determinadas
     *
     */
    public void setValor(int valor, int f, int c) throws MatrizExcepcion {

        if (f < 0 || f >= getFilas()) {
            throw new MatrizExcepcion("Fila incorrecta" + f);
        }
        if (c < 0 || c >= getColumnas()) {
            throw new MatrizExcepcion("Columna incorrecta");
        }
        matriz[f][c] = valor;
    }

    /**
     * Suma la matriz actual con la que recibe como parámetro
     *
     */
    public Matriz sumar(Matriz otra) throws MatrizExcepcion {

        int filas = getFilas();
        int columnas = getColumnas();
        if (otra == null) {
            throw new MatrizExcepcion("matriz nula");
        }
        if (otra.getFilas() != filas) {
            throw new MatrizExcepcion("Filas no coinciden");
        }
        if (otra.getColumnas() != columnas) {
            throw new MatrizExcepcion("Columnas no coinciden");
        }

        Matriz suma = new Matriz(filas, columnas);
        for (int f = 0; f < filas; f++) {
            for (int c = 0; c < columnas; c++) {
                int valor = matriz[f][c] + otra.getValor(f, c);
                suma.setValor(valor, f, c);
            }
        }
        return suma;
    }

    /**
     * Multiplica la matriz actual por la que recibe como parámetro
     */
    public Matriz producto(Matriz otra) throws MatrizExcepcion {

        if (otra == null) {
            throw new MatrizExcepcion("ut8.matrices.modelo.Matriz null");
        }
        if (this.getColumnas() != otra.getFilas()) {
            throw new MatrizExcepcion(
                    "Columns de la 1ª no coinciden con filas "
                            + "de la 2ª");
        }

        int filas = getFilas();
        int columnas = getColumnas();
        Matriz producto = new Matriz(filas, otra.getColumnas());
        for (int f = 0; f < filas; f++) {
            for (int c = 0; c < otra.getColumnas(); c++) {
                int valor = 0;
                for (int k = 0; k < getColumnas(); k++) {
                    valor += matriz[f][k] * matriz[k][c];
                }
                producto.setValor(valor, f, c);
            }
        }
        return producto;
    }

    /**
     * @return String representación textual de la matriz
     */
    @Override
    public String toString() {

        StringBuilder str = new StringBuilder();
        str.append(matriz.length + "\t" + matriz[0].length + "\n");
        for (int f = 0; f < getFilas(); f++) {
            for (int c = 0; c < getColumnas(); c++) {
                str.append(matriz[f][c] + "\t");
            }
            str.append("\n");
        }
        return str.toString();
    }

    /**
     * Multiplica la matriz actual por otra
     *
     *
     */
    public Matriz multiplicarPor(Matriz otra) throws MatrizExcepcion {

        int filas = getFilas();
        int columnas = getColumnas();
        if (otra == null) {
            throw new MatrizExcepcion("Parámetro incorrecto, matriz null");
        }
        if (columnas != otra.getFilas()) {
            throw new MatrizExcepcion("Parámetro incorrecto, columnas"
                    + " de la primera matriz y filas de la segunda matriz no coinciden");
        }
        Matriz producto = new Matriz(filas, otra.getColumnas());
        for (int f = 0; f < filas; f++) {
            for (int c = 0; c < otra.getColumnas(); c++) {
                int resul = 0;
                for (int k = 0; k < columnas; k++) {
                    resul += matriz[f][k] * otra.getValor(k, c);
                }
                producto.setValor(resul, f, c);
            }
        }
        return producto;
    }

}
