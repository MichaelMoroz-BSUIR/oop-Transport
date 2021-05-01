package serializer;

import transport.Transport;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

public interface Serializer {
    void save(File out, Collection<? extends Transport> ts) throws IOException;
    Collection<? extends Transport> load(File in) throws IOException;
}