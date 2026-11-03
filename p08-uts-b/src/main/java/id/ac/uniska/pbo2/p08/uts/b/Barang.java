/*Nama: Rizqian Ardy Rahman
/*NPM : 2410010572
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.uniska.pbo2.p08.uts.b;

/**
 *
 * @author ASUS TUF
 */
public class Barang {
    public enum Kategori {
        ALAT_TULIS("Alat Tulis"),
        MAKANAN("Makanan"),
        ELEKTRONIK("Elektronik"),
        LAINNYA("Lainnya");
 
        private final String label;
 
        Kategori(String label) {
            this.label = label;
        }
 
        @Override
        public String toString() {
            return label;
        }
    }
 
    private final String nama;
    private final Kategori kategori;
    private final long harga;
    private final int jumlah;
 
    public Barang(String nama, Kategori kategori, long harga, int jumlah) {
        this.nama = nama;
        this.kategori = kategori;
        this.harga = harga;
        this.jumlah = jumlah;
    }
 
    public String getNama() { return nama; }
    public Kategori getKategori() { return kategori; }
    public long getHarga() { return harga; }
    public int getJumlah() { return jumlah; }
 
    public long getSubtotal() {
        return harga * jumlah;
    }
}
