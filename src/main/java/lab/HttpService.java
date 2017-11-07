package lab;

public class HttpService {
    HttpService()
    {

    }
    public void handleHttpCode(int code) {
        HttpStatus httpCode = HttpStatus.findByHttpCode(code);
        httpCode.handleCode(code);
    }
}
