import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] words = {"java", "python", "java", "golang", "java", "python"};
        int k = 2;
        SigmaTechTest top = new SigmaTechTest();
        List<String> result = top.topKFrequent(words, k);
        System.out.println(result.toString());
        top.countWords("This is a test This is only a test");

        Map<String, Object> validJson1 = new HashMap<>();
        List<String> validJson1Child = new ArrayList<>();
        validJson1Child.add("name");
        validJson1Child.add("A");
        validJson1Child.add("age");
        validJson1Child.add("30");
        validJson1.put("user", validJson1Child);
        System.out.println(top.isValidJson(validJson1));

        Map<String, Object> validJson2 = new HashMap<>();
        validJson2.put("123", "wrong");
        System.out.println(top.isValidJson(validJson2));
    }
}

class SigmaTechTest {
    String[] words;
    int k;
    public SigmaTechTest() {

    }

    public List<String> topKFrequent(String[] words, int k){
        for(int i = 0; i < words.length; i++){

        }

        HashSet<String> distinctNum = new HashSet<>();
        HashMap<String, Integer> infoNum = new HashMap<>();

        //distinct num
        for(int i = 0; i < words.length; i++){
            distinctNum.add(words[i]);
        }

        //find info each num
        for(String distNum: distinctNum){
            int found = 0;
            for(int j = 0; j < words.length; j++){
                if(distNum == words[j]){
                    found = found + 1;
                }
            }
            infoNum.put(distNum, found);
        }

        //sort value
        int[] sortByValue = new int[infoNum.size()];
        int index = 0;
        for (Map.Entry<String, Integer> entry : infoNum.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            sortByValue[index] = value;
            index = index + 1;
        }
        Arrays.sort(sortByValue);
        for(int i = 0; i < sortByValue.length; i++){

        }

        //sorting ways 1
        List<List<String>> list = new ArrayList<>();
        int max = sortByValue[sortByValue.length-1];
        int min = sortByValue[0];
        for(int i = min; i <= max; i++){
            List<String> intVal = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : infoNum.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();
                if(value == i) {
                    for (int j = 0; j < value; j++) {
                        intVal.add(key);
                    }
                }
            }
            Collections.sort(intVal);
            Collections.reverse(intVal);
            list.add(intVal);
        }

        index = 0;
        for(List<String> entry: list){
            for(int i = 0; i < entry.size(); i++){
                words[index] = entry.get(i);
                index = index + 1;
            }
        }

        List<String> result = new ArrayList<>();
        for(int i = 0; i < words.length; i++){
            result.add(words[i]);
        }

        Collections.reverse(result);
        //distinct array
        distinctNum = new HashSet<>();
        //distinct num
        for(int i = 0; i < result.size(); i++){
            distinctNum.add(result.get(i));
        }
        List<String> finalResult = new ArrayList<>();
        int i = 0;
        for(String distNum: distinctNum){
            if(i == k) {
                break;
            }
            finalResult.add(distNum);
            i++;
        }
        Collections.reverse(finalResult);
        return finalResult;
    }

    public Boolean isValidJson(Object input){
        if(input == null){
            return true;
        }
        if(input instanceof String || input instanceof Number || input instanceof Boolean){
            return true;
        }
        if(input instanceof List<?>){
            for(Object elem: (List<?>) input){
                if(isValidJson(elem)){
                    return false;
                }
            }
            return true;
        }
        if(input.getClass().isArray()){
            Object[] arr = (Object[]) input;
            for(Object elem : arr){
                if(!isValidJson(elem)){
                    return false;
                }
            }
            return true;
        }
        if(input instanceof Map<?,?>){
            for(Map.Entry<?,?> entry : ((Map<?, ?>) input).entrySet()){
                if(!(entry.getKey() instanceof String)){
                    return false;
                }
                if(!isValidJson(entry.getValue())){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public void countWords(String str){
        String[] strArr = str.split("\\s+");
        HashSet<String> distinctNum = new HashSet<>();
        HashMap<String, Integer> infoNum = new HashMap<>();

        //distinct num
        for(int i = 0; i < strArr.length; i++){
            distinctNum.add(strArr[i]);
        }

        //find info each num
        for(String distNum: distinctNum){
            int found = 0;
            for(int j = 0; j < strArr.length; j++){
                if(distNum.equals(strArr[j])){
                    found = found + 1;
                }
            }
            infoNum.put(distNum, found);
        }
        System.out.println("infoNum : " + infoNum);
    }

}


class Mahasiswa {
    String nama, nim, lulus;
    int nilai;

    private void setNama(String nama){
        this.nama = nama;
    }

    private void setNim(String nim){
        this.nim = nim;
    }

    private void setNilai(int nilai){
        this.nilai = nilai;
        if(this.nilai > 70){
            this.lulus = "lulus";
        } else {
            this.lulus = "tidak lulus";
        }
    }

    private String getNama(){
        return this.nama;
    }

    private String getNim(){
        return this.nim;
    }

    private int getNilai(){
        return this.nilai;
    }
}