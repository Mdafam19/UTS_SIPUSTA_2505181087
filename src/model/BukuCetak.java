/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Administrator
 */
public class BukuCetak extends Koleksi implements Terarsip {
    
    private int jumlahHalaman;
    private String nomorRak;
    private int lokasiLantai;
    private boolean sedangDiperbaiki;
    private boolean sedangDipinjam;
    
    public BukuCetak(String kodeKoleksi, String judul, int tahunTerbit, int jumlahHalaman, String nomorRak, int lokasiLantai, boolean sedangDiperbaiki){
        super(kodeKoleksi, judul, tahunTerbit);
        
        this.jumlahHalaman = jumlahHalaman;
        this.nomorRak = nomorRak;
        this.lokasiLantai = lokasiLantai;
        this.sedangDiperbaiki = sedangDiperbaiki;
        this.sedangDipinjam = false;   
    }
    
    @Override
    public boolean layakDipinjam(){
        return !sedangDiperbaiki;
    }
    
    @Override
    public String getStatusKelayakan(){
        if(sedangDiperbaiki){
            return "Tidak layak: buku sedang diperbaiki";
        }
        return "Layak dipinjam";
    }
    
     @Override
    public String deskripsi() {
        return super.deskripsi()
                + " | Halaman: " + jumlahHalaman
                + " | Rak: " + nomorRak
                + " | Lantai: " + lokasiLantai;
    }

    @Override
    public String nomorRak() {
        return nomorRak;
    }

    @Override
    public int lokasiLantai() {
        return lokasiLantai;
    }

    public boolean isSedangDipinjam() {
        return sedangDipinjam;
    }

    public void setSedangDipinjam(boolean sedangDipinjam) {
        this.sedangDipinjam = sedangDipinjam;
    }
}
