import com.letscode.IC.InteligenciaCentral;
import com.letscode.rebeldes.Individuo;
import com.letscode.rebeldes.Raca;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Inscricao {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Sistema de inscrição de rebeldes contra o Império");
        InteligenciaCentral ic = new InteligenciaCentral();
        Scanner sc = new Scanner(System.in);
        boolean aceitaRebeldes = false;
        do {
            if (aceitaRebeldes) {
                System.out.println("Pressione C para continuar / I para imprimir em arquivo / S para Sair ...");
                sc.nextLine();
                String tecla = sc.nextLine();
                if (!tecla.toUpperCase().equals("C")) {
                    if (tecla.toUpperCase().equals("I")) {
                        try {
                            System.out.println("Selecione a ordenação da lista: N -> Nome /I -> Idade / R -> Raça");
                            String ordem = sc.nextLine();
                            ic.printRebeldes(ordem);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                    }
                    else if (tecla.toUpperCase().equals("S")) {
                        break;
                    }
                }
            }

            System.out.println("Insira seu nome: ");
            String nome = sc.nextLine().trim();
            System.out.println("Insira sua idade: ");
            short idade = sc.nextShort();
            System.out.println("Insira sua raça:[1-Humano;2-Gree;3-Rakata]");
            short raca = sc.nextShort();

            Raca racaIndividuo = Raca.values()[raca - 1];
            Individuo rebelde = Individuo.builder()
                .nome(nome)
                .idade(idade)
                .raca(racaIndividuo)
                .build();
            /*
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();
            Set<ConstraintViolation<Individuo>> constraintViolations = validator.validate(rebelde);
            */
            System.out.println("Aguarde, estamos a verificar sua filiação!");
            TimeUnit.MILLISECONDS.sleep(2000);
            if (ic.addRebelde(rebelde)) {
                System.out.println("Sua filiação foi aceita!");
            }
            else {
                System.out.println("Rejeitamos sua filiação!");
            }

            aceitaRebeldes = ic.aceitaNovosRebeldes();
        }
        while (aceitaRebeldes);

        System.out.println("Ok! Nao aceitamos mais rebeldes!");
    }
}
