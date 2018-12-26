package fourWayStreetLights.service;

import fourWayStreetLights.util.FourWayStreetLights;
import fourWayStreetLights.util.Logger;
import fourWayStreetLights.util.Results;

public class StreetLightsContext implements StreetLightsStateI{

	private StreetLightsStateI currentState;
	
	private int debugLevel;
	private Results results;
	
	private StreetLightsStateI northState;
	private StreetLightsStateI eastState;
	private StreetLightsStateI westState;
	private StreetLightsStateI southState;
	
	public StreetLightsContext(int debugLevel){
		northState = new NorthStateImpl(this);
		eastState = new EastStateImpl(this);
		westState = new WestStateImpl(this);
		southState = new SouthStateImpl(this);
		setDebugLevel(debugLevel);
		setCurrentState(northState);
		Logger.writeMessage("instantiating StretLightsContext object", Logger.DebugLevel.CONSTRUCTOR);
	}

	public int getDebugLevel() {
		return debugLevel;
	}

	public void setDebugLevel(int debugLevel) {
		this.debugLevel = debugLevel;
	}

	public Results getResults() {
		return results;
	}

	public void setResults(Results results) {
		this.results = results;
	}

	public StreetLightsStateI getCurrentState() {
		return currentState;
	}

	public void setCurrentState(StreetLightsStateI currentState) {
		this.currentState = currentState;
	}
	
	public StreetLightsStateI getNorthState() {
		return northState;
	}

	public void setNorthState(StreetLightsStateI northState) {
		this.northState = northState;
	}

	public StreetLightsStateI getEastState() {
		return eastState;
	}

	public void setEastState(StreetLightsStateI eastState) {
		this.eastState = eastState;
	}

	public StreetLightsStateI getWestState() {
		return westState;
	}

	public void setWestState(StreetLightsStateI westState) {
		this.westState = westState;
	}

	public StreetLightsStateI getSouthState() {
		return southState;
	}

	public void setSouthState(StreetLightsStateI southState) {
		this.southState = southState;
	}

	@Override
	public FourWayStreetLights passTraffic(FourWayStreetLights fourWayStreetLights, String line) {
		// TODO Auto-generated method stub
		fourWayStreetLights = currentState.passTraffic(fourWayStreetLights, line);
		return fourWayStreetLights;
	}
}
