public class ProdukAir implements Info {
 
    private String idProduk;
    private String namaProduk;   // contoh: Air Isi Ulang Biasa, Air RO, Air Mineral
    private int ukuran;          // dalam liter, contoh: 19, 15, 12
    private double harga;        // harga per galon
 
    public ProdukAir(String idProduk, String namaProduk, int ukuran, double harga) {
        this.idProduk = idProduk;
        this.namaProduk = namaProduk;
        this.ukuran = ukuran;
        this.harga = harga;
    }
 
    // ===== Accessor =====
    public String getIdProduk() {
        return idProduk;
    }
 
    public String getNamaProduk() {
        return namaProduk;
    }
 
    public int getUkuran() {
        return ukuran;
    }
 
    public double getHarga() {
        return harga;
    }
 
    // ===== Mutator =====
    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
    }
 
    public void setUkuran(int ukuran) {
        this.ukuran = ukuran;
    }
 
    public void setHarga(double harga) {
        this.harga = harga;
    }
 
    @Override
    public void tampilInfo() {
        System.out.println("ID Produk  : " + idProduk);
        System.out.println("Nama Air   : " + namaProduk);
        System.out.println("Ukuran     : " + ukuran + " Liter");
        System.out.println("Harga      : Rp" + harga);
    }
}