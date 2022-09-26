package br.toba.party.restapi.serialization;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SerializationLabels {
    ID("id"),
    NAME("name"),
    CATEGORY("category"),
    UNIT_VALUE("unit_value"),
    QUANTITY("quantity"),
    QUANTITY_TYPE("quantity_type"),
    RESPONSIBLES("responsible"),
    TOTAL("total"),
    VALUE("value"),
    ITEMS("items"),
    ITEM("item");

    private final String value;


    @Override
    public String toString() {
        return this.value;
    }
}
