package serializer;

import transport.Transport;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class JavaSerializer implements Serializer {
    @Override
    public void save(File out, Collection<? extends Transport> ts) throws IOException {
        if (Objects.requireNonNull(ts).isEmpty())
            return;
        try (ObjectOutputStream os = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream(out)))) {
            for (Transport t : ts)
                os.writeObject(t);
        }
    }

    @Override
    public Collection<? extends Transport> load(File in) throws IOException {
        try (ObjectInputStream is = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream(in)))) {
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
