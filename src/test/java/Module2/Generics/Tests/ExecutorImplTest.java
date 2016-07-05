package Module2.Generics.Tests;

import Module2.Generics.DataValidator;
import Module2.Generics.ExecutorImpl;
import Module2.Generics.Task;
import Module2.Generics.TaskExample;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel Solo on 12.06.2016.
 */
public class ExecutorImplTest {
    ExecutorImpl executor = new ExecutorImpl();
    DataValidator validator = new DataValidator();

    @Test
    public void testExecutor() throws Exception {

        List<Task<Long>> list = new ArrayList<Task<Long>>();

        list.add(new TaskExample<>(10L));
        list.add(new TaskExample<>(100L));
        list.add(new TaskExample<>(15L));
        test1(list);
    }

    public void test1(List<Task<Long>> tasks) throws Exception {
        for (Task<Long> task : tasks) {
            executor.addTask(task);
        }
        executor.addTask(new TaskExample<>(10L), validator);
        executor.addTask(new TaskExample<>(1L), validator);
        executor.addTask(new TaskExample<>(3L), validator);
        executor.addTask(new TaskExample<>(0L), validator);
        executor.execute();


        List<Long> listInvalid = executor.getInvalidResults();

        List<Long> listValid = executor.getValidResults();

        System.out.println("Valid:");
        for (Long aLong : listValid) {
            System.out.println(aLong);
        }

        System.out.println("Invalid:");
        for (Long aLong : listInvalid) {
            System.out.println(aLong);
        }


    }

}