/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p02.perpustakaan.mini;

/**
 *
 * @author ASUS TUF
 */ 
import java.util.List;

// 1. Add the class declaration here
public class AplikasiPerputakaan { 
    
    public static void main(String[] args) {
        // TODO code application logic here
        Perpustakaan perpus = new Perpustakaan();
        perpus.tambah(new Buku("B001", "Laskar Pelangi", 2005, "Andrea Hirata"));
        perpus.tambah(new Buku("B002", "Clean Code", 2008, "Robert C. Martin"));
        perpus.tambah(new Majalah("M001", "Majalah Teknologi Kita", 2026, "Agustus")); 
        perpus.tambah(new Skripsi("S001", "Sistem Pendukung Keputusan", 2023, "Siti Rahmah", "Teknik Informatika"));

        Anggota siti = new Anggota("2410010123", "Siti Rahmah");
        Anggota budi = new Anggota("2410010456", "Budi Santoso");

        tampilkanDaftar(perpus);

        System.out.println();
        cetakPinjam(perpus, "B002", siti);
        cetakPinjam(perpus, "B002", budi);
        cetakPinjam(perpus, "M001", budi);
        System.out.println("Peminjam B002: " + perpus.getPeminjam("B002").nama());

        System.out.println();
        cetakKembali(perpus, "B002", 2);
        cetakKembali(perpus, "M001", 3);

        System.out.println();
        
        // --- TAMBAHAN: Uji Fitur Pencarian Judul ---
       List<Koleksi> hasilPencarian = perpus.cariJudul("code");
        System.out.println("Hasil pencarian \"code\": " + hasilPencarian.size() + " koleksi");
        for (Koleksi k : hasilPencarian) {
            System.out.println(k); // Menggunakan toString() agar langsung sesuai dengan format perpustakaan
        }

        System.out.println();

        // --- TAMBAHAN: Uji Coba Peminjaman Skripsi (Siti Rahmah meminjam S001) ---
        cetakPinjam(perpus, "S001", siti);

        System.out.println();
        System.out.println("Koleksi tersedia: " + perpus.jumlahTersedia()
            + " dari " + perpus.getDaftarKoleksi().size());
    }
    
    private static void tampilkanDaftar(Perpustakaan perpus) {
        System.out.println("=== Daftar Koleksi ===");
        for (Koleksi k : perpus.getDaftarKoleksi()) {
            System.out.println(k); // otomatis memanggil toString()
        }
    }

    private static void cetakPinjam(Perpustakaan perpus, String kode, Anggota anggota) {
        boolean berhasil = perpus.pinjam(kode, anggota);
        System.out.println(anggota.nama() + " meminjam " + kode + ": "
            + (berhasil ? "berhasil" : "gagal"));
    }

    private static void cetakKembali(Perpustakaan perpus, String kode, int hariTerlambat) {
        long denda = perpus.kembalikan(kode, hariTerlambat);
        System.out.println("Pengembalian " + kode + " terlambat " + hariTerlambat
            + " hari, denda Rp" + denda);
    }
}
