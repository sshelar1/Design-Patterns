package fourWayStreetLights.service;

import fourWayStreetLights.util.FourWayStreetLights;
import fourWayStreetLights.util.Logger;

public class SouthStateImpl implements StreetLightsStateI{
	
	private StreetLightsContext streetLightsContext;
	private FourWayStreetLights fourWayStreetLights;
	private String stateChange;
	
	public SouthStateImpl() {
		// TODO Auto-generated constructor stub
		fourWayStreetLights = null;
		Logger.writeMessage("instantiating SouthStateImpl object", Logger.DebugLevel.CONSTRUCTOR);
	}
	
	public SouthStateImpl(StreetLightsContext streetLightsContextIn) {
		// TODO Auto-generated constructor stub
		streetLightsContext = streetLightsContextIn;
		fourWayStreetLights = null;
		Logger.writeMessage("instantiating SouthStateImpl object", Logger.DebugLevel.CONSTRUCTOR);
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
		stateChange = "State Changed from : " + stateIn + " to : South";
		return stateChange;
	}

	@Override
	public FourWayStreetLights passTraffic(FourWayStreetLights fourWayStreetLightsIn, String line) {
		// TODO Auto-generated method stub
		fourWayStreetLights = fourWayStreetLightsIn.updateFourWayStreetLights(fourWayStreetLightsIn, line, streetLightsContext);
		
		if (fourWayStreetLights.getEast().equalsIgnoreCase("green")) {
			streetLightsContext.setCurrentState(streetLightsContext.getEastState());
			streetLightsContext.getResults().storeNewResult(new EastStateImpl().getStateChange("South"));
			Logger.writeMessage(new EastStateImpl().getStateChange("South"), Logger.DebugLevel.STATES);
			fourWayStreetLights.setNorth("red");
			fourWayStreetLights.setWest("red");
			fourWayStreetLights.setSouth("red");
		}else if (fourWayStreetLights.getWest().equalsIgnoreCase("green")) {
			streetLightsContext.setCurrentState(streetLightsContext.getWestState());
			streetLightsContext.getResults().storeNewResult(new WestStateImpl().getStateChange("South"));
			Logger.writeMessage(new WestStateImpl().getStateChange("South"), Logger.DebugLevel.STATES);
			fourWayStreetLights.setNorth("red");
			fourWayStreetLights.setEast("red");
			fourWayStreetLights.setSouth("red");
		}else if (fourWayStreetLights.getNorth().equalsIgnoreCase("green")) {
			streetLightsContext.setCurrentState(streetLightsContext.getNorthState());
			streetLightsContext.getResults().storeNewResult(new NorthStateImpl().getStateChange("South"));
			Logger.writeMessage(new NorthStateImpl().getStateChange("South"), Logger.DebugLevel.STATES);
			fourWayStreetLights.setEast("red");
			fourWayStreetLights.setWest("red");
			fourWayStreetLights.setSouth("red");
		}
		return fourWayStreetLights;
	}
	
	
}