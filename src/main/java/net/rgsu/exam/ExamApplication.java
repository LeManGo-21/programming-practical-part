package net.rgsu.exam;

import net.rgsu.exam.services.LogService;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class ExamApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new SpringApplicationBuilder(ExamApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);

		if (args.length < 1){
			System.out.println("Отсутсвует аргумент командной строки!");
			return;
		}

		context.getBean(LogService.class).getLogs(args[0]);
	}
}