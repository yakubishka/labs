package yakubishka.ru.lab8;

public class Test {

  private void method1() {
    System.out.println("METHOD 1");
  }

  @CountOfExecution(3)
  private void method2() {
    System.out.println("METHOD 2");
  }

  @CountOfExecution(4)
  private void method3() {
    System.out.println("METHOD 3");
  }

  private void method4() {
    System.out.println("METHOD 4");
  }

}
