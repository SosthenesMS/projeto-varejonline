package br.comvarejonline.projetoinicial.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProduto;

    @Column(name = "codigoDeBarras", nullable = false, unique = true, length = 45)
    private String codigoDeBarras;

    @Column(name = "nome", nullable = false, length = 45)
    private String nome;

    @Column(name = "quantidadeMinima")
    private int quantidadeMinima;

    @Column(name = "saldoInicial")
    private int saldoInicial;

    @OneToOne // Criação da chave estrangeira
    @JoinColumn(name = "idTipoUsuario")
    private TipoUsuario tipoUsuario;

}
