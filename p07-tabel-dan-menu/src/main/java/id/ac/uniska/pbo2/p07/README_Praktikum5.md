# Laporan Praktikum: Tabel, Menu, dan Komponen Lanjutan (p07-tabel-dan-menu)

## Jawaban Eksperimen Praktikum 5 (Modul 7)

###1. Pengaruh Mengomentari fireTableRowsInserted
* **Pertanyaan:** Di KontakTableModel, jadikan baris fireTableRowsInserted(baris, baris); sebagai komentar, lalu tambah kontak baru. Apakah tabel langsung berubah?

* **Jawaban:** Tidak ada perubahan pada antarmuka tabel (JTable). Secara logic, objek kontak yang baru memang sudah berhasil masuk ke dalam koleksi data (List) di memori. Namun, karena baris perintah fireTableRowsInserted dimatikan, model gagal mengirimkan event atau sinyal kepada UI JTable bahwa ada baris baru. Akibatnya, tampilan tabel tidak di-refresh hingga ada aksi lain yang memicu pembaruan layar.

###2. Efek Mengganti barisTerpilih Tanpa Konversi Indeks
* **Pertanyaan:** Di method barisTerpilih, ganti isinya menjadi return kontakTable.getSelectedRow();. Cari kata "ah", pilih Ahmad Fauzi, lalu klik Hapus dan pilih No. Nama siapa yang muncul di dialog konfirmasi?

* **Jawaban:** Nama yang muncul adalah data kontak yang berada pada urutan teratas (indeks ke-0) di dalam List model data Anda. Kesalahan ini terjadi karena saat fitur pencarian aktif, baris yang tampil di layar (view) sudah terfilter, sehingga getSelectedRow() akan mengembalikan indeks ke-0 (karena Ahmad Fauzi ada di baris pertama hasil filter). Padahal, di dalam data asli (model), indeks ke-0 mungkin adalah kontak lain. Oleh sebab itu, metode convertRowIndexToModel() sangat krusial digunakan untuk memetakan indeks tampilan agar sesuai dengan indeks data sebenarnya.

###3. Pengaruh Mengubah Parameter Modal Dialog
* **Pertanyaan:** Di konstruktor DialogKontak, ubah super(pemilik, judul, true) menjadi false. Saat dialog terbuka, coba klik jendela utama. Apa yang terjadi pada kontak yang ditambahkan?

* **Jawaban:** Pengguna kini bisa mengklik dan berinteraksi kembali dengan jendela utama (Main Frame) meskipun pop-up dialog kontak masih dalam keadaan terbuka. Parameter false mengubah perilaku JDialog dari modal (fokus aplikasi terkunci hanya pada dialog) menjadi non-modal (jendela dialog dan jendela utama bisa diakses secara bersamaan).

###4. Perilaku Accelerator Ctrl+E dan Ctrl+D saat Tanpa Seleksi
* **Pertanyaan:** Tekan Ctrl+N, Ctrl+E, dan Ctrl+D. Mengapa Ctrl+E dan Ctrl+D tidak bekerja saat tidak ada baris yang dipilih?

* **Jawaban:** Pintasan Ctrl+E dan Ctrl+D tidak direspons oleh sistem karena tombol maupun item menu untuk Edit dan Hapus sedang dalam status disabled (setEnabled(false)). Sistem sudah dikonfigurasi agar aksi modifikasi dan penghapusan data hanya aktif jika sistem mendeteksi adanya baris yang diklik/diseleksi di dalam tabel (nilai getSelectedRow() lebih dari atau sama dengan 0).

###5. Perubahan Kode initComponents() pada Perubahan Accelerator
* **Pertanyaan:** Di tab Design, ubah accelerator hapusItem menjadi tombol Delete tanpa Ctrl. Baris apa yang berubah di initComponents()?

* **Jawaban:** Kode KeyStroke yang digenerate oleh GUI Builder di dalam metode initComponents() akan berubah. Parameter CTRL_DOWN_MASK (yang mewakili tombol Ctrl) akan dihilangkan, sehingga kodenya berganti menjadi seperti ini:

Java
hapusItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, 0));
(Angka 0 menandakan bahwa tombol Delete ditekan sendirian tanpa kombinasi modifier key).

###6. Dampak Inisialisasi Model Setelah initComponents()
* **Pertanyaan:** Ubah deklarasi atribut menjadi private KontakTableModel model; lalu isi model = new KontakTableModel(); setelah initComponents(). Jalankan. Pesan error apa yang muncul dan mengapa?

* **Jawaban:** Program akan mengalami crash dengan memunculkan error NullPointerException. Hal ini terjadi karena di dalam metode initComponents(), NetBeans mencoba memasangkan model ke tabel (misalnya dengan pemanggilan tabel.setModel(model);). Apabila objek model baru dibuat menggunakan kata kunci new setelah metode tersebut dipanggil, maka objek model yang diserahkan ke tabel masih bernilai kosong (null).