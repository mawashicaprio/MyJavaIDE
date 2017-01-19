import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.datatransfer.*;
import java.util.*;
import javax.swing.*;
class javaIde extends Frame implements ActionListener,ItemListener
{
    TextArea ta1,ta2;
    CheckboxMenuItem m61,m62;
    TextField t1,t2,t3;
    Toolkit tk;
    Dialog d1;
    String cs,sf;
    Choice c,c1,c2,c3;
    Scrollbar s1,s2,s3;
    int sso=0;
    static int r,g,b,r1,g1,b1,ip;
    javaIde()
    {
    super("JPDK 1.0 - Untitled");
    setSize(1000,800);
    setLayout(null);
    setBackground(Color.gray);
    menusetup();
    ctrlsetup();
    setVisible(true);
//javaIde().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

void ctrlsetup()
{
    tk=getToolkit();
    ta1=new TextArea(1000,800);
    ta1.setBackground(Color.white);
    ta2=new TextArea(1000,800);
    ta2.setBackground(Color.white);    
    ta1.setBounds(5,43,990,480);
    ta2.setBounds(5,560,990,194);
    ta2.setEditable(false);
    add(ta1);
    add(ta2);
}

void menusetup()
{
   try{
    MenuBar mb=new MenuBar();
    Menu m1=new Menu("File");
    Menu m2=new Menu("Edit");
    Menu m3=new Menu("Search");
    Menu m4=new Menu("Format");
    Menu m5=new Menu("Run");
    Menu m6=new Menu("Window");
    Menu m7=new Menu("Help");

    MenuItem m11=new MenuItem("New");
    MenuItem m14=new MenuItem("Open");
    MenuItem m12=new MenuItem("Save");
    MenuItem m13=new MenuItem("Save As");
    MenuItem m15=new MenuItem("Close");
    MenuItem m16=new MenuItem("Quit");

    MenuItem m21=new MenuItem("Undo");
    MenuItem m22=new MenuItem("Cut");
    MenuItem m23=new MenuItem("Copy");
    MenuItem m24=new MenuItem("Paste");
    MenuItem m25=new MenuItem("Clear");
    MenuItem m26=new MenuItem("Select All");

    MenuItem m31=new MenuItem("Find");
    MenuItem m32=new MenuItem("Find Next");

    MenuItem m41=new MenuItem("Font");
    Menu m42=new Menu("Colors");
    MenuItem m421=new MenuItem("ForeColor");
    MenuItem m422=new MenuItem("BackColor");
    m42.add(m421);
    m42.add(m422);

    MenuItem m51=new MenuItem("Compile");
    MenuItem m52=new MenuItem("Application");
    MenuItem m53=new MenuItem("Applet");
    MenuItem m55=new MenuItem("IExplorer");
    MenuItem m56=new MenuItem("Ms-Access");
    

    m61=new CheckboxMenuItem("Full Screen");
    m62=new CheckboxMenuItem("Output Window",true);
    m61.addItemListener(this);
    m62.addItemListener(this);
 MenuItem m72=new MenuItem("About JPDK 1.0");


    m1.add(m11);
    m1.add(m14);
    m1.add(m12);   
    m1.add(m13);
    m1.add(m15);
    m1.addSeparator();
    m1.add(m16);

    m2.add(m21);
    m2.addSeparator();
    m2.add(m22);
    m2.add(m23);
    m2.add(m24);
    m2.add(m25);
    m2.addSeparator();
    m2.add(m26);

    m3.add(m31);
    m3.add(m32);

    m4.add(m41);
    m4.add(m42);

    m5.add(m51);
    m5.addSeparator();
    m5.add(m52);
    m5.add(m53);
    m5.add(m55);
    m5.addSeparator();
    m5.add(m56);

    m6.add(m61);
    m6.add(m62);
 
    m7.add(m72);

    mb.add(m1);
    mb.add(m2);
    mb.add(m3);
    mb.add(m4);
    mb.add(m5);
    mb.add(m6);
    mb.add(m7);
    setMenuBar(mb);

    m1.addActionListener(this);
    m2.addActionListener(this);
    m3.addActionListener(this);
    m4.addActionListener(this);
    m5.addActionListener(this);
    m6.addActionListener(this);
    m7.addActionListener(this);
    m42.addActionListener(this);
    }
    catch(Exception e){}
    
}

public void itemStateChanged(ItemEvent e)
{
       if(m61.getState())
       {
        ta1.setBounds(5,43,990,745);
        m62.setState(false);
        validate();
       }
       else
       {
        ta1.setBounds(5,43,990,480);
        validate();
       }
       if(m62.getState())
       {
         ta2.setVisible(true);
        validate();
       }
       else
       {
        ta2.setVisible(false);
        validate();
       }
}

public void actionPerformed(ActionEvent e)
{
    String s=e.getActionCommand();

    if (s=="New")
    {
      ta1.setText("");
      d1=new Dialog(this,"New ... ",true);
      d1.setLocation(300,300);
      d1.setSize(250,90);
      d1.setLayout(new FlowLayout());
      d1.add(new Label("Select the File Type"));
      c=new Choice();
      c.add("Application");
      c.add("Applet");
      c.add("Frame");
      c.add("Swing");
      c.add("JDBC");
      c.add("HTML");
      d1.add(c);
      Button b1=new Button("Start");
      Button b2=new Button("Cancel");
      d1.add(b1);
      d1.add(b2);

      b1.addActionListener(new ActionListener()
      {
      public void actionPerformed(ActionEvent v)
      {
      String xx=c.getSelectedItem();
      String title=getTitle().substring(11,getTitle().length()-5);      
    
      if(xx=="Application")
      {
         String s1="import java.lang.*;";
         FileDialog fd=new FileDialog(new javaIde(),"Save Application",FileDialog.SAVE);
         fd.setVisible(true);
         setTitle("JPDK 1.0 - " + new File(fd.getFile()) + ".java");
         title=getTitle().substring(11,getTitle().length()-5);
         s1+="\nclass " + title;
         s1+="\n{\n\tpublic static void main(String args[])";
         s1+="\n\t{\n\n\n\t}\n}";
         ta1.setText(s1);
      }
      if(xx=="Frame")
      {
         String s1="import java.awt.*;";
         s1+="\nimport java.awt.event.*;";
         s1+="\nclass frame1 extends Frame";
         s1+="\n{\n\tpublic frame1()\n\t{";
         s1+="\n\tsuper(\"My Frame\");";
         s1+="\n\tsetSize(300,300);";
         s1+="\n\tsetLayout(new FlowLayout());";
         s1+="\n\taddWindowListener(new WindowAdapter()";
         s1+="\n\t{\n\tpublic void windowClosing(WindowEvent we){";
         s1+="\n\tSystem.exit(0);";
         s1+="\n\n\t}});";
         s1+="\n\tsetVisible(true);\n\t}\n}";
         FileDialog fd=new FileDialog(new javaIde(),"Save Frame",FileDialog.SAVE);
         fd.setVisible(true);
         setTitle("JPDK 1.0 - " + new File(fd.getFile()) + ".java");
         title=getTitle().substring(11,getTitle().length()-5);
         s1+="\nclass " + title;
         s1+="\n{\n\tpublic static void main(String args[])";
         s1+="\n\t{\n\tnew frame1();\n\t}\n}";
         ta1.setText(s1);
      }


      if(xx=="Applet")
      {
         String s1="import java.awt.*;";
         s1+="\nimport java.awt.event.*;";
         s1+="\nimport java.applet.*;";    
         FileDialog fd=new FileDialog(new javaIde(),"Save Applet",FileDialog.SAVE);
         fd.setVisible(true);
         setTitle("JPDK 1.0 - " + new File(fd.getFile()) + ".java");
         title=getTitle().substring(11,getTitle().length()-5);
         s1+="\n//<applet code "+title+".class";
         s1+="\npublic class " + title + " extends Applet";
         s1+="\n{\n\tpublic void init()\n\t{\n\n\n\t}";
         s1+="\n\tpublic void start()\n\t{\n\n\n\t}";
         s1+="\n\tpublic void paint(Graphics g)\n\t{\n\n\n\t}";
         s1+="\n\tpublic void stop()\n\t{\n\n\n\t}";
         s1+="\n\tpublic void destroy()\n\t{\n\n\n\t}\n}";
         ta1.setText(s1);
      }
if(xx=="Swing")
      {
         String s1="import java.awt.*;";
         s1+="\nimport java.awt.event.*;";
         s1+="\nimport javax.swing.*;";    
         FileDialog fd=new FileDialog(new javaIde(),"Save Applet",FileDialog.SAVE);
         fd.setVisible(true);
         setTitle("JPDK 1.0 - " + new File(fd.getFile()) + ".java");
         title=getTitle().substring(11,getTitle().length()-5);
         s1+="\n//<applet code "+title+".class";
         s1+="\npublic class " + title + " extends JApplet";
         s1+="\n{\n\tpublic void init()\n\t{\n\n\n\t";
         s1+="\tContainer con=getContentPane();";
         s1+="\n\n\tcon.add()\n\n\t}";
         s1+="\n}";
         ta1.setText(s1);
}


      if(xx=="JDBC")
      {
         String s1="import java.sql.*;";
         s1+="\nimport java.io.*;";
         FileDialog fd=new FileDialog(new javaIde(),"Save JDBC",FileDialog.SAVE);
         fd.setVisible(true);
         setTitle("JPDK 1.0 - " + fd.getFile() + ".java");
         title=getTitle().substring(11,getTitle().length()-5);
         s1+="\npublic class " + title;
         s1+="\n{\n\tpublic static void main(String ar[]) throws Exception";
         s1+="\n\t{\n\tClass.forName(\"sun.jdbc.odbc.JdbcOdbcDriver\");";
         s1+="\n\tConnection cn=DriverManager.getConnection(\"jdbc:odbc:dsnname\");";
         s1+="\n\tStatement st=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);";
         s1+="\n\tResultSet rs=st.executeQuery(\"select * from tablename\");";
         s1+="\n\n\n\t}\n}";
         ta1.setText(s1);
      }


      if(xx=="HTML")
      {
         FileDialog fd=new FileDialog(new javaIde(),"Save HTML",FileDialog.SAVE);
         fd.setVisible(true);
         setTitle("JPDK 1.0 - " +fd.getDirectory()+ fd.getFile() + ".html");
          title=getTitle().substring(11,getTitle().length()-5);
         String s1="<html>";
         s1+="\n<head>";
         s1+="\n<title> Web page </title>";
         s1+="\n</head>";
         s1+="\n<body>";
         s1+="\n\n\n\n";
         s1+="\n</body>";
         s1+="\n</html>";
         ta1.setText(s1);
      }


      ta1.requestFocus();
      d1.dispose();
      }
      });
      b2.addActionListener(new ActionListener()
      {
      public void actionPerformed(ActionEvent v)
      {
      d1.dispose();
      }
      });
      d1.setVisible(true);
    }

    if (s=="Open")
    {
ta2.setText("");
      FileDialog fd=new FileDialog(this,"File Open ...",FileDialog.LOAD);
      fd.setVisible(true);
      setTitle("JPDK 1.0 - " + new File(fd.getFile()));
      try{
      FileInputStream ds=new FileInputStream(fd.getFile());
      int c;
      ta1.setText("");
      String sx="";
      while((c=ds.read())!=-1)
        sx=sx+(char)c;
      ta1.setText(sx);
      }catch(Exception se){}
    }

    if (s=="Save")
    {
    String t=getTitle();
    File ff;
    if (t=="JPDK 1.0 - Untitled")
    {
       FileDialog fd=new FileDialog(this,"File Saving...",FileDialog.SAVE);
       fd.setVisible(true);
       ff=new File(fd.getFile());
    }
    else
    {
       ff=new File(t.substring(11,t.length()));
    }
    try{
    PrintWriter pw = new PrintWriter(new FileOutputStream(ff),true);
    pw.println(ta1.getText());
    }catch(Exception fe){};
    setTitle("JPDK 1.0 - " + ff);
    }


    if (s=="Save As")
    {
    String t=getTitle();
    File ff;
    FileDialog fd;
    if (t=="JPDK 1.0 - Untitled")
       fd=new FileDialog(this,"Save...",FileDialog.SAVE);
    else
       fd=new FileDialog(this,"Save As ...",FileDialog.SAVE);
    fd.setVisible(true);
    ff=new File(fd.getFile());
    try{
    PrintWriter pw = new PrintWriter(new FileOutputStream(ff),true);
    pw.println(ta1.getText());
    }catch(Exception fe){};
    setTitle("JPDK 1.0 - " + ff);
    }

   if(s=="Close")
   {
      setTitle("JPDK1.0 - Untitled");
      ta1.setText("");
ta2.setText("");
      ta1.requestFocus();
   }

   if(s=="Quit")
          System.exit(0);

   if (s=="Undo")
   {
   ta1.setText(cs);
   }

   if(s=="Cut")
   {
       String s1=ta1.getSelectedText();
       String b=ta1.getText();
       cs=ta1.getText();
       b=ta1.getText().substring(0,ta1.getCaretPosition());
       b=b+ta1.getText().substring(ta1.getCaretPosition()+ta1.getSelectedText().length(),ta1.getText().length());
       ta1.setText(b);
       StringSelection ss=new StringSelection(s1);
       Clipboard cl=tk.getSystemClipboard();
       cl.setContents(ss,ss);
   }

   if (s=="Copy")
   {
      String s1=ta1.getSelectedText();
      StringSelection ss=new StringSelection(s1);
      Clipboard cl=tk.getSystemClipboard();
      cl.setContents(ss,ss);
    }

    if (s=="Paste")
    {
    String dat="";
    Clipboard cl=tk.getSystemClipboard();
    Transferable con=cl.getContents(this);
    try{
       dat=(String) con.getTransferData(DataFlavor.stringFlavor);
       }
    catch(Exception ex){}
   StringBuffer tt=new StringBuffer(ta1.getText());
   tt.insert(ta1.getCaretPosition(),dat);
   ta1.setText(tt.toString());
   }

   if(s=="Clear")
   {
        String s1=ta1.getSelectedText();
        String b=ta1.getText();
        cs =ta1.getText();
        b=ta1.getText().substring(0,ta1.getCaretPosition());
        b=b+ta1.getText().substring(ta1.getCaretPosition()+ta1.getSelectedText().length(),ta1.getText().length());
        ta1.setText(b);
    }
   
    if (s=="Select All")
    {
      ta1.select(0,ta1.getText().length());
    }
   
    if (s=="Find")
    {
      d1=new Dialog(this,"Find ... ",true);
      d1.setLocation(300,300);
      d1.setSize(250,90);
      d1.setLayout(new FlowLayout());
      d1.add(new Label("Enter the Text to Find"));
      t3=new TextField(10);
      d1.add(t3);
      Button b1=new Button("Find");
      Button b2=new Button("Cancel");
      d1.add(b1);
      d1.add(b2);
      b1.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent we)
        {
        sf=t3.getText();
        String tst=ta1.getText();
        int az=tst.indexOf(sf,sso);
        ta1.select(az,az+sf.length());
        sso=az+sf.length();
        d1.dispose();
        }
      });
      b2.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent we)
        {
        d1.dispose();
        }
      });

      d1.setVisible(true);
    }

    if (s=="Find Next")
    {
     sf=t3.getText();
     String tst=ta1.getText();
     int len=ta1.getText().length();
     int az=0;
     if(sso<=len)
     {az=tst.indexOf(sf,sso);
        ta1.select(az,az+sf.length());
 sso=az+sf.length();
     }
     else
     {
       sso=0;
     ta1.select(az,az);
     }
     //ta1.select(az,az+sf.length());
    // sso=az+sf.length();
    }

    if(s=="Font")
    {
     d1=new Dialog(this,"Fonts .... ",true);
     d1.setLocation(250,200);
     d1.setSize(300,100);
     d1.setLayout(new FlowLayout());
     c1=new Choice();
     String FontList[];
     GraphicsEnvironment ge=GraphicsEnvironment.getLocalGraphicsEnvironment();
     FontList=ge.getAvailableFontFamilyNames();
     for(int i=0;i<FontList.length;i++)
       c1.add(FontList[i]);
     d1.add(c1);
     c2=new Choice();
     for(int i=8;i<=60;i+=2)
       c2.add(i+"");
     d1.add(c2);
     c3=new Choice();
     c3.add("Normal");
     c3.add("Bold");
     c3.add("Italic");
     c3.add("Both");
     d1.add(c3);
     Button b1=new Button("OK");
     Button b2=new Button("Cancel");
     d1.add(b1);
     d1.add(b2);
     b1.addActionListener(new ActionListener()
     {
        public void actionPerformed(ActionEvent e)
        {
        d1.dispose();
        String s1=c1.getSelectedItem();
        int s2=Integer.parseInt(c2.getSelectedItem());
        String s3=c3.getSelectedItem();
        String s4="";
        if (s3=="Normal")
        {
        ta1.setFont(new Font(s1,Font.PLAIN,s2));
        ta2.setFont(new Font(s1,Font.PLAIN,s2));
        }
        else if(s3=="Bold")
        {
        ta1.setFont(new Font(s1,Font.BOLD,s2));
        ta2.setFont(new Font(s1,Font.BOLD,s2));
        }
        else if(s3=="Italic")
        {
        ta1.setFont(new Font(s1,Font.ITALIC,s2));
        ta2.setFont(new Font(s1,Font.ITALIC,s2));
        }
        else if(s3=="Both")
        {
        ta1.setFont(new Font(s1,Font.ITALIC+Font.BOLD,s2));
        ta2.setFont(new Font(s1,Font.ITALIC+Font.BOLD,s2));
        }

        }
     });
     b2.addActionListener(new ActionListener()
     {
        public void actionPerformed(ActionEvent e)
        {
        d1.dispose();
        }
     });
     d1.setVisible(true);
    }

    if(s=="BackColor")
    {
     d1=new Dialog(this,"Colors .... ",true);
     d1.setLocation(200,250);
     d1.setSize(280,220);
     d1.setLayout(null);
     s1=new Scrollbar(Scrollbar.HORIZONTAL,0,10,0,255);
     s2=new Scrollbar(Scrollbar.HORIZONTAL,0,10,0,255);
     s3=new Scrollbar(Scrollbar.HORIZONTAL,0,10,0,255);
     Label l1=new Label("Red");
     Label l2=new Label("Green");
     Label l3=new Label("Blue");
     t1=new TextField(10);
     t1.setText("Sample");
     l1.setBounds(10,37,100,10);
     s1.setBounds(10,50,150,25);
     l2.setBounds(10,77,100,10);
     s2.setBounds(10,90,150,25);
     l3.setBounds(10,117,100,10);
     s3.setBounds(10,130,150,25);
     s1.addAdjustmentListener(new AdjustmentListener()
     {
        public void adjustmentValueChanged(AdjustmentEvent e)
        {
        r=s1.getValue();
        t1.setBackground(new Color(r,g,b));
        }
     });
     s2.addAdjustmentListener(new AdjustmentListener()
     {
        public void adjustmentValueChanged(AdjustmentEvent e)
        {
        g=s2.getValue();
        t1.setBackground(new Color(r,g,b));
        }
     });
     s3.addAdjustmentListener(new AdjustmentListener()
     {
        public void adjustmentValueChanged(AdjustmentEvent e)
        {
        b=s3.getValue();
        t1.setBackground(new Color(r,g,b));
        }
     });
     t1.setBounds(165,75,75,60);
     t1.setEnabled(false);
     d1.add(l1);
     d1.add(l2);
     d1.add(l3);
     d1.add(s1);
     d1.add(s2);
     d1.add(s3);
     d1.add(t1);
     Button b1=new Button("OK");
     Button b2=new Button("Cancel");
     b1.setBounds(60,180,50,25);
     b2.setBounds(120,180,50,25);
     d1.add(b1);
     d1.add(b2);
     b1.addActionListener(new ActionListener()
     {
        public void actionPerformed(ActionEvent e)
        {
        ta1.setBackground(new Color(r,g,b));
        ta2.setBackground(new Color(r,g,b));
        d1.dispose();
        }
     });
     b2.addActionListener(new ActionListener()
     {
        public void actionPerformed(ActionEvent e)
        {
            d1.dispose();
        }
     });
      d1.setVisible(true);
     }

    if(s=="ForeColor")
    {
     d1=new Dialog(this,"Colors .... ",true);
     d1.setLocation(200,250);
     d1.setSize(280,220);
     d1.setLayout(null);
    s1=new Scrollbar(Scrollbar.HORIZONTAL,0,10,0,255);
     s2=new Scrollbar(Scrollbar.HORIZONTAL,0,10,0,255);
     s3=new Scrollbar(Scrollbar.HORIZONTAL,0,10,0,255);
     Label l1=new Label("Red");
     Label l2=new Label("Green");
     Label l3=new Label("Blue");
     t1=new TextField(10);
     t1.setFont(new Font("Impact",Font.BOLD,30));
     t1.setText("Aa");
     l1.setBounds(10,37,100,10);
     s1.setBounds(10,50,150,25);
     l2.setBounds(10,77,100,10);
     s2.setBounds(10,90,150,25);
     l3.setBounds(10,117,100,10);
     s3.setBounds(10,130,150,25);
     s1.addAdjustmentListener(new AdjustmentListener()
     {
        public void adjustmentValueChanged(AdjustmentEvent e)
        {
        r1=s1.getValue();
        t1.setForeground(new Color(r1,g1,b1));
        }
     });
     s2.addAdjustmentListener(new AdjustmentListener()
     {
        public void adjustmentValueChanged(AdjustmentEvent e)
        {
        g1=s2.getValue();
        t1.setForeground(new Color(r1,g1,b1));
        }
     });
     s3.addAdjustmentListener(new AdjustmentListener()
     {
        public void adjustmentValueChanged(AdjustmentEvent e)
        {
        b1=s3.getValue();
        t1.setForeground(new Color(r1,g1,b1));
        }
     });
     t1.setBounds(165,75,75,60);
     t1.setEditable(false);
     d1.add(l1);
     d1.add(l2);
     d1.add(l3);
     d1.add(s1);
     d1.add(s2);
     d1.add(s3);
     d1.add(t1);
     Button b11=new Button("OK");
     Button b2=new Button("Cancel");
     b11.setBounds(60,180,50,25);
     b2.setBounds(120,180,50,25);
     d1.add(b11);
     d1.add(b2);
     b11.addActionListener(new ActionListener()
     {
        public void actionPerformed(ActionEvent e)
        {
        ta1.setForeground(new Color(r1,g1,b1));
        ta2.setForeground(new Color(r1,g1,b1));
        d1.dispose();
        }
     });
     b2.addActionListener(new ActionListener()
     {
        public void actionPerformed(ActionEvent e)
        {
            d1.dispose();
        }
     });
      s1.requestFocus();
      d1.setVisible(true);
     }

    
    if (s=="Compile")
    {
    try{
    String r = getTitle().substring(11,getTitle().length());
System.out.println(getTitle().substring(0,getTitle().length()));
    Runtime rt =Runtime.getRuntime();
    Process p =rt.exec("javac  "+r); 
    p.waitFor();
    int i =p.exitValue();
    InputStream ip =p.getErrorStream();
    int a =ip.available();
    ta2.setText("");
    ta2.setText("Compiling ...."  +"\n\n");
    if(a==0)
    ta2.setText(ta2.getText()+"Good !!. There is no error in your Program\n");
    else
    {
       int c;
       String ts=ta2.getText();
       while((c =ip.read()) != -1)
       {
       ts=ts+(char) c;
       }
       ta2.setText(ts);
    }
    }catch(Exception ex){}
    }

    if(s =="Application")
    {
    String r = getTitle().substring(11,getTitle().length()-5);
    try
    {
    Runtime t =Runtime.getRuntime();
    Process p=t.exec("java  "+r);
    p.waitFor();
    int i =p.exitValue();
    InputStream ip =p.getInputStream();
    int a =ip.available();
    ta2.setText("Output of " + r + ".java  ...... \n\n");
    String ts=ta2.getText();
    if(a!=0)
    {
    int c;
    while((c =ip.read()) != -1)
    {
      ts=ts+(char) c;
    }
    ta2.setText(ts);
    }
    else
       ta2.setText("Program Successfully Executed");
    }catch(Exception eq){}
    }

    if(s =="Applet")
    {
    String r = getTitle().substring(11,getTitle().length());
    try
    {
    Runtime t =Runtime.getRuntime();
    Process p=t.exec("appletviewer "+r);
    p.waitFor();
    int i =p.exitValue();
    InputStream ip =p.getInputStream();
    int a =ip.available();
    ta2.setText("Applet Executed");
    String ts=ta2.getText();
    int c;
    while((c =ip.read()) != -1)
    {
      ts=ts+(char) c;
    }
    ta2.setText(ts);
    }catch(Exception eq){}
    }

    if(s =="IExplorer")
    {
    	
    try{
    	
     String r =getTitle().substring(11,getTitle().length()); 
System.out.println(r);
    Runtime t =Runtime.getRuntime();
    String result ="C:/Program Files/Internet Explorer/IEXPLORE.EXE "+"D:/projects/"+r;
System.out.println(r);
    Process p=t.exec(result);
    p.waitFor();
    int i =p.exitValue();
    }catch(Exception ip){}
    }

    if(s=="Ms-Access")
    {
    try{
    Runtime t =Runtime.getRuntime();
    Process p=t.exec("c:/Program files/Microsoft office/Office12/MSACCESS.exe");
    p.waitFor();
    int i =p.exitValue();
    }catch(Exception ip){}
    }

    if(s=="Oracle8.0")
    {
    try{
    Runtime t =Runtime.getRuntime();
    Process p=t.exec("d:/oracle/ora81/bin/sqlplusw");
    p.waitFor();
    int i =p.exitValue();
    }catch(Exception ip){}
    }


    if(s=="About JPDK 1.0")
    {
     d1=new Dialog(this,"About JPDK 1.0",true);
     d1.setLocation(100,100);
     d1.setSize(400,500);
     d1.setLayout(null);
     Label l1=new Label("Sun JPDK 1.0");
     Label l2=new Label("Windows 98");
     Label l3=new Label("This Product is licensed to");
     Label l4=new Label("");
     Label l5=new Label("");
     Label l6=new Label("");
     Button b1=new Button("OK");
     l1.setBounds(50,50,100,25);
     l2.setBounds(50,75,100,25);
     l3.setBounds(50,150,200,25);
     l4.setBounds(50,190,200,25);
     l5.setBounds(50,220,100,25);
     l6.setBounds(50,260,100,25);
   
     b1.setBounds(150,425,50,50);
     d1.add(l1);
     d1.add(l2);
     d1.add(l3);
     d1.add(l4);
     d1.add(l5);
     d1.add(l6);
     d1.add(b1);
     b1.addActionListener(new ActionListener()
     {
        public void actionPerformed(ActionEvent we)
        {
        d1.dispose();
        }
      });
     d1.setVisible(true);
     
    }
 }    

}
public class javaEditor extends javaIde
{
    public static void main(String ar[])throws Exception
    {
        javaIde f=new javaIde();
            


    }
}



