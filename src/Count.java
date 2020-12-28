import java.util.Map;
import java.util.TreeMap;

public class Count {
    public static final char SPACE = ' ';
    public static final char TAB = '\t';
    public static final char BREAK_LINE = '\n';

    public static void main(String[] args) {
        String str = "Tôi năm nay 25 tuôi , tôi sinh ra và lớn lên tại Nghệ A quê hương Bác Hồ ."+
                "        \n Năm này tôi dự kiến sẽ đổi sang một công việc mới để có thể thay đổi cuộc sống hiện tại ."+
                "\nMong răng đây là một sự lựa chọn sáng suốt .";
        System.out.println(str);
        System.out.println("Liệt kê số lần xuất hiện của các từ : ");
        Map<String, Integer> wordMap = countWords(str);
        for (String key: wordMap.keySet()){
            System.out.println(key+" "+wordMap.get(key));
        }
    }

    public static Map<String, Integer> countWords(String input){
        Map<String,Integer> wordMap = new TreeMap<String,Integer>();
        if(input == null){
            return wordMap;
        }
        int size = input.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if(input.charAt(i) != SPACE && input.charAt(i) != TAB
            && input.charAt(i) != BREAK_LINE){
                sb.append(input.charAt(i));
            }else {
                addWord( wordMap,sb);
                sb = new StringBuilder();
            }
        }
        addWord(wordMap,sb);
        return wordMap;
    }

    public static void addWord(Map<String,Integer> wordMap,StringBuilder sb){
        String word = sb.toString();
        if (word.length() == 0){
            return;
        }
        if(wordMap.containsKey(word)){
            int count = wordMap.get(word)+1;
            wordMap.put(word,count);
        }else {
            wordMap.put(word,1);
        }
    }
}
