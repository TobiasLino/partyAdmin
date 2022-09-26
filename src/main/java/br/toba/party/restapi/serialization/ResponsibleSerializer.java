package br.toba.party.restapi.serialization;

import br.toba.party.domain.itemresponsible.ItemResponsible;
import br.toba.party.domain.responsible.Responsible;
import br.toba.party.restapi.wrapper.ResponsibleWrapper;
import com.pineapple.commons.serialization.JsonBuilder;
import com.pineapple.commons.serialization.serialize.AbstractJsonSerializer;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;

import static br.toba.party.restapi.serialization.SerializationLabels.*;

@Service
public class ResponsibleSerializer extends AbstractJsonSerializer<ResponsibleWrapper> {

    @Override
    public void serialize(ResponsibleWrapper responsibleWrapper, Enum<?> anEnum, JsonBuilder jsonBuilder) throws IOException {
        final Responsible responsible = responsibleWrapper.getResponsible();
        jsonBuilder.writeStartObject()
                .writeNumberField(ID, responsible.getId())
                .writeStringField(NAME, responsible.getName())
                .writeNumberField(TOTAL, getFinalPrice(responsible));
        serializeItems(responsible, jsonBuilder);
        jsonBuilder.writeEndObject();
    }

    private void serializeItems(final Responsible responsible, JsonBuilder builder) throws IOException {
        builder.writeArrayFieldStart(ITEMS);

        final AbstractJsonSerializer<ItemResponsible> serializer = (AbstractJsonSerializer<ItemResponsible>) getSerializer(ItemResponsible.class);
        for (final ItemResponsible itemResponsible : responsible.getItems()) {
            serializer.serialize(itemResponsible, builder);
        }

        builder.writeEndArray();
    }

    private BigDecimal getFinalPrice(final Responsible responsible) {
        BigDecimal result = new BigDecimal("0");
        for (final ItemResponsible itemResponsible : responsible.getItems()) {
             result = result.add(new BigDecimal(itemResponsible.getQuantity())
                    .multiply(itemResponsible.getItem().getUnitValue()));
        }
        return result;
    }
}
