package eapli.base.BoardManagement.domain;

import domain.model.*;
import eapli.base.usermanagement.domain.BaseRoles;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

class PostItsTest {
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

    private PostIts createPostIt(SharedBoard a) {
        NumColumns nc = new NumColumns(2);
        NumRows nr = new NumRows(2);
        return new PostIts(1, nr,nc,getNewDummyUser(), "aaaaa", a);
    }

    @Test
    void getters() {
        SharedBoard b = createSharedBoard();
        PostIts a = createPostIt(b);

        assertEquals(a.version(), 1, 0.00001);
        assertEquals(a.numColumns().numColumns(), 2);
        assertEquals(a.numRows().numRows(), 2);
        assertEquals(a.sharedBoard(), b);
        assertEquals(a.data(), "aaaaa");
    }

    @Test
    void setters() {
        SharedBoard b = createSharedBoard();
        PostIts a = createPostIt(b);

        assertEquals(a.version(), 1, 0.00001);
        a.changeVersion(2);
        assertEquals(a.version(), 2, 0.00001);
    }

}