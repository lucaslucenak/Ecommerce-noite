package com.almeida.Ecommercenoite.models;


import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "tb_vendas")
public class VendaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "idVendedor")
    private Long idVendedor;

    @Column(name = "idCliente")
    private Long idCliente;

    @Column(name = "idProduto")
    private Long idProduto;

    @Column(name = "foiEnviado")
    private Boolean foiEnviado;
}