/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.hilosadivinadores;

/**
 *
 * @author navarro
 */
public class HilosAdivinadores {
    private static final int MAX_NUMERO = 100;
    private static final int NUM_HILOS = 10;

    public static void main(String[] args) {
        NumeroOculto numeroOculto = new NumeroOculto(MAX_NUMERO);
        Thread[] hilos = new Thread[NUM_HILOS];

        for (int i = 0; i < hilos.length; i++) {
            Thread hiloAdvinador = new Thread(new HiloAdivinador(numeroOculto, "HiloAdivinador-" + (i + 1), MAX_NUMERO));
            hilos[i] = hiloAdvinador;
        }
        
        for (Thread hiloAdvinador : hilos) {
            hiloAdvinador.start();
        }
        
        for (Thread hiloAdvinador : hilos) {
            try {
                hiloAdvinador.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("El juego ha terminado.");
    }
}
