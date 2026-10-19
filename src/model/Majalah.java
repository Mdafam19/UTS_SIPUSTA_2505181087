/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Administrator
 */
public class Majalah extends Koleksi implements Terarsip {

    private String edisi;
    private String bulanTerbit;
    private String nomorRak;
    private int lokasiLantai;
    private boolean edisiTerbaru;
    private boolean sedangDipinjam;

    public Majalah(
            String kodeKoleksi,
            String judul,
            int tahunTerbit,
            String edisi,
            String bulanTerbit,
            String nomorRak,
            int lokasiLantai,
            boolean edisiTerbaru) {

        super(kodeKoleksi, judul, tahunTerbit);

        this.edisi = edisi;
        this.bulanTerbit = bulanTerbit;
        this.nomorRak = nomorRak;
        this.lokasiLantai = lokasiLantai;
        this.edisiTerbaru = edisiTerbaru;
        this.sedangDipinjam = false;
    }

    @Override
    public boolean layakDipinjam() {
        return !edisiTerbaru;
    }

    @Override
    public String getStatusKelayakan() {
        if (edisiTerbaru) {
            return "Tidak layak: majalah merupakan edisi terbaru";
        }

        return "Layak dipinjam";
    }

    @Override
    public String deskripsi() {
        return super.deskripsi()
                + " | Edisi: " + edisi
                + " | Bulan: " + bulanTerbit
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
