package fr.lusseau.claude.infrastructure.resource;

import fr.lusseau.claude.application.factory.IAbstractCrudUseCaseFactory;
import fr.lusseau.claude.domain.model.Company;
import fr.lusseau.claude.domain.validator.CompanyValidator;
import fr.lusseau.claude.infrastructure.factory.FactoryService;
import fr.lusseau.claude.infrastructure.resource.exception.ResourceException;
import fr.lusseau.claude.infrastructure.utils.annotation.LogAudited;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.infrastructure.controller
 * @date 13/08/2022
 */
@LogAudited
@Named
@Path("/companies")
public class CompanyRestResourceImpl {

    private final IAbstractCrudUseCaseFactory<Company> crudUseCaseFactory;

    private final FactoryService factoryService;

    @ConfigProperty(name = "company.response.error.msg.companyNotFound")
    String companyNotFound;

    @ConfigProperty(name = "company.response.error.msg.invalidCompany")
    String invalidCompany;

    @ConfigProperty(name = "company.response.error.msg.nameExist")
    String nameExist;

    @ConfigProperty(name = "company.response.error.msg.emptyCompanyList")
    String emptyCompanyList;


    @Inject
    public CompanyRestResourceImpl(FactoryService factoryService, IAbstractCrudUseCaseFactory<Company> crudUseCaseFactory) {
        this.crudUseCaseFactory = crudUseCaseFactory;
        this.factoryService = factoryService;
    }

    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Company> getAll() {
        List<Company> companies = crudUseCaseFactory.getAll();
        if (companies.isEmpty()) {
            throw new ResourceException(emptyCompanyList);
        }
        return companies;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Company getOne(@PathParam("id") Long id) {
        Company company =crudUseCaseFactory.getOne(id);
        if (company == null) {
            throw new ResourceException(companyNotFound);
        }
        return company;
    }

    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(Company company) {
        Long id = null;
        Company newCompany = Company.builder()
                .withName(company.getName())
                .withPlace(company.getPlace())
                .withType(company.getType())
                .build();
        try {
            CompanyValidator.validateCompany(newCompany);
        } catch (RuntimeException e) {
            throw new ResourceException(invalidCompany);
        }
        if (factoryService.getUseCaseFactory().getCheckUseCase().checkIfCompanyNameExist(newCompany.getName(),id)) {
            throw new ResourceException(nameExist);
        }
        company = crudUseCaseFactory.create(newCompany);
        if (company == null) {
            return Response.notModified().status(Response.Status.NOT_IMPLEMENTED).build();
        }
        return Response.ok().status(Response.Status.CREATED).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/update")
    @Transactional
    public Response update(Company company) {
        if (crudUseCaseFactory.getOne(company.getId()) == null) {
            throw new ResourceException(companyNotFound);
        }
        if (factoryService.getUseCaseFactory().getCheckUseCase().checkIfCompanyNameExist(company.getName(), company.getId())) {
            throw new ResourceException(nameExist);
        }
        try {
            crudUseCaseFactory.update(company);
        } catch (RuntimeException e) {
            throw new ResourceException(invalidCompany);
        }
        return Response.ok().status(Response.Status.ACCEPTED).build();
    }

    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response remove(@PathParam("id") Long id) {
        Company company = crudUseCaseFactory.getOne(id);
        if (company == null) {
            throw new ResourceException(companyNotFound);
        }
        crudUseCaseFactory.remove(company);
        return Response.ok().status(Response.Status.ACCEPTED).build();
    }
}