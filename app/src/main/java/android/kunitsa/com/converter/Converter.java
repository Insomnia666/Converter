package android.kunitsa.com.converter;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by Администратор on 07.06.2017.
 */

public class Converter {

    public static final BigDecimal one = new BigDecimal(1);
    public static final BigDecimal ten = new BigDecimal(10);

    public String anyConvertToDec(String s, int r){

        BigDecimal fract, whole;

        BigDecimal res = new BigDecimal(r);

        fract = new BigDecimal(s.substring(0, s.indexOf(".")));
        whole = new BigDecimal(s.substring(s.indexOf(".")+1));

        return  decFractConvertToAny(fract, res).concat(".").concat(decWholeConvertToAny(whole, res));
    };

    public String decConvertToany(String s, int r){
        BigDecimal fract, whole;

        BigDecimal res = new BigDecimal(r);

        fract = new BigDecimal(s.substring(0, s.indexOf(".")));
        whole = new BigDecimal(s.substring(s.indexOf(".")+1));

        return  anyFractConvertToDec(fract, res).concat(".").concat(anyWholeConvertToDec(whole, res));
    }

    public String decFractConvertToAny(BigDecimal fract, BigDecimal r){
        String result = null, buffer = null;
        while (fract.compareTo(r) != -1){
            if (result!=null){
                buffer = String.valueOf(fract.remainder(r));
                result = buffer.concat(result);
                fract = fract.divideToIntegralValue(r);
            }else {
                result = String.valueOf(fract.remainder(r));
                buffer = String.valueOf(fract.divideToIntegralValue(r));
                fract = fract.divideToIntegralValue(r);
            }
        }
        result = buffer.concat(result);
        return result;
    }

    public String decWholeConvertToAny(BigDecimal whole, BigDecimal r){
        String result = null, buffer = null;
        while (whole.compareTo(one) != -1){
            whole = whole.divide(ten);
        }
        for (int i=0; i<6; i++) {
            if (result!=null) {
                buffer = String.valueOf(whole.multiply(r));
                result = result.concat(buffer.substring(0, buffer.indexOf(".")));
                whole = whole.multiply(r);
                whole = whole.remainder(one);
            }else {
                buffer = String.valueOf(whole.multiply(r));
                result = buffer.substring(0, buffer.indexOf("."));
                whole = whole.multiply(r);
                whole = whole.remainder(one);
            }
        }
        return result;
    }

    public String anyFractConvertToDec(BigDecimal fract, BigDecimal r) {
        String result = null;
        int k = 0;

        BigDecimal f = fract;
        while (f.compareTo(one) != -1){
            k++;
            f.divide(ten);
        }
        f = new BigDecimal(0);
        for(int i=0; i<k; i++){
            if (fract.compareTo(one) != -1){
                f=f.add((fract.remainder(ten).multiply(r.pow(i))));
            }
        }
        result = String.valueOf(f);
        return result;
    }

    public String anyWholeConvertToDec(BigDecimal whole, BigDecimal r){
        String result = null;
        int k = 0;

        BigDecimal w = whole;
        while (w.compareTo(one) != -1){
            k--;
            w.divide(ten);
        }
        w = new BigDecimal(0);
        for (int i=k; i<0; i++){
            if (whole.compareTo(one) != -1){
                w=w.add((whole.remainder(ten).multiply(r.pow(i))));
            }
        }
        result = String.valueOf(w);
        return result;
    }
}
