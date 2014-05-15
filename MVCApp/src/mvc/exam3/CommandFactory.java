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
			// �Է°� Ȯ��
			// �Է°��� �߸��Ǿ��� ��� �ش� ������ ������������ �̵�
			return new regConfirmCommand();
		} else if (cmd.equals("REGCOMPLETE")) {
			// DB ���� ������ ����
			return new RegCompleteCommand();
		} else {
			// �������� ��û�� �ƴ� �Ϳ� ���� ���� ó��
			return null;
		}
	}
}
