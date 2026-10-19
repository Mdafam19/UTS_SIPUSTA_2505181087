/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package layanan;

/**
 *
 * @author Administrator
 */
import java.util.Comparator;
import model.Koleksi;

public class UrutLayakLaluJudul
        implements Comparator<Koleksi> {

    @Override
    public int compare(Koleksi a, Koleksi b) {

        int hasilKelayakan = Boolean.compare(
                b.layakDipinjam(),
                a.layakDipinjam()
        );

        if (hasilKelayakan != 0) {
            return hasilKelayakan;
        }

        return a.getJudul().compareToIgnoreCase(
                b.getJudul()
        );
    }
}
