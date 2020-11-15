package yakubishka.ru.lab8;


import java.lang.reflect.Method;

// Написать аннотацию с целочисленным параметром.
// Создать класс, содержащий только приватные методы (3-4шт),
// аннотировать любые из них. Вызвать из другого класса все
// аннотированные методы столько раз, сколько указано в параметре аннотации.
public class Lab8 {

  public static void main(String[] args) {
    Test test = new Test();
    Class<?> klass = test.getClass();
    for (Method method: klass.getDeclaredMethods()) {
      if (method.isAnnotationPresent(CountOfExecution.class)) {
        method.setAccessible(true);
        for(int i=0; i < method.getAnnotation(CountOfExecution.class).value(); i++) {
          try {
            method.invoke(test);
          } catch (Exception e) {
            e.printStackTrace();
          }
        }
      }
    }
  }

}
