package DAY11.TUGAS10.Method;

import java.util.Comparator;

import DAY11.TUGAS10.Pemain;

public class sortNama implements Comparator<Pemain> {

    public int compare(Pemain p1, Pemain p2) {
        String a = p1.getNama();
        String b = p2.getNama();
        return a.compareTo(b);
    }
    
}
