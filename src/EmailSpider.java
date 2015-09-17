import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailSpider {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("test.html"));
			String line = null;
			try {
				while ((line = br.readLine() ) != null) {
					parse(line);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
	}

	public static void parse(String s) {
		Pattern p = Pattern.compile("[\\w[-.]]+@[\\w[-.]]+\\.[\\w]+");
		Matcher m = p.matcher(s);
		while(m.find()) {
			System.out.println(m.group());
		}
	}

}
