package pattern.action;

public class UpdateController implements Controller {

	@Override
	public String requestHandle() {
		
		System.out.println("UpdateController register logic");
		return "update_result.jsp";
	}

}
