package sample;

import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import transport.Transport;

import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;

public interface ViewModel extends Controller {
    Main getMain();
    void setMain(Main m);

    Transport getTransport();
    void setTransport(Transport t);

    default void setOnEnterIntSetter(TextField f, IntConsumer setter) {
        f.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                try {
                    setter.accept(Integer.parseInt(f.getText().trim()));
                    getMain().refresh();
                } catch (Exception ex) {
                    getMain().handle(ex);
                }
            }
        });
    }
    default void setOnEnterDoubleSetter(TextField f, DoubleConsumer setter) {
        f.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                try {
                    setter.accept(Double.parseDouble(f.getText().trim()));
                    getMain().refresh();
                } catch (Exception ex) {
                    getMain().handle(ex);
                }
            }
        });
    }
    default void setOnEnterStringSetter(TextField f, Consumer<String> setter) {
        f.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                try {
                    setter.accept(f.getText().trim());
                    getMain().refresh();
                } catch (Exception ex) {
                    getMain().handle(ex);
                }
            }
        });
    }
}