/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author dream
 */
 //Elimizde N x N bir matris bulunuyor. Matriste sağ üstten aşağıya
doğru çapraz çizgiler çekiliyor ve bu çizgilerin geçtiği matrislerin elemanları toplanıyor.
Elemanları toplamı en büyük olan çizginin değerini yazdırınız.

Örnek sayılar sırasıyla:
5 7 1
4 3 6
7 9 11
Ve en büyük değer: 9 + 6 = 15
Girdi(Standard Input):
 İlk satır N integer değerini içerecek. Sonraki N satır ise Xi integer sayılarını içerecek.
Çıktı(Standard Output):
 Sadece en büyük toplam olan integer değer yazdırılacak.

public class Soru3 {
    public static void main(String[] args) {
        int k=0,geciciJ=1,topla=0,a,max;
        Scanner scn=new Scanner(System.in);
        System.out.print("N(NxN):");
        int n = scn.nextInt();
        int[] matris1 = new int[n*n];
        int[][] matris0 = new int[n][n];
        ArrayList<Integer> geciciMatris = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(i+" "+j);
                matris0[i][j] = scn.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matris1[k] = matris0[i][j]; //kullanıcıdan aldığım 2 boyutlu diziyi tek boyutlu diziye aktardım
                k++;
            }
        }
        geciciMatris.add(matris1[0]); //matrisin ilk değerini dizi listeme ekledim
        k=n;
        for (int i = 0; i < (2*n-1)/2; i++) { //matrisin sol kısmındaki çizgilerinde ve ortadaki çizgisinde bulunan değerlerin toplamını dizi listeme gönderdim
            for (int j =geciciJ ; j < k+1; j = j+n-1) {
                topla = topla + matris1[j];
            } 
            geciciMatris.add(topla);
            topla = 0;
            geciciJ++;
            k+=n;
        }
        for (int i = 0; i < matris1.length / 2; i++) { //matrisi ters çevirdim
            a = matris1[i]; 
            matris1[i] = matris1[matris1.length - i - 1]; 
            matris1[matris1.length - i - 1] = a; 
        }
        topla=0;
        k=n;
        geciciJ=1;
        for (int i = 0; i < (2*n-3)/2; i++) { //ters çevirdiğim matrisin de orta çizgisi dışında sol kısımdaki çizgilerinde ve ortadaki çizgisinde bulunan değerlerin toplamını dizi listeme gönderdim
            for (int j =geciciJ ; j < k+1; j = j+n-1) {
                topla = topla + matris1[j];
            } 
            geciciMatris.add(topla);
            topla = 0;
            geciciJ++;
            k+=n;
        }
       geciciMatris.add(matris1[0]); //matrisi ters çevirdiğim için sol elemanı ilk elemanı olmuş oldu, bunu da dizi listeme gönderdim
       max = geciciMatris.get(0);
        for (int i = 0; i<geciciMatris.size(); i++) { //dizi listemdeki en büyük değeri aldım
            if(geciciMatris.get(i)>max){
                max = geciciMatris.get(i);
            }
        }
        System.out.println(max);
   {

        }

    }
}
