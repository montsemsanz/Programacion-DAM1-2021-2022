package ut9.calculadora.controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import ut9.calculadora.modelo.Calculadora;

public class CalculadoraController {

    @FXML
    private Label lblResultado;

    @FXML
    private Button btnCalcular;

    @FXML
    private TextField txtNumero1;

    @FXML
    private TextField txtNumero2;

    @FXML
    private RadioButton rbtSuma;

    @FXML
    private RadioButton rbtResta;

    @FXML
    private RadioButton rbtProducto;

    @FXML
    private RadioButton rbtDivision;

    private Calculadora calculadora;

    @FXML
    public void initialize() {
        this.calculadora = new Calculadora();

    }

    @FXML
    void calcular(ActionEvent event) {
        TextField target = txtNumero1;
        String txtN1 = txtNumero1.getText().trim();
        String txtN2 = txtNumero2.getText().trim();
        if (txtN1.isEmpty()) {
            mostrarMensaje("Teclee valor");
            cogerFoco(target);

        } else if (txtN2.isEmpty()) {
            target = txtNumero2;
            mostrarMensaje("Teclee valor");
            cogerFoco(target);

        } else {

            try {
                target = txtNumero1;
                int n1 = Integer.parseInt(txtN1);
                target = txtNumero2;
                int n2 = Integer.parseInt(txtN2);
                target = txtNumero1;
                if (rbtSuma.isSelected()) {
                    int resul = calculadora.sumar(n1, n2);
                    lblResultado.setText(String.format("Suma: " + resul));
                } else if (rbtResta.isSelected()) {
                    int resul = calculadora.restar(n1, n2);
                    lblResultado.setText(String.format("Resta: " + resul));
                } else if (rbtProducto.isSelected()) {
                    int resul = calculadora.multiplicar(n1, n2);
                    lblResultado.setText(String.format("Producto: " + resul));
                } else {
                    try {
                        int resul = calculadora.dividir(n1, n2);
                        lblResultado.setText(
                                String.format("División entera: "
                                        + resul));

                    } catch (ArithmeticException e) {
                        mostrarMensaje("Error división entre 0");
                        target = txtNumero2;

                    }

                }

            } catch (NumberFormatException e) {

                mostrarMensaje("Error al convertir nº");
            } finally {
                cogerFoco(target);
            }

        }

    }

    private void mostrarMensaje(String mensaje) {

        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setTitle("Aviso al usuario/a");
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();

    }

    private void cogerFoco(TextField target) {

        target.requestFocus();
        target.selectAll();

    }

}
