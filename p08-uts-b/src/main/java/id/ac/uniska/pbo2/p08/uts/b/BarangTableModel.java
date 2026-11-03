/*nama : Rizqian Ardy Rahman
/*npm 2410010572
*/
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.uniska.pbo2.p08.uts.b;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author ASUS TUF
 */
public class BarangTableModel extends AbstractTableModel { 
  
    private static final String[] KOLOM = {"Nama Barang", "Kategori", "Harga", "Jumlah", "Subtotal"}; 
    private final List<Barang> daftar = new ArrayList<>(); 
  
    @Override 
    public int getRowCount() { 
        return daftar.size(); 
    } 
  
    @Override 
    public int getColumnCount() { 
        return KOLOM.length; 
    } 
  
    @Override 
    public String getColumnName(int kolom) { 
        return KOLOM[kolom]; 
    }
    
    @Override 
   public Object getValueAt(int baris, int kolom) {
    Barang k = daftar.get(baris);
    return switch (kolom) {
        case 0 -> k.getNama();      
        case 1 -> k.getKategori();  
        case 2 -> k.getHarga();    
        case 3 -> k.getJumlah();    
        case 4 -> k.getSubtotal();  
        default -> null;
    }; 
    } 
  
    public Barang get(int baris) { 
        return daftar.get(baris); 
    } 
  
    public void tambah(Barang barang) { 
        daftar.add(barang); 
        int baris = daftar.size() - 1; 
        fireTableRowsInserted(baris, baris); // tampilkan baris baru 
    } 
  
    public void ubah(int baris, Barang barang) { 
        daftar.set(baris, barang); 
        fireTableRowsUpdated(baris, baris); 
    } 
  
    public void hapus(int baris) { 
        daftar.remove(baris); 
        fireTableRowsDeleted(baris, baris); 
    }
    
}