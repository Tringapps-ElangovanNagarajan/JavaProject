package OnlineQuizPortal;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class OnlineQuizPortal extends JFrame implements ActionListener
{
	JLabel jlb;
	JRadioButton jrb[]=new JRadioButton[5];
	JButton button1,button2;
	ButtonGroup bg;
	int count=0,cur=0,temp=0,a=1,b=1;
	int bm[]=new int[10];	
	OnlineQuizPortal(String str)
	{
		super(str);
		jlb=new JLabel();
		add(jlb);
		bg=new ButtonGroup();
		for(int i=0;i<5;i++)
		{
			jrb[i]=new JRadioButton();	
			add(jrb[i]);
			bg.add(jrb[i]);
		}
		button1=new JButton("Next Question");
		button2=new JButton("Bookmark");
		button1.addActionListener(this);
		button2.addActionListener(this);
		add(button1);
		add(button2);
		setQuestion();
		jlb.setBounds(30,40,550,20);
		jrb[0].setBounds(80,80,450,20);
		jrb[1].setBounds(80,110,450,20);
		jrb[2].setBounds(80,140,450,20);
		jrb[3].setBounds(80,170,450,20);
		button1.setBounds(100,250,150,25);
		button2.setBounds(450,250,150,25);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250,100);
		setVisible(true);
		setSize(900,550);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==button1)
		{
			if(checkAnswer())
				count=count+1;
			cur++;
			setQuestion();	
			if(cur==9)
			{
				button1.setEnabled(false);
				button2.setText("Result");
			}
		}
		if(ae.getActionCommand().equals("Bookmark"))
		{
			JButton bk=new JButton("Bookmark"+a);
			bk.setBounds(700,20+30*a,135,25);
			add(bk);
			bk.addActionListener(this);
			bm[a]=cur;
			a++;
			cur++;
			setQuestion();	
			if(cur==9)
				button2.setText("Result");
			setVisible(false);
			setVisible(true);
		}
		for(int i=0,j=1;i<a;i++,j++)
		{
		if(ae.getActionCommand().equals("Bookmark"+j))
		{
			if(checkAnswer())
				count=count+1;
			temp=cur;
			cur=bm[j];
			setQuestion();
			((JButton)ae.getSource()).setEnabled(false);
			cur=temp;
		}
		}
	
		if(ae.getActionCommand().equals("Result"))
		{
			if(checkAnswer())
				count=count+1;
			cur++;
		
			JOptionPane.showMessageDialog(this,"Your total mark out of 10 is "+count);
			System.exit(0);
		}
	}

	void setQuestion()
	{
		jrb[4].setSelected(true);
		if(cur==0)
		{
			jlb.setText("Q1 : What Is Bundle In IOS");
			jrb[0].setText("It is a Class");
			jrb[1].setText("It is used to send sata");
			jrb[2].setText("It is folder with .app Extension");
			jrb[3].setText("None Of Above");	
		}
		if(cur==1)
		{
			jlb.setText("Q2 : Which Of The Following Declares A Mutable Array In Swift?");
			jrb[0].setText("Let X=[Int]()");
			jrb[1].setText("Var X=[Int]");
			jrb[2].setText("Var X=[Int]()");
			jrb[3].setText("Let X=[Int]");
		}
		if(cur==2)
		{
			jlb.setText("Q3 : The IDE Used In Swift Is");
			jrb[0].setText("XCode");
			jrb[1].setText("Ld");
			jrb[2].setText("Gas");
			jrb[3].setText("SwiftC");
		}
		if(cur==3)
		{
			jlb.setText("Q4 : IOS Is A __ software.");
			jrb[0].setText("Proprietary");
			jrb[1].setText("Free And Open Source");
			jrb[2].setText("All of the mentioned");
			jrb[3].setText("None of the mentioned");
		}
		if(cur==4)
		{
			jlb.setText("Q5 : For Unwrapping Value Inside Optional What Should We Use?");
			jrb[0].setText("?");
			jrb[1].setText("@");
			jrb[2].setText("!");
			jrb[3].setText("None Of These");
		}
		if(cur==5)
		{
			jlb.setText("Q6: What Is A LLVM ?");
			jrb[0].setText("Swiftc Compiler");
			jrb[1].setText("Contains Both Compiler (swiftc And Objective C)");
			jrb[2].setText("Objective C Compiler");
			jrb[3].setText("None Of The Above");
		}
		if(cur==6)
		{
			jlb.setText("Q7: Which Of The Following Is Incorrect Data Type In SWIFT ?");
			jrb[0].setText("UInt");
			jrb[1].setText("Double");
			jrb[2].setText("Char");
			jrb[3].setText("Optional");
		}
		if(cur==7)
		{
			jlb.setText("Q8 : We Can Return Multiple Values In Swift From Function By Using?");
			jrb[0].setText("Array");
			jrb[1].setText("Tuple");
			jrb[2].setText("Dictionary");
			jrb[3].setText("None");		
		}
		if(cur==8)
		{
			jlb.setText("Q9:  While defining a function we use the keyword:");
			jrb[0].setText("function");
			jrb[1].setText("fun");
			jrb[2].setText("func");
			jrb[3].setText("FUN");
		}
		if(cur==9)
		{
			jlb.setText("Q10: To Create Contants In Swift We Use Keyword?");
			jrb[0].setText("Var");
			jrb[1].setText("Conts");
			jrb[2].setText("Let");
			jrb[3].setText("None");
		}
		
	}

	boolean checkAnswer()
	{
		if(cur==0)
			return(jrb[2].isSelected());
		if(cur==1)
			return(jrb[2].isSelected());
		if(cur==2)
			return(jrb[0].isSelected());
		if(cur==3)
			return(jrb[0].isSelected());
		if(cur==4)
			return(jrb[2].isSelected());
		if(cur==5)
			return(jrb[1].isSelected());
		if(cur==6)
			return(jrb[2].isSelected());
		if(cur==7)
			return(jrb[1].isSelected());
		if(cur==8)
			return(jrb[2].isSelected());
		if(cur==9)
			return(jrb[2].isSelected());
		return false;
	}

	public static void main(String str[])
	{
		new OnlineQuizPortal("Online Quiz Portal for Swift Language");
	}

}
