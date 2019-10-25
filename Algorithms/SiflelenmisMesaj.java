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
 /* Aslı ve Kerem önemli bir yarışma hakkında birbirleriyle mesajlaşmaktadırlar ve Kerem
mesajlaşmayı güvenli tutmak istemektedir bu yüzden gönderdiği mesajları kendi
oluşturduğu bir şifreleme algoritması ile şifreleyerek gönderir. Aslı'ya Kerem'in gönderdiği
şifreli mesajı çözmesi için bir program yazınız.
 Kerem Algoritması:
Gönderilecek mesajın uzunluğu tam kare bir sayı olması gerekmektedir örnek olarak
4, 9, 16. Algoritmaya göre mesaj önce 2 boyutlu bir diziye aktarılır daha sonra (0,0)
elemanından başlayarak spiral şeklinde karakterler birleştirilerek şifrelenmiş mesaj
oluşturulur.
Girdi(Standard Input):
 Klavyeden tek satır string girilecektir ve bu şifrelenmiş mesaj olacaktır.
Çıktı(Standard Output):
 Şifresi çözülmüş orijinal mesaj yazdırılacaktır.
 */
public class Soru1 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        String gelenMesaj = "";
        System.out.print("Mesajı giriniz:");
        gelenMesaj = scn.nextLine();
        char[] gelenMesajChar=gelenMesaj.toCharArray();
        for (int i = 0; i < sifreyiCoz(gelenMesajChar).length; i++) {
            System.out.print(sifreyiCoz(gelenMesajChar)[i]);
        }
    }
    
    public static char [] sifreyiCoz(char[] gelenMesaj){ //gelen şifreli mesajı spiral şeklinde 2 boyutlu bir matrisin içine yerleştirdim ve bu matrisi sağdan sola doğru tek boyutlu bir dizinin içerisine yerleştirdim
        int k=0,a=0; // k tek boyutlu dizimdeki elemanları 2 boyutlu diziye spiral olarak yerleştirmek, a da spiral dönüşte aldığım elemanların sayısının belirli bir kurala göre azaltmak için kullandığım değişkenim
        int lenght=(int)Math.sqrt(gelenMesaj.length); //kolaylık açısından gelen mesajın boyutunun karekök değerini tuttuğum değişkenim
        int y=lenght-1,x=0; //sütun ayarlamaları için kullandığım değişkenlerim
        int dikeyYukariSatir=lenght-2, yataySagaSatir=lenght-1,satirBaslangic=0,sutunBaslangic=0; //satır ayarlamaları için kullandığım değişkenlerim
        
        char[] cozulenMesaj = new char[gelenMesaj.length];
        char [][] mesajSpiral = new char [lenght][lenght];
        
        while (k<gelenMesaj.length) { //spiral-dikey eksen aşağı
            
                for (int i = 0; i < lenght-a; i++) {
                    if(k==gelenMesaj.length){
                break;
            }
                mesajSpiral[satirBaslangic+i][sutunBaslangic] = gelenMesaj[k];
                k++;
            }
            a++;
                for (int i = 0; i < lenght-a; i++) { //spiral-yetay eksen sağa
                    if(k==gelenMesaj.length){
                break;
            }
                    mesajSpiral[yataySagaSatir][x+i+1] = gelenMesaj[k];
                    k++;
                    
                }
        
                for (int i = 0; i < lenght-a; i++) { //spiral-dikey eksen yukarı
                    if(k==gelenMesaj.length){
                break;
            }
                mesajSpiral[dikeyYukariSatir-i][y] = gelenMesaj[k];
                k++;
            }
            a++;
                for (int i = 0; i < lenght-a; i++) { //spiral-yatay eksen sola
                    if(k==gelenMesaj.length){
                break;
            }
                mesajSpiral[satirBaslangic][lenght-2-i] = gelenMesaj[k];
                k++;
                
                }
                x++;
                y--;
                satirBaslangic++;
                sutunBaslangic++;
                yataySagaSatir--;
                dikeyYukariSatir--;
            
        }
        int sayac=0;
        for (int i = 0; i < mesajSpiral.length; i++) {
            for (int j = 0; j < mesajSpiral.length; j++) {
                cozulenMesaj[sayac]=mesajSpiral[i][j];
                sayac++;
            }
        }
        
    return cozulenMesaj;
    }
}
