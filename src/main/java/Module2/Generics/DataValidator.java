package Module2.Generics;

/**
 * Created by Daniel Solo on 09.06.2016.
 */
public class DataValidator implements Validator<Number> {

    @Override
    public boolean isValid(Number result) {
            boolean num = (result != null) && (result.longValue()%2==0);
            return num;
    }
}
