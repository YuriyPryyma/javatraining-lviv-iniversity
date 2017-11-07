package lab;

public class ClientErrorHttpCodeHandler implements HttpStatusHandler {
    @Override
    public void handleCode(int code) {
        throw new RuntimeException("Client error. Error code: " + code);
    }
}