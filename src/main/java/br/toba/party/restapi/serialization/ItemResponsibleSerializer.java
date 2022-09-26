package br.toba.party.restapi.serialization;

import br.toba.party.domain.itemresponsible.ItemResponsible;
import com.pineapple.commons.serialization.JsonBuilder;
import com.pineapple.commons.serialization.serialize.AbstractJsonSerializer;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;

import static br.toba.party.restapi.serialization.SerializationLabels.*;

@Service
public class ItemResponsibleSerializer extends AbstractJsonSerializer<ItemResponsible> {


    @Override
    public void serialize(ItemResponsible itemResponsible, Enum<?> anEnum, JsonBuilder jsonBuilder) throws IOException {
        jsonBuilder.writeStartObject()
                .writeStringField(ITEM, itemResponsible.getItem().getName())
                .writeNumberField(QUANTITY, new BigDecimal(itemResponsible.getQuantity()))
                .writeNumberField(UNIT_VALUE, itemResponsible.getItem().getUnitValue())
                .writeNumberField(TOTAL,
                        new BigDecimal(itemResponsible
                                .getQuantity())
                                .multiply(itemResponsible
                                        .getItem()
                                        .getUnitValue()))
                .writeEndObject();
    }
}
