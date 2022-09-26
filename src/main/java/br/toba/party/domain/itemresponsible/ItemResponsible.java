package br.toba.party.domain.itemresponsible;

import br.toba.party.domain.item.Item;
import br.toba.party.domain.responsible.Responsible;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "item_responsible")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemResponsible {

    @EmbeddedId
    private ItemResponsibleKey id;

    @ManyToOne
    @MapsId("itemId")
    @JoinColumn(name = "id_item")
    private Item item;

    @ManyToOne
    @MapsId("responsibleId")
    @JoinColumn(name = "id_responsible")
    private Responsible responsible;

    @Column(name = "quant")
    private Integer quantity;

}
