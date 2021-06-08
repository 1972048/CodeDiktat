// Theovanno Tjahyamulia - 1972048
// class
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConverterCalculator {

    public static String convertToBinary(int number){
        return coreConvertFromDecimal(number,2);  
    }
    
    public static String convertToHexa(int number){
        return coreConvertFromDecimal(number,16);
    }

    public static String convertToOctal(int number){
        return coreConvertFromDecimal(number,8);
    }
    
    public static int convertBinaryToDecimal(String number){
        return coreConvertToDecimal(number,2);
    }
    
    public static int convertHexaToDecimal(String number){
        return coreConvertToDecimal(number,16);
    }

    private static String coreConvertFromDecimal(int number,int radix){   
        String s="";
        if(radix!=8){
            if(radix==2){
                while(radix<number){
                    radix*=2;
                }
                while(number>0){
                    radix/=2;
                    if(number>=radix){
                        number=number-radix;
                        s=s+"1";
                    }
                    else{
                        s=s+"0";
                    }
                }
                while(radix!=1){
                    s=s+"0";
                    radix/=2;
                }
            }
            else if(radix==16){
                while(radix<=number){
                    radix*=16;
                }
                int h=0;
                while(number>0){
                    radix/=16;
                    h=number-(number%radix);
                    number-=h;
                    h=h/radix;
                    if(h>9){
                        if(h==10){
                            s+="A";
                        }
                        else if(h==11){
                            s+="B";
                        }
                        else if(h==12){
                            s+="C";
                        }
                        else if(h==13){
                            s+="D";
                        }
                        else if(h==14){
                            s+="E";
                        }
                        else if(h==15){
                            s+="F";
                        }
                    }
                    else{
                        s+=Integer.toString(h);
                    }
                }
                while(radix!=1){
                    s=s+"0";
                    radix/=16;
                }
            }
            StringBuilder sb = new StringBuilder(s);
            s=sb.reverse().toString();
            String[] S = s.split("(?<=\\G....)");
            s="";
            for(int i=0;i<S.length;i++){
                s=s+S[i];
                if(i<S.length-1){
                    s=s+" ";
                }
            }
            sb = new StringBuilder(s);
            s=sb.reverse().toString();
        }
        else{
            while(radix<=number){
                radix*=8;
            }
            int h=0;
            while(number>0){
                radix/=8;
                h=number-(number%radix);
                number-=h;
                h=h/radix;
                s+=Integer.toString(h);
            }
            while(radix!=1){
                s=s+"0";
                radix/=8;
            }
            StringBuilder sb = new StringBuilder(s);
            s=sb.reverse().toString();
            String[] S = s.split("(?<=\\G...)");
            s="";
            for(int i=0;i<S.length;i++){
                s=s+S[i];
                if(i<S.length-1){
                    s=s+" ";
                }
            }
            sb = new StringBuilder(s);
            s=sb.reverse().toString();
        }
        return s;
    }

    private static int coreConvertToDecimal(String numberString,int radix){
        int s=0;
        String S="";
        if(radix==2){
            Pattern pattern = Pattern.compile("[^01]", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(numberString);
            boolean matchFound = matcher.find();
            if(matchFound) {
                return 0;
            }
            else{
                StringBuilder sb = new StringBuilder(numberString);
                S=sb.reverse().toString();
                String[] SS = S.split("");
                for(int i=0;i<SS.length;i++){
                    if(SS[i].equals("1")){
                        s+=Math.round(Math.pow(radix,i));
                    }
                }
            }
        }
        else{
            Pattern pattern = Pattern.compile("[^0-9abcdef]", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(numberString);
            boolean matchFound = matcher.find();
            if(matchFound) {
                return 0;
            }
            else if(radix==16){
                StringBuilder sb = new StringBuilder(numberString);
                S=sb.reverse().toString();
                String[] SS = S.split("");
                pattern = Pattern.compile("[0-9]", Pattern.CASE_INSENSITIVE);
                for(int i=0;i<SS.length;i++){
                    matcher = pattern.matcher(SS[i]);
                    matchFound = matcher.find();
                    if(matchFound) {
                        s+=Math.round(Math.pow(radix,i)*Integer.parseInt(SS[i]));
                    }
                    else{
                        if (SS[i].toUpperCase().equals("A")){
                            s+=Math.round(Math.pow(radix,i)*10);
                        }
                        else if (SS[i].toUpperCase().equals("B")){
                            s+=Math.round(Math.pow(radix,i)*11);
                        }
                        else if (SS[i].toUpperCase().equals("C")){
                            s+=Math.round(Math.pow(radix,i)*12);
                        }
                        else if (SS[i].toUpperCase().equals("D")){
                            s+=Math.round(Math.pow(radix,i)*13);
                        }
                        else if (SS[i].toUpperCase().equals("E")){
                            s+=Math.round(Math.pow(radix,i)*14);
                        }
                        else if (SS[i].toUpperCase().equals("F")){
                            s+=Math.round(Math.pow(radix,i)*15);
                        }
                    }
                }
            }
        }
        return s;
    }
}
