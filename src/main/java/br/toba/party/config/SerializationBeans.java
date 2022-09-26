package br.toba.party.config;

import br.toba.party.domain.itemresponsible.ItemResponsible;
import br.toba.party.restapi.deserialization.ItemDeserializer;
import br.toba.party.restapi.deserialization.MoneyDeserializer;
import br.toba.party.restapi.serialization.ItemResponsibleSerializer;
import br.toba.party.restapi.serialization.ResponsibleSerializer;
import br.toba.party.restapi.serialization.ItemSerializer;
import br.toba.party.restapi.wrapper.ItemWrapper;
import br.toba.party.restapi.wrapper.MoneyWrapper;
import br.toba.party.restapi.wrapper.ResponsibleWrapper;
import com.pineapple.commons.serialization.deserialize.AbstractJsonDeserializer;
import com.pineapple.commons.serialization.serialize.AbstractJsonSerializer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class SerializationBeans {

    @Bean
    public Map<Class<?>, AbstractJsonSerializer<?>> serializerMap(
            @Qualifier("itemSerializer") ItemSerializer itemSerializer,
            @Qualifier("responsibleSerializer") ResponsibleSerializer responsibleSerializer,
            @Qualifier("itemResponsibleSerializer") ItemResponsibleSerializer itemResponsibleSerializer) {
        return new HashMap<>() {{
            put(ItemWrapper.class, itemSerializer);
            put(ResponsibleWrapper.class, responsibleSerializer);
            put(ItemResponsible.class, itemResponsibleSerializer);
        }};
    }

    @Bean
    public Map<Class<?>, AbstractJsonDeserializer<?>> deserializerMap(
            @Qualifier("moneyDeserializer") MoneyDeserializer moneyDeserializer,
            @Qualifier("itemDeserializer") ItemDeserializer itemDeserializer) {
        return new HashMap<>() {{
            put(MoneyWrapper.class, moneyDeserializer);
            put(ItemWrapper.class, itemDeserializer);
        }};
    }
}
