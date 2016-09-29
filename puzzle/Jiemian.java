import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Jiemian implements ActionListener
{
  private JFrame frame;
private JPanel panel;
private JPanel panelcenter;
private JPanel panelnorth;
private Buttonx kong;
private Buttonx selected;
private Buttonx but[][];
private JButton begin;

public Jiemian()
  {
	  this.chuangjian();
	  this.zuzhang();
	  this.zhuce();
	  this.xianshi();
  }
  public void chuangjian()
  {
	  frame=new JFrame();
	  panel=new JPanel();
	  panelnorth=new JPanel();
	  panelcenter=new JPanel();
	  but=new Buttonx[4][4];
	  for (int i = 0; i < but.length; i++) 
	  {
		for (int j = 0; j < but[i].length; j++) 
		{
			but[i][j]=new Buttonx(i,j);
		
		}
		
	 }
	  begin=new JButton("开始");
	  kong=but[3][3];
	  frame.setDefaultCloseOperation(3);
	  
  }
  public void zuzhang()
  {
	  panel.setLayout(new BorderLayout());
	  panel.add(panelnorth,BorderLayout.NORTH);
	  panel.add(panelcenter);
	  panelcenter.setLayout(new GridLayout(4,4));
	  for (int i = 0; i < but.length; i++) 
	  {
			for (int j = 0; j < but[i].length; j++) 
			{
				panelcenter.add(but[i][j]);
			}
	  }
	  
	  panelnorth.add(begin);
	  frame.add(panel);
  }
  public void chuangjianpintu()
  {
	  for (int k = 0; k < 1000; k++) 
	  {
	    int s=(int)(Math.random()*4);
	    int i=kong.bi;
	    int j=kong.bj;
	    if(s==0)
	     {
		  i++;
	     }
	    if(s==1)
	    {
		  i--;
	     }
	    if(s==2)
	    {
		  j++;
	    }
	   if(s==3)
	   {
		  j--;
	    }
	  
	   this.move(i,j);
	 }
	//最后一行
		
		for (int i = kong.bi+1; i <=3; i++) 
		{
			this.move(i, kong.bj);
		}
		
		//最后一列
		
		for (int i = kong.bj+1; i <=3; i++) 
		{
			this.move(kong.bi, i);
		}
  }
  public void move(int x,int y)
  {
	  if(x<0||x>3||y<0||y>3)
		{
			return;
		}
		int t = kong.ti;
		kong.ti = but[x][y].ti;
		but[x][y].ti = t;
		t = kong.tj;
		kong.tj = but[x][y].tj;
		but[x][y].tj = t;
		kong.repaint();
		but[x][y].repaint();
		kong=but[x][y];
		
		
  }
  
  public void zhuce()
  {
	  begin.addActionListener(this);
	  for (int i = 0; i < but.length; i++) 
	  {
		for (int j = 0; j < but[i].length; j++) 
		{
			but[i][j].addActionListener(this);
		}
	}
  }
  public void xianshi()
  {
	  frame.setVisible(true);
	  frame.setSize(500,600);
  }
  public static void main(String[] args) {
	new Jiemian();
}
@Override
public void actionPerformed(ActionEvent e) {
	Object o=e.getSource();
	if(o==begin)
	{
		this.chuangjianpintu();
	}
	else
	{
		selected=(Buttonx)o;
		int xs=selected.bi;
		int ys=selected.bj;
		int xk=kong.bi;
		int yk=kong.bj;
		if(Math.abs(xs-xk)+Math.abs(ys-yk)==1)
		{
			this.move(xs, ys);
		}
	}
	
}
}
