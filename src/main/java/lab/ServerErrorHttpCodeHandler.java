package lab;

public class ServerErrorHttpCodeHandler implements HttpStatusHandler {
    @Override
    public void handleCode(int code) {
        throw new RuntimeException("Server erro. Error code: " + code);
    }
}