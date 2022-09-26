package br.toba.party.domain.item;

import br.toba.party.infra.exception.ItemAlreadyExistException;
import br.toba.party.infra.exception.ItemNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DefaultItemService implements ItemService {

    private final ItemRepository repository;

    @Override
    public Item findById(Long id) throws Exception {
        return repository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(String.format("Item %d not found", id)));
    }

    @Override
    public List<Item> findAll() throws Exception {
        return repository.findAll();
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public Item editUnitPrice(Long itemId, BigDecimal newPrice) throws Exception {
        Item item = findById(itemId);
        item.setUnitValue(newPrice);
        return repository.save(item);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public Item addItem(Item item) throws Exception {
        final Optional<Item> existentItem = repository.findByName(item.getName());
        if (existentItem.isPresent()) {
            throw new ItemAlreadyExistException(String.format("Item %s already exists", item.getName()));
        }
        // TODO: adicionar domain event de colocar como responsabilidade minha
        return repository.save(item);
    }
}
