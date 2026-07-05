import java.util.ArrayList;

public class DepotService {
 
    private ArrayList<Pelanggan> daftarPelanggan;
    private ArrayList<ProdukAir> daftarProduk;
    private ArrayList<Transaksi> daftarTransaksi;
 
    public DepotService() {
        daftarPelanggan = new ArrayList<>();
        daftarProduk = new ArrayList<>();
        daftarTransaksi = new ArrayList<>();
    }
 
    // ================= PELANGGAN =================
 
    public void tambahPelanggan(Pelanggan p) {
        daftarPelanggan.add(p);
        System.out.println("Pelanggan berhasil ditambahkan.");
    }
 
    public void lihatPelanggan() {
        if (daftarPelanggan.isEmpty()) {
            System.out.println("Belum ada data pelanggan.");
            return;
        }
        for (Pelanggan p : daftarPelanggan) {
            p.tampilInfo();
            System.out.println("------------------------");
        }
    }
 
    public boolean editPelanggan(String idPelanggan, String namaBaru, String alamatBaru, String noHpBaru) {
        for (Pelanggan p : daftarPelanggan) {
            if (p.getIdPelanggan().equalsIgnoreCase(idPelanggan)) {
                p.setNama(namaBaru);
                p.setAlamat(alamatBaru);
                p.setNoHp(noHpBaru);
                return true;
            }
        }
        return false;
    }
 
    public boolean hapusPelanggan(String idPelanggan) {
        for (int i = 0; i < daftarPelanggan.size(); i++) {
            if (daftarPelanggan.get(i).getIdPelanggan().equalsIgnoreCase(idPelanggan)) {
                daftarPelanggan.remove(i);
                return true;
            }
        }
        return false;
    }
 
    public Pelanggan cariPelangganByNama(String nama) {
        for (Pelanggan p : daftarPelanggan) {
            if (p.getNama().equalsIgnoreCase(nama)) {
                return p;
            }
        }
        return null; // tidak ditemukan
    }
 
    public Pelanggan cariPelangganById(String idPelanggan) {
        for (Pelanggan p : daftarPelanggan) {
            if (p.getIdPelanggan().equalsIgnoreCase(idPelanggan)) {
                return p;
            }
        }
        return null;
    }
 
    // ================= PRODUK =================
 
    public void tambahProduk(ProdukAir produk) {
        daftarProduk.add(produk);
        System.out.println("Produk berhasil ditambahkan.");
    }
 
    public void lihatProduk() {
        if (daftarProduk.isEmpty()) {
            System.out.println("Belum ada data produk.");
            return;
        }
        for (ProdukAir p : daftarProduk) {
            p.tampilInfo();
            System.out.println("------------------------");
        }
    }
 
    public ProdukAir cariProdukById(String idProduk) {
        for (ProdukAir p : daftarProduk) {
            if (p.getIdProduk().equalsIgnoreCase(idProduk)) {
                return p;
            }
        }
        return null;
    }
 
    // ================= TRANSAKSI =================
 
    public void tambahTransaksi(Transaksi t) {
        daftarTransaksi.add(t);
        System.out.println("Transaksi berhasil dicatat.");
    }
 
    public void lihatRiwayatTransaksi() {
        if (daftarTransaksi.isEmpty()) {
            System.out.println("Belum ada transaksi.");
            return;
        }
        for (Transaksi t : daftarTransaksi) {
            t.tampilInfo();
            System.out.println("------------------------");
        }
    }
 
    public boolean hapusTransaksi(String idTransaksi) {
        for (int i = 0; i < daftarTransaksi.size(); i++) {
            if (daftarTransaksi.get(i).getIdTransaksi().equalsIgnoreCase(idTransaksi)) {
                daftarTransaksi.remove(i);
                return true;
            }
        }
        return false;
    }
 
    public void laporanPendapatan() {
        if (daftarTransaksi.isEmpty()) {
            System.out.println("Belum ada transaksi untuk dilaporkan.");
            return;
        }
 
        double totalPendapatan = 0;
        for (Transaksi t : daftarTransaksi) {
            totalPendapatan += t.hitungTotal();
        }
 
        System.out.println("===== LAPORAN PENDAPATAN =====");
        System.out.println("Jumlah Transaksi : " + daftarTransaksi.size());
        System.out.println("Total Pendapatan : Rp" + totalPendapatan);
    }
 
    // Getter untuk daftar (dibutuhkan Main untuk beberapa proses input)
    public ArrayList<Pelanggan> getDaftarPelanggan() {
        return daftarPelanggan;
    }
 
    public ArrayList<ProdukAir> getDaftarProduk() {
        return daftarProduk;
    }
 
    public ArrayList<Transaksi> getDaftarTransaksi() {
        return daftarTransaksi;
    }
}