package br.toba.party.domain.itemresponsible;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ItemResponsibleKey implements Serializable {

    @Column(name = "id_item")
    private Long itemId;

    @Column(name = "id_responsible")
    private Long responsibleId;
}
