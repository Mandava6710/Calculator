Name:Ganesh Mandava 
ID:CT4JP5004 
Domain:Java Programming 
Durantion:July 15 to August 15 2024 
Mentor: Muzammil Ahmed 
Description:  Here's a detailed description of the Java calculator code provided:

The provided Java code implements a basic graphical calculator application using Swing components.
The `Calculator` class creates a user interface with a main window (`JFrame`), a text field (`JTextField`) for displaying inputs and results, and a grid of buttons (`JButton`) for digits (0-9), arithmetic operations (+, -, *, /), decimal points, equals, clear, and delete functions. 
The constructor sets up the layout, positions the components, and configures the buttons with action listeners to handle user interactions. 
The `actionPerformed` method manages button clicks to update the text field, perform calculations, and handle errors such as division by zero. 
The `main` method instantiates the `Calculator` class, initializing and displaying the calculator interface. 
Overall, the code provides a simple yet functional calculator with a user-friendly graphical interface and basic error handling.

### **Description of the Calculator Code**

#### **1. Class Declaration**

- **Class Definition**:
  ```java
  public class Calculator implements ActionListener
  ```
  The `Calculator` class implements the `ActionListener` interface to handle button clicks and other user interactions.

#### **2. Imports**

- **Imports**:
   ```java
  import javax.swing.*;
  import java.awt.*;
  import java.awt.event.*;
  ```
  These imports include Swing components for the GUI (`JFrame`, `JTextField`, `JButton`), layout management (`GridLayout`), and event handling (`ActionListener`).

#### **3. Instance Variables**

- **JFrame**:
  ```java
  JFrame frame;
  ```
  The main window of the calculator.

- **JTextField**:
  ```java
  JTextField textfield;
  ```
  Displays user input and calculation results.

- **JButton Arrays**:
  ```java
  JButton[] numberButton = new JButton[10];
  JButton[] functionButton = new JButton[8];
  ```
  Arrays to store number buttons (0-9) and function buttons (operators, decimal, equals, etc.).

- **Individual Buttons**:
  ```java
  JButton addButton, subButton, mulButton, divButton, decButton, eqlButton, clrButton, delButton;
  ```
  Buttons for arithmetic operations, decimal point, equals, clear, and delete.

- **JPanel**:
  ```java
  JPanel panel;
  ```
  Panel to organize the calculator's buttons.

- **Font**:
  ```java
  Font myfont = new Font("MV Boli", Font.BOLD, 30);
  ```
  Defines the font style and size for the buttons and text field.

- **Calculation Variables**:
  ```java
  double num1 = 0, num2 = 0, result = 0;
  Character operator;
  boolean isDecimalUsed = false;
  ```
  Variables to store numbers, results, the current operator, and a flag to check if a decimal point has been used.

#### **4. Constructor**

- **Frame Setup**:
  ```java
  frame = new JFrame("Calculator");
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setSize(420, 520);
  frame.setResizable(false);
  frame.setLayout(null);
  ```
  Initializes the main window with a title, size, and layout. The layout is set to `null` for absolute positioning.

- **Text Field**:
  ```java
  textfield = new JTextField();
  textfield.setBounds(50, 40, 300, 50);
  textfield.setFont(myfont);
  textfield.setEditable(false);
  ```
  Creates a non-editable text field for displaying calculations.

- **Button Initialization**:
  ```java
  addButton = new JButton("+");
  subButton = new JButton("-");
  mulButton = new JButton("*");
  divButton = new JButton("/");
  decButton = new JButton(".");
  eqlButton = new JButton("=");
  delButton = new JButton("Delete");
  clrButton = new JButton("Clear");
  ```
  Initializes buttons for arithmetic operations, decimal point, equals, delete, and clear.

- **Function Buttons Array Setup**:
  ```java
  functionButton[0] = addButton;
  functionButton[1] = subButton;
  functionButton[2] = mulButton;
  functionButton[3] = divButton;
  functionButton[4] = decButton;
  functionButton[5] = eqlButton;
  functionButton[6] = delButton;
  functionButton[7] = clrButton;
  ```
  Assigns the created buttons to the `functionButton` array for easy management.

- **Button Configuration**:
  ```java
  for (int i = 0; i < 8; i++) {
      functionButton[i].addActionListener(this);
      functionButton[i].setFont(myfont);
      functionButton[i].setFocusable(false);
  }
  ```
  Sets up action listeners for all function buttons and assigns the font.

- **Number Buttons Initialization**:
  ```java
  for (int i = 0; i < 10; i++) {
      numberButton[i] = new JButton(String.valueOf(i));
      numberButton[i].addActionListener(this);
      numberButton[i].setFont(myfont);
      numberButton[i].setFocusable(false);
  }
  ```
  Creates number buttons (0-9) and configures them similarly to function buttons.

- **Button Layout**:
  ```java
  delButton.setBounds(50, 410, 145, 50);
  clrButton.setBounds(200, 410, 145, 50);
  ```
  Sets the position and size of the delete and clear buttons.

- **Panel Layout**:
  ```java
  panel = new JPanel();
  panel.setBounds(50, 100, 300, 300);
  panel.setLayout(new GridLayout(4, 4, 10, 10));
  ```
  Configures a panel with a grid layout to organize number and operation buttons.

- **Adding Buttons to Panel**:
  ```java
  panel.add(numberButton[1]);
  panel.add(numberButton[2]);
  panel.add(numberButton[3]);
  panel.add(addButton);
  ```
  Adds buttons to the panel in a grid format.

- **Adding Components to Frame**:
  ```java
  frame.add(panel);
  frame.add(delButton);
  frame.add(clrButton);
  frame.add(textfield);
  frame.setVisible(true);
  ```
  Adds the panel, delete and clear buttons, and text field to the frame. Finally, makes the frame visible.

#### **5. Action Handling**

- **Number Button Handling**:
  ```java
  for (int i = 0; i < 10; i++) {
      if (e.getSource() == numberButton[i]) {
          textfield.setText(textfield.getText().concat(String.valueOf(i)));
      }
  }
  ```
  Appends the number corresponding to the clicked button to the text field.

- **Operator Button Handling**:
  ```java
  if (e.getSource() == addButton) {
      num1 = getNumberFromTextField();
      operator = '+';
      textfield.setText("");
      isDecimalUsed = false;
  }
  ```
  Stores the current number, sets the operator, and clears the text field for the next input.

- **Decimal Point Handling**:
  ```java
  if (e.getSource() == decButton) {
      if (!isDecimalUsed) {
          textfield.setText(textfield.getText().concat("."));
          isDecimalUsed = true;
      }
  }
  ```
  Adds a decimal point to the text field if not already present.

- **Equals Button Handling**:
  ```java
  if (e.getSource() == eqlButton) {
      num2 = getNumberFromTextField();
      try {
          switch (operator) {
              case '+':
                  result = num1 + num2;
                  break;
              case '-':
                  result = num1 - num2;
                  break;
              case '*':
                  result = num1 * num2;
                  break;
              case '/':
                  if (num2 != 0) {
                      result = num1 / num2;
                  } else {
                      textfield.setText("Error");
                      return;
                  }
                  break;
          }
          textfield.setText(String.valueOf(result));
          num1 = result;
      } catch (Exception ex) {
          textfield.setText("Error");
      }
      isDecimalUsed = false;
  }
  ```
  Performs the calculation based on the operator and updates the text field with the result. Handles division by zero and other errors.

- **Clear Button Handling**:
  ```java
  if (e.getSource() == clrButton) {
      textfield.setText("");
      isDecimalUsed = false;
  }
  ```
  Clears the text field and resets the decimal point usage flag.

- **Delete Button Handling**:
  ```java
  if (e.getSource() == delButton) {
      String str = textfield.getText();
      if (str.length() > 0) {
          textfield.setText(str.substring(0, str.length() - 1));
          if (str.endsWith(".")) {
              isDecimalUsed = false;
          }
      }
  }
  ```
  Deletes the last character from the text field and adjusts the decimal point usage flag if needed.

#### **6. Helper Method**

- **`getNumberFromTextField()`**:
  ```java
  private double getNumberFromTextField() {
      String text = textfield.getText();
      if (text.isEmpty()) {
          return 0;
      }
      return Double.parseDouble(text);
  }
  ```
  Converts the text in the text field to a `double` for calculations.

#### **7. Main Method**

- **`main`**:
  ```java
  public static void main(String[] args) {
      new Calculator();
  }
  ```
  Creates an instance of the `Calculator` class, initializing and displaying the calculator GUI.

### **Summary**
The code creates a graphical calculator application using Java Swing. It features:

 Basic Arithmetic Operations: Addition, subtraction, multiplication, division.
 Decimal Point Handling: Allows input of decimal numbers.
 Error Handling: Includes basic error handling for division by zero.
 User Interface: Uses JFrame for the main window, JTextField for displaying results, and JButton for user interaction. Buttons are arranged in a grid layout

Key Changes:
1.Error Handling: Added handling for division by zero and display "Error" for invalid operations.
2.Decimal Point Handling: Added a flag isDecimalUsed to ensure only one decimal point can be added.
3.Code Cleanup: Simplified the code and extracted repetitive logic into methods.
This version of the calculator should be more user-friendly and robust, handling common errors and input issues more gracefully.
