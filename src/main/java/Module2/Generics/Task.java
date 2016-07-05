package Module2.Generics;

/**
 * Created by Daniel Solo on 07.06.2016.
 */
public interface Task <T>{

    // Метода запускает таск на выполнение
    void execute();

    // Возвращает результат выполнения
    T getResult();


}
