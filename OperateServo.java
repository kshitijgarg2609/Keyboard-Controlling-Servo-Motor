import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
class OperateServo
{
	JFrame jf;
	ServoCmd serv;
	SerialRW srw;
	boolean w;
	Thread t;
	OperateServo()
	{
		serv=new ServoCmd();
		srw=new SerialRW();
		srw.d=30;
		t=new Thread()
		{
			public void run()
			{
				while(w)
				{
					delay(40);
					srw.sendGet(serv.exe());
				}
			}
		}
		;
		jf=new JFrame("Keyboard Controlling Servo !!!");
		jf.setExtendedState(JFrame.MAXIMIZED_BOTH);
		jf.addKeyListener(
		new KeyListener()
		{
			public void keyTyped(KeyEvent e)
			{
			}
			public void keyPressed(KeyEvent e)
			{
				if(e.getKeyCode()==KeyEvent.VK_A)
				{
					serv.inc();
				}
				else if(e.getKeyCode()==KeyEvent.VK_D)
				{
					serv.dec();
				}
			}
			public void keyReleased(KeyEvent e)
			{
			}
		}
		);
		jf.setVisible(true);
		w=true;
		t.start();
	}
	void delay(int a)
	{
		try
		{
			Thread.sleep(a);
		}
		catch (InterruptedException e)
		{
			System.out.println(e);
		}
	}
	void stop()
	{
		w=false;
		srw.close();
	}
}
