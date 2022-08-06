package com.company;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {

    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bplus,bminus,bmul,bdivide,bsqrt,bclear,bback,bdot,b00,bequalto;
    TextField tf;


    Calculator(){

      Panel p1 = new Panel(new GridBagLayout());
      p1.setBounds(5,5,370,90);
      p1.setBackground(Color.black);
      GridBagConstraints gc = new GridBagConstraints();
      tf = new TextField(20);
      tf.setFont(new Font("Arial", Font.BOLD, 30));
      gc.gridx=0;
      gc.gridy=0;
      gc.gridwidth=4;
      gc.gridheight=8;
      p1.add(tf,gc);
      add(p1);

      Panel p2 = new Panel(new GridLayout(6,5));
      p2.setBackground(Color.orange);
      p2.setBounds(5,95,370,360);
      add(p2);

      Font font = new Font("Calibri",1,20);

      bsqrt = new Button("sqrt");bsqrt.setFont(font);p2.add(bsqrt);
      bsqrt.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              tf.setText(Math.sqrt(Integer.parseInt(tf.getText()))+"");
          }
      });

      bclear = new Button("C");bclear.setFont(font);p2.add(bclear);
      bclear.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              tf.setText(null);
          }
      });

      bback = new Button("back");bback.setFont(font);p2.add(bback);
      bback.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              String input = tf.getText();
              String output="";
              for (int i = 0;i<input.length()-1;i++){
                  output=output+input.charAt(i);
              }
              tf.setText(output);
          }
      });

      bdivide = new Button("/");bdivide.setFont(font);p2.add(bdivide);
      bdivide.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              tf.setText(tf.getText()+" / ");
          }
      });

      b7 = new Button("7");b7.setFont(font);p2.add(b7);
      b7.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              tf.setText(tf.getText()+"7");
          }
      });

      b8 = new Button("8");b8.setFont(font);p2.add(b8);
      b8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf.setText(tf.getText()+"8");
            }
      });

      b9 = new Button("9");b9.setFont(font);p2.add(b9);
        b9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf.setText(tf.getText()+"9");
            }
        });

      bmul = new Button("*");bmul.setFont(font);p2.add(bmul);
      bmul.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              tf.setText(tf.getText()+" * ");
          }
      });

      b4 = new Button("4");b4.setFont(font);p2.add(b4);
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf.setText(tf.getText()+"4");
            }
        });

      b5 = new Button("5");b5.setFont(font);p2.add(b5);
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf.setText(tf.getText()+"5");
            }
        });

      b6 = new Button("6");b6.setFont(font);p2.add(b6);
        b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf.setText(tf.getText()+"6");
            }
        });

      bminus = new Button("-");bminus.setFont(font);p2.add(bminus);
      bminus.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              tf.setText(tf.getText()+" - ");
          }
      });

      b1 = new Button("1");b1.setFont(font);p2.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf.setText(tf.getText()+"1");
            }
        });

      b2 = new Button("2");b2.setFont(font);p2.add(b2);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf.setText(tf.getText()+"2");
            }
        });

      b3 = new Button("3");b3.setFont(font);p2.add(b3);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf.setText(tf.getText()+"3");
            }
        });

      bplus = new Button("+");bplus.setFont(font);p2.add(bplus);
      bplus.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              tf.setText(tf.getText()+" + ");
          }
      });

      b00 = new Button("expression");b00.setFont(new Font("Arial", Font.BOLD, 10));p2.add(b00);
      b00.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              ScriptEngineManager mgr = new ScriptEngineManager();
              ScriptEngine engine = mgr.getEngineByName("JavaScript");

              String exp = tf.getText();
              try {
                  tf.setText(engine.eval(exp)+"");
              } catch (ScriptException ex) {
                  ex.printStackTrace();
              }
          }
      });

      b0 = new Button("0");b0.setFont(font);p2.add(b0);
        b0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf.setText(tf.getText()+"0");
            }
        });

      bdot = new Button(".");bdot.setFont(font);p2.add(bdot);
        bdot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf.setText(tf.getText()+".");
            }
        });

      bequalto = new Button("=");bequalto.setFont(font);p2.add(bequalto);
      bequalto.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              String[] splitNum = tf.getText().split(" ");
              Double num1 = Double.parseDouble(splitNum[0]);
              Double num2 = Double.parseDouble(splitNum[2]);

              if(splitNum[1].equals("+")){
                  tf.setText((num1+num2)+"");
              }
              else if(splitNum[1].equals("-")){
                  tf.setText((num1-num2)+"");
              }
              else if(splitNum[1].equals("*")){
                  tf.setText((num1*num2)+"");
              }
              else if(splitNum[1].equals("/")){
                  tf.setText((num1/num2)+"");
              }
          }
      });

    }

    public static void main(String[] args) {
        Calculator c = new Calculator();
        c.setTitle("Calculator");
        c.setSize(400,500);
        c.setLayout(null);
        c.setVisible(true);
        c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
