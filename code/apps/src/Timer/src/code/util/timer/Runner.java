package code.util.timer;

public class Runner 
{
	
	public static void main(String[] args)
	{
		Thread t = new Thread(new Timer());
		t.start();
	}

}
