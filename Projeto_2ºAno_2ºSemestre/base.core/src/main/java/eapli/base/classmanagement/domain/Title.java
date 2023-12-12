package eapli.base.classmanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;

/**
 * The type Title.
 */
@Embeddable
public class Title implements ValueObject {
    private String title;

    /**
     * Instantiates a new Title.
     *
     * @param title the title
     */
    public Title(String title) {
        Preconditions.nonEmpty(title,"Title can't be empyt or null");
        this.title = title;
    }

    /**
     * Instantiates a new Title.
     */
    protected Title(){
    }

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }


    /**
     * Value of title.
     *
     * @param title the title
     * @return the title
     */
    public static Title valueOf(final String title) {
        return new Title(title);
    }
}
