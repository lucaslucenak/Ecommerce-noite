package com.almeida.Ecommercenoite.models;


import lombok.*;

import javax.persistence.*;
import java.util.Locale;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "tb_categorias")
public class CategoriaModel {

    public CategoriaModel(String nome) {
        this.nome = nome.toUpperCase(Locale.ROOT);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome")
    private String nome;
}
