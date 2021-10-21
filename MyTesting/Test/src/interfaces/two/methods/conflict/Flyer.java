package interfaces.two.methods.conflict;

public interface Flyer {

	default public String identifyMyself() {
		return "I am able to fly.";
	}
}
