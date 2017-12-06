package novelhealthcare;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessageResourceBundle 
{
	public static void main(String[] args) 
	{
		MessageSource messageSource = new ClassPathXmlApplicationContext("applicationContext.xml");
		String message1 = messageSource.getMessage("userId.required", new Object[]{"yuga"},Locale.US);
		String message2 = messageSource.getMessage("password.required", new Object[]{"Deva"},Locale.US);
		System.out.println(message1);
		System.out.println(message2);
	}
}
