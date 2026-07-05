import java.util.Scanner;

public class Main {
 
    static Scanner input = new Scanner(System.in);
    static DepotService depotService = new DepotService();
    static int nomorTransaksi = 1;
    static int nomorPelanggan = 1;
    static int nomorProduk = 1;
 
    public static void main(String[] args) {
 
        Admin admin = new Admin("admin", "admin123");
 
        System.out.println("===== LOGIN ADMIN =====");
        boolean loginBerhasil = false;
 
        // Perulangan login, diberi kesempatan sampai 3 kali
        for (int percobaan = 1; percobaan <= 3; percobaan++) {
            System.out.print("Username : ");
            String usernameInput = input.nextLine();
            System.out.print("Password : ");
            String passwordInput = input.nextLine();
 
            if (admin.cekLogin(usernameInput, passwordInput)) {
                loginBerhasil = true;
                System.out.println("\nLogin berhasil! Selamat datang, " + admin.getUsername());
                admin.tampilInfo();
                break;
            } else {
                System.out.println("Username/Password salah. Sisa percobaan: " + (3 - percobaan) + "\n");
            }
        }
 
        if (!loginBerhasil) {
            System.out.println("Login gagal 3 kali. Program dihentikan.");
            return;
        }
 
        // Tambah beberapa produk contoh secara otomatis (memudahkan demo saat presentasi)
        depotService.tambahProduk(new ProdukAir(bikinIdProduk(), "Air Isi Ulang Biasa", 19, 5000));
        depotService.tambahProduk(new ProdukAir(bikinIdProduk(), "Air RO", 19, 7000));
        depotService.tambahProduk(new ProdukAir(bikinIdProduk(), "Air Mineral", 12, 6000));
 
        boolean lanjut = true;
        while (lanjut) {
            tampilkanMenu();
            int pilihan = bacaPilihanMenu();
 
            switch (pilihan) {
                case 1 -> tambahPelangganMenu();
                case 2 -> depotService.lihatPelanggan();
                case 3 -> editPelangganMenu();
                case 4 -> hapusPelangganMenu();
                case 5 -> tambahProdukMenu();
                case 6 -> depotService.lihatProduk();
                case 7 -> transaksiMenu();
                case 8 -> depotService.lihatRiwayatTransaksi();
                case 9 -> cariPelangganMenu();
                case 10 -> depotService.laporanPendapatan();
                case 11 -> {
                    System.out.println("Terima kasih. Program selesai.");
                    lanjut = false;
                }
                default -> System.out.println("Pilihan tidak tersedia, coba lagi.");
            }
            System.out.println();
        }
    }
 
    // ===== Menu tampilan =====
    static void tampilkanMenu() {
        System.out.println("===== SISTEM MANAJEMEN DEPOT AIR MINUM =====");
        System.out.println("1. Tambah Pelanggan");
        System.out.println("2. Lihat Pelanggan");
        System.out.println("3. Edit Pelanggan");
        System.out.println("4. Hapus Pelanggan");
        System.out.println("5. Tambah Produk Air");
        System.out.println("6. Lihat Produk");
        System.out.println("7. Transaksi Isi Ulang");
        System.out.println("8. Riwayat Transaksi");
        System.out.println("9. Cari Pelanggan");
        System.out.println("10. Laporan Pendapatan");
        System.out.println("11. Keluar");
        System.out.print("Pilih menu: ");
    }
 
    // Baca pilihan menu dengan Error Handling
    static int bacaPilihanMenu() {
        try {
            int pilihan = Integer.parseInt(input.nextLine());
            return pilihan;
        } catch (NumberFormatException e) {
            System.out.println("Input harus berupa angka!");
            return -1; // nilai tidak valid, akan masuk ke default di switch
        }
    }
 
    // ===== Fitur Pelanggan =====
    static void tambahPelangganMenu() {
        System.out.print("Nama Pelanggan : ");
        String nama = input.nextLine();
        System.out.print("Alamat         : ");
        String alamat = input.nextLine();
        System.out.print("No HP          : ");
        String noHp = input.nextLine();
 
        Pelanggan pelangganBaru = new Pelanggan(bikinIdPelanggan(), nama, alamat, noHp);
        depotService.tambahPelanggan(pelangganBaru);
    }
 
    static void editPelangganMenu() {
        System.out.print("Masukkan ID Pelanggan yang ingin diedit: ");
        String id = input.nextLine();
 
        Pelanggan cek = depotService.cariPelangganById(id);
        if (cek == null) {
            System.out.println("ID Pelanggan tidak ditemukan.");
            return;
        }
 
        System.out.print("Nama Baru   : ");
        String nama = input.nextLine();
        System.out.print("Alamat Baru : ");
        String alamat = input.nextLine();
        System.out.print("No HP Baru  : ");
        String noHp = input.nextLine();
 
        boolean berhasil = depotService.editPelanggan(id, nama, alamat, noHp);
        System.out.println(berhasil ? "Data berhasil diubah." : "Gagal mengubah data.");
    }
 
    static void hapusPelangganMenu() {
        System.out.print("Masukkan ID Pelanggan yang ingin dihapus: ");
        String id = input.nextLine();
        boolean berhasil = depotService.hapusPelanggan(id);
        System.out.println(berhasil ? "Pelanggan berhasil dihapus." : "ID Pelanggan tidak ditemukan.");
    }
 
    static void cariPelangganMenu() {
        System.out.print("Masukkan nama pelanggan yang dicari: ");
        String nama = input.nextLine();
        Pelanggan hasil = depotService.cariPelangganByNama(nama);
        if (hasil != null) {
            hasil.tampilInfo();
        } else {
            System.out.println("Pelanggan dengan nama tersebut tidak ditemukan.");
        }
    }
 
    // ===== Fitur Produk =====
    static void tambahProdukMenu() {
        System.out.print("Nama Produk (contoh: Air RO) : ");
        String nama = input.nextLine();
 
        int ukuran;
        double harga;
        try {
            System.out.print("Ukuran (liter)               : ");
            ukuran = Integer.parseInt(input.nextLine());
            System.out.print("Harga per galon               : ");
            harga = Double.parseDouble(input.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Ukuran/Harga harus berupa angka. Produk gagal ditambahkan.");
            return;
        }
 
        ProdukAir produkBaru = new ProdukAir(bikinIdProduk(), nama, ukuran, harga);
        depotService.tambahProduk(produkBaru);
    }
 
    // ===== Fitur Transaksi =====
    static void transaksiMenu() {
        System.out.print("Masukkan nama pelanggan: ");
        String nama = input.nextLine();
        Pelanggan pelanggan = depotService.cariPelangganByNama(nama);
 
        if (pelanggan == null) {
            System.out.println("Pelanggan tidak ditemukan. Silakan tambah pelanggan dulu.");
            return;
        }
 
        depotService.lihatProduk();
        System.out.print("Masukkan ID Produk yang dipilih: ");
        String idProduk = input.nextLine();
        ProdukAir produk = depotService.cariProdukById(idProduk);
 
        if (produk == null) {
            System.out.println("Produk tidak ditemukan.");
            return;
        }
 
        int jumlahGalon;
        try {
            System.out.print("Jumlah galon: ");
            jumlahGalon = Integer.parseInt(input.nextLine());
 
            if (jumlahGalon <= 0) {
                System.out.println("Jumlah galon harus lebih dari 0.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Jumlah galon harus berupa angka.");
            return;
        }
 
        Transaksi transaksiBaru = new Transaksi(bikinIdTransaksi(), pelanggan, produk, jumlahGalon);
        depotService.tambahTransaksi(transaksiBaru);
 
        System.out.println("\n----- STRUK TRANSAKSI -----");
        transaksiBaru.tampilInfo();
    }
 
    // ===== Method bantu untuk membuat ID otomatis =====
    static String bikinIdPelanggan() {
        return "PLG-" + String.format("%03d", nomorPelanggan++);
    }
 
    static String bikinIdProduk() {
        return "PRD-" + String.format("%03d", nomorProduk++);
    }
 
    static String bikinIdTransaksi() {
        return "TRX-" + String.format("%03d", nomorTransaksi++);
    }
}