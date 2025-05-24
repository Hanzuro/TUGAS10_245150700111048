package DAY11.TUGAS10.Method;

import java.util.Comparator;

import DAY11.TUGAS10.Pemain;

public class sortTB implements Comparator<Pemain> {

    public int compare(Pemain p1, Pemain p2) {
        Integer a = p1.getTinggiBadan();
        Integer b = p2.getTinggiBadan();
        return a.compareTo(b);
    }
    
}
