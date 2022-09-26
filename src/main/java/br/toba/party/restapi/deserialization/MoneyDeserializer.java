package br.toba.party.restapi.deserialization;

import br.toba.party.restapi.wrapper.MoneyWrapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.pineapple.commons.serialization.deserialize.AbstractJsonDeserializer;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;

import static br.toba.party.restapi.serialization.SerializationLabels.VALUE;

@Service
public class MoneyDeserializer extends AbstractJsonDeserializer<MoneyWrapper> {


    @Override
    public MoneyWrapper deserialize(JsonNode jsonNode) throws IOException {
        return new MoneyWrapper(new BigDecimal(getStringFieldValue(jsonNode, VALUE)));
    }
}
