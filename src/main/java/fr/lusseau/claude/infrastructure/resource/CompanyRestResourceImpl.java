package fr.lusseau.claude.infrastructure.resource;

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
    public CompanyRestResourceImpl(FactoryService factoryService) {
        this.factoryService = factoryService;
    }

    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Company> getAll() {
        List<Company> companies = this.factoryService.getUseCaseFactory().getCrudCompanyUseCase().getAll();
        if (companies.isEmpty()) {
            throw new ResourceException(emptyCompanyList);
        }
        return companies;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Company getOne(@PathParam("id") Long id) {
        Company company = this.factoryService.getUseCaseFactory().getCrudCompanyUseCase().getOne(id);
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
        Company newCompany = Company.builder().withName(company.getName()).withPlace(company.getPlace()).withType(company.getType()).build();
        boolean isNameExist = this.factoryService.getUseCaseFactory().getCheckUseCase().checkIfCompanyNameExist(newCompany.getName());
        try {
            CompanyValidator.validateCompany(newCompany);
        } catch (RuntimeException e) {
            throw new ResourceException(invalidCompany);
        }
        if (isNameExist) {
            throw new ResourceException(nameExist);
        }
        company = this.factoryService.getUseCaseFactory().getCrudCompanyUseCase().create(newCompany);
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
        if (this.factoryService.getUseCaseFactory().getCrudCompanyUseCase().getOne(company.getId()) == null) {
            throw new ResourceException(companyNotFound);
        }
        if (factoryService.getUseCaseFactory().getCheckUseCase().checkIfCompanyNameExist(company.getName())) {
            throw new ResourceException(nameExist);
        }
        try {
            this.factoryService.getUseCaseFactory().getCrudCompanyUseCase().update(company);
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
        Company company = factoryService.getUseCaseFactory().getCrudCompanyUseCase().getOne(id);
        if (company == null) {
            throw new ResourceException(companyNotFound);
        }
        this.factoryService.getUseCaseFactory().getCrudCompanyUseCase().remove(company);
        return Response.ok().status(Response.Status.ACCEPTED).build();
    }
}