package br.toba.party.restapi.deserialization;

import br.toba.party.domain.item.Item;
import br.toba.party.restapi.wrapper.ItemWrapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.pineapple.commons.serialization.deserialize.AbstractJsonDeserializer;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;

import static br.toba.party.restapi.serialization.SerializationLabels.*;

@Service
public class ItemDeserializer extends AbstractJsonDeserializer<ItemWrapper> {

    @Override
    public ItemWrapper deserialize(JsonNode jsonNode) throws IOException {
        Item item = Item.builder()
                .name(getStringFieldValue(jsonNode, NAME))
                .category(getStringFieldValue(jsonNode, CATEGORY))
                .unitValue(new BigDecimal(getStringFieldValue(jsonNode, UNIT_VALUE)))
                .quantity(getLongFieldValue(jsonNode, QUANTITY))
                .quantityType(getStringFieldValue(jsonNode, QUANTITY_TYPE))
                .build();
        return new ItemWrapper(item);
    }
}
