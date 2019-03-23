import com.fazecast.jSerialComm.*;
class SerialRW
{
	static SerialPort port;
	static boolean connect;
	int d;
	String msg;
	Thread t;
	{
		connect=false;
	}
	SerialRW()
	{
		if(connect)
		{
			System.out.println("PORT ALREADY IN USE !!!");
			return;
		}
		d=40;
		reset();
		try
		{
			port=SerialPort.getCommPorts()[0];
			port.openPort();
			port.disablePortConfiguration();
			port.addDataListener(
			new SerialPortDataListener()
			{
				public int getListeningEvents()
				{
					return port.LISTENING_EVENT_DATA_RECEIVED;
				}
				public void serialEvent(SerialPortEvent event)
				{
					if(event.getEventType()==SerialPort.LISTENING_EVENT_DATA_RECEIVED)
					{
						String n=new String(event.getReceivedData());
						msg+=n;
					}
				}
			}
			)
			;
			connect=true;
		}
		catch(Exception e)
		{
			close();
		}
	}
	void close()
	{
		port.removeDataListener();
		port.closePort();
		connect=false;
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
	void reset()
	{
		msg="";
	}
	String filter13(String a)
	{
		String b="";
		int i;
		char c;
		for(i=0;i<a.length();i++)
		{
			c=a.charAt(i);
			if(c=='\r')
			{
				continue;
			}
			b+=c;
		}
		return b;
	}
	String filter10(String a)
	{
		String b="";
		int i;
		char c;
		for(i=0;i<a.length();i++)
		{
			c=a.charAt(i);
			if(c=='\n')
			{
				continue;
			}
			b+=c;
		}
		return b;
	}
	String filter10or13(String a)
	{
		String b="";
		int i;
		char c;
		for(i=0;i<a.length();i++)
		{
			c=a.charAt(i);
			if(c=='\r'||c=='\n')
			{
				continue;
			}
			b+=c;
		}
		return b;
	}
	String sendGet(String a)
	{
		byte arr[];
		int i;
		reset();
		arr=new byte[a.length()];
		for(i=0;i<a.length();i++)
		{
			arr[i]=(byte)(a.charAt(i));
		}
		i=port.writeBytes(arr,arr.length);
		delay(d);
		if(i==-1)
		{
			return null;
		}
		else
		{
			return filter13(msg);
		}
	}
}
