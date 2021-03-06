package calculations;

import java.util.LinkedList;

import javax.swing.JOptionPane;

import javafx.scene.control.TextArea;

public class ComplexNumber {

	public static final int XY = 0;
	public static final int RCIS = 1;
	private double real;
	private double imaginary;
	int ID;

	/**
	 * Constructs a new ComplexNumber object with both real and
	 * imaginary parts 0 (z = 0 + 0i).
	 */
	public ComplexNumber() {
		real = 0.0;
		imaginary = 0.0;
	}

	/**
	 * Constructs a new ComplexNumber object.
	 * 
	 * @param real      the real part, Re(z), of the complex number
	 * @param imaginary the imaginary part, Im(z), of the complex number
	 */
	public ComplexNumber(double real, double imaginary) {
		this.real = real;
		this.imaginary = imaginary;
	}

	/**
	 * Setter for the ComplexNumber ID.
	 * 
	 * @param complexNumberID
	 */
	public void setID(int complexNumberID) {
		this.ID = complexNumberID;
	}

	/**
	 * Adds another ComplexNumber to the current complex number.
	 * 
	 * @param z the complex number to be added to the current complex number
	 */
	public void add(ComplexNumber z) {
		set(add(this, z));
	}

	/**
	 * Subtracts another ComplexNumber from the current complex number.
	 * 
	 * @param z the complex number to be subtracted from the current complex number
	 */
	public void subtract(ComplexNumber z) {
		set(subtract(this, z));
	}

	/**
	 * Multiplies another ComplexNumber to the current complex number.
	 * 
	 * @param z the complex number to be multiplied to the current complex number
	 */
	public void multiply(ComplexNumber z) {
		set(multiply(this, z));
	}

	/**
	 * Divides the current ComplexNumber by another ComplexNumber.
	 * 
	 * @param z the divisor
	 */
	public void divide(ComplexNumber z) {
		set(divide(this, z));
	}

	/**
	 * Sets the value of current complex number to the passed complex number.
	 * 
	 * @param z the complex number
	 */
	public void set(ComplexNumber z) {
		this.real = z.real;
		this.imaginary = z.imaginary;
	}

	/**
	 * Adds two ComplexNumber.
	 * 
	 * @param z1 the first ComplexNumber.
	 * @param z2 the second ComplexNumber.
	 * @return the resultant ComplexNumber (z1 + z2).
	 */
	public static ComplexNumber add(ComplexNumber z1, ComplexNumber z2) {
		return new ComplexNumber(z1.real + z2.real, z1.imaginary + z2.imaginary);
	}

	/**
	 * Subtracts one ComplexNumber from another.
	 * 
	 * @param z1 the first ComplexNumber.
	 * @param z2 the second ComplexNumber.
	 * @return the resultant ComplexNumber (z1 - z2).
	 */
	public static ComplexNumber subtract(ComplexNumber z1, ComplexNumber z2) {
		return new ComplexNumber(z1.real - z2.real, z1.imaginary - z2.imaginary);
	}

	/**
	 * Multiplies one ComplexNumber to another.
	 * 
	 * @param z1 the first ComplexNumber.
	 * @param z2 the second ComplexNumber.
	 * @return the resultant ComplexNumber (z1 * z2).
	 */
	public static ComplexNumber multiply(ComplexNumber z1, ComplexNumber z2) {
		double _real = z1.real * z2.real - z1.imaginary * z2.imaginary;
		double _imaginary = z1.real * z2.imaginary + z1.imaginary * z2.real;
		return new ComplexNumber(_real, _imaginary);
	}

	/**
	 * Divides one ComplexNumber by another.
	 * 
	 * @param z1 the first ComplexNumber.
	 * @param z2 the second ComplexNumber.
	 * @return the resultant ComplexNumber (z1 / z2).
	 */
	public static ComplexNumber divide(ComplexNumber z1, ComplexNumber z2) {
		ComplexNumber output = multiply(z1, z2.conjugate());
		double div = Math.pow(z2.mod(), 2);
		return new ComplexNumber(output.real / div, output.imaginary / div);
	}

	/**
	 * The complex conjugate of the current complex number.
	 * 
	 * @return a ComplexNumber object which is the conjugate of the
	 *         current complex number
	 */
	public ComplexNumber conjugate() {
		return new ComplexNumber(this.real, -this.imaginary);
	}

	/**
	 * The modulus, magnitude or the absolute value of current complex number.
	 * 
	 * @return the magnitude or modulus of current complex number
	 */
	public double mod() {
		return Math.sqrt(Math.pow(this.real, 2) + Math.pow(this.imaginary, 2));
	}

	/**
	 * The square of the current complex number.
	 * 
	 * @return a ComplexNumber which is the square of the current
	 *         complex number.
	 */
	public ComplexNumber square() {
		double _real = this.real * this.real - this.imaginary * this.imaginary;
		double _imaginary = 2 * this.real * this.imaginary;
		return new ComplexNumber(_real, _imaginary);
	}

	/**
	 * @return the complex number in x + yi format
	 */
	@Override
	public String toString() {
		return String.format("%.4f + (%.4f)i", this.real, this.imaginary);
	}

	/**
	 * Calculates the exponential of the ComplexNumber
	 * 
	 * @param z The input complex number
	 * @return a ComplexNumber which is e^(input z)
	 */
	public static ComplexNumber exp(ComplexNumber z) {
		double a = z.real;
		double b = z.imaginary;
		double r = Math.exp(a);
		a = r * Math.cos(b);
		b = r * Math.sin(b);
		return new ComplexNumber(a, b);
	}

	/**
	 * Calculates the ComplexNumber to the passed integer power.
	 * 
	 * @param z     The input complex number
	 * @param power The power.
	 * @return a <code>ComplexNumber</code> which is (z)^power
	 */
	public static ComplexNumber pow(ComplexNumber z, int power) {
		ComplexNumber output = new ComplexNumber(z.getRe(), z.getIm());
		for (int i = 1; i < power; i++) {
			double _real = output.real * z.real - output.imaginary * z.imaginary;
			double _imaginary = output.real * z.imaginary + output.imaginary * z.real;
			output = new ComplexNumber(_real, _imaginary);
		}
		return output;
	}

	/**
	 * Calculates the sine of the ComplexNumber
	 * 
	 * @param z the input complex number
	 * @return a ComplexNumber which is the sine of z.
	 */
	public static ComplexNumber sin(ComplexNumber z) {
		double x = Math.exp(z.imaginary);
		double x_inv = 1 / x;
		double r = Math.sin(z.real) * (x + x_inv) / 2;
		double i = Math.cos(z.real) * (x - x_inv) / 2;
		return new ComplexNumber(r, i);
	}

	/**
	 * Calculates the cosine of the ComplexNumber
	 * 
	 * @param z the input complex number
	 * @return a ComplexNumber which is the cosine of z.
	 */
	public static ComplexNumber cos(ComplexNumber z) {
		double x = Math.exp(z.imaginary);
		double x_inv = 1 / x;
		double r = Math.cos(z.real) * (x + x_inv) / 2;
		double i = -Math.sin(z.real) * (x - x_inv) / 2;
		return new ComplexNumber(r, i);
	}

	/**
	 * Calculates the tangent of the ComplexNumber
	 * 
	 * @param z the input complex number
	 * @return a ComplexNumber which is the tangent of z.
	 */
	public static ComplexNumber tan(ComplexNumber z) {
		return divide(sin(z), cos(z));
	}

	/**
	 * Calculates the co-tangent of the ComplexNumber
	 * 
	 * @param z the input complex number
	 * @return a ComplexNumber which is the co-tangent of z.
	 */
	public static ComplexNumber cot(ComplexNumber z) {
		return divide(new ComplexNumber(1, 0), tan(z));
	}

	/**
	 * Calculates the secant of the ComplexNumber
	 * 
	 * @param z the input complex number
	 * @return a ComplexNumber which is the secant of z.
	 */
	public static ComplexNumber sec(ComplexNumber z) {
		return divide(new ComplexNumber(1, 0), cos(z));
	}

	/**
	 * Calculates the co-secant of the ComplexNumber
	 * 
	 * @param z the input complex number
	 * @return a ComplexNumber which is the co-secant of z.
	 */
	public static ComplexNumber cosec(ComplexNumber z) {
		return divide(new ComplexNumber(1, 0), sin(z));
	}

	/**
	 * The real part of ComplexNumber
	 * 
	 * @return the real part of the complex number
	 */
	public double getRe() {
		return this.real;
	}

	/**
	 * The imaginary part of ComplexNumber
	 * 
	 * @return the imaginary part of the complex number
	 */
	public double getIm() {
		return this.imaginary;
	}

	/**
	 * The argument/phase of the current complex number.
	 * 
	 * @return arg(z) - the argument of current complex number
	 */
	public double getArg() {
		return Math.atan2(imaginary, real);
	}

	/**
	 * Parses the String as a ComplexNumber of type x+yi.
	 * 
	 * @param s the input complex number as string
	 * @return a ComplexNumber which is represented by the string.
	 */
	public static ComplexNumber parseComplex(String s) {
		s = s.replaceAll(" ", "");
		ComplexNumber parsed = null;
		if (s.contains(String.valueOf("+")) || (s.contains(String.valueOf("-")) && s.lastIndexOf('-') > 0)) {
			String re = "";
			String im = "";
			s = s.replaceAll("i", "");
			s = s.replaceAll("I", "");
			if (s.indexOf('+') > 0) {
				re = s.substring(0, s.indexOf('+'));
				im = s.substring(s.indexOf('+') + 1, s.length());
				parsed = new ComplexNumber(Double.parseDouble(re), Double.parseDouble(im));
			} else if (s.lastIndexOf('-') > 0) {
				re = s.substring(0, s.lastIndexOf('-'));
				im = s.substring(s.lastIndexOf('-') + 1, s.length());
				parsed = new ComplexNumber(Double.parseDouble(re), -Double.parseDouble(im));
			}
		} else {
			// Pure imaginary number
			if (s.endsWith("i") || s.endsWith("I")) {
				s = s.replaceAll("i", "");
				s = s.replaceAll("I", "");
				parsed = new ComplexNumber(0, Double.parseDouble(s));
			}
			// Pure real number
			else {
				parsed = new ComplexNumber(Double.parseDouble(s), 0);
			}
		}
		return parsed;
	}

	/**
	 * Checks if the passed ComplexNumber is equal to the current.
	 * 
	 * @param z the complex number to be checked
	 * @return true if they are equal, false otherwise
	 */
	@Override
	public final boolean equals(Object z) {
		if (!(z instanceof ComplexNumber))
			return false;
		ComplexNumber a = (ComplexNumber) z;
		return (real == a.real) && (imaginary == a.imaginary);
	}

	/**
	 * The inverse/reciprocal of the complex number.
	 * 
	 * @return the reciprocal of current complex number.
	 */
	public ComplexNumber inverse() {
		return divide(new ComplexNumber(1, 0), this);
	}

	/**
	 * Formats the Complex number as x + yi or r.cis(theta)
	 * 
	 * @param format_id the format ID ComplexNumber.XY or ComplexNumber.RCIS.
	 * @return a string representation of the complex number
	 * @throws IllegalArgumentException if the format_id does not match.
	 */
	public String format(int format_id) throws IllegalArgumentException {
		String out = "";
		if (format_id == XY)
			out = toString();
		else if (format_id == RCIS) {
			out = mod() + " cis(" + getArg() + ")";
		} else {
			throw new IllegalArgumentException("Unknown Complex Number format.");
		}
		return out;
	}

	/** Method that adds a new vector to the history in order to be operated. */
	public static boolean addComplexNumber(LinkedList<ComplexNumber> history, TextArea area) {
		try {
			try {
				double re = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la parte real."));
				double im = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la parte imaginaria."));
				ComplexNumber cN = new ComplexNumber(re, im);
				history.add(cN);
				area.setText(area.getText() + "\n" + cN.ID + ":\t" + cN.toString());
			} catch (NullPointerException e) {
				return false;
			}
		} catch (NumberFormatException ex) {
			return false;
		}
		return true;
	}

	/** Generate ComplexNumber with random elements. */
	public static boolean random(LinkedList<ComplexNumber> history) {
		try {
			try {
				double re = Math.random() * 10;
				double im = Math.random() * 10;
				ComplexNumber cN = new ComplexNumber(re, im);
				history.add(cN);
			} catch (NullPointerException e) {
				return false;
			}
		} catch (NumberFormatException ex) {
			return false;
		}
		return true;
	}

	/**
	 * Method that fills a text area with all available vector registers throughout
	 * the program execution.
	 * 
	 * @param area The text area where the user will see the vectors.
	 */
	public static void updateHistory(LinkedList<ComplexNumber> history, TextArea area) {
		area.setText("");
		for (ComplexNumber cN : history) {
			area.setText(area.getText() + "\n" + cN.ID + ":\t" + cN.toString());
		}
	}
}