package mySpring;

import factory.InjectRandomInt;
import lombok.SneakyThrows;

import java.util.Random;

import java.lang.reflect.Field;

class RandomIntConfigurator implements ObjectConfigurator{
    private Random random = new Random();
    @Override
    @SneakyThrows
    public <T> void configureObject(T obj, Class<T> type)
    {
        Field[] fields = type.getDeclaredFields();
        for (Field field : fields) {

            InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
            if (annotation != null) {
                int min = annotation.min();
                int max = annotation.max();
                int randomIntValue = random.nextInt(max - min) + min;
                field.setAccessible(true);
                field.set(obj, randomIntValue);
            }
        }
    }
}
