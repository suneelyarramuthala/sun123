import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
public class InputChecking extends MIDlet implements CommandListener {
 public Form form1;
 public TextField textfield1;
 public Command exitCommand;
 public Command okCommand;
 public StringItem st;
 public Display display;
 public InputChecking()
 {
 display=Display.getDisplay(this);
 form1=new Form("Insert the Phone number");
 exitCommand=new Command("Exit",Command.EXIT,1);
 okCommand=new Command("Ok",Command.OK,1);
 st=new StringItem("Phone Number is ","");
 textfield1=new TextField("Phone;","",30,TextField.ANY);
 form1.append(textfield1);
 form1.addCommand(okCommand);
 form1.addCommand(exitCommand);
 form1.setCommandListener(this);
 }
 public void startApp() {
 display.setCurrent(form1);
 }
 public void pauseApp() {
 }
 public void destroyApp(boolean unconditional) {
 }
 public void commandAction(Command cmd,Displayable displayable)
 {
 if(cmd==exitCommand)
 notifyDestroyed();
 else if(cmd==okCommand)
 {
 String s=textfield1.getString();
 s=s.replace(' ', '.');
 
 int len=s.length();
 int i=0;
 int c=0;
 
 String s1="";
 while(i<len) { 
 
 if(s.charAt(i)=='.') 
 { 
 if(c==0)
 { 
 if(s1.equals("040") || s1.equals("041") || s1.equals("050") || s1.equals("0400") || 
s1.equals("044"))
 {
 c++; 
 s1="";
 }
 }
 if(c==1)
 {
 
 if(s1.length()-1==3)
 {
 c++;
 s1="";
 }
}
 }
 s1=s1+s.charAt(i);
 i++;
 }
 if(s1.length()-1==3 || s1.length()-1==4 || s1.length()-1==5)
 c++; 
 if(c==3)
 st.setText("OK");
 else
 {
 st.setText("wrong\n Phone Number Format is xxx xxx xxxx\nArea code must be 040|050|041|0400|044");
 }
 form1.append(st);
 } }
}
