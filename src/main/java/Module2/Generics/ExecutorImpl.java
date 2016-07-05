package Module2.Generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel Solo on 09.06.2016.
 */
public class ExecutorImpl<T> implements Executor<T> {

    List<Task<? extends T>> tasks=new ArrayList<>();
    List<T> validTasks = new ArrayList<>();
    List<T> inValidTasks = new ArrayList<>();

    boolean isExecute;

    @Override
    public void addTask(Task<? extends T> task) throws Exception{
        if (isExecute)throw new Exception();
        tasks.add(task);
        validTasks.add(task.getResult());
    }


    @Override
    public void addTask(Task<? extends T> task, Validator<? super T> validator) throws Exception {
        if (isExecute)throw new Exception();
        tasks.add(task);
        if (validator.isValid(task.getResult())) validTasks.add(task.getResult());
        else inValidTasks.add(task.getResult());

    }

    @Override
    public void execute() {
        isExecute = true;
    }

    @Override
    public List<T> getValidResults() throws Exception{
        if (!isExecute) throw new Exception();

        return validTasks;
    }

    @Override
    public List<T> getInvalidResults() throws Exception {
        if (!isExecute) throw new Exception();

        return inValidTasks;
    }
}