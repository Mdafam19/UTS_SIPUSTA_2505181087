/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package layanan;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import model.Koleksi;

import eksepsi.KoleksiSedangDipinjamException;
import eksepsi.KoleksiTidakLayakException;
/**
 *
 * @author Administrator
 */
public class KatalogPerpustakaan {
    
    private final List<Koleksi> daftarKoleksi;
    
    public KatalogPerpustakaan() {
        daftarKoleksi = new ArrayList<>();
    }
    
    public void tambahKoleksi(Koleksi koleksi) {
        daftarKoleksi.add(koleksi);
    }
    
        public void cetakStatus() {
        System.out.println("===== STATUS KATALOG ====");
        
        for (Koleksi koleksi : daftarKoleksi){
            System.out.println(koleksi.deskripsi());
            System.out.println("Status: " + koleksi.getStatusKelayakan());
            System.out.println("------------------------");
        }
    }
    
    public void urut(Comparator<Koleksi> comparator) {
        daftarKoleksi.sort(comparator);
    }
    
    
    public List<Koleksi> getDaftarKoleksi() {
        return new ArrayList<>(daftarKoleksi);
    }

    
    
public void pinjam(Koleksi koleksi)
        throws KoleksiSedangDipinjamException,
               KoleksiTidakLayakException {

    if (koleksi == null) {
        throw new IllegalArgumentException(
                "Koleksi yang akan dipinjam tidak ditemukan."
        );
    }

    if (koleksi instanceof model.BukuCetak) {
        model.BukuCetak buku = (model.BukuCetak) koleksi;

        if (buku.isSedangDipinjam()) {
            throw new KoleksiSedangDipinjamException(
                    "Buku sedang dipinjam. Silakan coba lagi nanti."
            );
        }

        if (!buku.layakDipinjam()) {
            throw new KoleksiTidakLayakException(
                    "Buku sedang diperbaiki dan belum bisa dipinjam."
            );
        }

        buku.setSedangDipinjam(true);

    } else if (koleksi instanceof model.Majalah) {
        model.Majalah majalah = (model.Majalah) koleksi;

        if (majalah.isSedangDipinjam()) {
            throw new KoleksiSedangDipinjamException(
                    "Majalah sedang dipinjam. Silakan coba lagi nanti."
            );
        }

        if (!majalah.layakDipinjam()) {
            throw new KoleksiTidakLayakException(
                    "Majalah edisi terbaru belum boleh dipinjam."
            );
        }

        majalah.setSedangDipinjam(true);

    } else if (koleksi instanceof model.BerkasDigital) {
        model.BerkasDigital berkas =
                (model.BerkasDigital) koleksi;

        if (berkas.isSedangDipinjam()) {
            throw new KoleksiSedangDipinjamException(
                    "Berkas digital sedang dipinjam."
            );
        }

        berkas.setSedangDipinjam(true);

    } else if (!koleksi.layakDipinjam()) {
        throw new KoleksiTidakLayakException(
                "Koleksi ini belum memenuhi syarat peminjaman."
        );
    }
}

}
