package mrt3project;

/**
 *
 * @author Jacob
 */
public class DVD {
	private	String title;
	private	String genre;
	private	String runtime;
	private	int year;
	private	double price;


	public	void setTitle(String t)
		{
			title = t;
		}
	public	void setGenre(String g)
		{
			genre = g;
		}
	public	void setRuntime(String r)
		{
			runtime = r;
		}
	public	void setYear(int y)
		{
			year = y;
		}
	public	void setPrice(double p)
		{
			price = p;
		}
	public	String getTitle()
		{
			return title;
		}
	public	String getGenre()
		{
			return genre;
		}
        public  String getRuntime()
		{
			return runtime;
		}
	public	int getYear()
		{
			return year;
		}
	public	double getPrice()
		{
			return price;
		}
}
