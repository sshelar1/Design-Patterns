package fourWayStreetLights.service;

import fourWayStreetLights.util.FourWayStreetLights;
import fourWayStreetLights.util.Logger;

public class NorthStateImpl implements StreetLightsStateI{

	private StreetLightsContext streetLightsContext;
	private FourWayStreetLights fourWayStreetLights;
	private String stateChange;
	
	public NorthStateImpl() {
		// TODO Auto-generated constructor stub
		fourWayStreetLights = null;
		Logger.writeMessage("instantiating NorthStateImpl object", Logger.DebugLevel.CONSTRUCTOR);
	}
	
	public NorthStateImpl(StreetLightsContext streetLightsContextIn) {
		// TODO Auto-generated constructor stub
		fourWayStreetLights = null;
		streetLightsContext = streetLightsContextIn;
		Logger.writeMessage("instantiating NorthStateImpl object", Logger.DebugLevel.CONSTRUCTOR);
	}

	public StreetLightsContext getStreetLightsContext() {
		return streetLightsContext;
	}

	public void setStreetLightsContext(StreetLightsContext streetLightsContext) {
		this.streetLightsContext = streetLightsContext;
	}

	public FourWayStreetLights getFourWayStreetLights() {
		return fourWayStreetLights;
	}

	public void setFourWayStreetLights(FourWayStreetLights fourWayStreetLights) {
		this.fourWayStreetLights = fourWayStreetLights;
	}

	public String getStateChange() {
		return stateChange;
	}

	public void setStateChange(String stateChange) {
		this.stateChange = stateChange;
	}
	
	public String getStateChange(String stateIn) {
		stateChange = "State Changed from : " + stateIn + " to : North";
		return stateChange;
	}
	
	@Override
	public FourWayStreetLights passTraffic(FourWayStreetLights fourWayStreetLightsIn, String line) {
		// TODO Auto-generated method stub
		fourWayStreetLights = fourWayStreetLightsIn.updateFourWayStreetLights(fourWayStreetLightsIn, line, streetLightsContext);		
		if (fourWayStreetLights.getEast().equalsIgnoreCase("green")) {
			streetLightsContext.setCurrentState(streetLightsContext.getEastState());
			streetLightsContext.getResults().storeNewResult(new EastStateImpl().getStateChange("North"));
			Logger.writeMessage(new EastStateImpl().getStateChange("North"), Logger.DebugLevel.STATES);
			fourWayStreetLights.setNorth("red");
			fourWayStreetLights.setWest("red");
			fourWayStreetLights.setSouth("red");
		}else if (fourWayStreetLights.getWest().equalsIgnoreCase("green")) {
			streetLightsContext.setCurrentState(streetLightsContext.getWestState());
			streetLightsContext.getResults().storeNewResult(new WestStateImpl().getStateChange("North"));
			Logger.writeMessage(new WestStateImpl().getStateChange("North"), Logger.DebugLevel.STATES);
			fourWayStreetLights.setNorth("red");
			fourWayStreetLights.setEast("red");
			fourWayStreetLights.setSouth("red");
		}else if (fourWayStreetLights.getSouth().equalsIgnoreCase("green")) {
			streetLightsContext.setCurrentState(streetLightsContext.getSouthState());
			streetLightsContext.getResults().storeNewResult(new SouthStateImpl().getStateChange("North"));
			Logger.writeMessage(new SouthStateImpl().getStateChange("North"), Logger.DebugLevel.STATES);
			fourWayStreetLights.setNorth("red");
			fourWayStreetLights.setWest("red");
			fourWayStreetLights.setEast("red");
		}
		return fourWayStreetLights;
	}

}
