package eapli.base.BoardManagement.domain;

import domain.model.*;
import eapli.base.usermanagement.domain.BaseRoles;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

class SharedBoardTest {

    private static SystemUserAuth dummyUser(final String username, final Role... roles) {
        // should we load from spring context?
        final SystemUserBuilder userBuilder = new SystemUserBuilder(new NilPasswordPolicy(), new PlainTextEncoder());
        return userBuilder.with(username, "duMMy1", "dummy", "dummy").withRoles(roles).build();
    }
    private SystemUserAuth getNewDummyUser() {
        return dummyUser("dummy@gmail.com", BaseRoles.ADMIN);
    }

    private SharedBoard createSharedBoard() {
        NumColumns nc = new NumColumns(10);
        NumRows nr = new NumRows(10);
        return new SharedBoard(nr,nc, getNewDummyUser());
    }

    @Test
    void getters() {
        SharedBoard a = createSharedBoard();

        assertEquals(a.numColumns().numColumns(), 10);
        assertEquals(a.numRows().numRows(), 10);
        assertEquals(a.admin().email().toString(), "dummy@gmail.com");
    }
}