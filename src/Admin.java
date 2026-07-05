public class Admin extends User {
 
    // Admin tidak butuh atribut tambahan,
    // cukup mewarisi username & password dari User.
 
    public Admin(String username, String password) {
        super(username, password); // memanggil constructor dari class User (parent)
    }
 
    // Override method tampilInfo() dari class User
    // Ini contoh nyata POLYMORPHISM: method sama, tapi isi/output beda
    @Override
    public void tampilInfo() {
        System.out.println("===== INFO ADMIN =====");
        System.out.println("Username Admin : " + getUsername());
        System.out.println("Status         : Administrator Sistem");
    }
}