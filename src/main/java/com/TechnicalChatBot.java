package com;

import java.io.File;

import org.alicebot.ab.Bot;
import org.alicebot.ab.Chat;
import org.alicebot.ab.History;
import org.alicebot.ab.MagicBooleans;
import org.alicebot.ab.MagicStrings;
import org.alicebot.ab.utils.IOUtils;
import org.springframework.stereotype.Component;

@Component
public class TechnicalChatBot {

	private static final boolean TRACE_MODE = false;
	static String botName = "super";

	public String getResourcesPath() {
		File currDir = new File(".");
		String path = currDir.getAbsolutePath();
		path = path.substring(0, path.length() - 2);
		System.out.println(path);
		String resourcesPath = path + File.separator + "src" + File.separator + "main" + File.separator + "resources";
		return resourcesPath;
	}

	public String getBotResponseFor(String textLine) {
		try {
			String mainResponse = "";
			String resourcesPath = getResourcesPath();
			MagicBooleans.trace_mode = TRACE_MODE;
			Bot bot = new Bot("super", resourcesPath);
			Chat chatSession = new Chat(bot);
			bot.brain.nodeStats();
			if ((textLine == null) || (textLine.length() < 1))
				textLine = MagicStrings.null_input;
			else {
				String request = textLine;
				if (MagicBooleans.trace_mode)
					System.out.println("STATE=" + request + ":THAT=" + ((History) chatSession.thatHistory.get(0)).get(0)
							+ ":TOPIC=" + chatSession.predicates.get("topic"));
				String response = chatSession.multisentenceRespond(request);
				while (response.contains("&lt;"))
					response = response.replace("&lt;", "<");
				while (response.contains("&gt;"))
					response = response.replace("&gt;", ">");
				mainResponse = response;
			}
			System.out.print("Bot : " + mainResponse);
			return mainResponse;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

}
