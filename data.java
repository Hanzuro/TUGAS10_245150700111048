package DAY11.TUGAS10;

import java.util.*;

import DAY11.TUGAS10.Method.*;

public class data {
    static ArrayList <Pemain> listPemain = new ArrayList<>();
    static ArrayList <Pemain> listPemainA = new ArrayList<>();
    static ArrayList <Pemain> listPemainB = new ArrayList<>();
    static ArrayList <Pemain> listPemainC = new ArrayList<>();
    
    
    static ArrayList <Integer> listTBA = new ArrayList<>();
    static ArrayList <Integer> listTBB = new ArrayList<>();
    static ArrayList <Integer> listBBA = new ArrayList<>();
    static ArrayList <Integer> listBBB = new ArrayList<>();
    
    public static void dataSource(){
        listPemain.add(new PemainA("Xavi", 6, 168, 50));           
        listPemain.add(new PemainA("Luka Modric", 10, 170, 60));
        listPemain.add(new PemainA("Andrés Iniesta", 8, 165, 56));
        listPemain.add(new PemainA("Marco Verratti", 7, 168, 55 ));
        listPemain.add(new PemainA("Toni Kroos", 18, 172, 60 ));
        listPemain.add(new PemainA("Bernardo Silva", 20, 170, 70 ));
        listPemain.add(new PemainA("David Silva", 21, 169, 66 ));
        listPemain.add(new PemainA("Jordi Alba", 17, 165, 61 ));
        listPemain.add(new PemainA("Antoine Griezmann", 7, 171, 72 ));
        listPemain.add(new PemainA("Phil Foden", 47, 166, 56 ));

        listPemain.add(new PemainB("Kylian Mbappe", 10, 170, 66));
        listPemain.add(new PemainB("Lionel Messi", 30, 167, 60));
        listPemain.add(new PemainB("N'Golo Kante", 13, 165, 59));
        listPemain.add(new PemainB("Eden Hazard", 7, 166, 58));
        listPemain.add(new PemainB("Sadio Mane", 10, 168, 58));
        listPemain.add(new PemainB("Harry Kane", 9, 175, 71));
        listPemain.add(new PemainB("Bukayo Saka", 7, 172, 68));
        listPemain.add(new PemainB("Jude Bellingham", 22, 171, 68));
        listPemain.add(new PemainB("Christian Pulisic", 11, 168, 65));
        listPemain.add(new PemainB("Paulo Dybala", 21, 169, 60));
        
    }
    
    public static void sortPemain(String kriteria, String tipe){
        ArrayList<Pemain> listSorted = new ArrayList<>();
        listSorted.addAll(listPemain);
        if (tipe.equals("1")){ //untuk ascending
            switch(kriteria){
                case "1": //Tinggi badan
                Collections.sort(listSorted, new sortTB());
                break;
                case "2": // Berat badan
                Collections.sort(listSorted, new sortBB());
                break;
                case "3": // Nama
                Collections.sort(listSorted, new sortNama());
                break;
                case "4": // Nomor Punggung
                Collections.sort(listSorted, new sortNomor());
                break;
                default:
                System.out.println("Pilihan tidak tersedia");
            }
        } else if (tipe.equals("2")){ //untuk decending
            switch(kriteria){
                case "1": // Tinggi Badan
                Collections.sort(listSorted, new sortTB().reversed());
                break;
                case "2": // Berat badan
                Collections.sort(listSorted, new sortBB().reversed());
                break;
                case "3": // Nama
                Collections.sort(listSorted, new sortNama().reversed());
                break;
                case "4": // Nomor Punggung
                Collections.sort(listSorted, new sortNomor().reversed());
                break;
                default:
                System.out.println("Pilihan tidak tersedia");
            }
            
        }

        System.out.println(Menu.header());
        for (Pemain p : listSorted){
            System.out.println(p.toString(p));
        }
        
        System.out.println("Apakah Anda ingin menyimpan hasil sortir?");
        System.out.println("1. Ya");
        System.out.println("2. Tidak");
        String jawab = Menu.input.nextLine();
        if (jawab.equals("1")){
            listPemain.clear();
            listPemain.addAll(listSorted);
            System.out.println("Hasil sortir telah disimpan");
        } else if ( jawab.equals("2")){
            System.out.println("Hasil sortir tidak disimpan");
        }
    }
    
    public static void separatorTim (){
        for (Pemain p : listPemain){
            if (p instanceof PemainA){
                listPemainA.add(p);
            } else if (p instanceof PemainB){
                listPemainB.add(p);
            }
        }
    }

    public static void separatorAtribut(){
        for (Pemain p : listPemain){
            if (p instanceof PemainA){
                listTBA.add(p.getTinggiBadan());
                listBBA.add(p.getBeratBadan());
            } else if (p instanceof Pemain B){
                listTBB.add(p.getTinggiBadan());
                listBBB.add(p.getBeratBadan());
            }
        }
    }
    
    public static boolean disjointAB(String parameter, boolean jenis){
        if (!Collections.disjoint(data.listBBA, data.listBBB) && parameter.equalsIgnoreCase("BB")){
            return jenis = true;
        } else if (!Collections.disjoint(data.listTBA, data.listTBB)&& parameter.equalsIgnoreCase("TB")){
            return jenis = true;
        }
        return jenis = false;
    }

    public static void maxMinTB(String tim){
        Pemain max;
        Pemain min;
        Menu.header();
        if (tim.equals("A")){
            max = Collections.max(listPemainA, new sortTB());
            min = Collections.min(listPemainA, new sortTB());
            System.out.println(max.toString(max) + ">>> Max");
            System.out.println(min.toString(min) + ">>> Min");
        } else if (tim.equals("B")){
            max = Collections.max(listPemainB, new sortTB());
            min = Collections.min(listPemainB, new sortTB());
            System.out.println(max.toString(max) + ">>> Max");
            System.out.println(min.toString(min) + ">>> Min");
        }
    }
    public static void maxMinBB(String tim){
        Pemain max;
        Pemain min;
        Menu.header();
        if (tim.equals("A")){
            max = Collections.max(listPemainA, new sortBB());
            min = Collections.min(listPemainA, new sortBB());
            System.out.println(max.toString(max) + ">>> Max");
            System.out.println(min.toString(min) + ">>> Min");
        } else if (tim.equals("B")){
            max = Collections.max(listPemainB, new sortBB());
            min = Collections.min(listPemainB, new sortBB());
            System.out.println(max.toString(max) + ">>> Max");
            System.out.println(min.toString(min) + ">>> Min");
        }
    }

    public static void cariPemain(String kriteria, String parameter) {
        Comparator<Pemain> byNama = Comparator.comparing(Pemain::getNama);
        Comparator<Pemain> byNomor = Comparator.comparingInt(Pemain::getNoPunggung);

        if (kriteria.equalsIgnoreCase("nama")) {
            Collections.sort(listPemain, byNama);

            Pemain key = new PemainA(parameter, 0, 0, 0);
            int index = Collections.binarySearch(listPemain, key, byNama);
            if (index >= 0) {
                Pemain p = listPemain.get(index);
                System.out.println(Menu.header());
                System.out.println(p.toString(p));
            } else {
                System.out.println("Pemain dengan nama '" + parameter + "' tidak ditemukan.");
            }

        } else if (kriteria.equalsIgnoreCase("nomor")) {
            Collections.sort(listPemain, byNomor);

            int noDicari = Integer.parseInt(parameter);
            Pemain key = new PemainA("", noDicari, 0, 0);
            int index = Collections.binarySearch(listPemain, key, byNomor);
            if (index >= 0) {
                Pemain p = listPemain.get(index);
                System.out.println(Menu.header());
                System.out.println(p.toString(p));
            } else {
                System.out.println("Pemain dengan nomor punggung '" + parameter + "' tidak ditemukan.");
            }

        } else {
            System.out.println("Kriteria pencarian tidak dikenali. Gunakan 'nama' atau 'nomor'.");
        }
    }
    
    public static ArrayList<Pemain> copyBtoC(){
        ArrayList<Pemain> list = new ArrayList<>(Collections.nCopies(listPemainB.size(), null));
        Collections.copy(list,listPemainB);
        if (!list.isEmpty()){
            System.out.println("Tim C Berhasil Dibuat!");
            return list;
        } else {
            System.out.println("Tim C Gagal Dibuat!");
            return list;
        }
    }
    public static void isiTimC(){
        ArrayList<Pemain> sementara = copyBtoC();
        if (listPemainC.isEmpty()){
            listPemainC.addAll(sementara);
        } else {
            System.out.println("Pemain sudah ada!");
        }
    }
}
