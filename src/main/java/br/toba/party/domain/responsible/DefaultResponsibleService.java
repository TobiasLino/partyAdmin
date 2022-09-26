package br.toba.party.domain.responsible;

import br.toba.party.infra.exception.ItemNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class DefaultResponsibleService implements ResponsibleService {

    private final ResponsibleRepository repository;

    @Override
    public Responsible findItemsByResponsibleName(String name) throws Exception {
        return repository.findByName(name);
    }

    @Override
    public Responsible findById(Long id) throws Exception {
        return repository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(String.format("Responsible %d not found", id)));
    }
}
