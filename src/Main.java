import java.io.IOException;

///TODO
/// Fix inconsistency with TEST and other garages with naming convention
public class Main {
	public static void main(String args[]) throws IOException {
		System.out.println(APIClient.getSpot("Test", 9));
	}
}
