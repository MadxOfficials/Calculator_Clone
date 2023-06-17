package com.themudhouse.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity{

    // Reference Variables
    private MaterialButton btn1, btn2, btnPlus, btnEquals, btnClear;
    private TextView txtV, txtVOperations;

    private String num1 = "";
    private String num2 = "";

    private boolean isOperatorActive = false;
    private String operator = "";

    private String previousNum2;
    private int result = 0;
    private String txtVResult = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Assigning variables
        btn1 = (MaterialButton) findViewById(R.id.mBtn1);
        btn2 = findViewById(R.id.mBtn2);
        btnPlus = findViewById(R.id.mBtnPlus);
        btnEquals = findViewById(R.id.mBtnEquals);
        btnClear = findViewById(R.id.mBtnAC);
        txtV = findViewById(R.id.txtVDisplay);
        txtVOperations = findViewById(R.id.txtVOperations);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = "";
                num2 = "";
                operator = "";
                txtV.setText("");
                isOperatorActive = false;
                txtVOperations.setText("");
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (num1 == "" && operator == "" && num2 == "") {
                    isOperatorActive = true;
                    operator = "+";
                    result = 0;
                    txtVResult = String.valueOf(result);
                    txtV.setText(txtVResult);
                    num1 = txtVResult;
                    txtVOperations.setText(num1 + operator);
                }
                else {
                    if (txtVResult != "" && num1 == txtVResult) {
                        num2 = "";
                        isOperatorActive = true;
                        operator = btnPlus.getText().toString();
                        txtV.setText(num1);
                        txtVOperations.setText(num1 + operator + num2);
                    }
                    else {
                        isOperatorActive = true;
                        operator = btnPlus.getText().toString();
                        txtV.setText(num1);
                        txtVOperations.setText(num1 + operator + num2);
                    }
                }

            }
        });

        btnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (num1 != "" && operator == "" && num2 == "") {
                    result = Integer.valueOf(num1);
                    txtVResult = String.valueOf(result);
                    txtV.setText(txtVResult);
                    txtVOperations.setText(num1 + "=");
                    num1 = txtVResult;
                } else if (num1 == "" && operator == "" && num2 == "") {
                    result = 0;
                    txtVResult = String.valueOf(result);
                    txtV.setText(txtVResult);
                    num1 = txtVResult;
                    txtVOperations.setText(num1 + "=");

                } else {
                    if (num1 != "" && operator != "" && num2 == "") {
                        num2 = num1;
                        result = Integer.valueOf(num1) + Integer.valueOf(num2);
                        txtVResult = String.valueOf(result);
                        txtV.setText(txtVResult);
                        txtVOperations.setText(num1 + operator + num2 + "=");
                        isOperatorActive = false;
                        num1 = txtVResult;
//                    num2 = "";
                    }
                    else if (num1 != "" && operator != "" && num2 != "") {
//                    num1 = txtVResult;
                        result = Integer.valueOf(num1) + Integer.valueOf(num2);
                        txtVResult = String.valueOf(result);
                        txtV.setText(txtVResult);
                        txtVOperations.setText(num1 + operator + num2 + "=");
                        num1 = txtVResult;
                        isOperatorActive = false;
                    }
                    else {
                        result = Integer.valueOf(num1) + Integer.valueOf(num2);
                        txtVResult = String.valueOf(result);
                        txtV.setText(txtVResult);
                        txtVOperations.setText(num1 + operator + num2 + "=");
                        isOperatorActive = false;
                        num1 = txtVResult;
                        num2 = "";
                    }
                }


            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isOperatorActive) {
                    if (num1 == txtVResult) {
                        num1 = "";
                        result = 0;
                        num1 = num1 + btn1.getText().toString();
                        txtV.setText(num1);
                    }
                    else {
                        num1 = num1 + btn1.getText().toString();
                        txtV.setText(num1);
                    }
                }
                else {
                    if (num1 != "" && operator != "" && num2 != "") {
                        num1 = "";
                        num2 = "";
                        operator = "";
                        isOperatorActive = false;
                        num2 = num2 + btn1.getText().toString();
                        txtV.setText(num2);
                        txtVOperations.setText("");
                    }
                    else {
                        num2 = num2 + btn1.getText().toString();
                        txtV.setText(num2);
                    }

                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isOperatorActive) {
                    if (num1 == txtVResult) {
                        num1 = "";
                        result = 0;
                        num1 = num1 + btn2.getText().toString();
                        txtV.setText(num1);
                    }
                    else {
                        num1 = num1 + btn2.getText().toString();
                        txtV.setText(num1);
                    }
                }
                else {
                    if (num2 == "" && num1 == txtVResult) {
//                        num1 = txtVResult;
                        num2 = num2 + btn2.getText().toString();
                        txtV.setText(num2);
                    }
                    else {
                        num2 = num2 + btn2.getText().toString();
                        txtV.setText(num2);
                    }
                }
            }
        });
    }
}