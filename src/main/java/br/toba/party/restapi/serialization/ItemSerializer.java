package br.toba.party.restapi.serialization;

import br.toba.party.domain.item.Item;
import br.toba.party.restapi.wrapper.ItemWrapper;
import com.pineapple.commons.serialization.JsonBuilder;
import com.pineapple.commons.serialization.serialize.AbstractJsonSerializer;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;

import static br.toba.party.restapi.serialization.SerializationLabels.*;

@Service
public class ItemSerializer extends AbstractJsonSerializer<ItemWrapper> {


    @Override
    public void serialize(ItemWrapper itemWrapper, Enum<?> anEnum, JsonBuilder jsonBuilder) throws IOException {
        final Item item = itemWrapper.getItem();
        jsonBuilder.writeStartObject()
                .writeNumberField(ID, item.getId())
                .writeStringField(NAME, item.getName())
                .writeStringField(CATEGORY, item.getCategory())
                .writeNumberField(UNIT_VALUE, item.getUnitValue())
                .writeNumberField(QUANTITY, item.getQuantity())
                .writeStringField(QUANTITY_TYPE, item.getQuantityType())
                .writeNumberField(TOTAL, (item.getUnitValue().multiply(new BigDecimal(item.getQuantity()))))
                .writeEndObject();

    }
}
