import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TreeMap;
import static java.nio.charset.Charset.defaultCharset;

// 61130701107
public class Collection  {
    private List<String> lists;

    private void getList() throws IOException  {
        this.lists = Files.readAllLines(Paths.get("src/sale.txt"), defaultCharset());
    }

    public static void main(String[] args) throws IOException  {
        // write your code here
        Collection coll = new Collection();
        coll.getList();

        coll.hashMap();
        coll.linkedHashMap();
        coll.treeMap();
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
        double diffTime = getDiffTime(startTime, endTime);

        System.out.println("HashMap Diff Time: " + diffTime + " seconds");
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
        double diffTime = getDiffTime(startTime, endTime);

        System.out.println("LinkedHashMap Diff Time: " + diffTime + " seconds");
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
        double diffTime = getDiffTime(startTime, endTime);

        System.out.println("TreeMap Diff Time: " + diffTime + " seconds");
    }


    private double getDiffTime(long startTime, long endTime) {
        System.out.println("StartTime : "+ startTime);
        System.out.println("EndTime : "+ endTime);

        Long diff = endTime  - startTime;
        double elapsedTimeInSecond = (double) diff / 1_000_000_000;
        return elapsedTimeInSecond;
    }
}