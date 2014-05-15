package mvc.exam3;

public class CommandFactory {
	private CommandFactory() {
	}

	private static CommandFactory instance = new CommandFactory();

	public static CommandFactory getInstance() {
		return instance;
	}

	public ICommand createCommand(String cmd) {
		if (cmd.equals("MAIN")) {
			return new MainCommand();
		} else if (cmd.equals("REGFORM")) {
			return new RegFormCommand();
		} else if (cmd.equals("REGCONFIRM")) {
			// 입력값 확인
			// 입력값이 잘못되었을 경우 해당 페이지 에러페이지로 이동
			return new regConfirmCommand();
		} else if (cmd.equals("REGCOMPLETE")) {
			// DB 연동 데이터 저장
			return new RegCompleteCommand();
		} else {
			// 정상적인 요청이 아닌 것에 대해 예외 처리
			return null;
		}
	}
}
