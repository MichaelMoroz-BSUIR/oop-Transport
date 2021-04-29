package sample;

import transport.Transport;

interface Entry {
    Transport getValue();
    Controller getController();
    void bind(Main main);
}