package lab;

public class RedirectionHttpCodeHandler implements HttpStatusHandler {
    @Override
    public void handleCode(int code) {
        System.out.println("Redirect. Code:  " + code);
    }
}