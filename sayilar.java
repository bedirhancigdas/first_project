import java.io.*;

public class sayilar {
    public static void main(String[] args) {
        try {
            // Giriş ve çıkış dosyalarını aç
            BufferedReader okuyucu = new BufferedReader(new FileReader("input.txt"));
            BufferedWriter yazici = new BufferedWriter(new FileWriter("output.txt"));

            String satir;
            while ((satir = okuyucu.readLine()) != null) {
                // Komutları işleme
                if (satir.equalsIgnoreCase("Exit")) {
                    break; // "Exit" komutu varsa işlemi bitir
                }

                if (satir.equalsIgnoreCase("Armstrong")) {
                    int sinir = Integer.parseInt(okuyucu.readLine().trim());
                    yazici.write("Armstrong " + sinir + ":\n");
                    for (int i = 1; i <= sinir; i++) {
                        if (armstrongMu(i)) {
                            yazici.write(i + " ");
                        }
                    }
                    yazici.write("\n\n");
                } else if (satir.equalsIgnoreCase("Emirp")) {
                    int sinir = Integer.parseInt(okuyucu.readLine().trim());
                    yazici.write("Emirp " + sinir + ":\n");
                    for (int i = 1; i <= sinir; i++) {
                        if (emirpMu(i)) {
                            yazici.write(i + " ");
                        }
                    }
                    yazici.write("\n\n");
                } else {
                    System.out.println("Bilinmeyen Komut: " + satir);
                }
            }

            yazici.write("Bittiii\n");
            okuyucu.close();
            yazici.close();
            System.out.println("Sonuçlar 'output.txt' dosyasına yazıldı.");
        } catch (IOException e) {
            System.out.println("Bir hata oluştu: " + e.getMessage());
        }
    }

    public static boolean armstrongMu(int sayi) {
        String sayiStr = String.valueOf(sayi);
        int basamakSayisi = sayiStr.length();
        int toplam = 0, gecici = sayi;

        while (gecici > 0) {
            int basamak = gecici % 10;
            toplam += Math.pow(basamak, basamakSayisi);
            gecici /= 10;
        }
        return toplam == sayi;
    }

    public static boolean asalMi(int sayi) {
        if (sayi <= 1) return false;
        for (int i = 2; i <= Math.sqrt(sayi); i++) {
            if (sayi % i == 0) return false;
        }
        return true;
    }

    public static boolean emirpMu(int sayi) {
        if (!asalMi(sayi)) return false;

        int tersSayi = Integer.parseInt(new StringBuilder(String.valueOf(sayi)).reverse().toString());
        return asalMi(tersSayi) && tersSayi != sayi;
    }
}