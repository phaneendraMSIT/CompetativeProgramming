import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;
import java.util.regex.*;

public class NumberOfAtoms {
	
	public static void main(String[] args) {
		System.out.println(countOfAtoms("H20"));
		System.out.println(countOfAtoms("Mg(OH)2"));
		System.out.println(countOfAtoms("K4(ON(SO3)2)2"));
		System.out.println(countOfAtoms("C10H16O"));
		System.out.println(countOfAtoms("Zn(NO3)2"));
		System.out.println(countOfAtoms("NaOH"));
		System.out.println(countOfAtoms("F2"));
	}
	
   
	public static String countOfAtoms(String formula) {
        Matcher matcher = Pattern.compile("([A-Z][a-z]*)(\\d*)|(\\()|(\\))(\\d*)").matcher(formula);
        Stack<Map<String, Integer>> stack = new Stack<>();
        stack.push(new TreeMap<>());

        while (matcher.find()) {
            String match = matcher.group();
            if (match.equals("(")) {
                stack.push(new TreeMap<>());
            } else if (match.startsWith(")")) {
                Map<String, Integer> top = stack.pop();
                int multiplicity = match.length() > 1 ? Integer.parseInt(match.substring(1, match.length())) : 1;
                for (String name: top.keySet()) {
                    stack.peek().put(name, stack.peek().getOrDefault(name, 0) + top.get(name) * multiplicity);
                }
            } else {
                int i = 1;
                while (i < match.length() && Character.isLowerCase(match.charAt(i))) {
                    i++;
                }
                String name = match.substring(0, i);
                int multiplicity = i < match.length() ? Integer.parseInt(match.substring(i, match.length())) : 1;
                stack.peek().put(name, stack.peek().getOrDefault(name, 0) + multiplicity);
            }
        }

        StringBuilder ans = new StringBuilder();
        for (String name: stack.peek().keySet()) {
            ans.append(name);
            final int count = stack.peek().get(name);
            if (count > 1) ans.append(String.valueOf(count));
        }
        return ans.toString();
    }
}