package serializer;

import transport.Transport;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class JavaSerializer implements Serializer {
    public void save(OutputStream out, Collection<? extends Transport> ts) throws Exception {
        if (Objects.requireNonNull(ts).isEmpty())
            return;
        try (ObjectOutputStream os = new ObjectOutputStream(out)) {
            for (Transport t : ts)
                os.writeObject(t);
        }
    }
    public Collection<? extends Transport> load(InputStream in) throws Exception {
        try (ObjectInputStream is = new ObjectInputStream(in)) {
            ArrayList<Transport> transports = new ArrayList<>();
            while (true) {
                try {
                    transports.add(((Transport) is.readObject()));
                } catch (EOFException e) {
                    break;
                }
            }
            return transports;
        }
    }
}
