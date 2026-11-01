package id.ac.uniska.pbo2.p07;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Menghubungkan daftar Kontak dengan JTable.
 * JTable bertanya kepada model: berapa baris, berapa kolom, dan apa isi setiap sel.
 */
public class KontakTableModel extends AbstractTableModel {

    // Menentukan judul kolom pada tabel
    private static final String[] KOLOM = {"Nama", "Telepon", "Email", "Kategori"};

    // Menyiapkan wadah (List) untuk menampung objek Kontak
    private final List<Kontak> daftar = new ArrayList<>();

    @Override
    public int getRowCount() {
        return daftar.size(); // Mengembalikan jumlah baris berdasarkan ukuran data
    }

    @Override
    public int getColumnCount() {
        return KOLOM.length; // Mengembalikan jumlah kolom (4 kolom)
    }

    @Override
    public String getColumnName(int kolom) {
        return KOLOM[kolom]; // Mengembalikan nama judul kolom tertentu
    }

    @Override
    public Object getValueAt(int baris, int kolom) {
        Kontak k = daftar.get(baris);
        // Mengisi sel tabel berdasarkan kolom ke-0 sampai ke-3
        return switch (kolom) {
            case 0 -> k.nama();
            case 1 -> k.telepon();
            case 2 -> k.email();
            default -> k.kategori();
        };
    }

    // Method untuk mengambil objek Kontak pada baris tertentu
    public Kontak get(int baris) {
        return daftar.get(baris);
    }

    // Method untuk menambah data kontak baru ke dalam tabel
    public void tambah(Kontak kontak) {
        daftar.add(kontak);
        int baris = daftar.size() - 1;
        fireTableRowsInserted(baris, baris); // Memberi tahu tabel ada baris baru yang masuk
    }

    // Method untuk mengubah data kontak yang sudah ada
    public void ubah(int baris, Kontak kontak) {
        daftar.set(baris, kontak);
        fireTableRowsUpdated(baris, baris); // Memberi tahu tabel ada baris yang berubah[cite: 1, 2, 5]
    }

    // Method untuk menghapus data kontak dari tabel
    public void hapus(int baris) {
        daftar.remove(baris);
        fireTableRowsDeleted(baris, baris); // Memberi tahu tabel ada baris yang dihapus[cite: 1, 2, 5]
    }
}