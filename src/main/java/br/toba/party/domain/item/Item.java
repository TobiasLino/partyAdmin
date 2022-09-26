package br.toba.party.domain.item;

import br.toba.party.domain.itemresponsible.ItemResponsible;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "item")
@SequenceGenerator(name = "item_sq", sequenceName = "item_sq", allocationSize = 1)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Item {

    @Id
    @GeneratedValue(generator = "item_sq", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "category")
    private String category;

    @Column(name = "unit_val")
    private BigDecimal unitValue;

    @Column(name = "quant")
    private Long quantity;

    @Column(name = "quant_type")
    private String quantityType;

}
