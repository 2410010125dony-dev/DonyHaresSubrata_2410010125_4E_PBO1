import java.time.LocalDate;
 
public class Transaksi implements Info {
 
    private String idTransaksi;
    private Pelanggan pelanggan;
    private ProdukAir produk;
    private int jumlahGalon;
    private LocalDate tanggal;
 
    public Transaksi(String idTransaksi, Pelanggan pelanggan, ProdukAir produk, int jumlahGalon) {
        this.idTransaksi = idTransaksi;
        this.pelanggan = pelanggan;
        this.produk = produk;
        this.jumlahGalon = jumlahGalon;
        this.tanggal = LocalDate.now(); // tanggal otomatis diambil saat transaksi dibuat
    }
 
    // ===== Accessor =====
    public String getIdTransaksi() {
        return idTransaksi;
    }
 
    public Pelanggan getPelanggan() {
        return pelanggan;
    }
 
    public ProdukAir getProduk() {
        return produk;
    }
 
    public int getJumlahGalon() {
        return jumlahGalon;
    }
 
    public LocalDate getTanggal() {
        return tanggal;
    }
 
    // Method untuk menghitung total harga transaksi
    public double hitungTotal() {
        return produk.getHarga() * jumlahGalon;
    }
 
    @Override
    public void tampilInfo() {
        System.out.println("ID Transaksi : " + idTransaksi);
        System.out.println("Pelanggan    : " + pelanggan.getNama());
        System.out.println("Produk       : " + produk.getNamaProduk() + " (" + produk.getUkuran() + "L)");
        System.out.println("Jumlah Galon : " + jumlahGalon);
        System.out.println("Total Harga  : Rp" + hitungTotal());
        System.out.println("Tanggal      : " + tanggal);
    }
}