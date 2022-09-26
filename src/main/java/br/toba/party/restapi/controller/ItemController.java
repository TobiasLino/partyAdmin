package br.toba.party.restapi.controller;

import br.toba.party.domain.item.ItemService;
import br.toba.party.restapi.wrapper.ItemWrapper;
import br.toba.party.restapi.wrapper.MoneyWrapper;
import com.pineapple.commons.serialization.wrapper.ListWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item/")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService service;

    @GetMapping("{id}")
    public ItemWrapper findById(@PathVariable("id") final Long id) throws Exception {
        return new ItemWrapper(service.findById(id));
    }

    @GetMapping
    public ListWrapper<ItemWrapper> findAll() throws Exception {
        return new ListWrapper<>(service.findAll(), ItemWrapper::new);
    }

    @PutMapping("{id}/edit-unit-price")
    public ItemWrapper editUnitPrice(@PathVariable("id") Long itemId, @RequestBody MoneyWrapper price) throws Exception {
        return new ItemWrapper(service.editUnitPrice(itemId, price.getValue()));
    }

    @PostMapping("add/")
    public ItemWrapper addItem(@RequestBody ItemWrapper itemWrapper) throws Exception {
        return new ItemWrapper(service.addItem(itemWrapper.getItem()));
    }
}
