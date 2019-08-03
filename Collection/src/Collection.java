import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static java.nio.charset.Charset.defaultCharset;

// 61130701107
public class Collection  {

    public static class HashTime {

        private String hashName;
        private double time;

        public  HashTime(String name, double time) {
            this.hashName = name;
            this.time = time;
        }

        public String getName() {
            return hashName;
        }

        public double getTime() {
            return time;
        }
    }

    private List<String> lists;

    private List<HashTime> listTime;

    private void getList() throws IOException  {
        this.lists = Files.readAllLines(Paths.get("src/sale.txt"), defaultCharset());
    }

    public static void main(String[] args) throws IOException  {
        // write your code here
        Collection coll = new Collection();
        coll.listTime = new ArrayList<>();
        coll.getList();

        coll.hashMap();
        coll.linkedHashMap();
        coll.treeMap();

        HashTime minTime =  Collections.min(coll.listTime, Comparator.comparing(s -> s.getTime()));
        System.out.println("Minimum time is " + minTime.getName() + " with time " + minTime.getTime() + " seconds");


        HashTime maxTime =  Collections.max(coll.listTime, Comparator.comparing(s -> s.getTime()));
        System.out.println("Maximum time is " + maxTime.getName() + " with time " + maxTime.getTime() + " seconds");
    }

    protected void hashMap() {

        HashMap<String, String> hMap = new HashMap<>(this.lists.size());

        long startTime = System.nanoTime();

        for (int i = 0; i < this.lists.size(); i++) {
            String value = this.lists.get(i);
            hMap.put(Integer.toString(i), value);
        }

        for(HashMap.Entry m:hMap.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }

        long endTime = System.nanoTime();
        double hashMapTime = getDiffTime(startTime, endTime);


        listTime.add(new HashTime("hashMap", hashMapTime));
    }

    private void linkedHashMap() {

        LinkedHashMap<String, String> lMap = new LinkedHashMap<>(this.lists.size());

        long startTime = System.nanoTime();

        for (int i = 0; i < this.lists.size(); i++) {
            String value = this.lists.get(i);
            lMap.put(Integer.toString(i), value);
        }

        for(HashMap.Entry m:lMap.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }

        long endTime = System.nanoTime();
        double linkedHashMapTime = getDiffTime(startTime, endTime);

        listTime.add(new HashTime("linkedHashMap", linkedHashMapTime));

    }

    private void treeMap() {

        TreeMap<String, String> tMap = new TreeMap<>();

        long startTime = System.nanoTime();

        for (int i = 0; i < this.lists.size(); i++) {
            String value = this.lists.get(i);
            tMap.put(Integer.toString(i), value);
        }

        for(HashMap.Entry m:tMap.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }

        long endTime = System.nanoTime();
        double treeMapTime = getDiffTime(startTime, endTime);

        listTime.add(new HashTime("treeMap", treeMapTime));
    }


    private double getDiffTime(long startTime, long endTime) {
        System.out.println("StartTime : "+ startTime);
        System.out.println("EndTime : "+ endTime);

        Long diff = endTime  - startTime;
        double elapsedTimeInSecond = (double) diff / 1_000_000_000;
        return elapsedTimeInSecond;
    }
}