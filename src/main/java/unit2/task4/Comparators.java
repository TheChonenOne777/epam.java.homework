package unit2.task4;

import unit2.task3.*;
import unit2.task3.Stationary;

import java.util.Arrays;
import java.util.Comparator;

public class Comparators {

    public static final PriceComparator priceComparator = new PriceComparator();
    public static final NameComparator nameComparator = new NameComparator();
    public static final PriceAndNameComparator priceAndNameComparator = new PriceAndNameComparator();
    public static final BiComparator nameAndPriceComparator = new BiComparator(priceComparator, nameComparator);


    private static void printArray(Stationary[] arr){
        for(Stationary st : arr){
            System.out.println(st);
        }
    }

    public static void main(String[] args) {

        Kit noviceKit = Kit.noviceKit();

        Stationary[] items = {
                noviceKit.pen,
                noviceKit.pencil,
                noviceKit.erasure,
                noviceKit.ruler,
                noviceKit.scissors,
                noviceKit.sharpener,
        };

        printArray(items);

        Arrays.sort(items, priceComparator);

        System.out.println("\nAfter price sort\n ");
        printArray(items);

        Arrays.sort(items, nameComparator);

        System.out.println("\nAfter name sort \n ");
        printArray(items);

        Arrays.sort(items, priceAndNameComparator);

        System.out.println("\nAfter price and then name sort \n ");
        printArray(items);

        Arrays.sort(items, nameAndPriceComparator);

        System.out.println("\nAfter name and then price sort \n ");
        printArray(items);

    }

}

class PriceComparator implements Comparator<Stationary> {

    @Override
    public int compare(Stationary o1, Stationary o2) {
        return o1.getPrice() - o2.getPrice();
    }
}

class NameComparator implements Comparator<Stationary>{

    @Override
    public int compare(Stationary o1, Stationary o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class PriceAndNameComparator implements Comparator<Stationary>{

    @Override
    public int compare(Stationary o1, Stationary o2) {
        int comp = o1.getPrice() - o2.getPrice();

        if(comp == 0){
            comp = o1.getName().compareTo(o2.getName());
        }

        return comp;
    }
}

class BiComparator implements Comparator<Stationary>{

    private final Comparator<Stationary> comp1;
    private final Comparator<Stationary> comp2;

    public BiComparator(Comparator<Stationary> comp1, Comparator<Stationary> comp2){
        this.comp1 = comp1;
        this.comp2 = comp2;
    }

    @Override
    public int compare(Stationary o1, Stationary o2) {
        int compare = comp1.compare(o1, o2);
        if(compare == 0){
            compare = comp2.compare(o1, o2);
        }

        return compare;
    }
}
