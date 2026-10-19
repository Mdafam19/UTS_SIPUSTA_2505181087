/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package uts_sipusta_2505181087;

import java.io.IOException;
import model.*;
import layanan.*;
import eksepsi.*;

public class UTS_SIPUSTA_2505181087 {

    public static void main(String[] args) {

        KatalogPerpustakaan katalog =
                new KatalogPerpustakaan();

        // 1. Memasukkan enam data wajib UTS
        BukuCetak buku1 = new BukuCetak(
                "BK-001", "Java How to Program",
                2022, 620, "A-12", 1, false
        );

        BukuCetak buku2 = new BukuCetak(
                "BK-002", "Basis Data Relasional",
                2021, 410, "B-04", 1, true
        );

        Majalah majalah1 = new Majalah(
                "MJ-001", "Info Teknologi Edisi 88",
                2026, "88", "Agustus", "C-01", 2, true
        );

        Majalah majalah2 = new Majalah(
                "MJ-002", "Info Teknologi Edisi 87",
                2026, "87", "Juli", "C-02", 2, false
        );

        BerkasDigital berkas1 = new BerkasDigital(
                "BD-001", "Panduan Pemrograman Java",
                2024, 15, "unduh.polmed.ac.id/bd001"
        );

        BerkasDigital berkas2 = new BerkasDigital(
                "BD-002", "Jurnal Rekayasa Perangkat",
                2025, 8, "unduh.polmed.ac.id/bd002"
        );

        katalog.tambahKoleksi(buku1);
        katalog.tambahKoleksi(buku2);
        katalog.tambahKoleksi(majalah1);
        katalog.tambahKoleksi(majalah2);
        katalog.tambahKoleksi(berkas1);
        katalog.tambahKoleksi(berkas2);

        // 2. Menampilkan seluruh status koleksi
        System.out.println("=== STATUS KATALOG ===");
        katalog.cetakStatus();

        // 3. Menampilkan ringkasan arsip
        System.out.println("\n=== RINGKASAN ARSIP ===");
        System.out.println(buku1.ringkasanArsip());
        System.out.println(majalah1.ringkasanArsip());

        // 4. Mengurutkan koleksi
        System.out.println("\n=== KATALOG SETELAH DIURUTKAN ===");
        katalog.urut(new UrutLayakLaluJudul());
        katalog.cetakStatus();

        // 5. Menguji peminjaman dan exception
        System.out.println("\n=== UJI PEMINJAMAN ===");

        try {
            katalog.pinjam(buku1);
            System.out.println(
                    "Berhasil meminjam: " + buku1.getJudul()
            );

            katalog.pinjam(buku1);

        } catch (KoleksiSedangDipinjamException
                | KoleksiTidakLayakException e) {
            System.out.println("Peminjaman gagal: " + e.getMessage());
        }

        try {
            katalog.pinjam(buku2);

        } catch (KoleksiSedangDipinjamException
                | KoleksiTidakLayakException e) {
            System.out.println("Peminjaman gagal: " + e.getMessage());
        }

        try {
            katalog.pinjam(majalah1);

        } catch (KoleksiSedangDipinjamException
                | KoleksiTidakLayakException e) {
            System.out.println("Peminjaman gagal: " + e.getMessage());
        }

        try {
            katalog.pinjam(majalah2);
            System.out.println(
                    "Berhasil meminjam: " + majalah2.getJudul()
            );

        } catch (KoleksiSedangDipinjamException
                | KoleksiTidakLayakException e) {
            System.out.println("Peminjaman gagal: " + e.getMessage());
        }

        // 6. Mengekspor katalog ke katalog.txt
        System.out.println("\n=== EKSPOR KATALOG ===");

        EksporKatalog ekspor = new EksporKatalog();

        try {
            ekspor.ekspor(katalog.getDaftarKoleksi());
            System.out.println(
                    "Katalog berhasil diekspor ke katalog.txt"
            );

        } catch (IOException e) {
            System.out.println(
                    "Gagal mengekspor katalog: " + e.getMessage()
            );
        }
    }
}

