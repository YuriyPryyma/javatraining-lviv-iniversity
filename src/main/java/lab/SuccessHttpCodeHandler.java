package lab;

public class SuccessHttpCodeHandler implements HttpStatusHandler {
    @Override
    public void handleCode(int code) {
        System.out.println("Good request. Code:  " + code);
    }
}