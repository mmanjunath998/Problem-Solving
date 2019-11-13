package com.basics.design;

interface State{
	void insertCoin();
	void pressButton();
	void dispense();
}

class CoinInsertedState implements State{
	VendingMachine machine;
	public CoinInsertedState(VendingMachine machine){
		this.machine = machine;
	}
	@Override
	public void insertCoin() {
		throw new IllegalArgumentException("coin is already inserted.");
		
	}
	@Override
	public void pressButton() {
		machine.setMachineState(machine.getDispensingState());
		
	}
	@Override
	public void dispense() {
		throw new IllegalArgumentException("button not pressed..");
		
	}
}

class DispensingState implements State{
		VendingMachine machine;
		
		public DispensingState(VendingMachine machine){
			this.machine = machine;
		}
		@Override
		public void insertCoin() {
			
			throw new IllegalArgumentException("Invalid action");
		}
		@Override
		public void pressButton() {
			throw new IllegalArgumentException("Invalid action");
			
		}
		@Override
		public void dispense() {
			machine.setMachineState(machine.getNoCoinInsertedState());
			
		}
}

class NoCoinInsertedState implements State{
	
	VendingMachine machine;
	
	public NoCoinInsertedState(VendingMachine machine){
		this.machine = machine;
	}

	@Override
	public void insertCoin() {
			if(!machine.isEmpty()){
				machine.setMachineState(machine.getCoinInsertedState());
			}else{
				throw new IllegalArgumentException("out of stock...");
			}
	}

	@Override
	public void pressButton() {
		throw new IllegalArgumentException("Invalid action");
	}
	@Override
	public void dispense() {
		throw new IllegalArgumentException("Invalid action");
	}
}

class EmptyState implements State{
	
	VendingMachine machine;
	public EmptyState(VendingMachine machine){
		this.machine = machine;
	}
	@Override
	public void insertCoin() {
		throw new IllegalArgumentException("Invalid action.");
	}
	@Override
	public void pressButton() {
		throw new IllegalArgumentException("Invalid action.");
	}
	@Override
	public void dispense() {
		throw new IllegalArgumentException("Invalid action.");
	}
}


public class VendingMachine {
	
	int capacity = 0;
	
	State machineState;
	State coinInsertedState;
	State dispensingState;
	State noCoinInsertedState;
	State emptyState;
	
	public VendingMachine(){
		this.coinInsertedState = new CoinInsertedState(this);
		this.dispensingState = new DispensingState(this);
		this.noCoinInsertedState = new NoCoinInsertedState(this);
		this.emptyState = new EmptyState(this);
	}
	
	public boolean isEmpty(){
		return capacity <= 0;
	}
	
	public void refill(int count){
		this.capacity +=  count;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public State getMachineState() {
		return machineState;
	}

	public void setMachineState(State machineState) {
		this.machineState = machineState;
	}

	public State getCoinInsertedState() {
		return coinInsertedState;
	}

	public void setCoinInsertedState(State coinInsertedState) {
		this.coinInsertedState = coinInsertedState;
	}

	public State getDispensingState() {
		return dispensingState;
	}

	public void setDispensingState(State dispensingState) {
		this.dispensingState = dispensingState;
	}

	public State getNoCoinInsertedState() {
		return noCoinInsertedState;
	}

	public void setNoCoinInsertedState(State noCoinInsertedState) {
		this.noCoinInsertedState = noCoinInsertedState;
	}

	public State getEmptyState() {
		return emptyState;
	}

	public void setEmptyState(State emptyState) {
		this.emptyState = emptyState;
	}

}
