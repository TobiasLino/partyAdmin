package br.toba.party.restapi.wrapper;

import br.toba.party.restapi.deserialization.MoneyDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@JsonDeserialize(using = MoneyDeserializer.class)
@Getter
@AllArgsConstructor
public class MoneyWrapper {

    private BigDecimal value;
}
