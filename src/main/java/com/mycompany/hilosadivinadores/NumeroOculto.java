/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hilosadivinadores;

import java.util.Random;

/**
 *
 * @author navarro
 */
class NumeroOculto {
    private final int numeroOculto;
    private boolean juegoTerminado = false;

    public NumeroOculto(int maxNumero) {
        Random random = new Random();
        this.numeroOculto = random.nextInt(maxNumero + 1);
        System.out.println("El número oculto es: " + this.numeroOculto);
    }

    public synchronized int propuestaNumero(int num) {
        if (juegoTerminado) {
            return -1;
        }
        if (num == numeroOculto) {
            juegoTerminado = true;
            return 1;
        }
        return 0;
    }

    public boolean isJuegoTerminado() {
        return juegoTerminado;
    }
}
