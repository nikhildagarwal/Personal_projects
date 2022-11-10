import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Stack;

public class decHexBinary {
    public static void main(String[] args){
        String input = args[0]; //command line input

        if(input.length()<3){
            System.out.println("Decimal(Input): "+ input);
            System.out.println("Binary: 0b"+decToBin(input));
            System.out.println("Hex: "+decToHex(input));
        }else{
            if(input.charAt(1)=='b'){
                System.out.println("Binary(Input): "+input);
                System.out.println("Decimal: "+binToDec(input));
                System.out.println("Hex: 0x"+decToHex(Integer.toString(binToDec(input))));
            }else if(input.charAt(1)=='x'){
                System.out.println("Hex(Input): "+input);
                System.out.println("Decimal: "+hexToDec(input));
                System.out.println("Binary: 0b"+decToBin(Integer.toString(hexToDec(input))));
            }else{
                System.out.println("Decimal(Input): "+ input);
                System.out.println("Binary: 0b"+decToBin(input));
                System.out.println("Hex: 0x"+decToHex(input));
            }
        }
        
    }
    private static int power(int b, int p){
        int result = b;
        if(p == 0){
            return 1;
        }else{
            for(int i = 1;i<p;i++){
                result = result*b;
            }
            return result;
        }
    }

    private static int binToDec(String a){
        int result = 0;
        int startInd = a.length()-3;
        for(int i = 0;i<a.length()-2;i++){
            if(a.charAt(i+2)=='1'){
                result = result + power(2,startInd);
                //System.out.println(result);
                startInd--;
            }else{
                startInd--;
            }
        }
        return result;
    }

    private static int hexToDec(String a){
        int res = 0;
        int startInde = a.length()-3;
        HashMap<Character,Integer> cod = new HashMap<>();
            cod.put('0',0);
            cod.put('1',1);
            cod.put('2',2);
            cod.put('3',3);
            cod.put('4',4);
            cod.put('5',5);
            cod.put('6',6);
            cod.put('7',7);
            cod.put('8',8);
            cod.put('9',9);
            cod.put('A',10);
            cod.put('B',11);
            cod.put('C',12);
            cod.put('D',13);
            cod.put('E',14);
            cod.put('F',15);
        for(int i = 0;i<a.length()-2;i++){
            char temp = a.charAt(i+2);
            int tempInt = cod.get(temp);
            res = res + tempInt*power(16,startInde);
            startInde--;
        }
        return res;
    }

    private static String decToHex(String a){
        String[] alphabet = {"A","B","C","D","E","F"};
        Stack<Integer> buildHex = new Stack<>();
        int inputD = Integer.parseInt(a);
        do{
            int remainder = inputD%16;
            
            buildHex.push(remainder);
            inputD = inputD /16;
        }while(inputD/16 != 0);
        buildHex.push(inputD%16);
        int length = buildHex.size();
        String buildH = "";
        for(int i =0;i<length;i++){
            int hi = buildHex.pop();
            if(hi<10){
                buildH = buildH + Integer.toString(hi);
            }else{
                int temp = hi%10;
                buildH = buildH + alphabet[temp];
            }

            
        }
        //System.out.println(buildHex.isEmpty());
        return buildH;
    }
    
    private static String decToBin(String a){
        List<Integer> buildBin = new ArrayList<>();
        int inputNum = Integer.parseInt(a);
        while(inputNum / 2 != 0){
            int remainder = inputNum%2;
            buildBin.add(remainder);
            inputNum = inputNum/2;
        }
        buildBin.add(inputNum%2);
        String result = "";
        int length = buildBin.size();
        int counter = length-1;
        for(int i = 0;i<length;i++){
            result = result + buildBin.get(counter);
            counter--;
        }
        return result;
    }
}
