package net.adam85w.rabbit2kafka_migration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class ArticleApplication {

	private final Logger log = LoggerFactory.getLogger(ArticleApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ArticleApplication.class, args);
	}

	@KafkaListener(topics = "articles")
	public void listen(Article article) {
		log.info("Received article: {}", article);
	}
}
