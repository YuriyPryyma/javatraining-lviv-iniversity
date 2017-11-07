package mySpring;

import factory.InjectRandomInt;
import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class ObjectFactory {
    private static ObjectFactory ourInstance = new ObjectFactory();
    private Config config = new JavaConfig();
    private List<ObjectConfigurator> configuratos = new ArrayList<ObjectConfigurator>();

    public static ObjectFactory getInstance() {
        return ourInstance;
    }

    private ObjectFactory() {
    }

    public void addConfigurator(ObjectConfigurator configurator)
    {
        configuratos.add(configurator);
    }

    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        if (type.isInterface()) {
           type =  config.getImpl(type);
        }
        T o = type.newInstance();
        for (ObjectConfigurator configurator : configuratos) {
            configurator.configureObject(o, type);
        }
        return o;
    }
}
