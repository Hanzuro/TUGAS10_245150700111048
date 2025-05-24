package DAY11.TUGAS10.Method;

import java.util.Comparator;

import DAY11.TUGAS10.Pemain;

public class sortBB implements Comparator<Pemain> {

    public int compare(Pemain p1, Pemain p2) {
        Integer a = p1.getBeratBadan();
        Integer b = p2.getBeratBadan();
        return a.compareTo(b);
    }
    
}
