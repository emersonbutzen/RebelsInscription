package com.letscode.rebeldes;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Individuo {

    @NotNull(message = "Apesar de ser rebelde, tens que ter um nome!")
    private String nome;

    private short idade;

    private Raca raca;
}
