class ServoCmd
{
	int pos;
	static String cmd;
	String base;
	ServoCmd()
	{
		pos=90;
		base="mov ";
		cmd=base;
	}
	ServoCmd(int a)
	{
		pos=a;
		base="mov ";
		cmd=base;
	}
	boolean valid(int a)
	{
		return (a>=0&&a<=180);
	}
	void inc()
	{
		int temp;
		temp=pos+3;
		if(valid(temp))
		{
			pos=temp;
			cmd=base+pos;
		}
		else
		{
			cmd=base+180;
		}
	}
	void dec()
	{
		int temp;
		temp=pos-3;
		if(valid(temp))
		{
			pos=temp;
			cmd=base+pos;
		}
		else
		{
			cmd=base+0;
		}
	}
	String exe()
	{
		return cmd;
	}
}
