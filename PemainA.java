package DAY11.TUGAS10;

public class PemainA extends Pemain {

    public PemainA(String nama, int noPung, int TB, int BB) {
        super(nama, noPung, TB, BB);
    }

    public String getTim(Pemain p){
        if (p instanceof PemainA){
            return "A";
        }
        return "";
    }
    
}
