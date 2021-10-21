package interfaces.two.methods.conflict;

public interface Mythical {
	
	default public String identifyMyself() {
		return "I am a mythical creature.";
	}
}
