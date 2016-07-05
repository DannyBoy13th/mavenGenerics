package Module2.Generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel Solo on 05.07.2016.
 */
public class Main {

    public static void main(String[] args) throws Exception {

        List<Task<Long>> list = new ArrayList<Task<Long>>();

        list.add(new TaskExample<>(10L));
        list.add(new TaskExample<>(100L));
        list.add(new TaskExample<>(15L));
        launcher(list);
    }

    public static void launcher(List<Task<Long>> tasks) throws Exception {
        ExecutorImpl executor = new ExecutorImpl();
        DataValidator validator = new DataValidator();
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

        System.out.println("Below you can see Vaild/Invalid results:");

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


