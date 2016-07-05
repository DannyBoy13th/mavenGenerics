package Module2.Generics;

/**
 * Created by Daniel Solo on 09.06.2016.
 */
public class TaskExample <T extends Number> implements Task<T> {

    T number;
    T result;

    public TaskExample(T number){
        result = number;
    }


    @Override
    public void execute() {

    }

    @Override
    public T getResult() {
        return result;
    }
}
