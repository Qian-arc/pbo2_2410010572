/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p02.perpustakaan.mini;

/**
 *
 * @author ASUS TUF
 */
public class Skripsi extends Koleksi {
    private String penulis;
    private String programStudi;

    public Skripsi(String id, String judul, int tahunTerbit, String penulis, String programStudi) {
        super(id, judul, tahunTerbit);
        this.penulis = penulis;
        this.programStudi = programStudi;
    }

    // Skripsi hanya dibaca di tempat (batas hari pinjam = 0)
    @Override
    public int batasHariPinjam() {
        return 0;
    }

    // Skripsi tidak boleh dipinjam bawa pulang (selalu mengembalikan false)
    @Override
    public boolean pinjam() {
        return false;
    }

    // Denda skripsi selalu 0
    @Override
    public long hitungDenda(int hariTerlambat) {
        return 0;
    }

    // Keterangan menampilkan penulis serta program studi
    @Override
    public String keterangan() {
        return "Skripsi karya " + penulis + ", Program Studi " + programStudi;
    } 
}
