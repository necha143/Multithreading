import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
Обращенные слова
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/

public class Converted_words {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader filereader = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();

        Set<String> unverified = new HashSet<>();

        while (filereader.ready()){
            String[] data = filereader.readLine().split(" ");
            for (String word : data) {
                StringBuilder stringBuilder = new StringBuilder(word);
                stringBuilder.reverse();
                String reversedWord = stringBuilder.toString();
                if (unverified.contains(reversedWord)) {
                    unverified.remove(reversedWord);
                    Pair pair = new Pair();
                    pair.first = word;
                    pair.second = reversedWord;
                    result.add(pair);
                } else {
                    unverified.add(word);
                }
            }
        }

    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
