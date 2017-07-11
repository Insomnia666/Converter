package android.kunitsa.com.converter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConverterActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView display;
    private Button one, two, three, four, five, six, seven, eight, nine, zero, point, result, backspace, allClear;
    Converter c = new Converter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);
        registerComponents();
    }

    public void registerComponents(){
        display = (TextView) findViewById(R.id.display);
        one = (Button) findViewById(R.id.btn1);
        two = (Button) findViewById(R.id.btn2);
        three = (Button) findViewById(R.id.btn3);
        four = (Button) findViewById(R.id.btn4);
        five = (Button) findViewById(R.id.btn5);
        six = (Button) findViewById(R.id.btn6);
        seven = (Button) findViewById(R.id.btn7);
        eight = (Button) findViewById(R.id.btn8);
        nine = (Button) findViewById(R.id.btn9);
        zero = (Button) findViewById(R.id.btn0);
        result = (Button) findViewById(R.id.btnResult);
        point = (Button) findViewById(R.id.btnPoint);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        zero.setOnClickListener(this);
        point.setOnClickListener(this);
        result.setOnClickListener(this);
        backspace = (Button) findViewById(R.id.btnBackSpace);
        allClear = (Button) findViewById(R.id.btnClear);
        backspace.setOnClickListener(this);
        allClear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                display.append("1");
                break;
            case R.id.btn2:
                display.append("2");
                break;
            case R.id.btn3:
                display.append("3");
                break;
            case R.id.btn4:
                display.append("4");
                break;
            case R.id.btn5:
                display.append("5");
                break;
            case R.id.btn6:
                display.append("6");
                break;
            case R.id.btn7:
                display.append("7");
                break;
            case R.id.btn8:
                display.append("8");
                break;
            case R.id.btn9:
                display.append("9");
                break;
            case R.id.btn0:
                display.append("0");
                break;
            case R.id.btnPoint:
                display.append(".");
                break;
            case R.id.btnResult:
                display.setText(c.anyConvertToDec(display.getText().toString(), 2));
                break;
            case R.id.btnBackSpace:
                if (display.getText().toString().length() > 0) {
                    display.setText(display.getText().toString().substring(0, display.getText().toString().length() - 1));
                }
            case R.id.btnClear:
                display.setText("");
                break;
        }
    }
}
