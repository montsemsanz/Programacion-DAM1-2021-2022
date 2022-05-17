package ut9.calculadora.modelo;

public class DatoIncorrectoException extends RuntimeException {

    private String mensaje;

    public DatoIncorrectoException(String mensaje) {

        this.mensaje = mensaje;
    }

    @Override
    public String getMessage() {

        return mensaje;
    }

}
