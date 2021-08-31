package pattern.action;

public class AddController implements Controller {

	@Override
	public String requestHandle() {
		
		System.out.println("AddController register logic");
		/*
		 * 1. 폼값 받기
		 * 2. VO객체 생성
		 * 3. DAO리턴
		 * 4. 바자니스 로직 호출
		 * 5. 바인딩
		 * 6. PATH 리턴
		 */
		return "add_result.jsp";
	}

}
