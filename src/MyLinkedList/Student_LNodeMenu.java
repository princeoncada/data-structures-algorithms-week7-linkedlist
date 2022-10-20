package MyLinkedList;


import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
public class Student_LNodeMenu extends JFrame implements ActionListener,ItemListener, KeyListener{
    private final JLabel lblChoose;
    private final JLabel lblName;
    private final JLabel lblAge;
    private final JLabel lblCourse;
    private final JLabel lblPosition;
    private final JTextField txtName;
    private final JTextField txtAge;
    private final JTextField txtCourse;
    private final JTextField txtPosition;
    private final JComboBox<String> cboChoose;
    private final JTextArea txtAreaUp;
    private final JTextArea txtAreaDown;
    private final JButton btnProcess;
    private final JButton btnClose;
    private final Student_LNode myNode;
    String hold="";
    Student_LNodeMenu(){
        myNode=new Student_LNode(null);
        lblChoose=new JLabel("Choose");
//Create menu List
        String[] menu ={
                "Add At First",
                "Add At Position",
                "Add At Last",
                "Add In Middle",
                "Delete At First",
                "Delete At Position",
                "Delete At Last",
                "Delete In Middle",
                "Delete Value",
                "Get First",
                "Get At Position",
                "Get Last",
                "Index Of Value"
        };
        cboChoose=new JComboBox<>(menu); //Load menu list to comboBox
        txtAreaUp=new JTextArea();
        txtAreaDown=new JTextArea();
        btnProcess=new JButton("Process");
        btnClose=new JButton("Close");
        lblName=new JLabel("Name");
        lblAge=new JLabel("Age");
        lblCourse=new JLabel("Course");
        lblPosition=new JLabel("Position");
        txtName=new JTextField();
        txtAge=new JTextField();
        txtCourse=new JTextField();
        txtPosition=new JTextField();
        txtPosition.setEditable(false);
        setTitle("LinkedList Application");
        setSize(400, 300);
//Background of the Frame
        getContentPane().setBackground(new Color(100,50,90,80));
        setLayout(null);
//Sets the text-field or text area disabled for editing
        txtAreaUp.setEditable(false);
        txtAreaDown.setEditable(false);
//Observers for LNode
        hold="Empty\t: "+myNode.isEmpty()+"\tCurrent Size\t: "+myNode.currentSize();
        txtAreaUp.setText(hold);
//Positioning each component to Frame
        add(txtAreaUp).setBounds(20,20,330,20);
        add(new JScrollPane(txtAreaDown)).setBounds(20,40,330,100);
        add(lblChoose).setBounds(20,140,60,20);
        add(cboChoose).setBounds(80,140,150,20);
        add(btnProcess).setBounds(240,140,110,100);
        add(lblName).setBounds(20,160,100,20);
        add(lblAge).setBounds(20,180,100,20);
        add(lblCourse).setBounds(20,200,100,20);
        add(lblPosition).setBounds(20,220,100,20);
        add(txtName).setBounds(80,160,150,20);
        add(txtAge).setBounds(80,180,150,20);
        add(txtCourse).setBounds(80,200,150,20);
        add(txtPosition).setBounds(80,220,150,20);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//Invoke event -click
        btnProcess.addActionListener(this);
        cboChoose.addItemListener(this);
        txtPosition.addKeyListener(this);
        txtName.addKeyListener(this);
        txtAge.addKeyListener(this);
        txtCourse.addKeyListener(this);
        btnProcess.setEnabled(false);
    }
    public static void main(String[] args) { new Student_LNodeMenu();
    }
    public void actionPerformed(ActionEvent e) {
//returns index value of a comboBox
        int i=cboChoose.getSelectedIndex();
//String item=cboChoose.getSelectedItem().toString();
        int pos;
//selection for ech index
        if(i==0){
            // AddAtFirst
            myNode.addAtFirst(txtName.getText(), Integer.parseInt(txtAge.getText()), txtCourse.getText());
        }else if(i==1){
            // AddAtPosition
            pos=Integer.parseInt(txtPosition.getText());
            myNode.addAtPosition(txtName.getText(), Integer.parseInt(txtAge.getText()), txtCourse.getText(), pos);
        }else if(i==2){
            // AddAtLast
            myNode.addAtLast(txtName.getText(), Integer.parseInt(txtAge.getText()), txtCourse.getText());
        }else if(i==3){
            // AddInMiddle
            myNode.addInMiddle(txtName.getText(), Integer.parseInt(txtAge.getText()), txtCourse.getText());
        }else if(i==4){
            // DeleteAtFirst
            myNode.deleteAtFirst();
        }else if(i==5){
            // DeleteAtPosition
            pos=Integer.parseInt(txtPosition.getText());
            myNode.deleteAtPosition(pos);
        }else if(i==6){
            // DeleteAtLast
            myNode.deleteAtLast();
        }else if(i==7){
            // DeleteInMiddle
            myNode.deleteInMiddle();
        }else if(i==8){
            // DeleteValue
            myNode.deleteValue(txtName.getText(), Integer.parseInt(txtAge.getText()), txtCourse.getText());
        }else if(i==9) {
            // GetFirst
            JOptionPane.showMessageDialog(null, new JTextArea("Student Name\t: " +
                    myNode.getFirst().getName() + "\nStudent Age\t: " + myNode.getFirst().getAge() +
                    "\nStudent Course\t: " + myNode.getFirst().getCourse()));
        }else if(i==10) {
            // GetAtPosition
            pos=Integer.parseInt(txtPosition.getText());
            JOptionPane.showMessageDialog(null, new JTextArea("Student Name\t: " +
                    myNode.getAtPosition(pos).getName() + "\nStudent Age\t: " + myNode.getAtPosition(pos).getAge() +
                    "\nStudent Course\t: " + myNode.getAtPosition(pos).getCourse()));
        }else if(i==11) {
            // GetLast
            JOptionPane.showMessageDialog(null, new JTextArea("Student Name\t: " +
                    myNode.getLast().getName() + "\nStudent Age\t: " + myNode.getLast().getAge() +
                    "\nStudent Course\t: " + myNode.getLast().getCourse()));
        }else if(i==12) {
            // IndexAt
            JOptionPane.showMessageDialog(null, "Student Position\t: "+myNode.indexAt(txtName.getText(),
                    Integer.parseInt(txtAge.getText()), txtCourse.getText()));
        }
//display the elements of Linked-list to textArea
        txtAreaDown.setText(myNode.traverse());
//clear the text area
        txtPosition.setText("");
        txtName.setText("");
        txtAge.setText("");
        txtCourse.setText("");
        hold="Empty\t: "+myNode.isEmpty()+"\tCurrent Size\t: "+myNode.currentSize();
        txtAreaUp.setText(hold);
        btnProcess.setEnabled(false);
    }
    //Activate/Deactivate components (text-fields) based on combo-box selection
    public void itemStateChanged(ItemEvent e) {
        int i=cboChoose.getSelectedIndex();
        if(i==0){
            // AddAtFirst
            disable(); //call disable method when first value of combo-box is selected
            btnProcess.setEnabled(false);
        }else if(i==1){
            // AddAtPosition
            enable(); //call enable method when second value of combo-box is selected
            btnProcess.setEnabled(false);
        }else if(i==2){
            // AddAtLast
            disable();
            btnProcess.setEnabled(false);
        }else if(i==3){
            // AddInMiddle
            disable();
            btnProcess.setEnabled(false);
        }else if(i==4){
            // DeleteAtFirst
            disableAll();
            btnProcess.setEnabled(true);
        }else if(i==5){
            // DeleteAtPosition
            disableAll();
            txtPosition.setEditable(true);
            btnProcess.setEnabled(false);
        }else if(i==6){
            // DeleteAtLast
            disableAll();
            btnProcess.setEnabled(true);
        }else if(i==7){
            // DeleteInMiddle
            disableAll();
            btnProcess.setEnabled(true);
        }else if(i==8){
            // DeleteValue
            disable();
            btnProcess.setEnabled(false);
        }else if(i==9){
            // GetFirst
            disableAll();
            btnProcess.setEnabled(true);
        }else if(i==10){
            // GetAtPosition
            disableAll();
            txtPosition.setEditable(true);
            btnProcess.setEnabled(false);
        }else if(i==11){
            // GetLast
            disableAll();
            btnProcess.setEnabled(true);
        }else if(i==12) {
            // IndexAt
            disable();
            btnProcess.setEnabled(false);
        }
    }
    public void enable(){
        txtName.setEditable(true);
        txtAge.setEditable(true);
        txtCourse.setEditable(true);
        txtPosition.setEditable(true);
    }
    public void disable(){
        txtName.setEditable(true);
        txtAge.setEditable(true);
        txtCourse.setEditable(true);
        txtPosition.setEditable(false);
    }
    public void disableAll(){
        txtName.setEditable(false);
        txtAge.setEditable(false);
        txtCourse.setEditable(false);
        txtPosition.setEditable(false);
    }
    public void keyPressed(KeyEvent arg0) { }
    //Activate/Deactivate button when a correct data is entered in a text-field
    public void keyReleased(KeyEvent e) {
        if(e.getSource().equals(txtName)){
            btnProcess.setEnabled(!txtName.getText().isEmpty()
                    && !txtAge.getText().isEmpty() && !txtCourse.getText().isEmpty());
        }
        if(e.getSource().equals(txtAge)){
            btnProcess.setEnabled(!txtName.getText().isEmpty()
                    && !txtAge.getText().isEmpty() && !txtCourse.getText().isEmpty());
        }
        if(e.getSource().equals(txtCourse)){
            btnProcess.setEnabled(!txtName.getText().isEmpty()
                    && !txtAge.getText().isEmpty() && !txtCourse.getText().isEmpty());
        }
        if(e.getSource().equals(txtPosition)){
            btnProcess.setEnabled(!txtPosition.getText().isEmpty());
        }
    }
    public void keyTyped(KeyEvent e) {
        if(e.getSource().equals(txtPosition)){
            if(!(Character.isDigit(e.getKeyChar()))){
                e.consume();
            }
        }
        if(e.getSource().equals(txtName)){
            if(!(Character.isAlphabetic(e.getKeyChar()))){
                e.consume();
            }
        }
        if(e.getSource().equals(txtAge)){
            if(!(Character.isDigit(e.getKeyChar()))){
                e.consume();
            }
        }
        if(e.getSource().equals(txtCourse)){
            if(!(Character.isAlphabetic(e.getKeyChar()))){
                e.consume();
            }
        }
    }
}
