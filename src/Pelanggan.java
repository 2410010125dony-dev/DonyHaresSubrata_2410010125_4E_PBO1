public class Pelanggan implements Info {
 
    private String idPelanggan;
    private String nama;
    private String alamat;
    private String noHp;
 
    public Pelanggan(String idPelanggan, String nama, String alamat, String noHp) {
        this.idPelanggan = idPelanggan;
        this.nama = nama;
        this.alamat = alamat;
        this.noHp = noHp;
    }
 
    // ===== Accessor =====
    public String getIdPelanggan() {
        return idPelanggan;
    }
 
    public String getNama() {
        return nama;
    }
 
    public String getAlamat() {
        return alamat;
    }
 
    public String getNoHp() {
        return noHp;
    }
 
    // ===== Mutator =====
    public void setNama(String nama) {
        this.nama = nama;
    }
 
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
 
    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }
 
    @Override
    public void tampilInfo() {
        System.out.println("ID Pelanggan : " + idPelanggan);
        System.out.println("Nama         : " + nama);
        System.out.println("Alamat       : " + alamat);
        System.out.println("No HP        : " + noHp);
    }
}