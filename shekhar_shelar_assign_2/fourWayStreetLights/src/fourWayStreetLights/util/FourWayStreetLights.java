package fourWayStreetLights.util;

import fourWayStreetLights.service.StreetLightsContext;

public class FourWayStreetLights {
	
	private String North, East, West, South;
	private int northCars, eastCars, westCars, southCars;
	private int directionAdd, directionMinus;
	private int carsAdded, carsReduced;
	
	public FourWayStreetLights() {
		//setDirectionAdd(-1);
		carsAdded = 0; carsReduced = 0;
		northCars=0; eastCars=0; westCars=0; southCars=0;
		North = "red"; East="red"; West="red"; South="red";
	}

	public String getNorth() {
		return North;
	}

	public void setNorth(String north) {
		North = north;
	}

	public String getEast() {
		return East;
	}

	public void setEast(String east) {
		East = east;
	}

	public String getWest() {
		return West;
	}

	public void setWest(String west) {
		West = west;
	}

	public String getSouth() {
		return South;
	}

	public void setSouth(String south) {
		South = south;
	}

	public int getNorthCars() {
		return northCars;
	}

	public void setNorthCars(int northCars) {
		this.northCars = northCars;
	}

	public int getEastCars() {
		return eastCars;
	}

	public void setEastCars(int eastCars) {
		this.eastCars = eastCars;
	}

	public int getWestCars() {
		return westCars;
	}

	public void setWestCars(int westCars) {
		this.westCars = westCars;
	}

	public int getSouthCars() {
		return southCars;
	}

	public void setSouthCars(int southCars) {
		this.southCars = southCars;
	}
	
	public int getDirectionAdd() {
		return directionAdd;
	}

	public void setDirectionAdd(int directionIn) {
		this.directionAdd = directionIn;
	}

	public int getDirectionMinus() {
		return directionMinus;
	}

	public void setDirectionMinus(int directionMinus) {
		this.directionMinus = directionMinus;
	}
	
	public FourWayStreetLights updateFourWayStreetLights(FourWayStreetLights fourWayStreetLightsIn, String line, StreetLightsContext streetLightsContext) {
		String [] data = line.split(" ");
		if (data[0].equalsIgnoreCase("add")) {
			directionMinus = -1;
			try {
				switch (data[4].toLowerCase()) {
					case "north": carsAdded = Integer.parseInt(data[1]);
								  fourWayStreetLightsIn.setNorthCars(fourWayStreetLightsIn.getNorthCars() + carsAdded);
								  Logger.writeMessage( carsAdded + " added to North", Logger.DebugLevel.CHANGEINPOOL);
								  setDirectionAdd(1);
						break;
					case "east": carsAdded = Integer.parseInt(data[1]);
								 fourWayStreetLightsIn.setEastCars(fourWayStreetLightsIn.getEastCars() + carsAdded);
								 Logger.writeMessage( carsAdded + " added to East", Logger.DebugLevel.CHANGEINPOOL);
								 setDirectionAdd(2);
						break;
					case "west": carsAdded = Integer.parseInt(data[1]);
								 fourWayStreetLightsIn.setWestCars(fourWayStreetLightsIn.getWestCars() + carsAdded);
								 Logger.writeMessage( carsAdded + " added to West", Logger.DebugLevel.CHANGEINPOOL);
								 setDirectionAdd(3);
						break;
					case "south": carsAdded = Integer.parseInt(data[1]);
								  fourWayStreetLightsIn.setSouthCars(fourWayStreetLightsIn.getSouthCars() + carsAdded);
								  Logger.writeMessage( carsAdded + " added to South", Logger.DebugLevel.CHANGEINPOOL);
								  setDirectionAdd(4);
						break;
					default: System.out.println("Not a valid Direction");
						break;
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Not valid number");
			}
		} else if (data[0].equalsIgnoreCase("turn")){
			directionAdd = -1;
			switch(data[1].toLowerCase()) {
				case "north": carsReduced = fourWayStreetLightsIn.getNorthCars() >= 2 ? fourWayStreetLightsIn.getNorthCars() - 2
						  						: (fourWayStreetLightsIn.getNorthCars() == 1 ? fourWayStreetLightsIn.getNorthCars() -1 
						  								: 0);
							  fourWayStreetLightsIn.setNorth(data[2]);
							  fourWayStreetLightsIn.setNorthCars(carsReduced);
							  Logger.writeMessage(carsReduced + " remaining in North", Logger.DebugLevel.CHANGEINPOOL);
							  setDirectionMinus(1);
					break;
				case "east": carsReduced = fourWayStreetLightsIn.getEastCars() >= 2 ? fourWayStreetLightsIn.getEastCars() - 2 
												: (fourWayStreetLightsIn.getEastCars() == 1 ? fourWayStreetLightsIn.getEastCars() - 1
														: 0);
							 fourWayStreetLightsIn.setEast(data[2]);
							 fourWayStreetLightsIn.setEastCars(carsReduced);
							 Logger.writeMessage(carsReduced + " remaining in East", Logger.DebugLevel.CHANGEINPOOL);
							 setDirectionMinus(2);
					break;
				case "west": carsReduced = fourWayStreetLightsIn.getWestCars() >= 2 ? fourWayStreetLightsIn.getWestCars() - 2
						 						: (fourWayStreetLightsIn.getWestCars() >= 1 ? fourWayStreetLightsIn.getWestCars() - 1 
						 								: 0);
							 fourWayStreetLightsIn.setWest(data[2]);
							 fourWayStreetLightsIn.setWestCars(carsReduced);
							 Logger.writeMessage(carsReduced + " remaining in West", Logger.DebugLevel.CHANGEINPOOL);
							 setDirectionMinus(3);
					break;
				case "south": carsReduced = fourWayStreetLightsIn.getSouthCars() >= 2 ? fourWayStreetLightsIn.getSouthCars() - 2
						  						: (fourWayStreetLightsIn.getSouthCars() == 1 ? fourWayStreetLightsIn.getSouthCars() - 1 
						  								: 0);
							  fourWayStreetLightsIn.setSouth(data[2]);
							  fourWayStreetLightsIn.setSouthCars(carsReduced);
							  Logger.writeMessage(carsReduced + " remaining in South", Logger.DebugLevel.CHANGEINPOOL);
							  setDirectionMinus(4);
					break;
				default: System.out.println("Not a valid Direction");
					break;
			}
		} 
		return fourWayStreetLightsIn;
	}

}
