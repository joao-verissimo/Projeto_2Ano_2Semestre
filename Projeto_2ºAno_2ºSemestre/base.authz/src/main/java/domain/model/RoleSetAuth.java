package domain.model;

import java.io.Serializable;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import eapli.framework.util.HashCoder;
import eapli.framework.validations.Preconditions;

/**
 * A set of roles. Part of the {@link SystemUserAuth} aggregate.
 *
 * @author Paulo Gandra Sousa
 */
@Entity
        /* package */ class RoleSetAuth implements Set<RoleAssignmentAuth>, Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue // (strategy = GenerationType.IDENTITY)
    private Long pk;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private final Set<RoleAssignmentAuth> assignments = new HashSet<>();

    @Override
    public boolean add(final RoleAssignmentAuth arg0) {
        Preconditions.nonNull(arg0);

        // TODO validations are missing, e.g., no overlap in roles with the same
        // role type
        return assignments.add(arg0);
    }

    /**
     * Checks if a user currently has an assignment of a certain role.
     *
     * @param r
     * @return true if a user currently has an assignment of a certain role
     */
    public boolean hasAssignment(final Role r) {
        for (final RoleAssignmentAuth assignment : assignments) {
            if (!assignment.isExpired() && assignment.isOf(r)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the user has or had in the past an assignment to a certain
     * role.
     *
     * @param r
     * @return true if the user has or had in the past an assignment to a
     *         certain role
     */
    public boolean hasOrHadAssignment(final Role r) {
        for (final RoleAssignmentAuth assignment : assignments) {
            if (assignment.isOf(r)) {
                return true;
            }
        }
        return false;
    }

    public Collection<Role> roleTypes() {
        final List<Role> ret = new ArrayList<>();
        assignments.forEach(role -> ret.add(role.type()));
        return ret;
    }

    /**
     * Returns the first non-expired assignment to a role or an empty optional
     * if no assignment to that role exists.
     *
     * <p>
     * The implementation uses the java Stream API, but is conceptually
     * equivalent to the following more traditional java code:
     *
     * <pre>
     * <code>
     * for (final RoleAssignment assignment : data) {
     *     if (assignment.isOf(role)) {
     *         return Optional.of(assignment);
     *     }
     * }
     * return Optional.empty();
     * </code>
     * </pre>
     *
     * @param role
     * @return the first non-expired assignment to a role or an empty optional
     */
    public Optional<RoleAssignmentAuth> getAssignment(final Role role) {
        return assignments.stream().filter(e -> !e.isExpired() && e.isOf(role)).findFirst();
    }

    @Override
    public boolean addAll(final Collection<? extends RoleAssignmentAuth> arg0) {
        return assignments.addAll(arg0);
    }

    @Override
    public void clear() {
        assignments.clear();
    }

    @Override
    public boolean contains(final Object arg0) {
        return assignments.contains(arg0);
    }

    @Override
    public boolean containsAll(final Collection<?> arg0) {

        return assignments.containsAll(arg0);
    }

    @Override
    public boolean isEmpty() {
        return assignments.isEmpty();
    }

    @Override
    public Iterator<RoleAssignmentAuth> iterator() {
        return assignments.iterator();
    }

    @Override
    public boolean remove(final Object arg0) {
        return assignments.remove(arg0);
    }

    @Override
    public boolean removeAll(final Collection<?> arg0) {
        return assignments.removeAll(arg0);
    }

    @Override
    public boolean retainAll(final Collection<?> arg0) {
        return assignments.retainAll(arg0);
    }

    @Override
    public int size() {
        return assignments.size();
    }

    @Override
    public Object[] toArray() {
        return assignments.toArray();
    }

    @Override
    public <T> T[] toArray(final T[] arg0) {
        return assignments.toArray(arg0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleSetAuth that = (RoleSetAuth) o;
        return Objects.equals(pk, that.pk) && Objects.equals(assignments, that.assignments);
    }

    @Override
    public int hashCode() {
        return new HashCoder().with(assignments).code();
    }
}
