package unit2.task3;

/**
 * Created by chertvl on 5/12/2017.
 */
public class Erasure extends Stationary implements erasable {
    public void erase(String str) {
        System.out.println(str + " has been erased.");
    }
}
