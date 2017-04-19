package br.pro.hashi.ensino.desagil.lucianogic.model;

public class HalfGate extends Gate {
	private AndGate andBot;
	private XorGate xorTop;

	public HalfGate() {
		super(2, 2);

		name = "HALF";

		andBot = new AndGate();
		xorTop = new XorGate();
		
	}

	@Override
	public boolean doRead(int index) {
		switch(index) {
		
		case 0:
			
			return xorTop.read();

		case 1:
			
			return andBot.read();
		}
		
		return false;
	}

	
	@Override
	protected void doConnect(Emitter emitter, int index) {
		switch(index) {
		
		case 0:
			
			andBot.connect(emitter, 0);
			
			xorTop.connect(emitter, 0);
			
			break;
			
		case 1:
			
			andBot.connect(emitter, 1);
			
			xorTop.connect(emitter, 1);
			
			break;
		}
	}
}

