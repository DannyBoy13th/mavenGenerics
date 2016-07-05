package Module2.Generics;

import java.util.List;

/**
 * Created by Daniel Solo on 07.06.2016.
 */
public interface Executor <T>{

    void addTask(Task <? extends T> task) throws Exception;

    void addTask(Task <? extends T> task, Validator<? super T> validator) throws Exception;

    void execute() throws Exception;

    List <T> getValidResults() throws Exception;

    List <T> getInvalidResults() throws Exception;


}
