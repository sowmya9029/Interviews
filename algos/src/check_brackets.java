import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

class Bracket {
	Bracket(char type, int position) {
		this.type = type;
		this.position = position;
	}

	boolean Match(char c) {
		if (this.type == '[' && c == ']')
			return true;
		if (this.type == '{' && c == '}')
			return true;
		if (this.type == '(' && c == ')')
			return true;
		return false;
	}

	char type;
	int position;
}

class check_brackets {
	public static void main(String[] args) throws IOException {
		InputStreamReader input_stream = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(input_stream);
		String text = reader.readLine();
		String check_bracket;
		Stack<Bracket> opening_brackets_stack = new Stack<Bracket>();
		for (int position = 0; position < text.length(); ++position) {
			char next = text.charAt(position);
			Bracket b =new Bracket(next, position);
			if (next == '(' || next == '[' || next == '{') {
				opening_brackets_stack.push(b);
			}

			if (next == ')' || next == ']' || next == '}') {

				if (opening_brackets_stack.isEmpty())
				{
					check_bracket= "not balanced";
				}              
				if (b.Match(opening_brackets_stack.pop().type) )
				{
					check_bracket= "not balanced";
				}

			}
		}
		if (opening_brackets_stack.isEmpty())
			System.out.println("Success");
		else
		{   /*not balanced*/
			System.out.println("Fail");
		} 
		
	}
}
