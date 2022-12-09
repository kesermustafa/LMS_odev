package odev;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LmsOdev01 {

    public static final String W = "\u001B[37m";
    public static final String R = "\u001B[31m";
    public static final String G = "\u001B[32m";
    public static final String Y = "\u001B[33m";
    public static final String B = "\u001B[34m";

    /*  - Kullanıcıdan int öğelerini girmesini ve listeye öğe eklemesini istemek için kod yazın
        - Kullanıcıdan kaldırılacak öğeleri girmesini isteyin, ardından bu öğeyi listeden kaldırın.
        - Kullanıcıdan güncellemek için öğeyi girmesini isteyin, ardından güncelleyin.
  */

    public static void main(String[] args) {

        giris();

    }

    static Scanner input = new Scanner(System.in);
    static List<Integer> arr = new ArrayList<>();
    static List<Integer> silinecek = new ArrayList<>();

    public static void giris(){
        System.out.println(G+"Lutfen yapmak istediginiz islemi seciniz.."+Y+"\n1= Elemen ekleme\n2= Eleman silme\n3= Eleman guncelleme\n0= Exit/Cikis");
        Scanner input = new Scanner(System.in);
        int secim = input.nextInt();
        switch (secim){

            case 1 :
                elemenEkle();
                break;
            case 2 :
                elemanSil();
                break;
            case 3 :
                guncelle();
                break;
            case 0 :
                System.out.println(B+"Tesekkur ederiz...");
                break;
            default:
                System.out.println(R+"Gecersiz secim yaptiniz..");
                giris();
        }
    }

    public static void elemenEkle(){

        do {
            System.out.println(B+"Eklemek istediginiz elemani giriniz...\nIselemi tamamlamak icin 0 giriniz ");
            int eleman = input.nextInt();
            if (eleman!=0){
                arr.add(eleman);
            }else{
                break;
            }
        }while (true);

        System.out.println(arr);
        giris();
    }

    public static void elemanSil() {

        System.out.println(G+"Mevcut listeniz : " + arr);
        System.out.println(B + "1= Tek eleman silmek \n2= Coklu eleman silmek icin giriniz ");
        int sec = input.nextInt();
        if (sec == 1) {
            System.out.println(B + "Silmek istediginiz elemani giriniz..");
            int elemanSil = input.nextInt();
            arr.remove((Integer) elemanSil);
            System.out.println(G+"Guncel listeniz : " + arr);
            giris();
        } else {

            do {
                System.out.println(B + "Silmek istediginiz elemani giriniz...\nIslemi tamamlamak icin 0 giriniz ");
                int elemanSil = input.nextInt();

                if (elemanSil != 0) {
                    if (arr.contains(elemanSil)) {
                        silinecek.add(elemanSil);
                    } else {
                        System.out.println(R + "Bu eleman listenizde bulunmamaktadir.");
                    }

                } else {
                    arr.removeAll(silinecek);
                    System.out.println(silinecek + " elemanlar silsinmistir.");
                    break;
                }
            } while (true);

            System.out.println(G+"Guncel listeniz : " + arr);
            giris();
        }
    }

    public static void guncelle(){

        System.out.println(G+"Guncel listeniz : " + arr);
        System.out.println(B+"Guncellemek istediginiz elemani giriniz...");
        int eleman1 = input.nextInt();

            if(!arr.contains(eleman1)){
                System.out.println(R+"Girdiginiz eleman bulunmamaktadir.");
                guncelle();
            }else {
                System.out.println(B+"Yeni deger giriniz...");
                int eleman2 = input.nextInt();
                arr.set(arr.indexOf(eleman1), eleman2);
            }

        System.out.println(G+"Guncel listeniz : " + arr);
        giris();
    }

}
