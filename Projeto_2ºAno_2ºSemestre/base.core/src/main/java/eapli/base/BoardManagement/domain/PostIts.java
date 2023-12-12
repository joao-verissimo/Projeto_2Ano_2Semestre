package eapli.base.BoardManagement.domain;

import domain.model.SystemUserAuth;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.time.util.CurrentTimeCalendars;

import javax.persistence.*;
import java.util.Calendar;

/**
 * @author Jorge Lima
 */

@Entity
public class PostIts implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPostIts;
    private double version;

    private PostItState postitstate;
    @Temporal(TemporalType.DATE)
    private Calendar date;

    private String data;
    private NumRows numRows;
    private NumColumns numColumns;

    public SystemUserAuth author() {
        return author;
    }

    @OneToOne
    private SystemUserAuth author;
    @ManyToOne
    private SharedBoard sharedBoard;

    protected PostIts() {
        // for ORM only
    }



    public PostIts(double version, NumRows numRows, NumColumns numColumns, SystemUserAuth author, String data, SharedBoard sharedBoard) {
        this.version = version;
        this.date = CurrentTimeCalendars.now();
        this.postitstate = PostItState.ACTIVE;
        this.author = author;
        this.data = data;
        this.numRows = numRows;
        this.numColumns = numColumns;
        this.sharedBoard = sharedBoard;
    }


    public Long idPostIts() {
        return idPostIts;
    }
    public double version() {
        return version;
    }

    public void changeVersion(double version) {
        this.version = version;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Long identity() {
        return null;
    }

    @Override
    public String toString() {
        return "PostIts{" +
                "idPostIts=" + idPostIts +
                ", version=" + version +
                ", postitstate=" + postitstate +
                ", date=" + date +
                ", data='" + data + '\'' +
                ", numRows=" + numRows +
                ", numColumns=" + numColumns +
                ", author=" + author +
                ", sharedBoard=" + sharedBoard +
                '}';
    }

    /*public String row_column() {
        return row_column;
    }

     */

    public NumRows numRows() {
        return numRows;
    }

    public NumColumns numColumns() {
        return numColumns;
    }

    public SharedBoard sharedBoard() {
        return sharedBoard;
    }

    public Calendar date() {
        return date;
    }

    public String data() {
        return data;
    }
}