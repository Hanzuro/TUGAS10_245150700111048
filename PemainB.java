package DAY11.TUGAS10;

public class PemainB extends Pemain {

    public PemainB(String nama, int noPung, int TB, int BB) {
        super(nama, noPung, TB, BB);
    }

    public String getTim(Pemain p){
        if (p instanceof PemainB){
            return "B";
        }
        return "";
    }
    
    
}
