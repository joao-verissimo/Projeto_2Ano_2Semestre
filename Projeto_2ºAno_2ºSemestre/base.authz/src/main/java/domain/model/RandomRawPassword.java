package domain.model;

import eapli.framework.strings.RandomString;
import eapli.framework.strings.util.Strings;

public final class RandomRawPassword {
    private static final int DEFAULT_LENGTH = 12;
    private static final String LOWER_CHARS = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER_CHARS = "abcdefghijklmnopqrstuvwxyz".toUpperCase();
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL = "_-+*/@=><#?!.%():;[]|{}&$€";
    public static final String ALLOWED_CHARS;
    private final String rawPassword;

    public RandomRawPassword() {
        this(12);
    }

    public RandomRawPassword(final int length) {
        if (length < 3) {
            throw new IllegalArgumentException("Lenght must be at least 4");
        } else {
            String part1 = RandomString.of(length - 3, "abcdefghijklmnopqrstuvwxyz").toString();
            String part2 = RandomString.of(1, UPPER_CHARS).toString();
            String part3 = RandomString.of(1, "0123456789").toString();
            String part4 = RandomString.of(1, "_-+*/@=><#?!.%():;[]|{}&$€").toString();
            this.rawPassword = Strings.shuffle(part1 + part2 + part3 + part4);
        }
    }

    public String toString() {
        return this.rawPassword;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof RandomRawPassword)) {
            return false;
        } else {
            RandomRawPassword other = (RandomRawPassword)o;
            Object this$rawPassword = this.rawPassword;
            Object other$rawPassword = other.rawPassword;
            if (this$rawPassword == null) {
                if (other$rawPassword != null) {
                    return false;
                }
            } else if (!this$rawPassword.equals(other$rawPassword)) {
                return false;
            }

            return true;
        }
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $rawPassword = this.rawPassword;
        result = result * 59 + ($rawPassword == null ? 43 : $rawPassword.hashCode());
        return result;
    }

    static {
        ALLOWED_CHARS = "abcdefghijklmnopqrstuvwxyz" + UPPER_CHARS + "0123456789_-+*/@=><#?!.%():;[]|{}&$€";
    }
}

