package lab;

import lombok.Getter;

@Getter
public enum HttpStatus {
    Informational(100, 199, new InformationalHttpCodeHandler()),
    Success(200, 299, new SuccessHttpCodeHandler()),
    Redirection(300, 399, new RedirectionHttpCodeHandler()),
    ClientError(400, 499, new ClientErrorHttpCodeHandler()),
    ServerError(500, 599, new ServerErrorHttpCodeHandler());

    private final int minCode;
    private final int maxCode;
    private final lab.HttpStatusHandler handler;

    public void handleCode(int code)
    {
        handler.handleCode(code);
    }

    HttpStatus(int minCode, int maxCode, lab.HttpStatusHandler handler) {
        this.minCode = minCode;
        this.maxCode = maxCode;
        this.handler = handler;
    }

    public static lab.HttpStatus findByHttpCode(int httpCode) {
        lab.HttpStatus[] statuses = values();
        for (lab.HttpStatus status : statuses) {
            if (status.minCode <= httpCode && httpCode <= status.maxCode) {
                return status;
            }
        }
        throw new RuntimeException(httpCode + " not supported");
    }
}
