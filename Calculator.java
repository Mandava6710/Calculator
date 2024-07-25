import javax.swing.*;
import java.awt.Font;
import java.awt.*;
import java.awt.event.*;



public class Calculator  implements ActionListener{
	
	JFrame frame;
	JTextField textfield;
	JButton[] numberButton=new JButton[10];
	JButton[] functionButton=new JButton[8];
	JButton addButton,subButton,mulButton,divButton,decButton,eqlButton,clrButton,delButton;
	JPanel panel;
	
	Font myfont=new Font("MV Boli",Font.BOLD,30);
	
	double num1=0,num2=0,result=0;
	Character operator;
	
	
	
	
	public Calculator() {
		frame=new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,520);
		frame.setResizable(false);
		frame.setLayout(null);
		
		
		textfield =new JTextField();
		textfield.setBounds(50,40,300,50);
		textfield.setFont(myfont);
		textfield.setEditable(false);
		
		addButton=new JButton("+");
		subButton=new JButton("-");
		mulButton=new JButton("*");
		divButton=new JButton("/");
		decButton=new JButton(".");
		eqlButton=new JButton("=");
		delButton=new JButton("Delete");
		clrButton=new JButton("Clear");
		
		functionButton[0]=addButton;
		functionButton[1]=subButton;
		functionButton[2]=mulButton;
		functionButton[3]=divButton;
		functionButton[4]=decButton;
		functionButton[5]=eqlButton;
		functionButton[6]=delButton;
		functionButton[7]=clrButton;
		
		
		for(int i=0;i<8;i++) {
			functionButton[i].addActionListener(this);
			functionButton[i].setFont(myfont);
			functionButton[i].setFocusable(false);
		}
		
		for(int i=0;i<10;i++) {
			numberButton[i]=new JButton(String.valueOf(i));
			numberButton[i].addActionListener(this);
			numberButton[i].setFont(myfont);
			numberButton[i].setFocusable(false);
		}
		
		
		delButton.setBounds(50,410,145,50);
		clrButton.setBounds(200,410,145,50);
		
		panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        panel.add(numberButton[1]);
        panel.add(numberButton[2]);
        panel.add(numberButton[3]);
        panel.add(addButton);

        panel.add(numberButton[4]);
        panel.add(numberButton[5]);
        panel.add(numberButton[6]);
        panel.add(subButton);

        panel.add(numberButton[7]);
        panel.add(numberButton[8]);
        panel.add(numberButton[9]);
        panel.add(mulButton);

        panel.add(decButton);
        panel.add(numberButton[0]);
        panel.add(eqlButton);
        panel.add(divButton);
		
        frame.add(panel);
        frame.add(delButton);
		frame.add(clrButton);
		frame.add(textfield);
		frame.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		  for (int i = 0; i < 10; i++) {
	            if (e.getSource() == numberButton[i]) {
	                textfield.setText(textfield.getText().concat(String.valueOf(i)));
	            }
		  }
		 
		  if (e.getSource() == addButton) {
	            num1 = Double.parseDouble(textfield.getText());
	            operator = '+';
	            textfield.setText("");
	        }
		  if (e.getSource() == subButton) {
	            num1 = Double.parseDouble(textfield.getText());
	            operator = '-';
	            textfield.setText("");
	        }
		  if (e.getSource() == mulButton) {
	            num1 = Double.parseDouble(textfield.getText());
	            operator = '*';
	            textfield.setText("");
	        }
		  if (e.getSource() == divButton) {
	            num1 = Double.parseDouble(textfield.getText());
	            operator = '/';
	            textfield.setText("");
	        }
		  if (e.getSource() == decButton) {
	            textfield.setText(textfield.getText().concat("."));
	        }
		  if (e.getSource() == eqlButton) {
			  num2 = Double.parseDouble(textfield.getText());
			  
			  switch (operator){
			  case '+':
				  result = num1+num2;
				  break;
				  
			  case '-':
				  result = num1-num2;
				  break;
				   
			  case '*':
				  result = num1*num2;
				  break;
				  
			  case '/':
				  result = num1/num2;
				  break;
				   
			  }
			  
			  textfield.setText(String.valueOf(result));
			  num1=result;
			  
		  }
		  if (e.getSource() == clrButton) {
	            textfield.setText("");
	        }
		  
		  if (e.getSource() == delButton) {
	            String str = textfield.getText();
	            textfield.setText("");
	            for (int i=0;i<str.length()-1;i++) {
	                textfield.setText(textfield.getText()+str.charAt(i));
	            }
		  
		  
		  
		  }
       }

       
	public static void main(String[] args) {
	   Calculator calc=new Calculator();
	}
}



