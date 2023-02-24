package br.comvarejonline.projetoinicial.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_tipodemovimento")
public class TipoDeMovimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipoMovimento;

    @Column(name = "nome", nullable = false, unique = true, length = 45)
    private String nome;

}
