package br.toba.party.domain.responsible;


public interface ResponsibleService {

    Responsible findItemsByResponsibleName(final String name) throws Exception;

    Responsible findById(final Long id) throws Exception;
}
