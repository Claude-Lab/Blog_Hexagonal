package fr.lusseau.claude.infrastructure.resource;

import javax.inject.Inject;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.infrastructure.controller
 * @date 18/08/2022
 */
public class UserRestControllerTest {


    private final UserRestResourceImpl userRestResource;

    @Inject
    public UserRestControllerTest(UserRestResourceImpl userRestResource) {
        this.userRestResource = userRestResource;
    }

//    @Test
//    void createUser() {
//        String email = "john.doe@lost.com";
//        String firstname = "John";
//        String lastname = "Doe";
//        String password = "what";
//        Role role = Role.SUBSCRIBER;
//        Boolean newUser = userRestController.createNewUser(email, firstname, lastname, password, role);
//        User user = User.builder()
//                .withEmail("john.doe@lost.com")
//                .withFirstname("John")
//                .withLastname("Doe")
//                .withPassword("what")
//                .withRole(Role.SUBSCRIBER).build();
//
//
//
//    }

}
