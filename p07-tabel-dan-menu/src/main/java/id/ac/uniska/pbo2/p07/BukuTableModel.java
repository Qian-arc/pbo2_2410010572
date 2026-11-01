/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.uniska.pbo2.p07;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS TUF
 */
public class BukuTableModel extends AbstractTableModel {

    // Menyiapkan wadah penyimpanan data buku
    private final List<Buku> list = new ArrayList<>();

    // Daftar judul kolom yang akan muncul pada JTable
    private final String[] kolom = {"Judul", "Penulis", "Penerbit", "Tahun", "Kategori"};

    @Override
    public int getRowCount() {
        return list.size(); // Mengembalikan jumlah baris berdasarkan jumlah data buku
    }

    @Override
    public int getColumnCount() {
        return kolom.length; // Mengembalikan jumlah kolom (5 kolom)
    }

    @Override
    public String getColumnName(int columnIndex) {
        return kolom[columnIndex]; // Menampilkan nama judul kolom
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Buku b = list.get(rowIndex);
        // Mengatur data apa saja yang tampil di setiap kolom berdasarkan record Buku
        return switch (columnIndex) {
            case 0 -> b.judul();
            case 1 -> b.penulis();
            case 2 -> b.penerbit();
            case 3 -> b.tahun();
            case 4 -> b.kategori();
            default -> null;
        };
    }

    // --- Method untuk Memanipulasi Data ---

    // Menambahkan data buku baru ke tabel
    public void tambah(Buku buku) {
        list.add(buku);
        fireTableRowsInserted(list.size() - 1, list.size() - 1);
    }

    // Mengubah data buku yang sudah ada pada baris tertentu
    public void ubah(int index, Buku buku) {
        list.set(index, buku);
        fireTableRowsUpdated(index, index);
    }

    // Menghapus data buku dari tabel
    public void hapus(int index) {
        list.remove(index);
        fireTableRowsDeleted(index, index);
    }

    // Mengambil objek Buku berdasarkan nomor baris
    public Buku get(int index) {
        return list.get(index);
    }
}