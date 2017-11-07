package lab;

import groovy.ui.Console;

public class InformationalHttpCodeHandler implements HttpStatusHandler {
    @Override
    public void handleCode(int code) {
        System.out.println("Information responce. Code: " + code);
    }
}