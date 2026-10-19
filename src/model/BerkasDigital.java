/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Administrator
 */
public class BerkasDigital extends Koleksi {

    private double ukuranMB;
    private String tautanUnduh;
    private boolean sedangDipinjam;

    public BerkasDigital(
            String kodeKoleksi,
            String judul,
            int tahunTerbit,
            double ukuranMB,
            String tautanUnduh) {

        super(kodeKoleksi, judul, tahunTerbit);

        this.ukuranMB = ukuranMB;
        this.tautanUnduh = tautanUnduh;
        this.sedangDipinjam = false;
    }

    @Override
    public boolean layakDipinjam() {
        return true;
    }

    @Override
    public String getStatusKelayakan() {
        return "Layak dipinjam";
    }

    @Override
    public String deskripsi() {
        return super.deskripsi()
                + " | Ukuran: " + ukuranMB + " MB"
                + " | Tautan: " + tautanUnduh;
    }

    public boolean isSedangDipinjam() {
        return sedangDipinjam;
    }

    public void setSedangDipinjam(boolean sedangDipinjam) {
        this.sedangDipinjam = sedangDipinjam;
    }
}

