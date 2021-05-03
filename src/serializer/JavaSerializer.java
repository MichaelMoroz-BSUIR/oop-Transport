package serializer;

import transport.Transport;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class JavaSerializer implements Serializer {
    public void save(OutputStream out, Collection<? extends Transport> ts) throws IOException {
        if (Objects.requireNonNull(ts).isEmpty())
            return;
        try (ObjectOutputStream os = new ObjectOutputStream(
                new BufferedOutputStream(out))) {
            for (Transport t : ts)
                os.writeObject(t);
        }
    }
    public Collection<? extends Transport> load(InputStream in) throws IOException {
        try (ObjectInputStream is = new ObjectInputStream(
                new BufferedInputStream(in))) {
            ArrayList<Transport> transports = new ArrayList<>();
            while (true) {
                try {
                    transports.add(((Transport) is.readObject()));
                } catch (ClassNotFoundException | ClassCastException e) {
                    throw new IOException(e);
                } catch (EOFException e) {
                    break;
                }
            }
            return transports;
        }
    }
}
