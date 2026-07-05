public class User implements Info {
 
    // Atribut dibuat private -> konsep ENCAPSULATION
    private String username;
    private String password;
 
    // Constructor -> dipakai saat objek User dibuat
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
 
    // ===== Accessor (Getter) =====
    public String getUsername() {
        return username;
    }
 
    public String getPassword() {
        return password;
    }
 
    // ===== Mutator (Setter) =====
    public void setUsername(String username) {
        this.username = username;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    // Method untuk mengecek apakah password yang diinput cocok
    public boolean cekLogin(String usernameInput, String passwordInput) {
        return this.username.equals(usernameInput) && this.password.equals(passwordInput);
    }
 
    // Implementasi dari interface Info
    @Override
    public void tampilInfo() {
        System.out.println("Username: " + username);
    }
}