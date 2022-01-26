package com.letscode.IC;

import com.letscode.rebeldes.Individuo;
import com.letscode.rebeldes.Raca;
import lombok.Cleanup;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Random;

public class InteligenciaCentral {
    Individuo[] rebeldes;
    int maximoDeRebeldes;
    int indice;
    int count;


    public InteligenciaCentral() {
        Random random = new Random();
        this.maximoDeRebeldes = random.nextInt(5) + 2;
        this.rebeldes = new Individuo[this.maximoDeRebeldes];
        this.indice = 0;
        this.count = 0;
    }

    public boolean aceitaNovosRebeldes() {
        return this.indice < maximoDeRebeldes;
    }

    public boolean addRebelde(String nome, short idade, short raca){
        this.count += 1;
        if (this.indice < maximoDeRebeldes && isFibonacci(this.count)) {
            Raca racaIndividuo = Raca.values()[raca - 1];
            this.rebeldes[this.indice] = new Individuo(nome, idade, racaIndividuo);
            this.indice += 1;
            return true;
        }
        else{
            return false;
        }
    }

    boolean isPerfectSquare(int x)
    {
        int s = (int) Math.sqrt(x);
        return (s*s == x);
    }

    boolean isFibonacci(int n)
    {
        return this.isPerfectSquare(5*n*n + 4) ||
                this.isPerfectSquare(5*n*n - 4);
    }

    public void printRebeldes() throws FileNotFoundException, UnsupportedEncodingException {
        @Cleanup PrintWriter writer = new PrintWriter("rebeldes.txt", "UTF-8");
        writer.println("Rebeldes da Let's Code");
        for (Individuo rebelde: this.rebeldes) {
            writer.println("Name: " + rebelde.getNome() + " Idade: " + rebelde.getIdade() + " Raca: " + rebelde.getRaca().name());
        }
    }
}
