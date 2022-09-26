package br.toba.party.restapi.controller;

import br.toba.party.domain.responsible.ResponsibleService;
import br.toba.party.restapi.wrapper.ResponsibleWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/responsible/")
@RequiredArgsConstructor
public class ResponsibleController {

    private final ResponsibleService service;

    @GetMapping("{id}")
    public ResponsibleWrapper findById(@PathVariable("id") final Long id) throws Exception {
        return new ResponsibleWrapper(service.findById(id));
    }

    @GetMapping("get-name/{name}")
    public ResponsibleWrapper findByName(@PathVariable("name") final String name) throws Exception {
        return new ResponsibleWrapper(service.findItemsByResponsibleName(name));
    }
}
