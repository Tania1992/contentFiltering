package com.filtering.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filtering.dao.WordsDao;

@Service
public class WordsService {
	
	@Autowired
	WordsDao wordsdao;
	
	public boolean checkSpam(String text)
	{
		String words[] = text.split(" ");
		int hamFrequency =0;
		int spamFrequency = 0;
		int totalSpamFrequency = 0;
		int totalHamFrequency = 0;
		totalSpamFrequency = wordsdao.totalWords("spam");
		totalHamFrequency = wordsdao.totalWords("ham");
		for(int i=0;i<words.length;i++)
		{
			hamFrequency = hamFrequency + wordsdao.checkFrequency(words[i].toLowerCase(), "ham");
			spamFrequency = spamFrequency + wordsdao.checkFrequency(words[i].toLowerCase(), "spam");
		}
		
		double hamProbability = hamFrequency%totalHamFrequency;
		double spamProbability = spamFrequency%totalSpamFrequency;
		
		if(hamProbability>spamProbability)
		{
			return false;
		}
		return true;
	}

}
