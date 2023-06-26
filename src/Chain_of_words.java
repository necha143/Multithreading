import java.io.*;
import java.util.*;

/*
Составить цепочку слов
Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн
Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/

public class Chain_of_words {
    public static void main(String[] args) throws Exception {
        //...

        BufferedReader readerConsol = new BufferedReader(new InputStreamReader(System.in));
        String fileName = readerConsol.readLine();
        readerConsol.close();

        BufferedReader readerFile = new BufferedReader(new FileReader(fileName));
        ArrayList<String> wordsList = new ArrayList<>();
        while (readerFile.ready()) {
            wordsList.addAll(Arrays.asList(readerFile.readLine().split(" ")));
        }
        readerFile.close();
        String[] words = wordsList.toArray(new String[wordsList.size()]);

        StringBuilder result = getLine(words);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        if (words == null || words.length == 0) return new StringBuilder();//проверки
        if (words.length == 1 || words[0].equals("")) return new StringBuilder(words[0]);

        StringBuilder result = new StringBuilder();
        ArrayList<String> wordsList = new ArrayList<>();

        wordsList.addAll(Arrays.asList(words));//из массива в коллекцию
        while (wordsList.remove("")) { //удаляем пустые строки
            wordsList.remove("");
        }

        while (isYes(wordsList)) { //самое главное в реализации задачи
            Collections.shuffle(wordsList); //перемешиваем слова случайно в цикле, пока не найдется нужная цепочка слов
//            System.out.println(wordsList);
        }

        for (String word : wordsList) { //в списке теперь лежит нужная цепочка
            result.append(word + " ");
        }
        result.deleteCharAt(result.length() - 1);//удалили последний пробел
        return result;
    }

    public static boolean isYes(ArrayList<String> wordsList) {//метод тупо проверяет цепочку на хотя первое попавшееся несовпадение
        //когда не совпали буквы он возвращает true, чтобы вызвавший его цикл сработал еще раз и перемешал содержимое списка!
        for (int i = 0; i < wordsList.size() - 1; i++) {
            String firstWord = wordsList.get(i).toLowerCase();
            String secondWord = wordsList.get(i + 1).toLowerCase();
            if (firstWord.charAt(firstWord.length() - 1) != secondWord.charAt(0)) return true;
        }
        return false; //тут вся цепочка получилась!
    }
}
