/*
Universidad del Valle de Guatemala
Eliazar Canastuj
carnet: 23384
*/

import java.util.*;
import java.io.*;


public class main{

    public static void main (String[] args){
        Scanner teclado = new Scanner(System.in);
        Radio radio = new Radio();

//menu del radio
        boolean menu = true;
        while(menu){
            System.out.println("Radio: "+radio.getEncendido());
            System.out.println("1. Prende el radio");
            System.out.println("2. Cambia de AM a FM a AM");
            System.out.println("3. subir volumen");
            System.out.println("4. bajar volumen");
            System.out.println("5. Avanzar en el dial de las emisoras.");
            System.out.println("6. Permite guardar una emisora en uno de los 12 botones");
            System.out.println("7. Permite seleccionar la emisora puesta en un botón");
            System.out.println("8. Apagar el radio");
            System.out.println("-------------------------------------------------------------");
            System.out.println("Banda: "+ radio.getBanda());
            System.out.println("Emisora: "+ radio.getEmisora());
            System.out.println("volumen: "+ radio.getVolumen());
            int opcion = teclado.nextInt();
            teclado.nextLine();
            

            //encender el radio
            switch(opcion){
                case 1:
                    radio.encender();
                    break;

                //cambiar emisora y al momento del cambio dejar en su frecuencia minima
                case 2:
                    if(radio.getBanda().equals("FM")){
                        radio.cambiarBanda("AM");
                        radio.setEmisora(1600);
                    }
                    else if(radio.getBanda().equals("AM")){
                        radio.cambiarBanda("FM");
                        radio.setEmisora(87.5);
                    }
                    break;

                //si el radio esta encendido aumentar el volumen a 1
                case 3:
                    if(radio.getEstado()){
                        radio.setVolume(1);
                    }
                    break;

                //si el radio esta encendido disminuir el volumen si este no es 0
                case 4:
                    if(radio.getEstado()){
                        if(radio.getVolumen() >= 0){
                            radio.setVolume(-1);
                        }
                    }
                    
                    break;

                //si el radio esta encendido aumentar la emisora
                case 5:
                    if(radio.getEstado()){
                        radio.subirEmisora();
                    }
                    break;


                //guardar una emissora en un boton
                case 6:
                    System.out.println("En que boton desea guardar la emisora: ");
                    int boton = teclado.nextInt();
                    teclado.nextLine();
                    if( 0 < boton && boton < 13){
                        radio.guardarEmisora(boton);
                    }
                    break;

                //poner emisora de un boton
                case 7:
                    System.out.println("Elija un boton ");
                    int boton1 = teclado.nextInt();
                    teclado.nextLine();
                    if( 0 < boton1 && boton1 < 13){
                        radio.seleccionarEmisora(boton1);
                    }
                    break;

                //apagar el radio
                case 8:
                    radio.apagar();
                    break;
            }
        }
    }
}
