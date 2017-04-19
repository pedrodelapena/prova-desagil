package br.pro.hashi.ensino.desagil.lucianogic.model;

public class FullGate extends Gate {
	private XorGate xorTop;
	private XorGate xorJG;
	private AndGate andMid;
	private AndGate andBot;
	private OrGate orSup;
	
	public FullGate() {
		super(3, 2);

		name = "FULL";

		xorTop = new XorGate();
		xorJG = new XorGate();	
		andMid = new AndGate();
		andBot = new AndGate();
		orSup = new OrGate();
		
		xorTop.connect(xorJG, 0);
		xorTop.connect(andMid, 0);
		andMid.connect(orSup, 0);
		andBot.connect(orSup, 1);
		
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

