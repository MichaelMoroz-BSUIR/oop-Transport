package sample;

import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import transport.Transport;

import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;

public interface ViewModel<T extends Transport> extends Controller {
    void bind(T t, Main eh);

    static void setOnEnterIntSetter(TextField f, IntConsumer setter, Main eh) {
        f.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                try {
                    setter.accept(Integer.parseInt(f.getText().trim()));
                    eh.refresh();
                } catch (Exception ex) {
                    eh.handle(ex);
                }
            }
        });
    }
    static void setOnEnterDoubleSetter(TextField f, DoubleConsumer setter, Main eh) {
        f.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                try {
                    setter.accept(Double.parseDouble(f.getText().trim()));
                    eh.refresh();
                } catch (Exception ex) {
                    eh.handle(ex);
                }
            }
        });
    }
    static void setOnEnterStringSetter(TextField f, Consumer<String> setter, Main eh) {
        f.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                try {
                    setter.accept(f.getText().trim());
                    eh.refresh();
                } catch (Exception ex) {
                    eh.handle(ex);
                }
            }
        });
    }
}