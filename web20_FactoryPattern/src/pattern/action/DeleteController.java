package pattern.action;

public class DeleteController implements Controller {

	@Override
	public String requestHandle() {
		
		System.out.println("DeleteController register logic");
		return "delete_result.jsp";
	}

}
