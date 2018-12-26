package fourWayStreetLights.service;

import fourWayStreetLights.util.FourWayStreetLights;
import fourWayStreetLights.util.Logger;

public class EastStateImpl implements StreetLightsStateI{
	
	private StreetLightsContext streetLightsContext;
	private FourWayStreetLights fourWayStreetLights;
	private String stateChange;

	public EastStateImpl() {
		// TODO Auto-generated constructor stub
		fourWayStreetLights = null;
		Logger.writeMessage("instantiating EastStateImpl object", Logger.DebugLevel.CONSTRUCTOR);
	}
	
	public EastStateImpl(StreetLightsContext streetLightsContextIn) {
		// TODO Auto-generated constructor stub
		streetLightsContext = streetLightsContextIn;
		fourWayStreetLights = null;
		Logger.writeMessage("instantiating EastStateImpl object", Logger.DebugLevel.CONSTRUCTOR);
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
		stateChange = "State Changed from : " + stateIn + " to : East";
		return stateChange;
	}

	@Override
	public FourWayStreetLights passTraffic(FourWayStreetLights fourWayStreetLightsIn, String line) {
		// TODO Auto-generated method stub
		fourWayStreetLights = fourWayStreetLightsIn.updateFourWayStreetLights(fourWayStreetLightsIn, line, streetLightsContext);
		if (fourWayStreetLights.getWest().equalsIgnoreCase("green")) {
			streetLightsContext.setCurrentState(streetLightsContext.getWestState());
			streetLightsContext.getResults().storeNewResult(new WestStateImpl().getStateChange("East"));
			Logger.writeMessage(new WestStateImpl().getStateChange("East"), Logger.DebugLevel.STATES);
			fourWayStreetLights.setNorth("red");
			fourWayStreetLights.setEast("red");
			fourWayStreetLights.setSouth("red");
		}else if (fourWayStreetLights.getSouth().equalsIgnoreCase("green")) {
			streetLightsContext.setCurrentState(streetLightsContext.getSouthState());
			streetLightsContext.getResults().storeNewResult(new SouthStateImpl().getStateChange("East"));
			Logger.writeMessage(new SouthStateImpl().getStateChange("East"), Logger.DebugLevel.STATES);
			fourWayStreetLights.setNorth("red");
			fourWayStreetLights.setWest("red");
			fourWayStreetLights.setEast("red");
		}else if (fourWayStreetLights.getNorth().equalsIgnoreCase("green")) {
			streetLightsContext.setCurrentState(streetLightsContext.getNorthState());
			streetLightsContext.getResults().storeNewResult(new NorthStateImpl().getStateChange("East"));
			Logger.writeMessage(new NorthStateImpl().getStateChange("East"), Logger.DebugLevel.STATES);
			fourWayStreetLights.setEast("red");
			fourWayStreetLights.setWest("red");
			fourWayStreetLights.setSouth("red");
		}
		return fourWayStreetLights;
	}

}
