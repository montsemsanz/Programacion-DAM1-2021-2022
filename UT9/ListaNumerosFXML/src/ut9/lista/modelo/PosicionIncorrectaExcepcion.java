package ut9.lista.modelo;

public class PosicionIncorrectaExcepcion extends RuntimeException {
    private String mensaje;

    public PosicionIncorrectaExcepcion(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String getMessage() {
        return this.mensaje;
    }
}
