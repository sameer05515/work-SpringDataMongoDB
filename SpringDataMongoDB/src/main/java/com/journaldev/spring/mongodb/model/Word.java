package com.journaldev.spring.mongodb.model;

import java.util.ArrayList;
import java.util.List;

public class Word {

	private String id;

	private String word;

	private String type;
	
	private List<Meaning> meanings=new ArrayList<Word.Meaning>();
	
	private List<Example> examples=new ArrayList<Word.Example>();;
	
	
	

	

	/**
	 * @param id
	 * @param word
	 * @param type
	 * @param meanings
	 * @param examples
	 */
	public Word(String id, String word, String type) {
		super();
		this.id = id;
		this.word = word;
		this.type = type;
	}

	public static final class Meaning {
		
		private String id;

		private String meaning;

		/**
		 * @param id
		 * @param meaning
		 */
		public Meaning(String id, String meaning) {
			super();
			this.id = id;
			this.meaning = meaning;
		}

		/**
		 * @return the id
		 */
		public String getId() {
			return id;
		}

		/**
		 * @param id the id to set
		 */
		public void setId(String id) {
			this.id = id;
		}

		/**
		 * @return the meaning
		 */
		public String getMeaning() {
			return meaning;
		}

		/**
		 * @param meaning the meaning to set
		 */
		public void setMeaning(String meaning) {
			this.meaning = meaning;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Meaning [");
			if (getId() != null)
				builder.append("getId()=").append(getId()).append(", ");
			if (getMeaning() != null)
				builder.append("getMeaning()=").append(getMeaning());
			builder.append("]");
			return builder.toString();
		}

	}

	public static final class Example {

		private String id;

		private String example;

		/**
		 * @param id
		 * @param example
		 */
		public Example(String id, String example) {
			super();
			this.id = id;
			this.example = example;
		}

		/**
		 * @return the id
		 */
		public String getId() {
			return id;
		}

		/**
		 * @param id the id to set
		 */
		public void setId(String id) {
			this.id = id;
		}

		/**
		 * @return the example
		 */
		public String getExample() {
			return example;
		}

		/**
		 * @param example the example to set
		 */
		public void setExample(String example) {
			this.example = example;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Example [");
			if (getId() != null)
				builder.append("getId()=").append(getId()).append(", ");
			if (getExample() != null)
				builder.append("getExample()=").append(getExample());
			builder.append("]");
			return builder.toString();
		}
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the word
	 */
	public String getWord() {
		return word;
	}

	/**
	 * @param word the word to set
	 */
	public void setWord(String word) {
		this.word = word;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the meanings
	 */
	public List<Meaning> getMeanings() {
		return meanings;
	}

	/**
	 * @param meanings the meanings to set
	 */
	public void setMeanings(List<Meaning> meanings) {
		this.meanings = meanings;
	}

	/**
	 * @return the examples
	 */
	public List<Example> getExamples() {
		return examples;
	}

	/**
	 * @param examples the examples to set
	 */
	public void setExamples(List<Example> examples) {
		this.examples = examples;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Word [");
		if (getId() != null)
			builder.append("getId()=").append(getId()).append(", ");
		if (getWord() != null)
			builder.append("getWord()=").append(getWord()).append(", ");
		if (getType() != null)
			builder.append("getType()=").append(getType()).append(", ");
		if (getMeanings() != null)
			builder.append("getMeanings()=").append(getMeanings()).append(", ");
		if (getExamples() != null)
			builder.append("getExamples()=").append(getExamples());
		builder.append("]");
		return builder.toString();
	}

}
