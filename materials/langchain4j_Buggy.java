package jp.kozaki.lab;

import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

import dev.langchain4j.model.openai.OpenAiChatModel;

public class langchain4j_Buggy {
    public static void main(String[] args) throws Exception {

        Properties prop = new Properties();
        prop.load(new FileInputStream("config.properties"));

        String apiKey = prop.getProperty("OPENAI_APIKEY");

        OpenAiChatModel model = OpenAiChatModel.builder()
                .apiKey(apiKey)
                .modelName("gpt-4o-mini")
                .build();

        String text = Files.readString(Path.of("exercise5_input.txt"));

        String prompt = """
                以下の文章を3行で要約してください。

                【文章】
                """ + text;

        String answer = model.chat(prompt);

        System.out.println(answer);
    }
}
