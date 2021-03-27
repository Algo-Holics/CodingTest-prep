import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Rearrange {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList alphalist = new ArrayList<Character>();
		int num = 0;
		String str = br.readLine();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) - '0' > 9) {
				alphalist.add(str.charAt(i));
			} else {
				num += str.charAt(i) - '0';
			}
		}
		alphalist.sort(null); // ��������
		// list.sort(Comparator.naturalOrder()); ��������
		// list.sort(Comparator.reverseOrder()); ��������

		ListIterator<Character> iter = alphalist.listIterator();
		while (iter.hasNext()) {
			System.out.print(iter.next());
		}
		System.out.println(num);

	}

}
