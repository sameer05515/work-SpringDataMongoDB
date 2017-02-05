package com.journaldev.spring.mongodb.main.word;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.xml.sax.SAXException;

import com.journaldev.spring.mongodb.model.Person;
import com.journaldev.spring.mongodb.model.Word;
import com.mongodb.MongoClient;
//import com.prem.vocab.build.proj.VocabBuildConstants.Examples;
//import com.prem.vocab.build.proj.VocabBuildConstants.Meanings;
//import com.prem.vocab.build.proj.VocabBuildConstants.Word;
import com.prem.vocab.build.proj.util.XMLUtilityImpl;

public class MongoWodUtil {

	public static final String DB_NAME = "journaldev";
	public static final String PERSON_COLLECTION = "Word";
	public static final String MONGO_HOST = "localhost";
	public static final int MONGO_PORT = 27017;

	public static void main(String[] args) {
		//insertWordData();
		System.out.println(findByID("1026"));
		System.out.println(findAll());
	}

	private static List<Word> findAll() {
		List<Word> word =null;
		try {
			MongoClient mongo = new MongoClient(
					MONGO_HOST, MONGO_PORT);
			MongoOperations mongoOps = new MongoTemplate(mongo, DB_NAME);
			word = mongoOps.findAll(Word.class, PERSON_COLLECTION);
			mongo.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return word;
	}

	private static Word findByID(String id) {
		Word word =null;
		try {
			MongoClient mongo = new MongoClient(
					MONGO_HOST, MONGO_PORT);
			MongoOperations mongoOps = new MongoTemplate(mongo, DB_NAME);
			word = mongoOps.findOne(
					new Query(Criteria.where("id").is(id)),
					Word.class, PERSON_COLLECTION);
			mongo.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return word;
		
	}

	private static void insertWordData() {

		try {
			MongoClient mongo = new MongoClient(MONGO_HOST, MONGO_PORT);
			MongoOperations mongoOps = new MongoTemplate(mongo, DB_NAME);

			XMLUtilityImpl xmlUtilityImpl = new XMLUtilityImpl();
			List<HashMap<String, String>> list = xmlUtilityImpl.getAllDescription();

			for (int i = 0; i < list.size(); i++) {
				HashMap<String, String> mapObject = list.get(i);

				if (mapObject.keySet() != null && mapObject.keySet().size() > 0) {

					Word word = new Word((i + 1) + "",
							getValue(mapObject, com.prem.vocab.build.proj.VocabBuildConstants.Word.node.getName()),
							getValue(mapObject, com.prem.vocab.build.proj.VocabBuildConstants.Word.TYPE.getName()));

					String mapValueForKey = getValue(mapObject,
							com.prem.vocab.build.proj.VocabBuildConstants.Meanings.node.getName());

					if (mapValueForKey != null && !mapValueForKey.trim().equalsIgnoreCase("")) {
						String[] strarr = mapValueForKey.trim().split("-->");
						int count = 0;
						for (String str : strarr) {

							word.getMeanings().add(new Word.Meaning((++count) + "", str));
						}
					}

					mapValueForKey = getValue(mapObject,
							com.prem.vocab.build.proj.VocabBuildConstants.Examples.node.getName());

					if (mapValueForKey != null && !mapValueForKey.trim().equalsIgnoreCase("")) {
						String[] strarr = mapValueForKey.trim().split("-->");
						int count = 0;
						for (String str : strarr) {

							word.getExamples().add(new Word.Example((++count) + "", str));

						}
					}
					System.out.println(word);
					mongoOps.insert(word, PERSON_COLLECTION);
				}
			}
			mongo.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static String getValue(HashMap<String, String> mapObject, String key) {
		String ret = "";
		if (mapObject.containsKey(key)) {
			ret = mapObject.get(key);
			ret = (ret != null) ? ret : "";
		}

		return ret;
	}

}
