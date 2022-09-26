package br.toba.party.domain.item;

import java.math.BigDecimal;
import java.util.List;

public interface ItemService {

    Item findById(final Long id) throws Exception;
    List<Item> findAll() throws Exception;

    Item editUnitPrice(final Long itemId, final BigDecimal newPrice) throws Exception;

    Item addItem(final Item item) throws Exception;
}
