package br.comvarejonline.projetoinicial.model;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;
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
@Entity(name = "tb_movimentacoesestoque")
public class MovimentacoesEstoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMovimentacoesEstoque;

    @Column(name = "quantidade")
    private int quantidade;

    @Column(name = "data")
    @JsonFormat(pattern = "dd/MM/yyy")
    private LocalDate data;

    @Column(name = "motivo", length = 45)
    private String motivo;

    @OneToOne // Criação da chave estrangeira
    @JoinColumn(name = "idTipoMovimento")
    private TipoDeMovimento tipoDeMovimento;

    @OneToOne // Criação da chave estrangeira
    @JoinColumn(name = "idTipoDocumento")
    private TipoDocumento tipoDocumento;

    @OneToOne // Criação da chave estrangeira
    @JoinColumn(name = "idProduto")
    private Produto produto;

    @OneToOne // Criação da chave estrangeira
    @JoinColumn(name = "idTipoUsuario")
    private TipoUsuario tipoUsuario;

}
