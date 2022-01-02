/*----------------------------------------------------------------------
	FILE        : MutableComplex.java
	AUTHOR      : Java-Aug-2021 Group
	LAST UPDATE : 02.01.2022

	Immutable Complex class that represents a complex number

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.math;

import static java.lang.Math.sqrt;

public class Complex {
	private static Complex add(double a1, double b1, double a2, double b2)
	{
		return new Complex(a1 + a2, b1 + b2);
	}

	private static Complex subtract(double a1, double b1, double a2, double b2)
	{
		return add(a1, b1, -a2, -b2);
	}

	private static Complex multiply(double a1, double b1, double a2, double b2)
	{
		return new Complex(a1 * a2 - b1 * b2, a1 * b2 + b1 * a2);
	}

	private static Complex divide(double a1, double b1, double a2, double b2)
	{
		Complex z = multiply(a1, b1, a2, -b2);

		return multiply(1 / (a2 * a2 + b2 * b2), z);
	}

	private final double m_real;
	private final double m_imag;

	public Complex(double theta)
	{
		m_real = Math.cos(theta);
		m_imag = Math.sin(theta);
	}

	public Complex(double real, double imag)
	{
		m_real = real;
		m_imag = imag;
	}

	public double getReal()
	{
		return m_real;
	}

	public double getImag()
	{
		return m_real;
	}

	public double getLength()
	{
		return getNorm();
	}
	
	public double getNorm()
	{
		return sqrt(m_real * m_real + m_imag * m_imag);
	}
	
	public Complex getConjugate()
	{
		return new Complex(m_real, -m_imag);
	}
	
	//add methods
	public static Complex add(double val, Complex z)
	{
		return add(val, 0, z.m_real, z.m_imag);
	}
	
	public Complex add(double val)
	{
		return add(m_real, m_imag, val, 0);
	}
	
	public Complex add(Complex other)
	{
		return add(m_real, m_imag, other.m_real, other.m_imag);
	}	
	
	//subtract methods
	public static Complex subtract(double val, Complex z)
	{
		return subtract(val, 0, z.m_real, z.m_imag);
	}
	
	public Complex subtract(double val)
	{
		return subtract(m_real, m_imag, val, 0);
	}
	
	public Complex subtract(Complex other)
	{
		return subtract(m_real, m_imag, other.m_real, other.m_imag);
	}	
	
	//multiply methods
	public static Complex multiply(double val, Complex z)
	{
		return multiply(val, 0, z.m_real, z.m_imag);
	}
	
	public Complex multiply(double val)
	{
		return multiply(m_real, m_imag, val, 0);
	}
	
	public Complex multiply(Complex other)
	{
		return multiply(m_real, m_imag, other.m_real, other.m_imag);
	}
	
	//divide methods
	public static Complex divide(double val, Complex z)
	{
		return divide(val, 0, z.m_real, z.m_imag);
	}
	
	public Complex divide(double val)
	{
		return divide(m_real, m_imag, val, 0);
	}
	
	public Complex divide(Complex other)
	{
		return divide(m_real, m_imag, other.m_real, other.m_imag);
	}	
	
	public String toString()
	{
		return String.format("|%.2f + %.2f * i| = %f", m_real, m_imag, getNorm());
	}
}
