/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Soru2Package;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author dream
 */
public class Main {
    public static void main(String[] args) {
        int kaydedilecekSayi=0;
        Person person = new Person();
        Scanner scn = new Scanner(System.in);
        System.out.print("Kaç tane müşteri ve çalışan kayıt etmek istiyorsunuz?");
        kaydedilecekSayi = scn.nextInt();
        List<Person> musteriList = new ArrayList<Person>();
        List<Person> calisanList = new ArrayList<Person>();
        for (int i = 0; i < kaydedilecekSayi; i++) {
            System.out.print("Müşteri ID:");
            int musteriId = scn.nextInt();
            System.out.print("Müşteri Adı:");
            scn.nextLine();
            String musteriAd = scn.nextLine();
            System.out.print("Müşteri Soyadı:");
            String musteriSoyad = scn.nextLine();
            System.out.print("Müşteri Yaşı:");
            int musteriYas = scn.nextInt();
            Person personMusteri = new Customer(musteriId, musteriAd, musteriSoyad, musteriYas);
            musteriList.add(personMusteri);
            System.out.print("Çalışan ID:");
            int calisanId = scn.nextInt();
            System.out.print("Çalışan Adı:");
            scn.nextLine();
            String calisanAd = scn.nextLine();
            System.out.print("Çalışan Soyadı:");
            String calisanSoyad = scn.nextLine();
            System.out.print("Çalışan Yaşı:");
            int calisanYas = scn.nextInt();
            Person personCalisan = new Employee(calisanId, calisanAd, calisanSoyad, calisanYas);
            calisanList.add(personCalisan); 
        }
        scn.nextLine();
        System.out.print("Hangi veritabanına kayıt etmek istiyorsunuz?");
        String veriTabani = scn.nextLine();
        person.add(veriTabani);
        System.out.print("Hangi listeyi görmek istediğinizi yazınız(Musteri-Calisan).");
        String hangiListe = scn.nextLine();
        if(hangiListe.equals("Musteri")){
            for (int i = 0; i < musteriList.size(); i++) {
                System.out.println("Id: "+musteriList.get(i).getId()+"\n"+"Ad: "+musteriList.get(i).getName()+"\n"+
                        "Soyad: "+musteriList.get(i).getLastName()+"\n"+"Yaş: "+musteriList.get(i).getAge()
                );
            }
        }else if(hangiListe.equals("Calisan")){
            for (int i = 0; i < calisanList.size(); i++) {
                System.out.println("Id: "+calisanList.get(i).getId()+"\n"+"Ad: "+calisanList.get(i).getName()+"\n"+
                        "Soyad: "+calisanList.get(i).getLastName()+"\n"+"Yaş: "+calisanList.get(i).getAge()
                );
            }
        }else{
            System.out.println("Musteri ya da Calisan yazınız");
        }
    }

}
