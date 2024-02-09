public class danielRubianesBox 
{
	private double length, height, depth;
	
	public danielRubianesBox( double length, double height, double depth )
	{
		this.length = length;
		this.height = height;
		this.depth= depth;
	}
	
	public double volume()
	{
		return length*height*depth;
	}
	
	// compare this Box to another Box
	int compareTo( danielRubianesBox other )
	{
		if (volume() > other.volume()) {
			return 1;
		}
		else if (volume() < other.volume()) {
			return -1;
		}
		else {
			return 0;
		}
	}
	
	public String toString()
	{
		return( "length: " + length + ",height: " + height + ",depth: " + depth + ",volume: " + volume() );
	}

}