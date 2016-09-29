import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;


public class Buttonx extends JButton
{
   private Image image;
   private int sx1,sy1,sx2,sy2;
   public int bi,bj;//°´Å¥×ø±ê
   public int ti,tj;//Í¼Æ¬×ø±ê
	public Buttonx(int x,int y)
   {
	   ImageIcon con=new ImageIcon("Autumn.jpg");
	   image=con.getImage();
	   bi=x;
	   bj=y;
	   ti=bi;
	   tj=bj;
	   
   }
	public void paintComponent(Graphics g)
   {
	   super.paintComponent(g);
	   
	   sx1=tj*200;
	   sy1=ti*150;
	   sx2=sx1+200;
	   sy2=sy1+150;
	   if(ti==3&&tj==3)
	   {
		   return;
	   }
	   g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), sx1, sy1, sx2, sy2, null);
   }
}
