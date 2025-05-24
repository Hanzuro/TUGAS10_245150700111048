package DAY11.TUGAS10.Method;

import java.util.Comparator;

import DAY11.TUGAS10.Pemain;

public class sortNomor implements Comparator<Pemain> {

    public int compare(Pemain p1, Pemain p2) {
        Integer a = p1.getNoPunggung();
        Integer b = p2.getNoPunggung();
        return a.compareTo(b);
    }
    
}