package by.epam.task1.service;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import by.epam.task1.bean.Point;

public class ValidationTriangle {
	
	private static ValidationTriangle instance;
	
	private ValidationTriangle(){}
	
	public static ValidationTriangle getInstance() {
		
		return (instance == null) ? new ValidationTriangle(): instance;
	}

	static{
			PropertyConfigurator.configure(NameParameter.PROPERTY_CONFIG_LOG4J);
	}
	final static Logger logger = Logger.getLogger(ValidationTriangle.class);
	
	
	public boolean isExistTriangle(Point a, Point b, Point c){
		logger.info(NameParameter.IS_EXIST_TRIANGLE + a+b+c);
		double ab = countDistance(a, b);
		double bc = countDistance(b, c);
		double ac = countDistance(a, c);
		
		if((ab < (bc+ac)) && (bc < (ab + ac)) && (ac < (ab+bc))){
			logger.info(NameParameter.IS_EXIST_RETURN_TRUE);
			return true;
		}else{
			logger.info(NameParameter.IS_EXIST_RETURN_FALSE);
			return false;
		}
	}
	
	 public double calculationSquare(Point a, Point b, Point c){
		logger.info(NameParameter.CALC_SQUARE + a+b+c);
		double ab = countDistance(a, b);
		double bc = countDistance(b, c);
		double ac = countDistance(a, c);
		double p = ((ab + bc + ac)/2);
		double square = Math.sqrt(p *(p-ab) * (p-bc) * (p-ac));
		logger.info(NameParameter.CALC_SQUARE_RETURN+ square);
		return square;
	}
	
	 public double calculationPerimeter(Point a, Point b, Point c){
		logger.info(NameParameter.CALC_PERIMETR + a+b+c);
		double ab = countDistance(a, b);
		double bc = countDistance(b, c);
		double ac = countDistance(a, c);
		double perimeter = ab+bc+ac;
		logger.info(NameParameter.CALC_PERIMETR_RETURN+ perimeter);
		return perimeter;
	}
	
	 public String checkType(Point a, Point b, Point c){
		logger.info(NameParameter.CHECK_TYPE + a+b+c);
		double ab = countDistance(a, b);
		double bc = countDistance(b, c);
		double ac = countDistance(a, c);
		
		double cosA = ((ab * ab) - (bc*bc) - (ac*ac))/(2*bc*ac);
		double cosB = ((bc*bc)-(ab*ab)-(ac*ac))/(2*ab*ac);
		double cosC = ((ac*ac)-(bc*bc)-(ab*ab))/(2*bc*ab);
		
		if (cosA == 0.0 || cosB == 0.0 || cosC == 0.0) {
			logger.info(NameParameter.TYPE_RETURN + NameParameter.TYPE_RECTANGULAR);
			return NameParameter.TYPE_RECTANGULAR;
		} else if (cosA == 0.5 && cosB == 0.5 && cosC == 0.5) {
			logger.info(NameParameter.TYPE_RETURN + NameParameter.TYPE_EQUILATERAL);
			return NameParameter.TYPE_EQUILATERAL;
		} else {
			logger.info(NameParameter.TYPE_RETURN + NameParameter.TYPE_SIMPLE);
			return NameParameter.TYPE_SIMPLE;
		}
	}

	private double countDistance(Point first, Point second) {
		logger.info(NameParameter.COUNT_DISTANCE + first + second);
		double dx = first.getxCoord() - second.getxCoord();
		double dy = first.getyCoord() - second.getyCoord();
		double distance = Math.sqrt(dx*dx + dy*dy);
		logger.info(NameParameter.COUNT_DISTANCE_RETURN + distance);
		return distance;
	}
	
	
}
