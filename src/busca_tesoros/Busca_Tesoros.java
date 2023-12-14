/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package busca_tesoros;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Andres
 */
public class Busca_Tesoros {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        //constantes
        final int VACIO = 0;
        final int MINA = 1;
        final int TESORO = 2;
        final int INTENTO = 5; 
        
        int[][] tablero = new int[5][5];
        
        int tesoroX;
        int tesoroY;
        int minaX = (int)(Math.random() * 5);
        int minaY = (int)(Math.random() * 5);
        int x;
        int y;
        int salir = 1;
        boolean terminado = false;    

        for(x = 0; x < tablero.length; x++) {
            for(y = 0; y < tablero[x].length; y++) {
              tablero[x][y] = VACIO;
            }
        }        
        
        tablero[minaX][minaY] = MINA;
        
        do {
            tesoroX = (int)(Math.random() * 5);
            tesoroY = (int)(Math.random() * 5);
        } while ((minaX == tesoroX) && (minaY == tesoroY));
        tablero[tesoroX][tesoroY] = TESORO;      
             
        // juego
        System.out.println("¡BUSCA TESOROS!");        
        //tablero
        System.out.println(" _ _ _ _ _ ");
        for(x = 0; x < tablero.length; x++) { 
            for(y = 0; y < tablero[x].length; y++) {                  
                System.out.print("|_");
            }
            System.out.println("|");                
        }
        System.out.println();
        
        //tablero
        /*System.out.println(" _ _ _ _ _ ");
        for(x=0; x<tablero.length; x++) {            
            for(y=0; y<tablero[x].length; y++) {                  
                switch(tablero[x][y]) {
                  case VACIO:
                    System.out.print("|_");                    
                    break;
                  case MINA:
                    System.out.print("|*");
                    break;
                  case TESORO: 
                    System.out.print("|$");
                    break;
                  case INTENTO:
                    System.out.print("|X");
                    break;
                }                
            }
            System.out.println("|");                
        }
        System.out.println();*/
        
        do { 
            if (salir == INTENTO) {
                System.out.println("Último Intento");
            } 
            System.out.println("Intento N° " + salir);
            // pide las coordenadas  
            System.out.print("Ingrese la fila: ");
            x = scanner.nextInt();
            System.out.print("Ingrese la columna: ");
            y = scanner.nextInt();            
      
            // mira lo que hay en las coordenadas indicadas por el usuario
            switch(tablero[x-1][y-1]) {
              case VACIO:
                tablero[x-1][y-1] = INTENTO;
                if (salir == INTENTO) {
                    System.out.println("¡Fallaste!");
                } 
                else {
                    System.out.println("¡Fallaste! Intenta de nuevo.");
                }                
                break;
              case MINA:
                System.out.println("¡Caístes en la mina! Lo siento  has perdido.");
                terminado = true;                
                break;
              case TESORO:
                System.out.println("¡Felicidades! Has encontrado el tesoro.");
                terminado = true;                
                break;
            }   
            
            //tablero
            System.out.println(" _ _ _ _ _ ");
            for(x=0; x<tablero.length; x++) {            
                for(y=0; y<tablero[x].length; y++) {                      
                    switch(tablero[x][y]) {
                      case VACIO:
                        System.out.print("|_");                    
                        break;
                      case MINA:
                          if (terminado || salir == INTENTO ) {
                              System.out.print("|*");
                          }
                          else {
                              System.out.print("|_");
                          }
                        break;
                      case TESORO:
                          if (terminado || salir == INTENTO ) {
                            System.out.print("|$");
                          }
                          else {
                              System.out.print("|_");
                          }
                        break;
                      case INTENTO:
                        System.out.print("|X");
                        break;
                    }                
                }
                System.out.println("|");                
            }
            System.out.println();                    
            
            if (terminado || salir == INTENTO) {
                break;
            } 
            
            salir++;            
        } while (!terminado);    
        
        System.out.println("Juego Terminado.");
        
    }
    
}
