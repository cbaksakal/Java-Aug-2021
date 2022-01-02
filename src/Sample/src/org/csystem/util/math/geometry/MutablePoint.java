/*----------------------------------------------------------------------
	FILE        : MutablePoint.java
	AUTHOR      : Java-Aug-2021 Group
	LAST UPDATE : 02.01.2022

	MutablePoint class that represents 2D point

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.math.geometry;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class MutablePoint {
	private double m_x;
	private double m_y;

	private MutablePoint(double a, double b, boolean polar)
	{
		if (polar) {
			m_x = a * Math.cos(b);
			m_y = a * Math.sin(b);
		}
		else {
			m_x = a;
			m_y = b;
		}
	}

	public static MutablePoint createCartesian()
	{
		return createCartesian(0);
	}

	public static MutablePoint createCartesian(double x)
	{
		return createCartesian(x, 0);
	}

	public static MutablePoint createCartesian(double x, double y)
	{
		return new MutablePoint(x, y, false);
	}

	public static MutablePoint createPolar()
	{
		return createPolar(0, 0);
	}

	public static MutablePoint createPolar(double r)
	{
		return createPolar(r, 0);
	}

	public static MutablePoint createPolar(double r, double theta)
	{
		return new MutablePoint(r, theta, true);
	}

	public double getX()
	{
		return m_x;
	}

	public void setX(double x)
	{
		m_x = x;
	}

	public double getY()
	{
		return m_y;
	}

	public void setY(double y)
	{
		m_y = y;
	}

	public double distance()
	{
		return distance(0, 0);
	}
	
	public double distance(MutablePoint other)
	{
		return distance(other.m_x, other.m_y);
	}

	public double distance(double a, double b)
	{
		return sqrt(pow(m_x - a, 2) + pow(m_y - b, 2));
	}
	
	public void offset(double dxy)
	{
		offset(dxy, dxy);
	}
	
	public void offset(double dx, double dy)
	{
		m_x += dx;
		m_y += dy;
	}
	
	public String toString()
	{
		return String.format("{x: %f, y: %f}", m_x, m_y);
	}
}