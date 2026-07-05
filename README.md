# Sistem Manajemen Depot Air Minum Isi Ulang

Proyek ini adalah aplikasi sederhana pengelolaan transaksi isi ulang galon menggunakan Java sebagai tugas akhir (UAS) dari mata kuliah Pemrograman Berbasis Objek 1 (PBO).

## Deskripsi

Aplikasi ini digunakan untuk mencatat data pelanggan depot air minum, mengelola data produk air (jenis dan ukuran galon), melakukan transaksi isi ulang, menghitung total biaya secara otomatis, serta mencetak struk transaksi. Aplikasi juga menyimpan riwayat seluruh transaksi, dapat mencari pelanggan berdasarkan nama, menghapus transaksi, mengedit data pelanggan, dan menampilkan laporan pendapatan depot.

Aplikasi ini mengimplementasikan beberapa konsep penting dalam pemrograman berorientasi objek (OOP) seperti Class, Object, Atribut, Method Constructor, Method Mutator, Method Accessor, Encapsulation, Inheritance, Polymorphism, Seleksi, Perulangan, IO Sederhana, Array (ArrayList), dan Error Handling.

## Cara Menjalankan

```bash
cd src/depotair
javac *.java
java Main
```

Login menggunakan:
- Username: `admin`
- Password: `admin123`

## Penjelasan Kode

Berikut adalah bagian kode yang relevan dengan konsep OOP yang dijelaskan:

1. **Class** adalah template atau blueprint dari object. Pada kode ini, `User`, `Admin`, `Pelanggan`, `ProdukAir`, `Transaksi`, `DepotService`, dan `Main` adalah contoh dari class.

```java
public class User implements Info {
    ...
}

public class Admin extends User {
    ...
}

public class DepotService {
    ...
}
```

2. **Object** adalah instance dari class. Pada kode ini, `new Pelanggan(...)`, `new ProdukAir(...)`, dan `new Transaksi(...)` adalah contoh pembuatan object.

```java
Admin admin = new Admin("admin", "admin123");
Pelanggan pelangganBaru = new Pelanggan(bikinIdPelanggan(), nama, alamat, noHp);
Transaksi transaksiBaru = new Transaksi(bikinIdTransaksi(), pelanggan, produk, jumlahGalon);
```

3. **Atribut** adalah variabel yang ada dalam class. Pada kode ini, `nama`, `alamat`, `harga`, dan `jumlahGalon` adalah contoh atribut.

```java
private String nama;
private String alamat;
private double harga;
private int jumlahGalon;
```

4. **Constructor** adalah method yang pertama kali dijalankan pada saat pembuatan object. Pada kode ini, constructor ada di setiap class, termasuk yang memanggil `super()` pada class turunan.

```java
public User(String username, String password) {
    this.username = username;
    this.password = password;
}

public Admin(String username, String password) {
    super(username, password);
}
```

5. **Mutator** atau setter digunakan untuk mengubah nilai dari suatu atribut. Pada kode ini, `setNama`, `setAlamat`, dan `setHarga` adalah contoh method mutator.

```java
public void setNama(String nama) {
    this.nama = nama;
}

public void setHarga(double harga) {
    this.harga = harga;
}
```

6. **Accessor** atau getter digunakan untuk mengambil nilai dari suatu atribut. Pada kode ini, `getNama`, `getHarga`, dan `getIdPelanggan` adalah contoh method accessor.

```java
public String getNama() {
    return nama;
}

public double getHarga() {
    return harga;
}
```

7. **Encapsulation** adalah konsep menyembunyikan data dengan membuat atribut menjadi private dan hanya bisa diakses melalui method. Pada kode ini, seluruh atribut di semua class dienkapsulasi dan hanya bisa diakses melalui method getter dan setter.

```java
private String idPelanggan;
private String namaProduk;
private int ukuran;
```

8. **Inheritance** adalah konsep di mana sebuah class bisa mewarisi property dan method dari class lain. Pada kode ini, `Admin` mewarisi `User` dengan sintaks `extends`.

```java
public class Admin extends User {
    ...
}
```

9. **Polymorphism** adalah konsep di mana sebuah nama dapat digunakan untuk merujuk ke beberapa tipe atau bentuk objek berbeda, sehingga method dengan nama sama bisa berperilaku berbeda tergantung tipe objeknya. Pada kode ini, method `tampilInfo()` dideklarasikan di interface `Info`, kemudian diimplementasikan secara berbeda oleh `User`, `Pelanggan`, `ProdukAir`, dan `Transaksi`, serta di-override lagi oleh `Admin`.

```java
// Interface Info
public interface Info {
    void tampilInfo();
}

// Implementasi di User
@Override
public void tampilInfo() {
    System.out.println("Username: " + username);
}

// Override di Admin
@Override
public void tampilInfo() {
    System.out.println("===== INFO ADMIN =====");
    System.out.println("Username Admin : " + getUsername());
    System.out.println("Status         : Administrator Sistem");
}
```

10. **Seleksi** adalah statement kontrol yang digunakan untuk membuat keputusan berdasarkan kondisi. Pada kode ini, digunakan seleksi `switch-case` untuk menu utama di `Main` dan `if-else` untuk validasi login maupun validasi jumlah galon.

```java
switch (pilihan) {
    case 1 -> tambahPelangganMenu();
    case 2 -> depotService.lihatPelanggan();
    case 11 -> {
        System.out.println("Terima kasih. Program selesai.");
        lanjut = false;
    }
    default -> System.out.println("Pilihan tidak tersedia, coba lagi.");
}
```

11. **Perulangan** adalah statement kontrol yang digunakan untuk menjalankan blok kode berulang kali. Pada kode ini, digunakan `while` untuk menu utama, `for` untuk percobaan login, serta `for-each` untuk menampilkan daftar pelanggan, produk, dan riwayat transaksi.

```java
for (Pelanggan p : daftarPelanggan) {
    p.tampilInfo();
    System.out.println("------------------------");
}
```

12. **Input Output Sederhana** digunakan untuk menerima input dari user dan menampilkan output ke user. Pada kode ini, digunakan class `Scanner` untuk menerima input dan `System.out.println` untuk menampilkan output, termasuk mencetak struk transaksi.

```java
Scanner input = new Scanner(System.in);
System.out.print("Nama Pelanggan : ");
String nama = input.nextLine();

System.out.println("Total Harga  : Rp" + hitungTotal());
```

13. **Array** adalah struktur data yang digunakan untuk menyimpan beberapa nilai dalam satu variabel. Pada kode ini, digunakan `ArrayList` untuk menyimpan `daftarPelanggan`, `daftarProduk`, dan `daftarTransaksi`.

```java
private ArrayList<Pelanggan> daftarPelanggan;
private ArrayList<ProdukAir> daftarProduk;
private ArrayList<Transaksi> daftarTransaksi;
```

14. **Error Handling** digunakan untuk menangani error yang mungkin terjadi saat runtime. Pada kode ini, digunakan `try-catch` untuk menangani `NumberFormatException` saat input menu, ukuran/harga produk, dan jumlah galon.

```java
static int bacaPilihanMenu() {
    try {
        int pilihan = Integer.parseInt(input.nextLine());
        return pilihan;
    } catch (NumberFormatException e) {
        System.out.println("Input harus berupa angka!");
        return -1;
    }
}
```

## Struktur Class

- `Info` (interface) — mendeklarasikan method `tampilInfo()`, dasar dari polymorphism
- `User` — data login dasar (username, password)
- `Admin` — turunan dari `User`, mewakili pengguna sistem yang login
- `Pelanggan` — data pelanggan depot (nama, alamat, no HP)
- `ProdukAir` — data jenis air, ukuran galon, dan harga
- `Transaksi` — satu transaksi isi ulang (gabungan pelanggan, produk, jumlah galon, tanggal)
- `DepotService` — menyimpan semua data master & riwayat transaksi, serta logika bisnis (tambah/edit/hapus/cari/laporan)
- `Main` — menu interaktif menggunakan Scanner, termasuk proses login

## Fitur Program

1. Login Admin
2. Tambah Pelanggan
3. Lihat Pelanggan
4. Edit Pelanggan
5. Hapus Pelanggan
6. Tambah Produk Air
7. Lihat Produk
8. Transaksi Isi Ulang Galon
9. Riwayat Transaksi
10. Cari Pelanggan berdasarkan Nama
11. Laporan Pendapatan
12. Keluar

## Usulan Nilai

| No  | Materi         |  Nilai  |
| :-: | -------------- | :-----: |
|  1  | Class          |    5    |
|  2  | Object         |    5    |
|  3  | Atribut        |    5    |
|  4  | Constructor    |    5    |
|  5  | Mutator        |    5    |
|  6  | Accessor       |    5    |
|  7  | Encapsulation  |    5    |
|  8  | Inheritance    |    5    |
|  9  | Polymorphism   |   10    |
| 10  | Seleksi        |    5    |
| 11  | Perulangan     |    5    |
| 12  | IO Sederhana   |   10    |
| 13  | Array          |   15    |
| 14  | Error Handling |   15    |
|     | **TOTAL**      | **100** |

## Pembuat

Nama: Dony Hares Subrata
NPM : 2410010125