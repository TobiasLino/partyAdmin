package br.toba.party.domain.responsible;

import br.toba.party.domain.itemresponsible.ItemResponsible;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "responsible")
@SequenceGenerator(name = "responsible_sq", sequenceName = "responsible_sq", allocationSize = 1)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Responsible {

    @Id
    @GeneratedValue(generator = "responsible_sq", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "responsible")
    Set<ItemResponsible> items;
}
