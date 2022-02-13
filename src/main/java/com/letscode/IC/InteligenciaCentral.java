package com.letscode.IC;

import com.letscode.rebeldes.Individuo;
import lombok.Cleanup;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class InteligenciaCentral {
    Queue<Individuo> rebeldes;
    int maximoDeRebeldes;
    int indice;
    int count;


    public InteligenciaCentral() {
        Random random = new Random();
        this.maximoDeRebeldes = random.nextInt(5) + 2;
        this.rebeldes  = new ArrayDeque<>();
        this.indice = 0;
        this.count = 0;
    }

    public boolean aceitaNovosRebeldes() {
        return this.indice < maximoDeRebeldes;
    }

    public boolean addRebelde(Individuo rebelde) {
        this.count += 1;
        if (this.indice < maximoDeRebeldes
                && this.isFibonacci(this.count)
                && !this.buscarRebelde(rebelde)) {

            this.rebeldes.add(rebelde);
            System.out.println(this.rebeldes);
            this.indice += 1;
            return true;
        }
        else{
            return false;
        }
    }

    public void printRebeldes(String ordem) throws FileNotFoundException, UnsupportedEncodingException {
        switch(ordem.toUpperCase()) {
            case "I":
                printRebels(this.sortByAge());
                break;
            case "R":
                printRebels(this.sortByRace());
                break;
            default:
                printRebels(this.sortByName());
        }
    }

    private void printRebels(Queue<Individuo> rebeldes) throws FileNotFoundException, UnsupportedEncodingException {
        this.printConsoleRebeldes(rebeldes);
        @Cleanup PrintWriter writer = new PrintWriter("rebeldes.txt", "UTF-8");
        writer.println("Rebeldes da Let's Code");
        for (Individuo rebelde: rebeldes) {
            if (rebelde != null){
                writer.println("Name: " + rebelde.getNome() + " Idade: " + rebelde.getIdade() + " Raca: " + rebelde.getRaca().name());
            }
        }
    }

    private Queue<Individuo> sortByName(){
        Comparator<Individuo> nameSorter = Comparator.comparing(Individuo::getNome);
        PriorityQueue<Individuo> sortedQueue = new PriorityQueue<Individuo>( nameSorter );
        for (Individuo rebelde: this.rebeldes) {
            if (rebelde != null){
                sortedQueue.add(rebelde);
            }
        }
        return sortedQueue;
    }

    private Queue<Individuo> sortByAge(){
        Comparator<Individuo> ageSorter = Comparator.comparing(Individuo::getIdade);
        PriorityQueue<Individuo> sortedQueue = new PriorityQueue<Individuo>( ageSorter );
        for (Individuo rebelde: this.rebeldes) {
            if (rebelde != null){
                sortedQueue.add(rebelde);
            }
        }
        return sortedQueue;
    }

    private Queue<Individuo> sortByRace (){
        Comparator<Individuo> raceSorter = Comparator.comparing(Individuo::getRaca);
        PriorityQueue<Individuo> sortedQueue = new PriorityQueue<Individuo>( raceSorter );
        for (Individuo rebelde: this.rebeldes) {
            if (rebelde != null){
                sortedQueue.add(rebelde);
            }
        }
        return sortedQueue;
    }

    private void printConsoleRebeldes(Queue<Individuo> rebeldes) {
        System.out.println(rebeldes);
    }

    private boolean buscarRebelde(Individuo rebelde){
        return this.rebeldes.contains(rebelde);
    }

    private boolean isPerfectSquare(int x)
    {
        int s = (int) Math.sqrt(x);
        return (s*s == x);
    }

    private boolean isFibonacci(int n) {
        return this.isPerfectSquare(5*n*n + 4) ||
                this.isPerfectSquare(5*n*n - 4);
    }
}
