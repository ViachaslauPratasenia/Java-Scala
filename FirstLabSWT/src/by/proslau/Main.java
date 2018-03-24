/**
 * <h1>First1Lab "Reverse string"</h1>
 * <p>
 * The first lab program implements an application
 * that reverse string
 * @author Viachaslau Pratasenia
 * @version 1.0
 * @since 2018-03-18
 * </p>
*/
package by.proslau;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class Main {
	/**
	 *<h1>Configure shell</h1>
	 *<p>
	 *This method configures the settings for the element table and their location
	 *</p>
	 *@param display
	 *@return returns the configured item table
	*/
	public static Shell ConfigureShell(Display display) {
		Shell shell = new Shell(display, SWT.SHELL_TRIM&(~SWT.RESIZE));
		shell.setText("Reverse");
		shell.setSize(330,175);
		shell.setLayout(new GridLayout(1, true));
		
		gridData = new GridData();
		gridData.horizontalAlignment = gridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		
		inputTextField = new Text(shell, SWT.BORDER);
		inputTextField.setLayoutData(gridData);
		
		outputTextField = new Text(shell, SWT.BORDER);
		outputTextField.setLayoutData(gridData);
		
		reverse = new Button(shell, SWT.PUSH);
		reverse.setText("»нвертировать");
		reverse.setLayoutData(gridData);
		
		label = new Label(shell, SWT.BORDER);
		label.setText("Ѕгуир - знани€ и стиль жизни");
		label.setLayoutData(gridData);
		
		reverse.addListener(SWT.Selection, new Listener() 
		{
			public void handleEvent(Event event)
			{
				if(inputTextField.getText().isEmpty() && outputTextField.getText().isEmpty()) {
					displayErrorMessage(display);
				}else if(!inputTextField.getText().isEmpty()) {
					outputTextField.setText(new StringBuilder(inputTextField.getText()).reverse().toString());
				}else {
					inputTextField.setText(new StringBuilder(outputTextField.getText()).reverse().toString());
				}
			}
		});
		
		return shell;
	}
	/**
	 *<h1>Display error message</h1>
	 *<p>
	 *Displays a message about an incorrect entry
	 *</p>
	 *@param display
	 *@return nothing
	*/
	public static void displayErrorMessage(Display display) {
		MessageBox m = new MessageBox(new Shell(display, SWT.ICON_ERROR));
		m.setText("ќшибка!");
		m.setMessage("¬ведите данные!");
		m.open();
		return;
	}
	/**
	 *This method is launch the application
	 *@param args
	 *@return nothing
	*/
	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = ConfigureShell(display);
		shell.open();
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch())
				display.sleep();
		}
	}
	
	private static Label label;
	private static GridData gridData;
	private static Text inputTextField;
	private static Text outputTextField;
	private static Button reverse;
}
