package com.letscode.rebeldes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class Individuo {

    String nome;

    short idade;

    Raca raca;
}
