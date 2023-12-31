/*
 * Copyright (c) 2013-2023 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package eapli.base.coursemanagement.domain.application;

import java.util.Optional;

import application.AuthorizationService;
import domain.model.SystemUserAuth;
import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BaseRoles;
import application.AuthzRegistry;
import application.UserSession;

/**
 *
 * @author Paulo Gandra de Sousa
 */
public class MyClientUserService {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ClientUserRepository repo = PersistenceContext.repositories().clientUsers();

    public ClientUser me() {
        final UserSession s = authz.session().orElseThrow(IllegalStateException::new);
        final SystemUserAuth myUser = s.authenticatedUser();
        // TODO cache the client user object
        final Optional<ClientUser> me = repo.findByEmail(myUser.identity());
        return me.orElseThrow(IllegalStateException::new);
    }

    public ClientUser myUser() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CLIENT_USER);
        final UserSession s = authz.session().orElseThrow(IllegalStateException::new);
        final SystemUserAuth me = s.authenticatedUser();
        return repo.findByEmail(me.identity()).orElseThrow(IllegalStateException::new);
    }

}
