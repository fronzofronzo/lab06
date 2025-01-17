package it.unibo.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private static final int ELEMS = 100_000;
    private static final int READ = 1_000;
    private static final int INIT_NUM = 1000;
    private static final int FINAL_NUM = 2000;
    private static final long AFRICA_POP = 1_110_635_000L;
    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */

        List<Integer> l1 = new ArrayList<>(); 
        for(int i=INIT_NUM; i<=FINAL_NUM; i++ ) {
            l1.add(i);
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        List<Integer> l2 = new LinkedList<>(l1);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        int n = l1.get(0);
        l1.set(0, l1.get(l1.size()-1));
        l1.set(l1.size()-1,n);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for(Integer x : l1) {
            System.out.println(x + " ");
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long time = System.nanoTime();
        for(int i=1; i<= ELEMS; i++) {
            l1.add(0, i);
        }
        time = System.nanoTime() - time;
         var millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println("ArrayList time: "+ time);

        time = System.nanoTime();
        for(int i=1; i<= ELEMS; i++) {
            l2.add(0,i);
        }
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println("LinkedList time: " +time);
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        time = System.nanoTime();
        for(int i=1; i<= READ; i++) {
            l1.get(l1.size()/2);
        }
        time = System.nanoTime() - time;
        System.out.println("ArrayList time: "+ time);
        time = System.nanoTime();
        for(int i=1; i<= READ; i++) {
            l2.get(l2.size()/2);
        }
        time = System.nanoTime() - time;
        System.out.println("LinkedList time: "+ time);
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        final Map<String, Long> world= new HashMap<>();

        
        world.put("Africa", AFRICA_POP);
        world.put("Americas", 972_005_000L);
        world.put("Antarctica", 0L);
        world.put("Asia", 4_298_723_000L);
        world.put("Europe", 742_452_000L);
        world.put("Ocenia", 38_304_000L);
        /*
         * 8) Compute the population of the world
         */
        long population = 0L;
        for(long nl : world.values()) {
            population = population + nl;
        } 
        System.out.println(population);
    }
}
