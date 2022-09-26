package br.toba.party.domain.item;

import br.toba.party.domain.itemresponsible.ItemResponsible;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
public class Item {

    @Id
    @GeneratedValue(generator = "item_sq", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "category")
    private String category;

    @Column(name = "unit_vql")
    private BigDecimal unitValue;

    @Column(name = "quant")
    private Integer quantity;

    @Column(name = "quant_type")
    private String quantityType;

    @OneToMany(mappedBy = "item")
    private Set<ItemResponsible> responsibles;

}
