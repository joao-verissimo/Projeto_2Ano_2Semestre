package eapli.base.BoardManagement.domain;

import domain.model.SystemUserAuth;
import eapli.framework.domain.model.AggregateRoot;
import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jorge Lima
 */
@Entity
public class SharedBoard implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBoard;
    private NumRows numRows;
    private NumColumns numColumns;

    private boolean archived;

    @OneToOne
    private SystemUserAuth admin;

    @ElementCollection
    @MapKeyColumn(name = "systemuser")
    @Column(name = "state")
    private Map<SystemUserAuth,State> map;

    public SharedBoard(NumRows numRows, NumColumns numColumns, SystemUserAuth admin) {
        this.numRows = numRows;
        this.numColumns = numColumns;
        this.admin = admin;
        archived = false;
        this.map = new HashMap<>();
    }

    protected SharedBoard() {
        // for ORM only
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public int compareTo(Long other) {
        return AggregateRoot.super.compareTo(other);
    }

    @Override
    public Long identity() { return null; }

    public Long getIdBoard() {
        return idBoard;
    }

    public void archive(){
        if (archived) {
            throw new IllegalStateException("Cannot archive a board that is already acrhived");
        }
        archived = true;
    }

    public Map<SystemUserAuth, State> getMap() {
        return map;
    }

    public void appendUser(SystemUserAuth user, State state) {
        this.map.put(user,state);
    }

    public NumRows numRows() {
        return numRows;
    }

    public NumColumns numColumns() {
        return numColumns;
    }

    public SystemUserAuth admin() {
        return admin;
    }
}
