package DAY11.TUGAS10;

import java.util.Scanner;
import java.util.ArrayList;

public class Menu {
    static Scanner input = new Scanner (System.in);
    static String jawab ;

    public static void menuUtama(){
        System.out.println("====== MENU UTAMA ======");
        System.out.println("1. Lihat Pemain");
        System.out.println("2. Sortir Pemain");
        System.out.println("3. Cari Pemain");
        System.out.println("4. Lihat Max/Min");
        System.out.println("5. Filter Pemain");
        System.out.println("6. Buat Tim C");
        System.out.println("7. Cek Kesamaan BB dan TB");
        System.out.println("8. Keluar");

        System.out.print("Pilih Menu : ");
        jawab = input.nextLine();
        switch (jawab) {
            case "1":
            lihatPemain();
            break;
            case "2":
            sortirPemain();
            break;
            case "3":
            cariPemain();
            break;
            case "4":
            lihatMaxMin();
            case "5":
            filterPemain();
            break;
            case "6":
            buatTimC();
            break;
            case "7":
            cekKesamaan();
            break;
            case "8":
            System.out.println("Terima Kasih Telah Menggunakan Program Kami!");
            System.exit(0);
            break;
            default:
            System.out.println("Pilihan tidak ada");
            menuUtama();
        }
    }

    public static void lihatPemain(){
        System.out.println("Tim mana yang ingin Anda tampilkan?");
        System.out.println("1. Tim A");
        System.out.println("2. Tim B");
        System.out.println("3. Semua");
        System.out.print("Pilih Tim : ");
        jawab = input.nextLine();
        switch (jawab) {
            case "1":
            lihatPemain(1);
            break;
            case "2":
            lihatPemain(2);
            break;
            case "3":
            lihatPemain(3);
            break;
            default:
            System.out.println("Pilihan tidak ada");
            lihatPemain();
            break;
        }
    }
    
    public static void lihatPemain(int tim){
        System.out.println("====== DAFTAR PEMAIN ======");
        System.out.println(header());
        System.out.println("________________________________________________");

        for (Pemain p : data.listPemain){
            if (p instanceof PemainA && tim == 1){
                System.out.println(p.toString(p));
            } else if (p instanceof PemainB && tim == 2){
                System.out.println(p.toString(p));
            } else if (tim == 3){
                System.out.println(p.toString(p));
            }
        }
        back();
    }

    public static void sortirPemain() {
        boolean start = true;

        while (start) {
            System.out.println("Pilih Tipe Sortir");
            System.out.println("1. Ascending");
            System.out.println("2. Descending");
            System.out.println("0. Kembali");
            String tipe = input.nextLine();

            if (tipe.equals("0")) menuUtama();

            if (!tipe.equals("1") && !tipe.equals("2")) {
                System.out.println("Pilihan tidak ada");
                continue;
            }

            System.out.println("Pilih Kriteria Sortir");
            System.out.println("1. Tinggi Badan");
            System.out.println("2. Berat Badan");
            System.out.println("3. Nama");
            System.out.println("4. Nomor Punggung");
            String kriteria = input.nextLine();

            if (!kriteria.equals("1") && !kriteria.equals("2") && !kriteria.equals("3") && !kriteria.equals("4")) {
                System.out.println("Pilihan tidak ada");
                continue;
            }

            data.sortPemain(kriteria, tipe);
            back();
            return;
        }
    }


    public static void cariPemain(){
        boolean start = true;
        while (start){
            System.out.println("Kriteria Pencarian : Nama/Nomor");
            System.out.print("Pilihan : ");
            String kriteria = input.nextLine();

            if (!kriteria.equalsIgnoreCase("nama") && !kriteria.equalsIgnoreCase("nomor")){
                System.out.println("Kriteria tidak sesuai, masukan kembali");
                input.nextLine();
                continue;
            }
            System.out.print("Keyword : ");
            String keyword = input.nextLine();
            data.cariPemain(kriteria, keyword);
            back();
        }
    }

    public static void lihatMaxMin(){
        System.out.println("======MAX TINGGI BADAN======");
        data.maxMinTB("A");
        data.maxMinTB("B");
        System.out.println("======MAX BERAT BADAN======");
        data.maxMinBB("A");
        data.maxMinBB("B");

        back();
    }

    public static void filterPemain(){
        System.out.println("====== TIM A ======");
        System.out.println("Kriteria : BB 53 - 56 kg");
        
        for (Pemain p : data.listPemainA){
            if (p instanceof PemainA && (p.getBeratBadan()<=56 && p.getBeratBadan() >= 53)){
                System.out.println(p.toString(p));
            }
        }
        
        System.out.println("====== TIM B ======");
        System.out.println("Kriteria : TB 160 - 168 cm");

        for (Pemain p : data.listPemainB){
            if (p instanceof PemainB && (p.getTinggiBadan()<=168 && p.getTinggiBadan() >= 160)){
                System.out.println(p.toString(p));
            }
        }

        back();
    }

    public static void buatTimC(){
        System.out.println("Tim C adalah hasil copy dari seluruh anggota tim B");

        data.isiTimC();
        System.out.println("Pencet ENTER untuk melihat hasil");
        input.nextLine();

        System.out.println("====== TIM C ======");
        System.out.println(header());
        System.out.println("________________________________________________");
        for (Pemain p : data.listPemainC){
            System.out.println(p.toString(p));
        }
        back();
    }   

    public static void cekKesamaan(){
        boolean TBSama = false;
        boolean BBSama = false;
        System.out.println("KESAMAAN BERAT BADAN TIM A DAN B");
            System.out.print("Hasil : ");
            if (data.disjointAB("BB",BBSama) == true){
                System.out.println("Terdapat Kesamaan Berat Badan");
            }
            if (data.disjointAB("TB",TBSama) == true){
                System.out.println("Terdapat Kesamaan Tinggi Badan");
            } 
            if (data.disjointAB("BB",BBSama) == false && data.disjointAB("TB",TBSama) == false){
                System.out.println("Tidak Terdapat Kesamaan Tinggi Badan Maupun Berat Badan");
            }
        
        back();
    }

    private static void back(){
        System.out.println("Silahkan pencet ENTER untuk kembali ke menu utama");
        input.nextLine();
        menuUtama();
    }

    public static String header(){
        return String.format("%-25s | %-2s | %-3s | %-2s | %-3s", "Nama", "NP", "TB", "BB", "Tim");
    }
}
