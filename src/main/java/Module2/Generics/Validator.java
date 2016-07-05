package Module2.Generics;

/**
 * Created by Daniel Solo on 07.06.2016.
 */
public interface Validator <T> {

    // Валидирует переданое значение

    boolean isValid(T result);

}
