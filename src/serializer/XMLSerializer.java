package serializer;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import transport.Transport;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;

public class XMLSerializer implements Serializer {
    private final Charset charset = StandardCharsets.UTF_8;

    public void save(OutputStream out, Collection<? extends Transport> ts) throws IOException {

        try {
            XMLOutputFactory output = XMLOutputFactory.newInstance();
            XMLStreamWriter writer = output.createXMLStreamWriter(new OutputStreamWriter(out, charset));

            writer.writeStartDocument(charset.displayName(), "1.0");
            writer.writeStartElement("Transports");

            for (Transport t : ts)
                t.write(writer);

            writer.writeEndElement();
            writer.writeEndDocument();

            writer.flush();
            writer.close();
        } catch (XMLStreamException e) {
            throw new IOException(e);
        }
    }
    public Collection<? extends Transport> load(InputStream in) throws IOException {
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(in);
            Node root = document.getDocumentElement();
            NodeList nodes = root.getChildNodes();
            ArrayList<Transport> ts = new ArrayList<>(nodes.getLength());
            for (int i = 0; i < nodes.getLength(); i++) {
                Node item = nodes.item(i);
                if (item.getNodeType() != Node.TEXT_NODE) {
                    Transport t = Transport.read(item);
                    if (t != null)
                        ts.add(t);
                }
            }
            return ts;
        } catch (Exception e) {
            throw new IOException(e);
        }
    }
}