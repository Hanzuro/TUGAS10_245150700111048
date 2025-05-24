package DAY11.TUGAS10;

public abstract class Pemain{
    private String nama;
    private int noPunggung;
    private int tinggiBadan;
    private int beratBadan;
    
    //Abtract Class
    public abstract String getTim(Pemain p);

    // Parent Class
    public Pemain (String nama, int noPung, int tb, int bb){
        this.nama = nama;
        this.noPunggung = noPung;
        this.tinggiBadan = tb;
        this.beratBadan = bb;
    }
    
    public String getNama(){
        return this.nama;
    }

    public int getNoPunggung(){
        return this.noPunggung;
    }

    public int getTinggiBadan(){
        return this.tinggiBadan;
    }

    public int getBeratBadan(){
        return this.beratBadan;
    }


    public void setNama(String nama){
        this.nama = nama;
    }

    public void setNoPunggung(int noPunggung){
        this.noPunggung = noPunggung;
    }

    public void setTinggiBadan(int tinggiBadan){
        this.tinggiBadan = tinggiBadan;
    }

    public void setBeratBadan(int beratBadan){
        this.beratBadan = beratBadan;
    }

    public String toString(Pemain p){
        return String.format("%-25s | %-2d | %-3d | %-2d | %-3s", 
        getNama(), getNoPunggung(), getTinggiBadan(), getBeratBadan(), getTim(p));
    }
}