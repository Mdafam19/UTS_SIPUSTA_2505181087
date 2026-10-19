/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package layanan;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import model.Koleksi;

/**
 *
 * @author Administrator
 */
public class EksporKatalog {

    public void ekspor(List<Koleksi> daftarKoleksi)
            throws IOException {

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter("katalog.txt"))) {

            writer.write(String.format(
                    "%-10s | %-35s | %-12s | %-50s",
                    "Kode", "Judul", "Tahun", "Status"
            ));

            writer.newLine();

            writer.write(
     "--------------------------------------------------------------------------------------------------------------------------------"
 );

            writer.newLine();

            for (Koleksi koleksi : daftarKoleksi) {
            writer.write(String.format(
                "%-10s | %-35s | %-12d | %-50s",
                koleksi.getKodeKoleksi(),
                koleksi.getJudul(),
                koleksi.getTahunTerbit(),
                koleksi.getStatusKelayakan()
            ));


                writer.newLine();
            }
        }
    }
}
