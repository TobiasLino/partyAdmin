package br.toba.party.restapi.wrapper;

import br.toba.party.domain.item.Item;
import br.toba.party.restapi.deserialization.ItemDeserializer;
import br.toba.party.restapi.serialization.ItemSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonSerialize(using = ItemSerializer.class)
@JsonDeserialize(using = ItemDeserializer.class)
@AllArgsConstructor
public class ItemWrapper {

    private Item item;
}
