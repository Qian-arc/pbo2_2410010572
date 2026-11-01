# Laporan Praktikum PBO 2 - Pertemuan 5: Event Handling
* **Nama:** Rizqian Ardy Rahman
* **NPM:** 2410010572
* **Kelas:** 5 Reg C

## 1. Pengamatan Praktikum 2 (Pengamat Event)

* **1.** Tindakan: Arahkan kursor ke tombol, lalu jauhkan. Event yang tercatat: MouseEvent (kursor masuk & keluar dari tombol).
* **2.** Tindakan: Klik tombol "Klik saya". Event yang tercatat: ActionEvent (tombol diklik).
* **3.** Tindakan: Centang lalu hapus centang Aktifkan fitur. Event yang tercatat: ItemEvent (kotak dicentang / centang dihapus).
* **4.** Tindakan: Ganti pilihan dari Pagi menjadi Malam. Event yang tercatat: ItemEvent (memilih Malam).
* **5.** Tindakan: Klik isian, lalu ketik kata "abc". Event yang tercatat: FocusEvent & KeyEvent (mendapat fokus, mengetik huruf a, b, c, kehilangan fokus).
* **6.** Tindakan: Klik tombol setelah mengetik di isian. Event yang tercatat: FocusEvent & ActionEvent.


## 2. Jawaban Eksperimen Praktikum 3 & 4
### Eksperimen Praktikum 3 (Konversi Suhu)
* **1. Hapus pemeriksaan `if (evt.getStateChange() == ItemEvent.SELECTED)`:** Pesan tercetak 2 kali setiap pilihan diganti karena event `itemStateChanged` terpanggil dua kali: sekali untuk status lama (`DESELECTED`) dan sekali untuk status baru (`SELECTED`).
* **2. Mengganti `keyReleased` dengan `keyPressed` pada `celsiusField`:** Hasil konversi terlambat satu karakter karena event `keyPressed` dieksekusi saat tombol keyboard baru ditekan (sebelum karakter tersebut benar-benar dimasukkan ke dalam teks isian).
* **3. Menghapus blok `try-catch` lalu mengetik huruf:** Muncul pesan error `java.lang.NumberFormatException` di jendela Output karena program gagal mengonversi huruf menjadi tipe data angka (`double`).

### Eksperimen Praktikum 4 (Kalkulator Sederhana)
* **1. Membuat event ganda pada `kaliButton` (GUI Builder + Lambda):** Pesan tercetak 2 kali karena listener terdaftar ganda. Oleh karena itu, satu komponen tombol sebaiknya hanya menggunakan satu cara agar aksi tidak berjalan tumpang tindih.
* **2. Menambahkan tombol modulus (%):** Di tab Design: Menambahkan tombol baru ke `operatorPanel`. Di tab Source: Menambahkan event handler `actionPerformed` yang memanggil `hitung('%')` serta menambahkan penanganan `case '%'` pada blok `switch` di method `hitung`.
* **3. Tombol Hapus mengembalikan kursor ke isian pertama:** Karena di dalam method `hapus` terdapat baris kode `angka1Field.requestFocusInWindow();` yang secara spesifik memindahkan fokus kembali ke kotak inputan pertama.

## 3. Peta Event `FormAnggotaPerpustakaan`
* **Kotak centang setuju (`setujuCheck`)**
* Menu Events: Item: itemStateChanged
* Aksi: Tombol Daftar hanya aktif jika dicentang
* **Tombol Batal (`batalButton`)**
* Menu Events: Action: actionPerformed
* Aksi: Kosongkan semua isian dan kembalikan fokus ke NPM
* **Tombol Daftar (`daftarButton`)**
* Menu Events: Action: actionPerformed
* Aksi: Tampilkan ringkasan data dengan JOptionPane
* **Isian NPM (`npmField`)**
* Menu Events: Key: keyReleased
* Aksi: Label kecil menampilkan jumlah digit, misalnya "8 dari 10 digit"
* **Form Utama (`JFrame`)**
* Menu Events: Window: windowClosing
* Aksi: Minta konfirmasi sebelum aplikasi ditutup


## 4. Tangkapan Layar (Screenshots)
### A. Properties Events Tombol Daftar
![Properties Events Daftar](Foto/propertiesDaftar.png)

### B. Dialog Ringkasan Pendaftaran
![Dialog Ringkasan](Foto/dialogRingkas.png)

### C. Dialog Konfirmasi Keluar
![Dialog Konfirmasi Keluar](Foto/dialogKeluar.png)

### A. Jendela Properties Bagian Events untuk Tombol Daftar
(Sisipkan gambar tangkapan layar jendela Properties -> Events untuk daftarButton di sini)  
![Properties Events Daftar](Foto/propertieDaftar.png)

### B. Dialog Ringkasan Pendaftaran
(Sisipkan gambar tangkapan layar saat tombol Daftar diklik dan memunculkan JOptionPane)  
![Dialog Ringkasan](Foto/dialogRingkasan.png)

### C. Dialog Konfirmasi Keluar Form
(Sisipkan gambar tangkapan layar saat tombol 'X' ditekan dan memunculkan dialog konfirmasi)  
`![Dialog Konfirmasi Keluar](Foto/dialogKeluar.png)

## 5. Deklarasi Penggunaan AI
* **Alat yang dipakai:** Gemini (Google)
* **Keperluan:** Membantu memahami struktur event handling Java Swing, menyusun logika event handler form anggota perpustakaan, serta merapikan kode praktikum.
