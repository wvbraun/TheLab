package code.apps.simpleCalc;

import javax.swing.JFrame;

/**
 * This application creates the classes for a simple 4-function calculator.
 * 
 * The calculator is spread over four classes instead of one class simply to
 * demonstrate a design pattern called Model-View-Controller. MVC is widely used
 * in the real world of modern object-oriented programming. The essential idea
 * is that it separates the data (often a large and complicated database) from
 * various views of that data (which may be webpages, custom applications,
 * spreadsheets, and so on), so that views can vary without in any way changing
 * the database. Another example is multi-player networked games. Each player
 * would have a viewport (or several viewports---for instance, heads-up displays
 * that may be overlaid onto the worldview), but the world itself would just be
 * lots and lots of shared data stored on central servers that hold the world's
 * dynamically changing data.
 * 
 * In the particular case of this assignment, though, one view might be a visual
 * calculator application and another view might be a command-line calculator. It's
 * irrelevant to the Model whether the user is entering commands by typing on a
 * keyboard and seeing output on the command line or by pressing buttons
 * displayed on a screen using a mouse (or by pressing buttons by typing keys on
 * the keyboard but seeing output on the screen, or both---or using a touchpad,
 * or some future device). The point is that in all of the above cases, the
 * Model would be entirely unchanged no matter the View or Views.
 * 
 * For this assignment it's completely unnecessary for you to understand any of
 * that. All you need to focus on is the Model class. If you wish, you might
 * look at the Controller class to see how the logic works. Also, if you wish,
 * you might look at the View class to see a bit of how Swing works too. In
 * general, in MVC, M handles the data, C handles the logic (often called the
 * 'business logic'), and V handles the display. C is like a brain, V is like a
 * face, and M is like a memory.
 */
@SuppressWarnings("serial")
// this class is for education only. don't serialize.
public class Calculator extends JFrame {
	public static void main(String[] args) {
		Calculator calc = new Calculator();
		CalculatorModel model = new CalculatorModel();
		CalculatorController controller = new CalculatorController(model);
		CalculatorView view = controller.getView();
		calc.setSize(300, 300);
		calc.setVisible(true);
		calc.add(view);
	}
}