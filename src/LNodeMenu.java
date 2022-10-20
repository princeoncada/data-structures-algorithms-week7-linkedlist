import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
public class LNodeMenu extends JFrame implements ActionListener,ItemListener, KeyListener{
    private final JLabel lblChoose;
    private final JLabel lblValue;
    private final JLabel lblPosition;
    private final JTextField txtValue;
    private final JTextField txtPosition;
    private final JComboBox cboChoose;
    private final JTextArea txtAreaUp;
    private final JTextArea txtAreaDown;
    private final JButton btnProcess;
    private final JButton btnClose;
    private final LNode myNode;
    String hold="";
    LNodeMenu(){
        myNode=new LNode();
        lblChoose=new JLabel("Choose");
//Create menu List
        String[] menu ={"Add At First","Add At Position","Add At Last",
                "Delete At First","Delete At Position","Delete At Last",
                "Get First","Get At Position","IndexAt","Get Last","addInMiddle","deleteInMiddle"};
        cboChoose=new JComboBox(menu); //Load menu list to comboBox
        txtAreaUp=new JTextArea();
        txtAreaDown=new JTextArea();
        btnProcess=new JButton("Process");
        btnClose=new JButton("Close");
        lblValue=new JLabel("Value");
        lblPosition=new JLabel("Position");
        txtValue=new JTextField();
        txtPosition=new JTextField();
        txtPosition.setEditable(false);
        setTitle("LinkedList Application");
        setSize(400, 300);
//Setbackground of the Frame
        getContentPane().setBackground(new Color(100,50,90,80));
        setLayout(null);
//Sets the textfield or text area disabled for editing
        txtAreaUp.setEditable(false);
        txtAreaDown.setEditable(false);
//Obervers for LNode
        hold="Empty\t: "+myNode.isEmpty()+"\tCurrent Size\t: "+myNode.currentSize();
        txtAreaUp.setText(hold);
//Positioning each component to Frame
        add(txtAreaUp).setBounds(20,20,330,20);
        add(new JScrollPane(txtAreaDown)).setBounds(20,40,330,100);
        add(lblChoose).setBounds(20,140,60,20);
        add(cboChoose).setBounds(80,140,150,20);
        add(btnProcess).setBounds(240,140,110,60);
        add(lblValue).setBounds(20,160,100,20);
        add(lblPosition).setBounds(20,180,100,20);
        add(txtValue).setBounds(80,160,150,20);
        add(txtPosition).setBounds(80,180,150,20);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//Invoke event -click
        btnProcess.addActionListener(this);
        cboChoose.addItemListener(this);
        txtPosition.addKeyListener(this);
        txtValue.addKeyListener(this);
        btnProcess.setEnabled(false);
    }
    public static void main(String[] args) {
        new LNodeMenu();
    }
    public void actionPerformed(ActionEvent e) {
//returns index value of a comboBox
        int i=cboChoose.getSelectedIndex();
//String item=cboChoose.getSelectedItem().toString();
        int pos;
//selection for ech index
        if(i==0){
            myNode.addAtFirst(txtValue.getText());
        }else if(i==1){
            pos=Integer.parseInt(txtPosition.getText());
            myNode.addAtPosition(txtValue.getText(),pos);
        }else if(i==2){
            myNode.addAtLast(txtValue.getText());
        }else if(i==3){
            myNode.deleteAtFirst();
        }else if(i==4){
            pos=Integer.parseInt(txtPosition.getText());
            myNode.deleteAtPosition(pos);
        }else if(i==5){
            myNode.deleteAtLast();
        }else if(i==6){
            JOptionPane.showMessageDialog(null, myNode.getFirst());
        }else if(i==7){
            pos=Integer.parseInt(txtPosition.getText());
            JOptionPane.showMessageDialog(null, myNode.get(pos ));
        }else if(i==8){
            JOptionPane.showMessageDialog(null, myNode.getLast());
        }
//display the elements of Linkedlist to tetxArea
        txtAreaDown.setText(myNode.traverse());
//clear the text area
        txtPosition.setText("");
        txtValue.setText("");
        hold="Empty\t: "+myNode.isEmpty()+"\tCurrent Size\t: "+myNode.currentSize();
        txtAreaUp.setText(hold);
        btnProcess.setEnabled(false);
    }
    //Activate/Deactivate components (textfields) based on combobox selection
    public void itemStateChanged(ItemEvent e) {
        int i=cboChoose.getSelectedIndex();
        if(i==0){
            disable(); //call disable method when first value of combobox is selected
        }else if(i==1){
            enable(); //call enable method when second value of combobox is selected
        }else if(i==2){ disable();
        }else if(i==3){
            disableAll();
            btnProcess.setEnabled(true);
        }else if(i==4){
            disableAll();
            btnProcess.setEnabled(true);
            txtPosition.setEditable(true);
        }else if(i==5){
            disableAll();
            btnProcess.setEnabled(true);
        }else if(i==6){
            btnProcess.setEnabled(true);
            disableAll();
        }else if(i==7){
            enable();
            btnProcess.setEnabled(true);
            txtValue.setEditable(false);
        }else if(i==8){
            disableAll();
            btnProcess.setEnabled(true);
        }
    }
    public void enable(){
        txtValue.setEditable(true);
        txtPosition.setEditable(true);
    }
    public void disable(){
        txtValue.setEditable(true);
        txtPosition.setEditable(false);
    }
    public void disableAll(){
        txtValue.setEditable(false);
        txtPosition.setEditable(false);
    }
    public void keyPressed(KeyEvent arg0) { }
    //Activate/Deactivate button when a correct data is entered in a textfield
    public void keyReleased(KeyEvent e) {
        if(e.getSource().equals(txtValue)){
            btnProcess.setEnabled(!txtValue.getText().isEmpty());
        }else if(e.getSource().equals(txtPosition)){
            btnProcess.setEnabled(!txtPosition.getText().isEmpty());
        }
    }
    public void keyTyped(KeyEvent e) {
        if(e.getSource().equals(txtPosition)){
            if(!(Character.isDigit(e.getKeyChar()))){
                e.consume();
            }
        }else if(e.getSource().equals(txtValue)){
            if(!(Character.isAlphabetic(e.getKeyChar()))){
                e.consume();
            }
        }
    }
}
