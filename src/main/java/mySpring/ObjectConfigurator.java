package mySpring;

public interface ObjectConfigurator {
    public <T> void configureObject(T obj, Class<T> type);
}
