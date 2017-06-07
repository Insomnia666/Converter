package android.kunitsa.com.converter;

/**
 * Created by Администратор on 07.06.2017.
 */

public class Converter {

    public String convertTo(String s, int r){

        int i=0, len=s.length();

        int fractional = 0, whole;
        String fractionalResult, wholeResult;
        double limit = -Double.MAX_VALUE;
        double multmin;

        fractional = Integer.parseInt(s.substring(0, s.indexOf(".")));
        whole = Integer.parseInt(s.substring(s.indexOf(".")+1));




        return wholeConvertTo(whole, r);
    };

    public String fractionalConvertTo(int fract, int r) {
        String result = null, buffer = null;
        while(fract>r){
            if (result!=null) {
                buffer = Integer.toString(fract % r);
                result = buffer.concat(result);
                fract = fract / r;
            }else {
                result = Integer.toString(fract % r);
                fract = fract/r;
            }
        }
        return result;
    }

    public String wholeConvertTo(double whole, int r) {
        String result = null, buffer = null;
        while (whole>1){
            whole=whole/10;
        }
        while(whole>0){
            if (result!=null) {
                buffer = Double.toString(whole*r);
                result = result.concat(buffer.substring(0, buffer.indexOf(".")));
                whole = whole*r;
                whole = whole%1;
            }else {
                buffer = Double.toString(whole*r);
                result = buffer.substring(0, buffer.indexOf("."));
                whole = whole*r;
                whole = whole%1;
            }
        }
        return result;
    }
}
