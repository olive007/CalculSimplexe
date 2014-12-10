package calculatorSimplex;

public class Main {

	public static void main(String[] args) {
		Controller controller = new Controller();
		
		if (controller.init()) {
			controller.loop();
		}
		controller.close();
	}

}
