package ac.at.fhcampuswien;

import ac.at.fhcampuswien.characters.*;
import ac.at.fhcampuswien.generics.Player;

import java.util.*;

public class App {
    public static void main(String[] args){

        Orc snaga = new Snaga();

        Player<Orc> player = new Player<>();  // create a new player object with Type Orc
        player.set(snaga);


        Troll troll = new Troll("Blaab", 60);
        //player.set(troll);  // cannot set to type Troll because we defined it to be Player<Orc>

        System.out.println(player.get().toString());


        Map<Integer,String> map = new HashMap<>();    // create a Map<K,V> with types Integer and String
        map.put(1,"John");
        map.put(2,"Jane");
        map.put(3,"Bart");


        ArrayList<Orc> orcArray =
                new ArrayList<>(Arrays.asList(
                    new Urukhai("Bolg", 48),
                    new Urukhai("Azog", 112),
                    new Snaga()
                ));

        printArrayList(orcArray);

        printGenericMap(mapOrcs(orcArray));

        printCollection(orcArray);


        Urukhai urukhai = new Urukhai("Azog", 112);
        upperBoundParamExample(snaga);
        upperBoundParamExample(urukhai);
        // upperBoundParamExample(troll);  // compilation error

        System.out.println();

        int num1 = 10;
        double double1 = 10.2;
        float float1 = 123.0f;
        long long1 = 123L;

        System.out.println("######### Upper bounded example #########");
        printNumber(sumUp(num1, double1));
        printNumber(sumUp(float1, num1));
        printNumber(sumUp(long1, float1));



        System.out.println();


        ArrayList<Troll> trollArray =
                new ArrayList<>(Arrays.asList(
                        new Troll("Buga", 17),
                        new Troll("Uga", 99),
                        troll
                ));

        printItems(orcArray);
        printOrcItems(orcArray);
        printItems(trollArray);
        //printOrcItems(trollArray);    // compiler error

        System.out.println();

        /**
         *  Reading and Writing to Files examples
         */

        Urukhai orc =  new Urukhai("Bolg", 66);
        Urukhai orc2 = new Urukhai("Azog", 666);

        Orc.serializeOrc(orc, "build/tmp/SerializationExample/" + orc.getName() + ".ser");
        Orc.serializeOrc(orc2, "build/tmp/SerializationExample/" + orc2.getName() + ".ser");


        Orc orc3 = Orc.deserializeOrc("build/tmp/SerializationExample/Bolg.ser");
        Orc orc4 = Orc.deserializeOrc("build/tmp/SerializationExample/Azog.ser");

        System.out.println(orc3);
        System.out.println(orc4);
    }

    // example Elements type accepting List of ANY type
    public static <E> void printArrayList(List<E> elements) {
        for ( E element : elements){
            System.out.println(element);
        }
        System.out.println();
    }

    // example for KEY and VALUE types which accepts Maps of ANY Key value pairs - eg. Map<Integer, String>, Map<Integer, Object>, ...
    public static <K, V> void printGenericMap(Map<K, V> map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.println( entry.getKey() + " " + entry.getValue() );
        }
    }

    // function that accepts List of type Orc and returns a Map<Integer, Orc>
    public static Map<Integer, Orc> mapOrcs(List<Orc> orcs){
        Map<Integer, Orc> map = new HashMap<>();

        int id = 1;

        for (Orc orc : orcs) {
            map.put(id, orc);
            id++;
        }

        return map;
    }


    /**
     *
     * Bounded Type Parameters
     *
     * -> limit the data types that can be passed to generics
     * following function only accepts type that extend Iterable Class
     *
     */
    // example Elements type which accepts ANY type that extends Iterable (Collections) - eg. Lists, Sets, ...
    // Collections in Java: https://www.javatpoint.com/collections-in-java
    public static <E, T extends Iterable<E>> void printCollection(T a){
        // for( Iterable type Iterable element : collection)
        for (E x : a) {
            System.out.print(x);
        }
    }

    public static <T extends Orc> void upperBoundParamExample(T obj){
        //obj can only be an object that implements Orc
    }


    /**
     * Accepts only Types that extend Number and returns their sum
     *
     * Number types: byte, short, int, long, float, double
     *
     */
    public static <T extends Number> double sumUp(T myNum1, T myNum2){
        return myNum1.doubleValue() + myNum2.doubleValue();
    }

    public static <T extends Number> void printNumber(T number){
        System.out.println(number);
    }

    /**
     * Wildcard examples
     */
    public static void printItems(List<?> list) {  // accepts any kind of List type
        for (int i=0; i< list.size(); i++) {
            System.out.println(list.get(i).toString());
        }
    }

    public static void printOrcItems(List<? extends Orc> list) {  // accepts all subclasses of Orc
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }
    }








    /**
     * DIFFERENCE between
     *      copyWithType(List<T>, List<T>)
     *      AND
     *      copyWithWildcard(List<? extends Number>, List<? extends Number>)
     *      ?
     */

    public static <T extends Number> void copyWithType(List<T> dest, List<T> src){
        // do some copy
    }

    public static void copyWithWildcard(List<? extends Number> dest, List<? extends Number> src){
        // do some copy
    }

    public static void test(){
        List<Integer> numList = new ArrayList<>();

        numList.add(1);
        numList.add(2);

        List<Double> numList2 = new ArrayList<>();

        numList2.add(2.3);
        numList2.add(10.4);

        // copyWithType(numList, numList2);

        copyWithWildcard(numList, numList2);


    }

}













