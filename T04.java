// NIM - Your Name
// 12S24025 - Paula Gevriella Tambunan
// 12S24031 - Amelia Renata Lumbanbatu

import java.util.*;
import java.lang.Math;

public class T04 {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        String[] iSBN = new String[3];
        double[] price = new double[3];
        int[] quantity = new int[3];
        double temporaryPrice, totalPrice;
        String tISBN;
        int temporaryQuantity;
        int inisialisasi, indeks, loop, position;

        for (inisialisasi = 0; inisialisasi <= 2; inisialisasi++) {
            iSBN[inisialisasi] = " ";
            price[inisialisasi] = 0.0;
            quantity[inisialisasi] = 0;
        }
        tISBN = input.nextLine();
        indeks = 0;
        position = 0;
        while (!tISBN.equals("---")) {
            temporaryPrice = Double.parseDouble(input.nextLine());
            temporaryQuantity = Integer.parseInt(input.nextLine());
            boolean next;

            next = false;
            for (loop = 0; loop <= 2; loop++) {
                if (tISBN.equals(iSBN[loop])) {
                    next = true;
                    position = loop;
                }
            }
            if (next == true) {
                quantity[position] = quantity[position] + temporaryQuantity;
            } else {
                iSBN[indeks] = tISBN;
                price[indeks] = temporaryPrice;
                quantity[indeks] = temporaryQuantity;
                indeks = indeks + 1;
            }
            tISBN = input.nextLine();
        }
        double diskon;
        int isi;

        diskon = 0;
        totalPrice = 0.0;
        for (isi = 0; isi <= 2; isi++) {
            double tempPrice;

            if (quantity[isi] >= 20) {
                tempPrice = (price[isi] - price[isi] * 0.12) * quantity[isi];
            } else {
                if (quantity[isi] >= 10) {
                    tempPrice = (price[isi] - price[isi] * 0.05) * quantity[isi];
                } else {
                    if (quantity[isi] >= 5) {
                        tempPrice = (price[isi] - price[isi] * 0.02) * quantity[isi];
                    } else {
                        tempPrice = price[isi] * quantity[isi];
                    }
                }
            }
            totalPrice = totalPrice + tempPrice;
        }
        System.out.println(toFixed(totalPrice,2));
    }
    
    private static String toFixed(double value, int digits) {
        return String.format("%." + digits + "f", value);
    }
}

