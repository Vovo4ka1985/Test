import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.calc("V*VII");

    }
    public String calc(String str) throws Exception {
        String res = null;
            String znak = "";
            if (str.contains("+")) {
                znak += "\\+";
            } else if (str.contains("-")) {
                znak += "\\-";
            } else if (str.contains("*")) {
                znak += "\\*";
            } else if (str.contains("/")) {
                znak += "\\/";

            }
            String[] array = str.split(znak);
            if(array.length>2){
                throw new Exception();
            }
            boolean index1 = Arrays.asList(Roman.rom1_10).contains(array[0]);
            boolean index2 = Arrays.asList(Roman.rom1_10).contains(array[1]);
            boolean indexArab1 = Arrays.asList(Arab.arab1_10).contains(array[0]);
            boolean indexArab2 = Arrays.asList(Arab.arab1_10).contains(array[1]);
            int a;
            int b;

            if (index1 == true && index2 == true) {
                a = Arrays.asList(Roman.rom1_10).indexOf(array[0]) + 1;
                b = Arrays.asList(Roman.rom1_10).indexOf(array[1]) + 1;
                int l = result(a, b, znak);
                res = Roman.arrRom[l - 1];
            } else if (indexArab1 == true && indexArab2 == true) {
                a = Integer.parseInt(array[0]);
                b = Integer.parseInt(array[1]);
                int l = (int) Math.floor(result(a, b, znak));
                res = String.valueOf(l);

            } else {
                throw new Exception();
            }
        return res;
    }
    public int result(int a, int b, String znak){
        if(znak.equals("\\+")){
            return a+b;
        }else  if(znak.equals("\\/")){
            return a/b;
        }else  if(znak.equals("\\*")){
            return a*b;
        }else {
            return a-b;
        }
    }
}
