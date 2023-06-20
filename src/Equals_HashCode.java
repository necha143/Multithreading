import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/*
Equals and HashCode
*/

public class Equals_HashCode {
    private final String first, last;

    public Equals_HashCode(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Equals_HashCode)) {
            return false;
        }

        Equals_HashCode n = (Equals_HashCode) o;

        if (!Objects.equals(first, n.first)) return false;
        return Objects.equals(last, n.last);
    }

    @Override
    public int hashCode() {
        int result = first != null ? first.hashCode() : 0;
        result = 31 * result + (last != null ? last.hashCode() : 0);
        return result;
    }

    public static void main(String[] args) {
        Set<Equals_HashCode> s = new HashSet<>();
        s.add(new Equals_HashCode("Donald", "Duck"));
        System.out.println(s.contains(new Equals_HashCode("Donald", "Duck")));
    }
}
