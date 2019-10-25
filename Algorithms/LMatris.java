import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dream                                       
 */
 //NxM matrisi içerisinde 3 hücreye dokunan küçük L ler içermektedir. Bu L
ler tüm yönlerde olabilir. L lerin dokunduğu hucrelerden
carpimlari en büyük olan sayıyı çıktı olarak veriniz
5 7 1
4 3 6
7 9 1
Bu örnekteki en büyük L'nin elemanlarının(4 7 9)
çarpımı 252'dir.
Örnek Girdi(Standard Input) Örnek Çıktı(Standard Output)
Girdi(Standard Intput):
 İlk satır N ve M integer değerlerini içerecek. Sonraki N satır ise her satırda M tane Xi
integer değerlerini içerecektir.
Çıktı(Standard Output):
 Sadece çarpımları en büyük L'nin değeri yazdırılacak(integer).

public class Soru4 {                     //kullanıcıdan aldığım matrisi 2x2 olarak oluşabilecek bütün karelere böldüm, bu kareler içindeki L'leri hesapladım ve daha sonra en büyük L değerini buldum.
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int sayacJ=0,sayacI=0,iGecici=0,jGecici=0,maxGecici=0,maxDeger=0;
        System.out.print("N(satır):");
        int n = scn.nextInt();
        System.out.print("M(sütun):");
        int m = scn.nextInt();
        int[][] matris = new int[n][m];
        int[][] geciciMatris = new int[2][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(i+" "+j);
                matris[i][j] = scn.nextInt();
            }
        }
        for(int a=0; a<n-1; a++){               //matrisi 2x2 şeklinde oluşabilecek bütün karelere böldüm
        for(int b=0; b<m-1; b++){  
            for (int i = sayacI; i < sayacI+2; i++) {
                for (int j = sayacJ; j < sayacJ+2; j++) {
                    System.out.println(matris[i][j]);
                    geciciMatris[iGecici][jGecici] = matris[i][j];
                    if(jGecici<1){
                        jGecici++;
                    }else{
                        jGecici=0;
                    }
                }
                if(iGecici<1){
                    iGecici++;
                }else{
                    iGecici=0;
                }
            }
            sayacJ++;
            int kareArray[] = {geciciMatris[0][0]*geciciMatris[1][0]*geciciMatris[1][1],  //dizi listeme karelerdeki L değerlerini gönderdim
            geciciMatris[0][1]*geciciMatris[1][1]*geciciMatris[1][0],
            geciciMatris[0][0]*geciciMatris[0][1]*geciciMatris[1][0],
            geciciMatris[0][0]*geciciMatris[0][1]*geciciMatris[1][1]
        };
            maxGecici = kareArray[0]; //en büyük L değerini hesapladım
            for (int i = 1; i < 4; i++) {
               if(kareArray[i]>maxGecici){
                   maxGecici = kareArray[i];
               }
            }
            if(maxGecici>maxDeger){
                maxDeger = maxGecici;
            }
        }
        sayacI++;
        sayacJ=0;
        }
        System.out.println(maxDeger);
    }
}
