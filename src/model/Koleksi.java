/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author dafa
 */
public abstract class Koleksi {
    
    protected String kodeKoleksi;
    protected String judul;
    protected int tahunTerbit;
    
    public Koleksi(String kodeKoleksi, String judul, int tahunTerbit){
        this.kodeKoleksi = kodeKoleksi;
        this.judul = judul;
        this.tahunTerbit = tahunTerbit;
    }
    
    public String getKodeKoleksi(){
        return kodeKoleksi;
    }
    
    public String getJudul(){
        return judul;
    }
    
    public int getTahunTerbit(){
        return tahunTerbit;
    }
    
    public abstract boolean layakDipinjam();
    
    public abstract String getStatusKelayakan();
    
    public String deskripsi() {
    return "Kode: " + kodeKoleksi
            + " | Judul: " + judul
            + " | Tahun Terbit: " + tahunTerbit;
}
}
