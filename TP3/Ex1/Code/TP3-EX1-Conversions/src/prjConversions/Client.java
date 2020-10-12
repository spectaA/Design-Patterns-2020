package prjConversions;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Saisi saisi=new Saisi();
        ConvBin convB=new ConvBin();
        ConvHex convH=new ConvHex();
        ConvOct convO=new ConvOct();
        saisi.add(convO);
        saisi.add(convB);
        saisi.add(convH);
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("Saisir un entier :");
            saisi.setNombre(sc.nextInt());
        }
    }
}