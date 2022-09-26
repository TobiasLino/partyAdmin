package br.toba.party.restapi.wrapper;

import br.toba.party.domain.responsible.Responsible;
import br.toba.party.restapi.serialization.ResponsibleSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@JsonSerialize(using = ResponsibleSerializer.class)
@Getter
@Setter
@AllArgsConstructor
public class ResponsibleWrapper {

    private Responsible responsible;
}
