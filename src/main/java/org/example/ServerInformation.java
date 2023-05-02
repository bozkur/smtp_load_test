package org.example;

public class ServerInformation {

    private final String hostname;
    private final int port;
    private final boolean tlsEnabled;


    public ServerInformation(String hostname, int port, boolean tlsEnabled) {
        this.hostname = hostname;
        this.port = port;
        this.tlsEnabled = tlsEnabled;
    }

    public String getHostname() {
        return hostname;
    }

    public int getPort() {
        return port;
    }

    public boolean isTlsEnabled() {
        return tlsEnabled;
    }
}
